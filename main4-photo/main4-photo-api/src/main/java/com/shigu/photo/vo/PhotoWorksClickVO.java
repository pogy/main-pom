package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoWorksClickVO
 * 工程: main-pom
 * 时间: 18-4-26 下午4:54
 * 创建人: wanghaoxiang
 * 描述: 作品浏览量
 */
public class PhotoWorksClickVO implements Serializable {

    //作品id
    private long worksId;

    //总点击量
    private long totalClick;

    //新增点击量（未写入数据库)
    private long addClick;

    public long getWorksId() {
        return worksId;
    }

    public void setWorksId(long worksId) {
        this.worksId = worksId;
    }

    public long getTotalClick() {
        return totalClick;
    }

    public void setTotalClick(long totalClick) {
        this.totalClick = totalClick;
    }

    public long getAddClick() {
        return addClick;
    }

    public void setAddClick(long addClick) {
        this.addClick = addClick;
    }
}
