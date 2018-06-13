package com.shigu.main4.photo.vo;

import java.io.Serializable;
import java.util.List;

public class GoatMenuVO implements Serializable{
    private String menuId;
    private String menuText;
    private List<GoatMenuSubVO> items;

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
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
