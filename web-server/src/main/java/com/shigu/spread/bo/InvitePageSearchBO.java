package com.shigu.spread.bo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 类名：InvitePageSearchBO
 * 类路径： com.shigu.spread.bo.InvitePageSearchBO
 * 创建者： whx
 * 创建时间： 7/24/18 2:21 PM
 * 项目： main-pom
 * 描述：
 */
public class InvitePageSearchBO implements Serializable {

    private String type;

    private Integer page;

    public String getType() {
        if (StringUtils.isEmpty(type)) {
            type = "tj";
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPage() {
        if (page == null || page <= 0) {
            page = 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
