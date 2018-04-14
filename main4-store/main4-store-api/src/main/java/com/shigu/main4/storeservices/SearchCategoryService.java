package com.shigu.main4.storeservices;

import com.shigu.main4.vo.CateMenu;
import com.shigu.main4.vo.HomeCateMenu;

import java.util.List;

/**
 * 逛市场导航栏类目
 * Created by sunyue on 18/3/20.
 */
public interface SearchCategoryService {

    /**
     * 获取逛市场导航栏展示类目
     *
     * @return
     */
    @Deprecated
    List<CateMenu> getMarketCateShow();

    List<CateMenu> getMarketCateShow(String webSite);

    /**
     * 获取首页导航栏展示类目
     *
     * @return
     */
    @Deprecated
    List<HomeCateMenu> getHomeCateShow();


    List<HomeCateMenu> getHomeCateShow(String webSite,Integer sex);
}
