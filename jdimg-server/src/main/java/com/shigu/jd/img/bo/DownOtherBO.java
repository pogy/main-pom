package com.shigu.jd.img.bo;

import javax.validation.constraints.NotNull;

/**
 * 其它图片的下载
 * Created by zhaohongbo on 17/1/18.
 */
public class DownOtherBO {
    @NotNull(message = "url is null")
    private String url;
    @NotNull(message = "mid is null")
    private Long mid;
    @NotNull(message = "witch is null")
    private String witch;
    @NotNull(message = "order is null")
    private Integer order;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getWitch() {
        return witch;
    }

    public void setWitch(String witch) {
        this.witch = witch;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
