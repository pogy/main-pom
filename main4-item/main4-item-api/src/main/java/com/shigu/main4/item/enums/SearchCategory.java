package com.shigu.main4.item.enums;

/**
 * 搜索分类
 * Created by zhaohongbo on 17/4/4.
 */
public enum SearchCategory {
    CATEGORY("总类","category",1),
    MARKET("市场","market",2),
//    SUBCATEGORY("分类","subcategory",-1),
    STYLE("风格","style",3),
    ELEMENT("元素","element",4),
    CUSTOM("自定义","custom",5);

    SearchCategory(String title, String value, Integer categoryType) {
        this.title = title;
        this.value = value;
        this.categoryType = categoryType;
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;
    /**
     * 分类搜索类别
     * 1、淘宝类目，2、市场，3、风格，4、元素 ,5 自定义
     */
    private Integer categoryType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
