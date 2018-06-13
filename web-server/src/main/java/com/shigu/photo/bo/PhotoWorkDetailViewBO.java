package com.shigu.photo.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 路径: com.shigu.photo.bo.PhotoWorkDetailViewBO
 * 工程: main-pom
 * 时间: 18-4-26 下午4:11
 * 创建人: wanghaoxiang
 * 描述: 查看作品详情
 */
public class PhotoWorkDetailViewBO implements Serializable {

    @NotNull(message = "非法的参数")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
