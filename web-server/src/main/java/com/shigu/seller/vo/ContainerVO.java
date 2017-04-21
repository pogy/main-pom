package com.shigu.seller.vo;

import freemarker.template.Template;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 装修页面内容部分值
 * Created by zhaohongbo on 17/4/19.
 */
public class ContainerVO extends FreemarkerVO{
    /**
     * 页面名字
     */
    private String pageName;
    /**
     * banner的ftl
     */
    private AreaVO banner;
    /**
     * 区域的ftl及值
     */
    private List<AreaVO> fitmentAreas;
    /**
     * 搜索模块,特殊
     */
    private SearchModuleVO searchModule;


    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public ContainerVO(FreeMarkerConfigurer cfg) {
        this.cfg=cfg;
        data=new HashMap<>();
    }

    public Template getTemplate(){
        try {
            return cfg.getConfiguration().getTemplate("/shop_design/container.ftl");
        } catch (IOException e) {
            return null;
        }
    }


    public AreaVO getBanner() {
        return banner;
    }

    public void setBanner(AreaVO banner) {
        this.banner = banner;
        data.put("banner",banner);
    }

    public List<AreaVO> getFitmentAreas() {
        return fitmentAreas;
    }

    public void setFitmentAreas(List<AreaVO> fitmentAreas) {
        this.fitmentAreas = fitmentAreas;
        data.put("fitmentAreas",fitmentAreas);
    }

    public SearchModuleVO getSearchModule() {
        return searchModule;
    }

    public void setSearchModule(SearchModuleVO searchModule) {
        this.searchModule = searchModule;
    }
}
