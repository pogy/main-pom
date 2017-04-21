package com.shigu.main4.vo.fitment;

import com.shigu.main4.vo.FitmentModule;

import java.util.List;

/**
 * 全屏轮播 模块
 * Created by Administrator on 2017/4/19 0019.
 */
public class SlideshowModule extends FitmentModule {
    private List<ImageInfo> images;

    /**
     * 模块高度
     */
    private Integer modHeight;

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
}
