package com.shigu.main4.vo;

/**
 * 描述：商品风格设置大类
 * 项目：main-pom
 * 类路径： com.shigu.main4.vo.ShiguStyleShowVO
 * 创建人：wanghaoxiang
 * 时间： 18-1-19 下午4:32
 **/
public class ShiguStyleShowVO {
    //父级风格id
    private Long psId;
    //风格显示名称
    private String name;
    //排序
    private Integer sort;

    public Long getPsId() {
        return psId;
    }

    public void setPsId(Long psId) {
        this.psId = psId;
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
