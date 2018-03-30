package com.shigu.spread.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 新版杭州男装首页一组人气商品
 */
public class HzManIndexHotItemsVO implements Serializable {
    //风格大类名称
    private String sname;
    //商品集合
    private List<NewHzManIndexItemGoatVO> goodsList;

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<NewHzManIndexItemGoatVO> getGoodsList() {
        return this.goodsList;
    }

    public void setGoodsList(List<NewHzManIndexItemGoatVO> goodsList) {
        this.goodsList = goodsList;
    }
}
