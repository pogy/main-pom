package com.shigu.main4.item.services;

import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.vo.CategoryValue;
import com.shigu.main4.item.vo.ShiguAggsPager;

import java.util.Date;
import java.util.List;

/**
 * 搜索服务
 * Created by zhaohongbo on 17/4/4.
 */
public interface ItemSearchService {

    int MAX_PAGE = 100;
    int DEFAULT_PAGE_SIZE = 40;
    String DATE_FMT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 搜索主方法
     * @param keyword 关键词
     * @param mid 市场ID
     * @param cids 叶子类目ID
     * @param shouldStoreIds 应该关联的店铺
     * @param priceFrom 批价开始
     * @param priceTo 批价结束
     * @param timeForm created时间开始
     * @param timeTo created时间结束
     * @param orderCase 条件
     * @param page 当前页码
     * @param pageSize 每页条数
     * @return
     */
    ShiguAggsPager searchItem(String keyword, String webSite, Long mid, List<Long> cids, List<Long> shouldStoreIds,
                              Double priceFrom, Double priceTo,
                              Date timeForm, Date timeTo, SearchOrderBy orderCase, Integer page, Integer pageSize, boolean aggs);
    /**
     * 查询搜索类目
     * @param category
     * @return
     */
    List<CategoryValue> selCategory(SearchCategory category);

    /**
     * 查询子级搜索类目
     * @param parentCateValue
     * @return
     */
    List<CategoryValue> selSubCategory(String parentCateValue, SearchCategory category);
}
