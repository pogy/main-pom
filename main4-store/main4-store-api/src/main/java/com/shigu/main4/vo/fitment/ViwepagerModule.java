package com.shigu.main4.vo.fitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图片轮播模块
 * Created by Administrator on 2017/4/18 0018.
 */
public class ViwepagerModule extends TitleShowModule {
    public ViwepagerModule() {
        this.setTitle("图片轮播");
    }

    private boolean isDefault;

    private List<ImageInfo> images = new ArrayList<>();

    /**
     * 模块高度
     */
    private Integer modHeight = 250;
    /**
     * 切换效果
     */
    private Integer modType = 1;

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public List<ImageInfo> getImages() {
        return images;
    }

    public void setImages(List<ImageInfo> images) {
        this.images = images;
    }

    public Integer getModHeight() {
        return modHeight;
    }

    public void setModHeight(Integer modHeight) {
        this.modHeight = modHeight;
    }

    public Integer getModType() {
        return modType;
    }

    public void setModType(Integer modType) {
        this.modType = modType;
    }
}
