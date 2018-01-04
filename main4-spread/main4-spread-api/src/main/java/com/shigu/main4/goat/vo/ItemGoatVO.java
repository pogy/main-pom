package com.shigu.main4.goat.vo;

import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 商品广告
 *
 * -Long itemId
 -String title
 -String picUrl
 * Created by zhaohongbo on 17/5/4.
 */
public class ItemGoatVO extends GoatVO implements Serializable{
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片链接
      */
    private String picUrl;
    /**
     * 风格
     */
    private String tag1;
    /**
     * 元素
     */
    private String tag2;
    /**
     * 店铺标题
     */
    private String tag3;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }
}
