package com.shigu.main4.item.enums;

/**
 * 搜索排行
 * Created by zhaohongbo on 17/4/4.
 */
public enum SearchOrderBy {
    NEW("新品","xp"),
    COMMON("综合排序","common"),
    GOODS_COMMON("商品库综合","goods_common"),
    SALE("销量","sale"),
    CLICK("点击量","click"),
    PRICEUP("价格升序","price-asc"),
    PRICEDOWN("价格降序","price-desc"),
    POPULAR("人气","popular"),
    GOODSUP("商品上传量","goods_up"),
    USER_LOVE("按用户喜欢程度","user_love"),
    STYLE_CHANNEL("风格频道","style_channel")
    ;

    SearchOrderBy(String title, String value) {
        this.title = title;
        this.value = value;
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;

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

    public static SearchOrderBy valueIs(String value) {
        for (SearchOrderBy searchOrderBy : values()) {
            if (searchOrderBy.getValue().equals(value)) {
                return searchOrderBy;
            }
        }
        return null;
    }
}
