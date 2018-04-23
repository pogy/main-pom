package com.shigu.main4.item.bo;

import com.shigu.main4.item.enums.SearchCheckd;
import com.shigu.main4.item.enums.SearchOrderBy;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 路径:com.shigu.main4.item.bo.GoodsSearchBO
 * 工程:main-pom
 * 时间:18-1-29下午3:53
 * 创建人:wanghaoxiang
 * 描述：商品搜索条件
 */
public class GoodsSearchBO implements Serializable {

    //关键词
    private String keyword;
    //分站
    private String webSite;
    //市场ID
    private Long mid;
    //附加条件，有大图下载/主图视频等
    private List<SearchCheckd> checkds;
    //叶子类目ID
    private List<Long> cids;
    //应该关联的店铺
    private List<Long> shouldStoreIds;
    private String sid;
    //批价开始
    private Double priceFrom;
    //批价结束
    private Double priceTo;
    //created时间开始
    private Date timeForm;
    //created时间结束
    private Date timeTo;
    //风格频道风格大类搜索条件
    private Long parentStyleId;
    //排序条件
    private SearchOrderBy orderCase;
    //当前页码
    private Integer page;
    //每页条数
    private Integer pageSize;
    //是否需要统计值
    private boolean aggs;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getWebSite() {
        if (StringUtils.isBlank(webSite)) {
            webSite = "hz";
        }
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public List<SearchCheckd> getCheckds() {
        return checkds;
    }

    public void setCheckds(List<SearchCheckd> checkds) {
        this.checkds = checkds;
    }

    public List<Long> getCids() {
        return cids;
    }

    public void setCids(List<Long> cids) {
        this.cids = cids;
    }

    public List<Long> getShouldStoreIds() {
        return shouldStoreIds;
    }

    public void setShouldStoreIds(List<Long> shouldStoreIds) {
        this.shouldStoreIds = shouldStoreIds;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public Date getTimeForm() {
        return timeForm;
    }

    public void setTimeForm(Date timeForm) {
        this.timeForm = timeForm;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public Long getParentStyleId() {
        return parentStyleId;
    }

    public void setParentStyleId(Long parentStyleId) {
        this.parentStyleId = parentStyleId;
    }

    public SearchOrderBy getOrderCase() {
        return orderCase;
    }

    public void setOrderCase(SearchOrderBy orderCase) {
        this.orderCase = orderCase;
    }

    public Integer getPage() {
        if (page == null) {
            page = 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            pageSize = 40;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAggs() {
        return aggs;
    }

    public void setAggs(boolean aggs) {
        this.aggs = aggs;
    }
}
