package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

public class HomeCateMenu implements Serializable{
    private Long id;
    private String text;
    private List<ThreeCateMenu> listitems;
    private List<ThreeCateMenu> detailitems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ThreeCateMenu> getListitems() {
        return listitems;
    }

    public void setListitems(List<ThreeCateMenu> listitems) {
        this.listitems = listitems;
    }

    public List<ThreeCateMenu> getDetailitems() {
        return detailitems;
    }

    public void setDetailitems(List<ThreeCateMenu> detailitems) {
        this.detailitems = detailitems;
    }
}
