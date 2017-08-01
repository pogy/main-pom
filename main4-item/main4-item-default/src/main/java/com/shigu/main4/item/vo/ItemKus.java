package com.shigu.main4.item.vo;

import com.opentae.data.mall.beans.ShiguGoodsTiny;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 来自商品库的，单天符合要求的商品
 * Created by zhaohongbo on 16/1/26.
 */
public class ItemKus {

    public ItemKus() {
        aitems=new ArrayList<ShiguGoodsTiny>();
        bitems=new ArrayList<ShiguGoodsTiny>();
        undefineds=new ArrayList<ShiguGoodsTiny>();
    }

    /**
     * A类品
     */
    private List<ShiguGoodsTiny> aitems;
    /**
     * B类品
     */
    private List<ShiguGoodsTiny> bitems;

    /**
     * 没定类品的商品
     */
    private List<ShiguGoodsTiny> undefineds;

    /**
     * 最后更新时间
     */
    private Date lastModifyTime;

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public List<ShiguGoodsTiny> getAitems() {
        return aitems;
    }

    public void setAitems(List<ShiguGoodsTiny> aitems) {
        this.aitems = aitems;
    }

    public List<ShiguGoodsTiny> getBitems() {
        return bitems;
    }

    public void setBitems(List<ShiguGoodsTiny> bitems) {
        this.bitems = bitems;
    }

    public List<ShiguGoodsTiny> getUndefineds() {
        return undefineds;
    }

    public void setUndefineds(List<ShiguGoodsTiny> undefineds) {
        this.undefineds = undefineds;
    }
}
