package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

public class CateMenu implements Serializable{
    private Long id;
    private String icon;
    private String text;
    private List<SubMenu> submenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SubMenu> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<SubMenu> submenu) {
        this.submenu = submenu;
    }
}
