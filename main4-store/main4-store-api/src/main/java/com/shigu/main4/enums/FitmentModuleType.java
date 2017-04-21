package com.shigu.main4.enums;

import com.shigu.main4.vo.FitmentModule;
import com.shigu.main4.vo.fitment.*;

/**
 * Created by wxc on 2017/4/17.
 *
 * @author wxc
 * @version main_site4.0 4.0.6
 * @since main_site4.0 4.0.6
 */
public enum FitmentModuleType {

    /**
     * 页头包括导航
     */
    Banner("页头", ShopBanner.class),
    /**
     * 1、宝贝推荐
     */
    Promote("宝贝推荐", ItemPromoteModule.class),
    /**
     * 2、宝贝搜索
     */
    Search("宝贝搜索", ItemSearchModule.class),
    /**
     * 3、自定义
     */
    Custom("自定义", CustomModule.class),
    /**
     * 4、宝贝分类
     */
    Category("宝贝分类", CategoryModule.class),
    /**
     * 5、宽屏图片
     */
    WideImage("宽屏图片", WideImageModule.class),
    /**
     * 6、图片轮播
     */
    Viwepager("图片轮播", ViwepagerModule.class),
    /**
     * 7、全屏轮播
     */
    Slideshow("全屏轮播", SlideshowModule.class),

    /**
     * 8、搜索结果页
     */
    SearchItems("搜索结果", SearchItemsModule.class)
    ;

    public String comment;
    public int value;
    public ModuleType<? extends FitmentModule> moduleType;
    <T extends FitmentModule> FitmentModuleType(String comment, Class<T> clazz) {
        this.comment = comment;
        this.value = this.ordinal();
        this.moduleType = new ModuleType<>(clazz);
    }

    public static FitmentModuleType typeOf(Integer type) {
        return values()[type];
    }

    public static <T extends FitmentModule> FitmentModuleType classOf(Class<T> clazz) {
        for (FitmentModuleType fitmentModuleType : values()) {
            if (fitmentModuleType.moduleType.getClazz() == clazz) {
                return fitmentModuleType;
            }
        }
        throw new RuntimeException("this module class not allow our enum.");
    }

    public static class ModuleType<T extends FitmentModule> {
        private Class<T> clazz;
        ModuleType(Class<T> clazz) {
            this.clazz = clazz;
        }
        public Class<T> getClazz() {
            return clazz;
        }
    }

}
