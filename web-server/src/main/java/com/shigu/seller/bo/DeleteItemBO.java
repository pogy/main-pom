package com.shigu.seller.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 删除商品BO
 * Created by zhaohongbo on 17/3/12.
 */
public class DeleteItemBO implements Serializable{
    @NotEmpty(message = "ids参数异常")
    private String ids;

    private String webSite;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
