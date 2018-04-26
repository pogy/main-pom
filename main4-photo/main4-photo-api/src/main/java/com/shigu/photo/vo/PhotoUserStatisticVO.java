package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoUserStaticVO
 * 工程: main-pom
 * 时间: 18-4-26 下午2:34
 * 创建人: wanghaoxiang
 * 描述: 作者额外信息
 */
public class PhotoUserStatisticVO extends PhotoUserVO implements Serializable {

    // 作品数
    private Integer worksCount;

    public Integer getWorksCount() {
        return worksCount;
    }

    public void setWorksCount(Integer worksCount) {
        this.worksCount = worksCount;
    }
}
