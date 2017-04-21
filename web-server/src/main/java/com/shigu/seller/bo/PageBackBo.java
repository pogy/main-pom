package com.shigu.seller.bo;

/**
 * 装修背景图设置
 * Created by Administrator on 2017/4/21 0021.
 */
public class PageBackBo {
    private Long page;
    private String pic;
    private Integer type;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
