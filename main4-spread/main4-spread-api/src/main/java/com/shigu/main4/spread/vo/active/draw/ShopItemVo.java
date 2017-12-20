package com.shigu.main4.spread.vo.active.draw;

import java.io.Serializable;

/**
 * 发现好店 携带商品
 * Created by bugzy on 2017/5/25 0025.
 */
public class ShopItemVo implements Serializable {

    private Long id;
    private String imgsrc;
    private String title;

    public ShopItemVo() {
    }

    public ShopItemVo(Long id, String imgsrc, String title) {
        this.id = id;
        this.imgsrc = imgsrc;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
