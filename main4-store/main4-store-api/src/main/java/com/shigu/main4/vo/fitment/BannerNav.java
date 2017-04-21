package com.shigu.main4.vo.fitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * banner 导航区配置
 * Created by Administrator on 2017/4/18 0018.
 */
public class BannerNav {

    private List<Long> pages = new ArrayList<>();

    private String background = "#F5F5F5";

    private String color = "#333";

    public List<Long> getPages() {
        return pages;
    }

    public void setPages(List<Long> pages) {
        this.pages = pages;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
