package com.shigu.photo.vo;

import java.io.Serializable;
import java.util.List;

public class GoatMenuVO implements Serializable{
    private Long menuId;
    private String menuText;
    private List<GoatMenuSubVO> items;

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuText() {
        return this.menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public List<GoatMenuSubVO> getItems() {
        return this.items;
    }

    public void setItems(List<GoatMenuSubVO> items) {
        this.items = items;
    }
}
