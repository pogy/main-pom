package com.shigu.search.bo;

/**
 * 今日新品
 * Created by zhaohongbo on 17/4/5.
 */
public class NewGoodsBO extends PageInSearchBO{
    /**
     * 分站
     */
    private String webSite;
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 关键字
     */
    private String keyword;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
