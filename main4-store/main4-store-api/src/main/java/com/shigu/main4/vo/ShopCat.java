package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/**
 * 店内类目
 * Created by zhaohongbo on 17/2/16.
 */
public class ShopCat implements Serializable, Comparable<ShopCat>{

    private static final long serialVersionUID = 5786220534796679720L;
    /**
     * 店内类目ID
     */
    private String cid;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 排序
     */
    private int sort;
    /**
     * 子类目
     */
    private List<ShopCat> subCats;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<ShopCat> getSubCats() {
        return subCats;
    }

    public void setSubCats(List<ShopCat> subCats) {
        this.subCats = subCats;
    }

    /**
     * 排序规则： 
     *      先按sortOrder进行排序 
     *      如果sortOrder相等，按主键从大到小排序
     */
    @Override
    public int compareTo(ShopCat o) {
        if (getSort() == o.getSort())
            return o.getCid().compareTo(getCid());
        return getSort() - o.getSort();
    }
}
