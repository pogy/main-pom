package com.shigu.main4.enums;

/**
 * 搜索来源匹配排序表达式
 * Created by bugzy on 2017/8/16 0016.
 */
public enum  SearchFrom {

    /**
     * 这是第一版搜索排序，现在只有商品库继续使用
     */
    goods("rough_project_c", "project_c"),
    /**
     * 这里是搜索默认的，
     */
    search("search_project", "search_jp")

    ;

    public final String firstRank;
    public final String secondRank;

    SearchFrom(String firstRank, String secondRank) {
        this.firstRank = firstRank;
        this.secondRank = secondRank;
    }

    public static SearchFrom from(String from) {
        for (SearchFrom searchFrom : values()) {
            if (searchFrom.name().equalsIgnoreCase(from)) {
                return searchFrom;
            }
        }
        return search;
    }
}
