package com.shigu.seller.vo;

import com.shigu.main4.vo.FitmentModule;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * 搜索模块
 * Created by zhaohongbo on 17/4/19.
 */
public class SearchModuleVO extends ModuleVO{
    public SearchModuleVO(FitmentModule moduleSet, FreeMarkerConfigurer cfg) {
        super(moduleSet, cfg);
    }

    /**
     * 设置搜索条件
     */
    public void setSearchParam(){

    }
}
