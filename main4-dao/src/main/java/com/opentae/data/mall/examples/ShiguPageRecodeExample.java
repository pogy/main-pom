package com.opentae.data.mall.examples;

import com.opentae.common.beans.Example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguPageRecodeExample extends Example {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguPageRecodeExample.Criteria> oredCriteria = new ArrayList();

    public ShiguPageRecodeExample() {
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<ShiguPageRecodeExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguPageRecodeExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguPageRecodeExample.Criteria or() {
        ShiguPageRecodeExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguPageRecodeExample.Criteria createCriteria() {
        ShiguPageRecodeExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguPageRecodeExample.Criteria createCriteriaInternal() {
        ShiguPageRecodeExample.Criteria criteria = new ShiguPageRecodeExample.Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if(value instanceof List) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }

        }

        protected Criterion(String condition, Object value) {
            this(condition, value, (String)null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, (String)null);
        }
    }

    public static class Criteria extends ShiguPageRecodeExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguPageRecodeExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguPageRecodeExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguPageRecodeExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguPageRecodeExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguPageRecodeExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguPageRecodeExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguPageRecodeExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdIsNull() {
            this.addCriterion("page_id is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdIsNotNull() {
            this.addCriterion("page_id is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdEqualTo(Long value) {
            this.addCriterion("page_id =", value, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdNotEqualTo(Long value) {
            this.addCriterion("page_id <>", value, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdGreaterThan(Long value) {
            this.addCriterion("page_id >", value, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("page_id >=", value, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdLessThan(Long value) {
            this.addCriterion("page_id <", value, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("page_id <=", value, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdIn(List<Long> values) {
            this.addCriterion("page_id in", values, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdNotIn(List<Long> values) {
            this.addCriterion("page_id not in", values, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdBetween(Long value1, Long value2) {
            this.addCriterion("page_id between", value1, value2, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("page_id not between", value1, value2, "pageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameIsNull() {
            this.addCriterion("page_name is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameIsNotNull() {
            this.addCriterion("page_name is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameEqualTo(String value) {
            this.addCriterion("page_name =", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameNotEqualTo(String value) {
            this.addCriterion("page_name <>", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameGreaterThan(String value) {
            this.addCriterion("page_name >", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("page_name >=", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameLessThan(String value) {
            this.addCriterion("page_name <", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameLessThanOrEqualTo(String value) {
            this.addCriterion("page_name <=", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameLike(String value) {
            this.addCriterion("page_name like", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameNotLike(String value) {
            this.addCriterion("page_name not like", value, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameIn(List<String> values) {
            this.addCriterion("page_name in", values, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameNotIn(List<String> values) {
            this.addCriterion("page_name not in", values, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameBetween(String value1, String value2) {
            this.addCriterion("page_name between", value1, value2, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageNameNotBetween(String value1, String value2) {
            this.addCriterion("page_name not between", value1, value2, "pageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlIsNull() {
            this.addCriterion("page_url is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlIsNotNull() {
            this.addCriterion("page_url is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlEqualTo(String value) {
            this.addCriterion("page_url =", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlNotEqualTo(String value) {
            this.addCriterion("page_url <>", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlGreaterThan(String value) {
            this.addCriterion("page_url >", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("page_url >=", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlLessThan(String value) {
            this.addCriterion("page_url <", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlLessThanOrEqualTo(String value) {
            this.addCriterion("page_url <=", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlLike(String value) {
            this.addCriterion("page_url like", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlNotLike(String value) {
            this.addCriterion("page_url not like", value, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlIn(List<String> values) {
            this.addCriterion("page_url in", values, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlNotIn(List<String> values) {
            this.addCriterion("page_url not in", values, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlBetween(String value1, String value2) {
            this.addCriterion("page_url between", value1, value2, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andPageUrlNotBetween(String value1, String value2) {
            this.addCriterion("page_url not between", value1, value2, "pageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpIsNull() {
            this.addCriterion("client_ip is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpIsNotNull() {
            this.addCriterion("client_ip is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpEqualTo(String value) {
            this.addCriterion("client_ip =", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpNotEqualTo(String value) {
            this.addCriterion("client_ip <>", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpGreaterThan(String value) {
            this.addCriterion("client_ip >", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("client_ip >=", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpLessThan(String value) {
            this.addCriterion("client_ip <", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpLessThanOrEqualTo(String value) {
            this.addCriterion("client_ip <=", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpLike(String value) {
            this.addCriterion("client_ip like", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpNotLike(String value) {
            this.addCriterion("client_ip not like", value, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpIn(List<String> values) {
            this.addCriterion("client_ip in", values, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpNotIn(List<String> values) {
            this.addCriterion("client_ip not in", values, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpBetween(String value1, String value2) {
            this.addCriterion("client_ip between", value1, value2, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientIpNotBetween(String value1, String value2) {
            this.addCriterion("client_ip not between", value1, value2, "clientIp");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerIsNull() {
            this.addCriterion("client_brower is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerIsNotNull() {
            this.addCriterion("client_brower is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerEqualTo(String value) {
            this.addCriterion("client_brower =", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerNotEqualTo(String value) {
            this.addCriterion("client_brower <>", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerGreaterThan(String value) {
            this.addCriterion("client_brower >", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerGreaterThanOrEqualTo(String value) {
            this.addCriterion("client_brower >=", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerLessThan(String value) {
            this.addCriterion("client_brower <", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerLessThanOrEqualTo(String value) {
            this.addCriterion("client_brower <=", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerLike(String value) {
            this.addCriterion("client_brower like", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerNotLike(String value) {
            this.addCriterion("client_brower not like", value, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerIn(List<String> values) {
            this.addCriterion("client_brower in", values, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerNotIn(List<String> values) {
            this.addCriterion("client_brower not in", values, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerBetween(String value1, String value2) {
            this.addCriterion("client_brower between", value1, value2, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerNotBetween(String value1, String value2) {
            this.addCriterion("client_brower not between", value1, value2, "clientBrower");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionIsNull() {
            this.addCriterion("client_brower_version is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionIsNotNull() {
            this.addCriterion("client_brower_version is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionEqualTo(String value) {
            this.addCriterion("client_brower_version =", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionNotEqualTo(String value) {
            this.addCriterion("client_brower_version <>", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionGreaterThan(String value) {
            this.addCriterion("client_brower_version >", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionGreaterThanOrEqualTo(String value) {
            this.addCriterion("client_brower_version >=", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionLessThan(String value) {
            this.addCriterion("client_brower_version <", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionLessThanOrEqualTo(String value) {
            this.addCriterion("client_brower_version <=", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionLike(String value) {
            this.addCriterion("client_brower_version like", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionNotLike(String value) {
            this.addCriterion("client_brower_version not like", value, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionIn(List<String> values) {
            this.addCriterion("client_brower_version in", values, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionNotIn(List<String> values) {
            this.addCriterion("client_brower_version not in", values, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionBetween(String value1, String value2) {
            this.addCriterion("client_brower_version between", value1, value2, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientBrowerVersionNotBetween(String value1, String value2) {
            this.addCriterion("client_brower_version not between", value1, value2, "clientBrowerVersion");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsIsNull() {
            this.addCriterion("client_os is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsIsNotNull() {
            this.addCriterion("client_os is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsEqualTo(String value) {
            this.addCriterion("client_os =", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsNotEqualTo(String value) {
            this.addCriterion("client_os <>", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsGreaterThan(String value) {
            this.addCriterion("client_os >", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsGreaterThanOrEqualTo(String value) {
            this.addCriterion("client_os >=", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsLessThan(String value) {
            this.addCriterion("client_os <", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsLessThanOrEqualTo(String value) {
            this.addCriterion("client_os <=", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsLike(String value) {
            this.addCriterion("client_os like", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsNotLike(String value) {
            this.addCriterion("client_os not like", value, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsIn(List<String> values) {
            this.addCriterion("client_os in", values, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsNotIn(List<String> values) {
            this.addCriterion("client_os not in", values, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsBetween(String value1, String value2) {
            this.addCriterion("client_os between", value1, value2, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andClientOsNotBetween(String value1, String value2) {
            this.addCriterion("client_os not between", value1, value2, "clientOs");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeIsNull() {
            this.addCriterion("in_time is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeIsNotNull() {
            this.addCriterion("in_time is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeEqualTo(Date value) {
            this.addCriterion("in_time =", value, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeNotEqualTo(Date value) {
            this.addCriterion("in_time <>", value, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeGreaterThan(Date value) {
            this.addCriterion("in_time >", value, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("in_time >=", value, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeLessThan(Date value) {
            this.addCriterion("in_time <", value, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("in_time <=", value, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeIn(List<Date> values) {
            this.addCriterion("in_time in", values, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeNotIn(List<Date> values) {
            this.addCriterion("in_time not in", values, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeBetween(Date value1, Date value2) {
            this.addCriterion("in_time between", value1, value2, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andInTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("in_time not between", value1, value2, "inTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeIsNull() {
            this.addCriterion("out_time is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeIsNotNull() {
            this.addCriterion("out_time is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeEqualTo(Date value) {
            this.addCriterion("out_time =", value, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeNotEqualTo(Date value) {
            this.addCriterion("out_time <>", value, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeGreaterThan(Date value) {
            this.addCriterion("out_time >", value, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("out_time >=", value, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeLessThan(Date value) {
            this.addCriterion("out_time <", value, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("out_time <=", value, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeIn(List<Date> values) {
            this.addCriterion("out_time in", values, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeNotIn(List<Date> values) {
            this.addCriterion("out_time not in", values, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeBetween(Date value1, Date value2) {
            this.addCriterion("out_time between", value1, value2, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andOutTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("out_time not between", value1, value2, "outTime");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlIsNull() {
            this.addCriterion("from_page_url is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlIsNotNull() {
            this.addCriterion("from_page_url is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlEqualTo(String value) {
            this.addCriterion("from_page_url =", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlNotEqualTo(String value) {
            this.addCriterion("from_page_url <>", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlGreaterThan(String value) {
            this.addCriterion("from_page_url >", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("from_page_url >=", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlLessThan(String value) {
            this.addCriterion("from_page_url <", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlLessThanOrEqualTo(String value) {
            this.addCriterion("from_page_url <=", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlLike(String value) {
            this.addCriterion("from_page_url like", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlNotLike(String value) {
            this.addCriterion("from_page_url not like", value, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlIn(List<String> values) {
            this.addCriterion("from_page_url in", values, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlNotIn(List<String> values) {
            this.addCriterion("from_page_url not in", values, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlBetween(String value1, String value2) {
            this.addCriterion("from_page_url between", value1, value2, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageUrlNotBetween(String value1, String value2) {
            this.addCriterion("from_page_url not between", value1, value2, "fromPageUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdIsNull() {
            this.addCriterion("from_page_id is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdIsNotNull() {
            this.addCriterion("from_page_id is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdEqualTo(Long value) {
            this.addCriterion("from_page_id =", value, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdNotEqualTo(Long value) {
            this.addCriterion("from_page_id <>", value, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdGreaterThan(Long value) {
            this.addCriterion("from_page_id >", value, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("from_page_id >=", value, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdLessThan(Long value) {
            this.addCriterion("from_page_id <", value, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("from_page_id <=", value, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdIn(List<Long> values) {
            this.addCriterion("from_page_id in", values, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdNotIn(List<Long> values) {
            this.addCriterion("from_page_id not in", values, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdBetween(Long value1, Long value2) {
            this.addCriterion("from_page_id between", value1, value2, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("from_page_id not between", value1, value2, "fromPageId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameIsNull() {
            this.addCriterion("from_page_name is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameIsNotNull() {
            this.addCriterion("from_page_name is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameEqualTo(String value) {
            this.addCriterion("from_page_name =", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameNotEqualTo(String value) {
            this.addCriterion("from_page_name <>", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameGreaterThan(String value) {
            this.addCriterion("from_page_name >", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("from_page_name >=", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameLessThan(String value) {
            this.addCriterion("from_page_name <", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameLessThanOrEqualTo(String value) {
            this.addCriterion("from_page_name <=", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameLike(String value) {
            this.addCriterion("from_page_name like", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameNotLike(String value) {
            this.addCriterion("from_page_name not like", value, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameIn(List<String> values) {
            this.addCriterion("from_page_name in", values, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameNotIn(List<String> values) {
            this.addCriterion("from_page_name not in", values, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameBetween(String value1, String value2) {
            this.addCriterion("from_page_name between", value1, value2, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andFromPageNameNotBetween(String value1, String value2) {
            this.addCriterion("from_page_name not between", value1, value2, "fromPageName");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdIsNull() {
            this.addCriterion("cookie_id is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdIsNotNull() {
            this.addCriterion("cookie_id is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdEqualTo(String value) {
            this.addCriterion("cookie_id =", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdNotEqualTo(String value) {
            this.addCriterion("cookie_id <>", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdGreaterThan(String value) {
            this.addCriterion("cookie_id >", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("cookie_id >=", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdLessThan(String value) {
            this.addCriterion("cookie_id <", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdLessThanOrEqualTo(String value) {
            this.addCriterion("cookie_id <=", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdLike(String value) {
            this.addCriterion("cookie_id like", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdNotLike(String value) {
            this.addCriterion("cookie_id not like", value, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdIn(List<String> values) {
            this.addCriterion("cookie_id in", values, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdNotIn(List<String> values) {
            this.addCriterion("cookie_id not in", values, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdBetween(String value1, String value2) {
            this.addCriterion("cookie_id between", value1, value2, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andCookieIdNotBetween(String value1, String value2) {
            this.addCriterion("cookie_id not between", value1, value2, "cookieId");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlIsNull() {
            this.addCriterion("brower_url is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlIsNotNull() {
            this.addCriterion("brower_url is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlEqualTo(String value) {
            this.addCriterion("brower_url =", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlNotEqualTo(String value) {
            this.addCriterion("brower_url <>", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlGreaterThan(String value) {
            this.addCriterion("brower_url >", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("brower_url >=", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlLessThan(String value) {
            this.addCriterion("brower_url <", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlLessThanOrEqualTo(String value) {
            this.addCriterion("brower_url <=", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlLike(String value) {
            this.addCriterion("brower_url like", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlNotLike(String value) {
            this.addCriterion("brower_url not like", value, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlIn(List<String> values) {
            this.addCriterion("brower_url in", values, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlNotIn(List<String> values) {
            this.addCriterion("brower_url not in", values, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlBetween(String value1, String value2) {
            this.addCriterion("brower_url between", value1, value2, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andBrowerUrlNotBetween(String value1, String value2) {
            this.addCriterion("brower_url not between", value1, value2, "browerUrl");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }

        public ShiguPageRecodeExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguPageRecodeExample.Criteria)this;
        }
    }
}
