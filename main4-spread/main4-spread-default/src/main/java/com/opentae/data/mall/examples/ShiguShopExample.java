package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguShopExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguShopExample.Criteria> oredCriteria = new ArrayList();

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

    public List<ShiguShopExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguShopExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguShopExample.Criteria or() {
        ShiguShopExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguShopExample.Criteria createCriteria() {
        ShiguShopExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguShopExample.Criteria createCriteriaInternal() {
        ShiguShopExample.Criteria criteria = new ShiguShopExample.Criteria();
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

    public static class Criteria extends ShiguShopExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguShopExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguShopExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguShopExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguShopExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguShopExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguShopExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguShopExample.Criteria andSynTaobaoIsNull() {
            this.addCriterion("syn_taobao is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoIsNotNull() {
            this.addCriterion("syn_taobao is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoEqualTo(Integer value) {
            this.addCriterion("syn_taobao =", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoNotEqualTo(Integer value) {
            this.addCriterion("syn_taobao <>", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoGreaterThan(Integer value) {
            this.addCriterion("syn_taobao >", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("syn_taobao >=", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoLessThan(Integer value) {
            this.addCriterion("syn_taobao <", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoLessThanOrEqualTo(Integer value) {
            this.addCriterion("syn_taobao <=", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoLike(String value) {
            this.addCriterion("syn_taobao like", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoNotLike(String value) {
            this.addCriterion("syn_taobao not like", value, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andSynTaobaoIn(List<Integer> values) {
            this.addCriterion("syn_taobao in", values, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoNotIn(List<Integer> values) {
            this.addCriterion("syn_taobao not in", values, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoBetween(Integer value1, Integer value2) {
            this.addCriterion("syn_taobao between", value1, value2, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSynTaobaoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("syn_taobao not between", value1, value2, "synTaobao");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerIsNull() {
            this.addCriterion("user_manager is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerIsNotNull() {
            this.addCriterion("user_manager is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerEqualTo(Integer value) {
            this.addCriterion("user_manager =", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerNotEqualTo(Integer value) {
            this.addCriterion("user_manager <>", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerGreaterThan(Integer value) {
            this.addCriterion("user_manager >", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("user_manager >=", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerLessThan(Integer value) {
            this.addCriterion("user_manager <", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerLessThanOrEqualTo(Integer value) {
            this.addCriterion("user_manager <=", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerLike(String value) {
            this.addCriterion("user_manager like", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerNotLike(String value) {
            this.addCriterion("user_manager not like", value, "userManager");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andUserManagerIn(List<Integer> values) {
            this.addCriterion("user_manager in", values, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerNotIn(List<Integer> values) {
            this.addCriterion("user_manager not in", values, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerBetween(Integer value1, Integer value2) {
            this.addCriterion("user_manager between", value1, value2, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserManagerNotBetween(Integer value1, Integer value2) {
            this.addCriterion("user_manager not between", value1, value2, "userManager");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementIsNull() {
            this.addCriterion("shop_announcement is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementIsNotNull() {
            this.addCriterion("shop_announcement is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementEqualTo(String value) {
            this.addCriterion("shop_announcement =", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotEqualTo(String value) {
            this.addCriterion("shop_announcement <>", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementGreaterThan(String value) {
            this.addCriterion("shop_announcement >", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_announcement >=", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementLessThan(String value) {
            this.addCriterion("shop_announcement <", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementLessThanOrEqualTo(String value) {
            this.addCriterion("shop_announcement <=", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementLike(String value) {
            this.addCriterion("shop_announcement like", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotLike(String value) {
            this.addCriterion("shop_announcement not like", value, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andShopAnnouncementIn(List<String> values) {
            this.addCriterion("shop_announcement in", values, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotIn(List<String> values) {
            this.addCriterion("shop_announcement not in", values, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementBetween(String value1, String value2) {
            this.addCriterion("shop_announcement between", value1, value2, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotBetween(String value1, String value2) {
            this.addCriterion("shop_announcement not between", value1, value2, "shopAnnouncement");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumIsNull() {
            this.addCriterion("shop_num is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumIsNotNull() {
            this.addCriterion("shop_num is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumEqualTo(String value) {
            this.addCriterion("shop_num =", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumNotEqualTo(String value) {
            this.addCriterion("shop_num <>", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumGreaterThan(String value) {
            this.addCriterion("shop_num >", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_num >=", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumLessThan(String value) {
            this.addCriterion("shop_num <", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            this.addCriterion("shop_num <=", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumLike(String value) {
            this.addCriterion("shop_num like", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumNotLike(String value) {
            this.addCriterion("shop_num not like", value, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andShopNumIn(List<String> values) {
            this.addCriterion("shop_num in", values, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumNotIn(List<String> values) {
            this.addCriterion("shop_num not in", values, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumBetween(String value1, String value2) {
            this.addCriterion("shop_num between", value1, value2, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNumNotBetween(String value1, String value2) {
            this.addCriterion("shop_num not between", value1, value2, "shopNum");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyIsNull() {
            this.addCriterion("sort_order_key is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyIsNotNull() {
            this.addCriterion("sort_order_key is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyEqualTo(String value) {
            this.addCriterion("sort_order_key =", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotEqualTo(String value) {
            this.addCriterion("sort_order_key <>", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyGreaterThan(String value) {
            this.addCriterion("sort_order_key >", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("sort_order_key >=", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyLessThan(String value) {
            this.addCriterion("sort_order_key <", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyLessThanOrEqualTo(String value) {
            this.addCriterion("sort_order_key <=", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyLike(String value) {
            this.addCriterion("sort_order_key like", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotLike(String value) {
            this.addCriterion("sort_order_key not like", value, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andSortOrderKeyIn(List<String> values) {
            this.addCriterion("sort_order_key in", values, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotIn(List<String> values) {
            this.addCriterion("sort_order_key not in", values, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyBetween(String value1, String value2) {
            this.addCriterion("sort_order_key between", value1, value2, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotBetween(String value1, String value2) {
            this.addCriterion("sort_order_key not between", value1, value2, "sortOrderKey");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdIsNull() {
            this.addCriterion("ever_user_id is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdIsNotNull() {
            this.addCriterion("ever_user_id is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdEqualTo(Long value) {
            this.addCriterion("ever_user_id =", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdNotEqualTo(Long value) {
            this.addCriterion("ever_user_id <>", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdGreaterThan(Long value) {
            this.addCriterion("ever_user_id >", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("ever_user_id >=", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdLessThan(Long value) {
            this.addCriterion("ever_user_id <", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("ever_user_id <=", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdLike(String value) {
            this.addCriterion("ever_user_id like", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdNotLike(String value) {
            this.addCriterion("ever_user_id not like", value, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andEverUserIdIn(List<Long> values) {
            this.addCriterion("ever_user_id in", values, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdNotIn(List<Long> values) {
            this.addCriterion("ever_user_id not in", values, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdBetween(Long value1, Long value2) {
            this.addCriterion("ever_user_id between", value1, value2, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEverUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("ever_user_id not between", value1, value2, "everUserId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonIsNull() {
            this.addCriterion("system_recommon is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonIsNotNull() {
            this.addCriterion("system_recommon is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonEqualTo(String value) {
            this.addCriterion("system_recommon =", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonNotEqualTo(String value) {
            this.addCriterion("system_recommon <>", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonGreaterThan(String value) {
            this.addCriterion("system_recommon >", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonGreaterThanOrEqualTo(String value) {
            this.addCriterion("system_recommon >=", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonLessThan(String value) {
            this.addCriterion("system_recommon <", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonLessThanOrEqualTo(String value) {
            this.addCriterion("system_recommon <=", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonLike(String value) {
            this.addCriterion("system_recommon like", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonNotLike(String value) {
            this.addCriterion("system_recommon not like", value, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andSystemRecommonIn(List<String> values) {
            this.addCriterion("system_recommon in", values, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonNotIn(List<String> values) {
            this.addCriterion("system_recommon not in", values, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonBetween(String value1, String value2) {
            this.addCriterion("system_recommon between", value1, value2, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andSystemRecommonNotBetween(String value1, String value2) {
            this.addCriterion("system_recommon not between", value1, value2, "systemRecommon");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneIsNull() {
            this.addCriterion("mobile_phone is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneIsNotNull() {
            this.addCriterion("mobile_phone is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneEqualTo(String value) {
            this.addCriterion("mobile_phone =", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneNotEqualTo(String value) {
            this.addCriterion("mobile_phone <>", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneGreaterThan(String value) {
            this.addCriterion("mobile_phone >", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("mobile_phone >=", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneLessThan(String value) {
            this.addCriterion("mobile_phone <", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            this.addCriterion("mobile_phone <=", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneLike(String value) {
            this.addCriterion("mobile_phone like", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneNotLike(String value) {
            this.addCriterion("mobile_phone not like", value, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andMobilePhoneIn(List<String> values) {
            this.addCriterion("mobile_phone in", values, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneNotIn(List<String> values) {
            this.addCriterion("mobile_phone not in", values, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneBetween(String value1, String value2) {
            this.addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMobilePhoneNotBetween(String value1, String value2) {
            this.addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlIsNull() {
            this.addCriterion("taobao_url is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlIsNotNull() {
            this.addCriterion("taobao_url is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlEqualTo(String value) {
            this.addCriterion("taobao_url =", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotEqualTo(String value) {
            this.addCriterion("taobao_url <>", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlGreaterThan(String value) {
            this.addCriterion("taobao_url >", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_url >=", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlLessThan(String value) {
            this.addCriterion("taobao_url <", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_url <=", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlLike(String value) {
            this.addCriterion("taobao_url like", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotLike(String value) {
            this.addCriterion("taobao_url not like", value, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andTaobaoUrlIn(List<String> values) {
            this.addCriterion("taobao_url in", values, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotIn(List<String> values) {
            this.addCriterion("taobao_url not in", values, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlBetween(String value1, String value2) {
            this.addCriterion("taobao_url between", value1, value2, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotBetween(String value1, String value2) {
            this.addCriterion("taobao_url not between", value1, value2, "taobaoUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateIsNull() {
            this.addCriterion("create_date is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateIsNotNull() {
            this.addCriterion("create_date is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateEqualTo(Date value) {
            this.addCriterion("create_date =", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateNotEqualTo(Date value) {
            this.addCriterion("create_date <>", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateGreaterThan(Date value) {
            this.addCriterion("create_date >", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_date >=", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateLessThan(Date value) {
            this.addCriterion("create_date <", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            this.addCriterion("create_date <=", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateLike(String value) {
            this.addCriterion("create_date like", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateNotLike(String value) {
            this.addCriterion("create_date not like", value, "createDate");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andCreateDateIn(List<Date> values) {
            this.addCriterion("create_date in", values, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateNotIn(List<Date> values) {
            this.addCriterion("create_date not in", values, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            this.addCriterion("create_date between", value1, value2, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            this.addCriterion("create_date not between", value1, value2, "createDate");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketIsNull() {
            this.addCriterion("display_in_market is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketIsNotNull() {
            this.addCriterion("display_in_market is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketEqualTo(Integer value) {
            this.addCriterion("display_in_market =", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotEqualTo(Integer value) {
            this.addCriterion("display_in_market <>", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketGreaterThan(Integer value) {
            this.addCriterion("display_in_market >", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("display_in_market >=", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketLessThan(Integer value) {
            this.addCriterion("display_in_market <", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketLessThanOrEqualTo(Integer value) {
            this.addCriterion("display_in_market <=", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketLike(String value) {
            this.addCriterion("display_in_market like", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotLike(String value) {
            this.addCriterion("display_in_market not like", value, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andDisplayInMarketIn(List<Integer> values) {
            this.addCriterion("display_in_market in", values, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotIn(List<Integer> values) {
            this.addCriterion("display_in_market not in", values, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketBetween(Integer value1, Integer value2) {
            this.addCriterion("display_in_market between", value1, value2, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotBetween(Integer value1, Integer value2) {
            this.addCriterion("display_in_market not between", value1, value2, "displayInMarket");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusIsNull() {
            this.addCriterion("shop_status is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusIsNotNull() {
            this.addCriterion("shop_status is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusEqualTo(Integer value) {
            this.addCriterion("shop_status =", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusNotEqualTo(Integer value) {
            this.addCriterion("shop_status <>", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusGreaterThan(Integer value) {
            this.addCriterion("shop_status >", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("shop_status >=", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusLessThan(Integer value) {
            this.addCriterion("shop_status <", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("shop_status <=", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusLike(String value) {
            this.addCriterion("shop_status like", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusNotLike(String value) {
            this.addCriterion("shop_status not like", value, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andShopStatusIn(List<Integer> values) {
            this.addCriterion("shop_status in", values, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusNotIn(List<Integer> values) {
            this.addCriterion("shop_status not in", values, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("shop_status between", value1, value2, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("shop_status not between", value1, value2, "shopStatus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxIsNull() {
            this.addCriterion("im_wx is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxIsNotNull() {
            this.addCriterion("im_wx is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxEqualTo(String value) {
            this.addCriterion("im_wx =", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxNotEqualTo(String value) {
            this.addCriterion("im_wx <>", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxGreaterThan(String value) {
            this.addCriterion("im_wx >", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_wx >=", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxLessThan(String value) {
            this.addCriterion("im_wx <", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxLessThanOrEqualTo(String value) {
            this.addCriterion("im_wx <=", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxLike(String value) {
            this.addCriterion("im_wx like", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxNotLike(String value) {
            this.addCriterion("im_wx not like", value, "imWx");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andImWxIn(List<String> values) {
            this.addCriterion("im_wx in", values, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxNotIn(List<String> values) {
            this.addCriterion("im_wx not in", values, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxBetween(String value1, String value2) {
            this.addCriterion("im_wx between", value1, value2, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImWxNotBetween(String value1, String value2) {
            this.addCriterion("im_wx not between", value1, value2, "imWx");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickIsNull() {
            this.addCriterion("tb_nick is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickIsNotNull() {
            this.addCriterion("tb_nick is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickEqualTo(String value) {
            this.addCriterion("tb_nick =", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickNotEqualTo(String value) {
            this.addCriterion("tb_nick <>", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickGreaterThan(String value) {
            this.addCriterion("tb_nick >", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("tb_nick >=", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickLessThan(String value) {
            this.addCriterion("tb_nick <", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickLessThanOrEqualTo(String value) {
            this.addCriterion("tb_nick <=", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickLike(String value) {
            this.addCriterion("tb_nick like", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickNotLike(String value) {
            this.addCriterion("tb_nick not like", value, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andTbNickIn(List<String> values) {
            this.addCriterion("tb_nick in", values, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickNotIn(List<String> values) {
            this.addCriterion("tb_nick not in", values, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickBetween(String value1, String value2) {
            this.addCriterion("tb_nick between", value1, value2, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTbNickNotBetween(String value1, String value2) {
            this.addCriterion("tb_nick not between", value1, value2, "tbNick");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameIsNull() {
            this.addCriterion("shop_name is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameIsNotNull() {
            this.addCriterion("shop_name is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameEqualTo(String value) {
            this.addCriterion("shop_name =", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameNotEqualTo(String value) {
            this.addCriterion("shop_name <>", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameGreaterThan(String value) {
            this.addCriterion("shop_name >", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_name >=", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameLessThan(String value) {
            this.addCriterion("shop_name <", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameLessThanOrEqualTo(String value) {
            this.addCriterion("shop_name <=", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameLike(String value) {
            this.addCriterion("shop_name like", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameNotLike(String value) {
            this.addCriterion("shop_name not like", value, "shopName");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andShopNameIn(List<String> values) {
            this.addCriterion("shop_name in", values, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameNotIn(List<String> values) {
            this.addCriterion("shop_name not in", values, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameBetween(String value1, String value2) {
            this.addCriterion("shop_name between", value1, value2, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopNameNotBetween(String value1, String value2) {
            this.addCriterion("shop_name not between", value1, value2, "shopName");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdIsNull() {
            this.addCriterion("item_link_id is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdIsNotNull() {
            this.addCriterion("item_link_id is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdEqualTo(Long value) {
            this.addCriterion("item_link_id =", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdNotEqualTo(Long value) {
            this.addCriterion("item_link_id <>", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdGreaterThan(Long value) {
            this.addCriterion("item_link_id >", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("item_link_id >=", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdLessThan(Long value) {
            this.addCriterion("item_link_id <", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdLessThanOrEqualTo(Long value) {
            this.addCriterion("item_link_id <=", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdLike(String value) {
            this.addCriterion("item_link_id like", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdNotLike(String value) {
            this.addCriterion("item_link_id not like", value, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andItemLinkIdIn(List<Long> values) {
            this.addCriterion("item_link_id in", values, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdNotIn(List<Long> values) {
            this.addCriterion("item_link_id not in", values, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdBetween(Long value1, Long value2) {
            this.addCriterion("item_link_id between", value1, value2, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andItemLinkIdNotBetween(Long value1, Long value2) {
            this.addCriterion("item_link_id not between", value1, value2, "itemLinkId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeIsNull() {
            this.addCriterion("zipcode is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeIsNotNull() {
            this.addCriterion("zipcode is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeEqualTo(String value) {
            this.addCriterion("zipcode =", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeNotEqualTo(String value) {
            this.addCriterion("zipcode <>", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeGreaterThan(String value) {
            this.addCriterion("zipcode >", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zipcode >=", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeLessThan(String value) {
            this.addCriterion("zipcode <", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeLessThanOrEqualTo(String value) {
            this.addCriterion("zipcode <=", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeLike(String value) {
            this.addCriterion("zipcode like", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeNotLike(String value) {
            this.addCriterion("zipcode not like", value, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andZipcodeIn(List<String> values) {
            this.addCriterion("zipcode in", values, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeNotIn(List<String> values) {
            this.addCriterion("zipcode not in", values, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeBetween(String value1, String value2) {
            this.addCriterion("zipcode between", value1, value2, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andZipcodeNotBetween(String value1, String value2) {
            this.addCriterion("zipcode not between", value1, value2, "zipcode");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainIsNull() {
            this.addCriterion("domain is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainIsNotNull() {
            this.addCriterion("domain is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainEqualTo(String value) {
            this.addCriterion("domain =", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainNotEqualTo(String value) {
            this.addCriterion("domain <>", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainGreaterThan(String value) {
            this.addCriterion("domain >", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            this.addCriterion("domain >=", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainLessThan(String value) {
            this.addCriterion("domain <", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainLessThanOrEqualTo(String value) {
            this.addCriterion("domain <=", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainLike(String value) {
            this.addCriterion("domain like", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainNotLike(String value) {
            this.addCriterion("domain not like", value, "domain");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andDomainIn(List<String> values) {
            this.addCriterion("domain in", values, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainNotIn(List<String> values) {
            this.addCriterion("domain not in", values, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainBetween(String value1, String value2) {
            this.addCriterion("domain between", value1, value2, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDomainNotBetween(String value1, String value2) {
            this.addCriterion("domain not between", value1, value2, "domain");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdIsNull() {
            this.addCriterion("floor_id is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdIsNotNull() {
            this.addCriterion("floor_id is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdEqualTo(Long value) {
            this.addCriterion("floor_id =", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdNotEqualTo(Long value) {
            this.addCriterion("floor_id <>", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdGreaterThan(Long value) {
            this.addCriterion("floor_id >", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("floor_id >=", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdLessThan(Long value) {
            this.addCriterion("floor_id <", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            this.addCriterion("floor_id <=", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdLike(String value) {
            this.addCriterion("floor_id like", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdNotLike(String value) {
            this.addCriterion("floor_id not like", value, "floorId");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andFloorIdIn(List<Long> values) {
            this.addCriterion("floor_id in", values, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdNotIn(List<Long> values) {
            this.addCriterion("floor_id not in", values, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            this.addCriterion("floor_id between", value1, value2, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            this.addCriterion("floor_id not between", value1, value2, "floorId");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleIsNull() {
            this.addCriterion("price_rule is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleIsNotNull() {
            this.addCriterion("price_rule is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleEqualTo(String value) {
            this.addCriterion("price_rule =", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleNotEqualTo(String value) {
            this.addCriterion("price_rule <>", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleGreaterThan(String value) {
            this.addCriterion("price_rule >", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_rule >=", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleLessThan(String value) {
            this.addCriterion("price_rule <", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleLessThanOrEqualTo(String value) {
            this.addCriterion("price_rule <=", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleLike(String value) {
            this.addCriterion("price_rule like", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleNotLike(String value) {
            this.addCriterion("price_rule not like", value, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andPriceRuleIn(List<String> values) {
            this.addCriterion("price_rule in", values, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleNotIn(List<String> values) {
            this.addCriterion("price_rule not in", values, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleBetween(String value1, String value2) {
            this.addCriterion("price_rule between", value1, value2, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andPriceRuleNotBetween(String value1, String value2) {
            this.addCriterion("price_rule not between", value1, value2, "priceRule");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonIsNull() {
            this.addCriterion("close_reason is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonIsNotNull() {
            this.addCriterion("close_reason is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonEqualTo(String value) {
            this.addCriterion("close_reason =", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonNotEqualTo(String value) {
            this.addCriterion("close_reason <>", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonGreaterThan(String value) {
            this.addCriterion("close_reason >", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("close_reason >=", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonLessThan(String value) {
            this.addCriterion("close_reason <", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonLessThanOrEqualTo(String value) {
            this.addCriterion("close_reason <=", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonLike(String value) {
            this.addCriterion("close_reason like", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonNotLike(String value) {
            this.addCriterion("close_reason not like", value, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andCloseReasonIn(List<String> values) {
            this.addCriterion("close_reason in", values, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonNotIn(List<String> values) {
            this.addCriterion("close_reason not in", values, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonBetween(String value1, String value2) {
            this.addCriterion("close_reason between", value1, value2, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andCloseReasonNotBetween(String value1, String value2) {
            this.addCriterion("close_reason not between", value1, value2, "closeReason");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlIsNull() {
            this.addCriterion("data_packet_url is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlIsNotNull() {
            this.addCriterion("data_packet_url is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlEqualTo(String value) {
            this.addCriterion("data_packet_url =", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotEqualTo(String value) {
            this.addCriterion("data_packet_url <>", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlGreaterThan(String value) {
            this.addCriterion("data_packet_url >", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("data_packet_url >=", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlLessThan(String value) {
            this.addCriterion("data_packet_url <", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlLessThanOrEqualTo(String value) {
            this.addCriterion("data_packet_url <=", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlLike(String value) {
            this.addCriterion("data_packet_url like", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotLike(String value) {
            this.addCriterion("data_packet_url not like", value, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andDataPacketUrlIn(List<String> values) {
            this.addCriterion("data_packet_url in", values, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotIn(List<String> values) {
            this.addCriterion("data_packet_url not in", values, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlBetween(String value1, String value2) {
            this.addCriterion("data_packet_url between", value1, value2, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotBetween(String value1, String value2) {
            this.addCriterion("data_packet_url not between", value1, value2, "dataPacketUrl");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusIsNull() {
            this.addCriterion("main_bus is null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusIsNotNull() {
            this.addCriterion("main_bus is not null");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusEqualTo(String value) {
            this.addCriterion("main_bus =", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusNotEqualTo(String value) {
            this.addCriterion("main_bus <>", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusGreaterThan(String value) {
            this.addCriterion("main_bus >", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusGreaterThanOrEqualTo(String value) {
            this.addCriterion("main_bus >=", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusLessThan(String value) {
            this.addCriterion("main_bus <", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusLessThanOrEqualTo(String value) {
            this.addCriterion("main_bus <=", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusLike(String value) {
            this.addCriterion("main_bus like", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusNotLike(String value) {
            this.addCriterion("main_bus not like", value, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }        public ShiguShopExample.Criteria andMainBusIn(List<String> values) {
            this.addCriterion("main_bus in", values, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusNotIn(List<String> values) {
            this.addCriterion("main_bus not in", values, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusBetween(String value1, String value2) {
            this.addCriterion("main_bus between", value1, value2, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }

        public ShiguShopExample.Criteria andMainBusNotBetween(String value1, String value2) {
            this.addCriterion("main_bus not between", value1, value2, "mainBus");
            return (ShiguShopExample.Criteria)this;
        }
    }
}
