package com.shigu.seller.vo;

import com.shigu.main4.vo.FitmentModule;
import com.shigu.main4.vo.fitment.*;
import freemarker.template.Template;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 模块
 * Created by zhaohongbo on 17/4/19.
 */
public class ModuleVO extends FreemarkerVO{

    /**
     * 模块设定
     */
    private FitmentModule moduleSet;


    public ModuleVO(FitmentModule moduleSet,FreeMarkerConfigurer cfg) {
        this.moduleSet = moduleSet;
        data=new HashMap<>();
        data.put("moduleSet",moduleSet);
        this.cfg=cfg;
    }

    /**
     * 得到模板
     * @return
     * @throws IOException
     */
    public Template getTemplate(){
        String ftlName="";
        if(this.moduleSet instanceof ItemPromoteModule){
            ftlName="/shop_design/goods-tui.ftl";
        }else if(this.moduleSet instanceof CategoryModule){
            ftlName="/shop_design/goods-cat.ftl";
        }else if(this.moduleSet instanceof CustomModule){
            ftlName="/shop_design/custom.ftl";
        }else if(this.moduleSet instanceof ItemSearchModule){
            ftlName="/shop_design/goods-search.ftl";
        }else if(this.moduleSet instanceof ShopBanner){
            ftlName="/shop_design/banner.ftl";
        }else if(this.moduleSet instanceof SlideshowModule){//全屏轮播
            ftlName="/shop_design/bigcarousel.ftl";
        }else if(this.moduleSet instanceof ViwepagerModule){//图片轮播
            ftlName="/shop_design/piccarousel.ftl";
        }else if(this.moduleSet instanceof WideImageModule){//宽屏图片
            ftlName="/shop_design/bigpic.ftl";
        }else if(this.moduleSet instanceof SearchItemsModule) {//搜索模块
            ftlName = "/shop_design/search-item.ftl";
        }
        try {
            return cfg.getConfiguration().getTemplate(ftlName);
        } catch (IOException e) {
            return null;
        }
    }


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public FitmentModule getModuleSet() {
        return moduleSet;
    }

    public void setModuleSet(FitmentModule moduleSet) {
        this.moduleSet = moduleSet;
    }
}
