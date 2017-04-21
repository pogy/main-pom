package com.shigu.main4.vo.fitment;

import com.shigu.main4.vo.FitmentModule;

/**
 * 模块标题展示 装饰模块
 * Created by Administrator on 2017/4/18 0018.
 */
public abstract class TitleShowModule extends FitmentModule {
    /**
     * 是否显示模块标题 0 / 1
     */
    private Integer titleShow = 1;
    /**
     * 模块标题
     */
    private String title;

    public Integer getTitleShow() {
        return titleShow;
    }

    public void setTitleShow(Integer titleShow) {
        this.titleShow = titleShow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
