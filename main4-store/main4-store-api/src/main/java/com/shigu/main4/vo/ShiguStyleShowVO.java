package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 描述：商品风格设置大类
 * 项目：main-pom
 * 类路径： com.shigu.main4.vo.ShiguStyleShowVO
 * 创建人：wanghaoxiang
 * 时间： 18-1-19 下午4:32
 **/
public class ShiguStyleShowVO implements Serializable, Comparable<ShiguStyleShowVO> {
    //父级风格id
    private Long spid;
    //风格显示名称
    private String name;
    //排序
    private Integer sort;

    @Override
    public int compareTo(ShiguStyleShowVO o) {
        if (o == null) {
            return -1;
        }
        if (sort == null) {
            if (o.getSort() == null) {
                return 0;
            } else {
                return 1;
            }
        }
        if (o.getSort() == null) {
            return -1;
        }
        return this.sort - o.sort;
    }

    public Long getSpid() {
        return spid;
    }

    public void setSpid(Long spid) {
        this.spid = spid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
