package com.shigu.main4.ucenter.vo;

import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 数据包中的商品
 * Created by zhaohongbo on 17/2/26.
 */
public class PackageItem implements Serializable{
    /**
     * 商品主键
     */
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品主图
     */
    private String picUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
