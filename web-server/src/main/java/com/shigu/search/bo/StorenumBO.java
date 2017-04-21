package com.shigu.search.bo;

import com.shigu.tools.EncodeParamter;

import java.io.Serializable;

/**
 * 档口搜索
 * Created by zhaohongbo on 17/4/5.
 */
public class StorenumBO extends PageInSearchBO implements Serializable{
    /**
     * 分站
     */
    private String webSite;
    /**
     * 市场ID
     */
    private Long mid;
    /**
     * 关键词
     */
    private String keyword;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        if (keyword != null) {
            this.keyword = EncodeParamter.iosToUtf8(keyword);
        }
    }
}
