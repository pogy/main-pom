package com.shigu.main4.cdn.vo;

import com.shigu.spread.vo.ItemSpreadVO;

import java.io.Serializable;
import java.util.List;

/**
 * 猜你喜欢,一行
 * Created by zhaohongbo on 17/4/10.
 */
public class LoveGoodsList implements Serializable{

    private String typeText;

    private List<ItemSpreadVO> items;

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public List<ItemSpreadVO> getItems() {
        return items;
    }

    public void setItems(List<ItemSpreadVO> items) {
        this.items = items;
    }
}
