package com.shigu.activity.bo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.activity.bo
 * @ClassName: ActivityBo
 * @Author: sy
 * @CreateDate: 2018/9/20 0020 19:03
 */
public class ActivityBo implements Serializable{

    private Long maId;
    private Integer page;
    private Integer pageSize = 50;

    public Long getMaId() {
        return maId;
    }

    public void setMaId(Long maId) {
        this.maId = maId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

}
