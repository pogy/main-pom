package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguShopExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ShiguShopExample() {
    }

    private Integer startIndex;
    private Integer endIndex;
    private String fields;
    protected String sqlStirng;
    private String webSite;

    public String getWebSite() {
        return this.webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getSqlStirng() {
        return this.sqlStirng;
    }

    public void setSqlStirng(String sqlStirng) {
        this.sqlStirng = sqlStirng;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public String getFields() {
        return this.fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
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

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andSynTaobaoIsNull() {
            this.addCriterion("syn_taobao is null");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoIsNotNull() {
            this.addCriterion("syn_taobao is not null");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoEqualTo(Integer value) {
            this.addCriterion("syn_taobao =", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoNotEqualTo(Integer value) {
            this.addCriterion("syn_taobao <>", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoGreaterThan(Integer value) {
            this.addCriterion("syn_taobao >", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("syn_taobao >=", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoLessThan(Integer value) {
            this.addCriterion("syn_taobao <", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoLessThanOrEqualTo(Integer value) {
            this.addCriterion("syn_taobao <=", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoLike(String value) {
            this.addCriterion("syn_taobao like", value, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoNotLike(String value) {
            this.addCriterion("syn_taobao not like", value, "synTaobao");
            return (Criteria)this;
        }        public Criteria andSynTaobaoIn(List<Integer> values) {
            this.addCriterion("syn_taobao in", values, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoNotIn(List<Integer> values) {
            this.addCriterion("syn_taobao not in", values, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoBetween(Integer value1, Integer value2) {
            this.addCriterion("syn_taobao between", value1, value2, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andSynTaobaoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("syn_taobao not between", value1, value2, "synTaobao");
            return (Criteria)this;
        }

        public Criteria andUserManagerIsNull() {
            this.addCriterion("user_manager is null");
            return (Criteria)this;
        }

        public Criteria andUserManagerIsNotNull() {
            this.addCriterion("user_manager is not null");
            return (Criteria)this;
        }

        public Criteria andUserManagerEqualTo(Integer value) {
            this.addCriterion("user_manager =", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerNotEqualTo(Integer value) {
            this.addCriterion("user_manager <>", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerGreaterThan(Integer value) {
            this.addCriterion("user_manager >", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("user_manager >=", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerLessThan(Integer value) {
            this.addCriterion("user_manager <", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerLessThanOrEqualTo(Integer value) {
            this.addCriterion("user_manager <=", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerLike(String value) {
            this.addCriterion("user_manager like", value, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerNotLike(String value) {
            this.addCriterion("user_manager not like", value, "userManager");
            return (Criteria)this;
        }        public Criteria andUserManagerIn(List<Integer> values) {
            this.addCriterion("user_manager in", values, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerNotIn(List<Integer> values) {
            this.addCriterion("user_manager not in", values, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerBetween(Integer value1, Integer value2) {
            this.addCriterion("user_manager between", value1, value2, "userManager");
            return (Criteria)this;
        }

        public Criteria andUserManagerNotBetween(Integer value1, Integer value2) {
            this.addCriterion("user_manager not between", value1, value2, "userManager");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementIsNull() {
            this.addCriterion("shop_announcement is null");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementIsNotNull() {
            this.addCriterion("shop_announcement is not null");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementEqualTo(String value) {
            this.addCriterion("shop_announcement =", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementNotEqualTo(String value) {
            this.addCriterion("shop_announcement <>", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementGreaterThan(String value) {
            this.addCriterion("shop_announcement >", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_announcement >=", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementLessThan(String value) {
            this.addCriterion("shop_announcement <", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementLessThanOrEqualTo(String value) {
            this.addCriterion("shop_announcement <=", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementLike(String value) {
            this.addCriterion("shop_announcement like", value, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementNotLike(String value) {
            this.addCriterion("shop_announcement not like", value, "shopAnnouncement");
            return (Criteria)this;
        }        public Criteria andShopAnnouncementIn(List<String> values) {
            this.addCriterion("shop_announcement in", values, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementNotIn(List<String> values) {
            this.addCriterion("shop_announcement not in", values, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementBetween(String value1, String value2) {
            this.addCriterion("shop_announcement between", value1, value2, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andShopAnnouncementNotBetween(String value1, String value2) {
            this.addCriterion("shop_announcement not between", value1, value2, "shopAnnouncement");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (Criteria)this;
        }        public Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andShopNumIsNull() {
            this.addCriterion("shop_num is null");
            return (Criteria)this;
        }

        public Criteria andShopNumIsNotNull() {
            this.addCriterion("shop_num is not null");
            return (Criteria)this;
        }

        public Criteria andShopNumEqualTo(String value) {
            this.addCriterion("shop_num =", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotEqualTo(String value) {
            this.addCriterion("shop_num <>", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumGreaterThan(String value) {
            this.addCriterion("shop_num >", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_num >=", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumLessThan(String value) {
            this.addCriterion("shop_num <", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumLessThanOrEqualTo(String value) {
            this.addCriterion("shop_num <=", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumLike(String value) {
            this.addCriterion("shop_num like", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotLike(String value) {
            this.addCriterion("shop_num not like", value, "shopNum");
            return (Criteria)this;
        }        public Criteria andShopNumIn(List<String> values) {
            this.addCriterion("shop_num in", values, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotIn(List<String> values) {
            this.addCriterion("shop_num not in", values, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumBetween(String value1, String value2) {
            this.addCriterion("shop_num between", value1, value2, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotBetween(String value1, String value2) {
            this.addCriterion("shop_num not between", value1, value2, "shopNum");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyIsNull() {
            this.addCriterion("sort_order_key is null");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyIsNotNull() {
            this.addCriterion("sort_order_key is not null");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyEqualTo(String value) {
            this.addCriterion("sort_order_key =", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyNotEqualTo(String value) {
            this.addCriterion("sort_order_key <>", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyGreaterThan(String value) {
            this.addCriterion("sort_order_key >", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("sort_order_key >=", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyLessThan(String value) {
            this.addCriterion("sort_order_key <", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyLessThanOrEqualTo(String value) {
            this.addCriterion("sort_order_key <=", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyLike(String value) {
            this.addCriterion("sort_order_key like", value, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyNotLike(String value) {
            this.addCriterion("sort_order_key not like", value, "sortOrderKey");
            return (Criteria)this;
        }        public Criteria andSortOrderKeyIn(List<String> values) {
            this.addCriterion("sort_order_key in", values, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyNotIn(List<String> values) {
            this.addCriterion("sort_order_key not in", values, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyBetween(String value1, String value2) {
            this.addCriterion("sort_order_key between", value1, value2, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andSortOrderKeyNotBetween(String value1, String value2) {
            this.addCriterion("sort_order_key not between", value1, value2, "sortOrderKey");
            return (Criteria)this;
        }

        public Criteria andEverUserIdIsNull() {
            this.addCriterion("ever_user_id is null");
            return (Criteria)this;
        }

        public Criteria andEverUserIdIsNotNull() {
            this.addCriterion("ever_user_id is not null");
            return (Criteria)this;
        }

        public Criteria andEverUserIdEqualTo(Long value) {
            this.addCriterion("ever_user_id =", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdNotEqualTo(Long value) {
            this.addCriterion("ever_user_id <>", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdGreaterThan(Long value) {
            this.addCriterion("ever_user_id >", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("ever_user_id >=", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdLessThan(Long value) {
            this.addCriterion("ever_user_id <", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("ever_user_id <=", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdLike(String value) {
            this.addCriterion("ever_user_id like", value, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdNotLike(String value) {
            this.addCriterion("ever_user_id not like", value, "everUserId");
            return (Criteria)this;
        }        public Criteria andEverUserIdIn(List<Long> values) {
            this.addCriterion("ever_user_id in", values, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdNotIn(List<Long> values) {
            this.addCriterion("ever_user_id not in", values, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdBetween(Long value1, Long value2) {
            this.addCriterion("ever_user_id between", value1, value2, "everUserId");
            return (Criteria)this;
        }

        public Criteria andEverUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("ever_user_id not between", value1, value2, "everUserId");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonIsNull() {
            this.addCriterion("system_recommon is null");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonIsNotNull() {
            this.addCriterion("system_recommon is not null");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonEqualTo(String value) {
            this.addCriterion("system_recommon =", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonNotEqualTo(String value) {
            this.addCriterion("system_recommon <>", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonGreaterThan(String value) {
            this.addCriterion("system_recommon >", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonGreaterThanOrEqualTo(String value) {
            this.addCriterion("system_recommon >=", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonLessThan(String value) {
            this.addCriterion("system_recommon <", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonLessThanOrEqualTo(String value) {
            this.addCriterion("system_recommon <=", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonLike(String value) {
            this.addCriterion("system_recommon like", value, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonNotLike(String value) {
            this.addCriterion("system_recommon not like", value, "systemRecommon");
            return (Criteria)this;
        }        public Criteria andSystemRecommonIn(List<String> values) {
            this.addCriterion("system_recommon in", values, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonNotIn(List<String> values) {
            this.addCriterion("system_recommon not in", values, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonBetween(String value1, String value2) {
            this.addCriterion("system_recommon between", value1, value2, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andSystemRecommonNotBetween(String value1, String value2) {
            this.addCriterion("system_recommon not between", value1, value2, "systemRecommon");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneIsNull() {
            this.addCriterion("mobile_phone is null");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            this.addCriterion("mobile_phone is not null");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            this.addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            this.addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            this.addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            this.addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            this.addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneLike(String value) {
            this.addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            this.addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria)this;
        }        public Criteria andMobilePhoneIn(List<String> values) {
            this.addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            this.addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            this.addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            this.addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlIsNull() {
            this.addCriterion("taobao_url is null");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlIsNotNull() {
            this.addCriterion("taobao_url is not null");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlEqualTo(String value) {
            this.addCriterion("taobao_url =", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlNotEqualTo(String value) {
            this.addCriterion("taobao_url <>", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlGreaterThan(String value) {
            this.addCriterion("taobao_url >", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_url >=", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlLessThan(String value) {
            this.addCriterion("taobao_url <", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_url <=", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlLike(String value) {
            this.addCriterion("taobao_url like", value, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlNotLike(String value) {
            this.addCriterion("taobao_url not like", value, "taobaoUrl");
            return (Criteria)this;
        }        public Criteria andTaobaoUrlIn(List<String> values) {
            this.addCriterion("taobao_url in", values, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlNotIn(List<String> values) {
            this.addCriterion("taobao_url not in", values, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlBetween(String value1, String value2) {
            this.addCriterion("taobao_url between", value1, value2, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andTaobaoUrlNotBetween(String value1, String value2) {
            this.addCriterion("taobao_url not between", value1, value2, "taobaoUrl");
            return (Criteria)this;
        }

        public Criteria andCreateDateIsNull() {
            this.addCriterion("create_date is null");
            return (Criteria)this;
        }

        public Criteria andCreateDateIsNotNull() {
            this.addCriterion("create_date is not null");
            return (Criteria)this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            this.addCriterion("create_date =", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            this.addCriterion("create_date <>", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            this.addCriterion("create_date >", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_date >=", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            this.addCriterion("create_date <", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            this.addCriterion("create_date <=", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateLike(String value) {
            this.addCriterion("create_date like", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotLike(String value) {
            this.addCriterion("create_date not like", value, "createDate");
            return (Criteria)this;
        }        public Criteria andCreateDateIn(List<Date> values) {
            this.addCriterion("create_date in", values, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            this.addCriterion("create_date not in", values, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            this.addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            this.addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria)this;
        }

        public Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (Criteria)this;
        }

        public Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (Criteria)this;
        }

        public Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (Criteria)this;
        }        public Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (Criteria)this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketIsNull() {
            this.addCriterion("display_in_market is null");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketIsNotNull() {
            this.addCriterion("display_in_market is not null");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketEqualTo(Integer value) {
            this.addCriterion("display_in_market =", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketNotEqualTo(Integer value) {
            this.addCriterion("display_in_market <>", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketGreaterThan(Integer value) {
            this.addCriterion("display_in_market >", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("display_in_market >=", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketLessThan(Integer value) {
            this.addCriterion("display_in_market <", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketLessThanOrEqualTo(Integer value) {
            this.addCriterion("display_in_market <=", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketLike(String value) {
            this.addCriterion("display_in_market like", value, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketNotLike(String value) {
            this.addCriterion("display_in_market not like", value, "displayInMarket");
            return (Criteria)this;
        }        public Criteria andDisplayInMarketIn(List<Integer> values) {
            this.addCriterion("display_in_market in", values, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketNotIn(List<Integer> values) {
            this.addCriterion("display_in_market not in", values, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketBetween(Integer value1, Integer value2) {
            this.addCriterion("display_in_market between", value1, value2, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andDisplayInMarketNotBetween(Integer value1, Integer value2) {
            this.addCriterion("display_in_market not between", value1, value2, "displayInMarket");
            return (Criteria)this;
        }

        public Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (Criteria)this;
        }

        public Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (Criteria)this;
        }

        public Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (Criteria)this;
        }        public Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (Criteria)this;
        }

        public Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (Criteria)this;
        }

        public Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (Criteria)this;
        }

        public Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (Criteria)this;
        }        public Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (Criteria)this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (Criteria)this;
        }

        public Criteria andShopStatusIsNull() {
            this.addCriterion("shop_status is null");
            return (Criteria)this;
        }

        public Criteria andShopStatusIsNotNull() {
            this.addCriterion("shop_status is not null");
            return (Criteria)this;
        }

        public Criteria andShopStatusEqualTo(Integer value) {
            this.addCriterion("shop_status =", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusNotEqualTo(Integer value) {
            this.addCriterion("shop_status <>", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusGreaterThan(Integer value) {
            this.addCriterion("shop_status >", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("shop_status >=", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusLessThan(Integer value) {
            this.addCriterion("shop_status <", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("shop_status <=", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusLike(String value) {
            this.addCriterion("shop_status like", value, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusNotLike(String value) {
            this.addCriterion("shop_status not like", value, "shopStatus");
            return (Criteria)this;
        }        public Criteria andShopStatusIn(List<Integer> values) {
            this.addCriterion("shop_status in", values, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusNotIn(List<Integer> values) {
            this.addCriterion("shop_status not in", values, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("shop_status between", value1, value2, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andShopStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("shop_status not between", value1, value2, "shopStatus");
            return (Criteria)this;
        }

        public Criteria andImWxIsNull() {
            this.addCriterion("im_wx is null");
            return (Criteria)this;
        }

        public Criteria andImWxIsNotNull() {
            this.addCriterion("im_wx is not null");
            return (Criteria)this;
        }

        public Criteria andImWxEqualTo(String value) {
            this.addCriterion("im_wx =", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxNotEqualTo(String value) {
            this.addCriterion("im_wx <>", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxGreaterThan(String value) {
            this.addCriterion("im_wx >", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_wx >=", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxLessThan(String value) {
            this.addCriterion("im_wx <", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxLessThanOrEqualTo(String value) {
            this.addCriterion("im_wx <=", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxLike(String value) {
            this.addCriterion("im_wx like", value, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxNotLike(String value) {
            this.addCriterion("im_wx not like", value, "imWx");
            return (Criteria)this;
        }        public Criteria andImWxIn(List<String> values) {
            this.addCriterion("im_wx in", values, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxNotIn(List<String> values) {
            this.addCriterion("im_wx not in", values, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxBetween(String value1, String value2) {
            this.addCriterion("im_wx between", value1, value2, "imWx");
            return (Criteria)this;
        }

        public Criteria andImWxNotBetween(String value1, String value2) {
            this.addCriterion("im_wx not between", value1, value2, "imWx");
            return (Criteria)this;
        }

        public Criteria andTbNickIsNull() {
            this.addCriterion("tb_nick is null");
            return (Criteria)this;
        }

        public Criteria andTbNickIsNotNull() {
            this.addCriterion("tb_nick is not null");
            return (Criteria)this;
        }

        public Criteria andTbNickEqualTo(String value) {
            this.addCriterion("tb_nick =", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickNotEqualTo(String value) {
            this.addCriterion("tb_nick <>", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickGreaterThan(String value) {
            this.addCriterion("tb_nick >", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("tb_nick >=", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickLessThan(String value) {
            this.addCriterion("tb_nick <", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickLessThanOrEqualTo(String value) {
            this.addCriterion("tb_nick <=", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickLike(String value) {
            this.addCriterion("tb_nick like", value, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickNotLike(String value) {
            this.addCriterion("tb_nick not like", value, "tbNick");
            return (Criteria)this;
        }        public Criteria andTbNickIn(List<String> values) {
            this.addCriterion("tb_nick in", values, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickNotIn(List<String> values) {
            this.addCriterion("tb_nick not in", values, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickBetween(String value1, String value2) {
            this.addCriterion("tb_nick between", value1, value2, "tbNick");
            return (Criteria)this;
        }

        public Criteria andTbNickNotBetween(String value1, String value2) {
            this.addCriterion("tb_nick not between", value1, value2, "tbNick");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (Criteria)this;
        }

        public Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (Criteria)this;
        }        public Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (Criteria)this;
        }

        public Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (Criteria)this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (Criteria)this;
        }        public Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria)this;
        }

        public Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (Criteria)this;
        }

        public Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (Criteria)this;
        }

        public Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (Criteria)this;
        }        public Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (Criteria)this;
        }

        public Criteria andShopNameIsNull() {
            this.addCriterion("shop_name is null");
            return (Criteria)this;
        }

        public Criteria andShopNameIsNotNull() {
            this.addCriterion("shop_name is not null");
            return (Criteria)this;
        }

        public Criteria andShopNameEqualTo(String value) {
            this.addCriterion("shop_name =", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            this.addCriterion("shop_name <>", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            this.addCriterion("shop_name >", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_name >=", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameLessThan(String value) {
            this.addCriterion("shop_name <", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            this.addCriterion("shop_name <=", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameLike(String value) {
            this.addCriterion("shop_name like", value, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameNotLike(String value) {
            this.addCriterion("shop_name not like", value, "shopName");
            return (Criteria)this;
        }        public Criteria andShopNameIn(List<String> values) {
            this.addCriterion("shop_name in", values, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            this.addCriterion("shop_name not in", values, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            this.addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria)this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            this.addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdIsNull() {
            this.addCriterion("item_link_id is null");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdIsNotNull() {
            this.addCriterion("item_link_id is not null");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdEqualTo(Long value) {
            this.addCriterion("item_link_id =", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdNotEqualTo(Long value) {
            this.addCriterion("item_link_id <>", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdGreaterThan(Long value) {
            this.addCriterion("item_link_id >", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("item_link_id >=", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdLessThan(Long value) {
            this.addCriterion("item_link_id <", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdLessThanOrEqualTo(Long value) {
            this.addCriterion("item_link_id <=", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdLike(String value) {
            this.addCriterion("item_link_id like", value, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdNotLike(String value) {
            this.addCriterion("item_link_id not like", value, "itemLinkId");
            return (Criteria)this;
        }        public Criteria andItemLinkIdIn(List<Long> values) {
            this.addCriterion("item_link_id in", values, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdNotIn(List<Long> values) {
            this.addCriterion("item_link_id not in", values, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdBetween(Long value1, Long value2) {
            this.addCriterion("item_link_id between", value1, value2, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andItemLinkIdNotBetween(Long value1, Long value2) {
            this.addCriterion("item_link_id not between", value1, value2, "itemLinkId");
            return (Criteria)this;
        }

        public Criteria andZipcodeIsNull() {
            this.addCriterion("zipcode is null");
            return (Criteria)this;
        }

        public Criteria andZipcodeIsNotNull() {
            this.addCriterion("zipcode is not null");
            return (Criteria)this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            this.addCriterion("zipcode =", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            this.addCriterion("zipcode <>", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            this.addCriterion("zipcode >", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zipcode >=", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeLessThan(String value) {
            this.addCriterion("zipcode <", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            this.addCriterion("zipcode <=", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeLike(String value) {
            this.addCriterion("zipcode like", value, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeNotLike(String value) {
            this.addCriterion("zipcode not like", value, "zipcode");
            return (Criteria)this;
        }        public Criteria andZipcodeIn(List<String> values) {
            this.addCriterion("zipcode in", values, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            this.addCriterion("zipcode not in", values, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            this.addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria)this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            this.addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria)this;
        }

        public Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (Criteria)this;
        }

        public Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (Criteria)this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (Criteria)this;
        }        public Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (Criteria)this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (Criteria)this;
        }        public Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andDomainIsNull() {
            this.addCriterion("domain is null");
            return (Criteria)this;
        }

        public Criteria andDomainIsNotNull() {
            this.addCriterion("domain is not null");
            return (Criteria)this;
        }

        public Criteria andDomainEqualTo(String value) {
            this.addCriterion("domain =", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            this.addCriterion("domain <>", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainGreaterThan(String value) {
            this.addCriterion("domain >", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            this.addCriterion("domain >=", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainLessThan(String value) {
            this.addCriterion("domain <", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            this.addCriterion("domain <=", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainLike(String value) {
            this.addCriterion("domain like", value, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainNotLike(String value) {
            this.addCriterion("domain not like", value, "domain");
            return (Criteria)this;
        }        public Criteria andDomainIn(List<String> values) {
            this.addCriterion("domain in", values, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            this.addCriterion("domain not in", values, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            this.addCriterion("domain between", value1, value2, "domain");
            return (Criteria)this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            this.addCriterion("domain not between", value1, value2, "domain");
            return (Criteria)this;
        }

        public Criteria andFloorIdIsNull() {
            this.addCriterion("floor_id is null");
            return (Criteria)this;
        }

        public Criteria andFloorIdIsNotNull() {
            this.addCriterion("floor_id is not null");
            return (Criteria)this;
        }

        public Criteria andFloorIdEqualTo(Long value) {
            this.addCriterion("floor_id =", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotEqualTo(Long value) {
            this.addCriterion("floor_id <>", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdGreaterThan(Long value) {
            this.addCriterion("floor_id >", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("floor_id >=", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdLessThan(Long value) {
            this.addCriterion("floor_id <", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdLessThanOrEqualTo(Long value) {
            this.addCriterion("floor_id <=", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdLike(String value) {
            this.addCriterion("floor_id like", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotLike(String value) {
            this.addCriterion("floor_id not like", value, "floorId");
            return (Criteria)this;
        }        public Criteria andFloorIdIn(List<Long> values) {
            this.addCriterion("floor_id in", values, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotIn(List<Long> values) {
            this.addCriterion("floor_id not in", values, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdBetween(Long value1, Long value2) {
            this.addCriterion("floor_id between", value1, value2, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotBetween(Long value1, Long value2) {
            this.addCriterion("floor_id not between", value1, value2, "floorId");
            return (Criteria)this;
        }

        public Criteria andPriceRuleIsNull() {
            this.addCriterion("price_rule is null");
            return (Criteria)this;
        }

        public Criteria andPriceRuleIsNotNull() {
            this.addCriterion("price_rule is not null");
            return (Criteria)this;
        }

        public Criteria andPriceRuleEqualTo(String value) {
            this.addCriterion("price_rule =", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleNotEqualTo(String value) {
            this.addCriterion("price_rule <>", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleGreaterThan(String value) {
            this.addCriterion("price_rule >", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_rule >=", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleLessThan(String value) {
            this.addCriterion("price_rule <", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleLessThanOrEqualTo(String value) {
            this.addCriterion("price_rule <=", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleLike(String value) {
            this.addCriterion("price_rule like", value, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleNotLike(String value) {
            this.addCriterion("price_rule not like", value, "priceRule");
            return (Criteria)this;
        }        public Criteria andPriceRuleIn(List<String> values) {
            this.addCriterion("price_rule in", values, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleNotIn(List<String> values) {
            this.addCriterion("price_rule not in", values, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleBetween(String value1, String value2) {
            this.addCriterion("price_rule between", value1, value2, "priceRule");
            return (Criteria)this;
        }

        public Criteria andPriceRuleNotBetween(String value1, String value2) {
            this.addCriterion("price_rule not between", value1, value2, "priceRule");
            return (Criteria)this;
        }

        public Criteria andCloseReasonIsNull() {
            this.addCriterion("close_reason is null");
            return (Criteria)this;
        }

        public Criteria andCloseReasonIsNotNull() {
            this.addCriterion("close_reason is not null");
            return (Criteria)this;
        }

        public Criteria andCloseReasonEqualTo(String value) {
            this.addCriterion("close_reason =", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonNotEqualTo(String value) {
            this.addCriterion("close_reason <>", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonGreaterThan(String value) {
            this.addCriterion("close_reason >", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("close_reason >=", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonLessThan(String value) {
            this.addCriterion("close_reason <", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonLessThanOrEqualTo(String value) {
            this.addCriterion("close_reason <=", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonLike(String value) {
            this.addCriterion("close_reason like", value, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonNotLike(String value) {
            this.addCriterion("close_reason not like", value, "closeReason");
            return (Criteria)this;
        }        public Criteria andCloseReasonIn(List<String> values) {
            this.addCriterion("close_reason in", values, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonNotIn(List<String> values) {
            this.addCriterion("close_reason not in", values, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonBetween(String value1, String value2) {
            this.addCriterion("close_reason between", value1, value2, "closeReason");
            return (Criteria)this;
        }

        public Criteria andCloseReasonNotBetween(String value1, String value2) {
            this.addCriterion("close_reason not between", value1, value2, "closeReason");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (Criteria)this;
        }

        public Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (Criteria)this;
        }        public Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlIsNull() {
            this.addCriterion("data_packet_url is null");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlIsNotNull() {
            this.addCriterion("data_packet_url is not null");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlEqualTo(String value) {
            this.addCriterion("data_packet_url =", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlNotEqualTo(String value) {
            this.addCriterion("data_packet_url <>", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlGreaterThan(String value) {
            this.addCriterion("data_packet_url >", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("data_packet_url >=", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlLessThan(String value) {
            this.addCriterion("data_packet_url <", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlLessThanOrEqualTo(String value) {
            this.addCriterion("data_packet_url <=", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlLike(String value) {
            this.addCriterion("data_packet_url like", value, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlNotLike(String value) {
            this.addCriterion("data_packet_url not like", value, "dataPacketUrl");
            return (Criteria)this;
        }        public Criteria andDataPacketUrlIn(List<String> values) {
            this.addCriterion("data_packet_url in", values, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlNotIn(List<String> values) {
            this.addCriterion("data_packet_url not in", values, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlBetween(String value1, String value2) {
            this.addCriterion("data_packet_url between", value1, value2, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andDataPacketUrlNotBetween(String value1, String value2) {
            this.addCriterion("data_packet_url not between", value1, value2, "dataPacketUrl");
            return (Criteria)this;
        }

        public Criteria andMainBusIsNull() {
            this.addCriterion("main_bus is null");
            return (Criteria)this;
        }

        public Criteria andMainBusIsNotNull() {
            this.addCriterion("main_bus is not null");
            return (Criteria)this;
        }

        public Criteria andMainBusEqualTo(String value) {
            this.addCriterion("main_bus =", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusNotEqualTo(String value) {
            this.addCriterion("main_bus <>", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusGreaterThan(String value) {
            this.addCriterion("main_bus >", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusGreaterThanOrEqualTo(String value) {
            this.addCriterion("main_bus >=", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusLessThan(String value) {
            this.addCriterion("main_bus <", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusLessThanOrEqualTo(String value) {
            this.addCriterion("main_bus <=", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusLike(String value) {
            this.addCriterion("main_bus like", value, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusNotLike(String value) {
            this.addCriterion("main_bus not like", value, "mainBus");
            return (Criteria)this;
        }        public Criteria andMainBusIn(List<String> values) {
            this.addCriterion("main_bus in", values, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusNotIn(List<String> values) {
            this.addCriterion("main_bus not in", values, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusBetween(String value1, String value2) {
            this.addCriterion("main_bus between", value1, value2, "mainBus");
            return (Criteria)this;
        }

        public Criteria andMainBusNotBetween(String value1, String value2) {
            this.addCriterion("main_bus not between", value1, value2, "mainBus");
            return (Criteria)this;
        }
    }
}
