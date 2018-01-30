package com.shigu.main4.cdn.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 路径:com.shigu.main4.cdn.vo.StyleCateNavVO
 * 工程:main-pom
 * 时间:18-1-26下午6:45
 * 创建人:wanghaoxiang
 * 描述：类目导航 风格频道
 */
public class StyleCateNavVO implements Serializable {
    //类目标记
    private String id;
    //类目名称
    private String text;
    //子类目导航
    private List<SubStyleCateNavVO> submenu;

    public StyleCateNavVO(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SubStyleCateNavVO> getSubmenu() {
        if (submenu == null) {
            submenu = new ArrayList<>();
        }
        return submenu;
    }

    public void setSubmenu(List<SubStyleCateNavVO> submenu) {
        this.submenu = submenu;
    }

    public StyleCateNavVO add(SubStyleCateNavVO vo) {
        this.getSubmenu().add(vo);
        return this;
    }
}
