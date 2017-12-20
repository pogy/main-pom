package com.shigu.main4.vo.fitment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * banner 导航区配置
 * Created by Administrator on 2017/4/18 0018.
 */
public class BannerNav implements Serializable {

    private List<Long> pages = new ArrayList<>();

    private String background = "#000000";

    private String color = "#ffffff";

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
