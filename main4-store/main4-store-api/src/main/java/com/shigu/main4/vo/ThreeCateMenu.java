package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

public class ThreeCateMenu implements Serializable{
    private String text;
    private List<HomeCateItem> items;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<HomeCateItem> getItems() {
        return items;
    }

    public void setItems(List<HomeCateItem> items) {
        this.items = items;
    }
}
