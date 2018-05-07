package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoWorksStyleVO
 * 工程: main-pom
 * 时间: 18-4-28 上午9:05
 * 创建人: wanghaoxiang
 * 描述: 用户认证页面作品风格信息
 */
public class PhotoWorksStyleVO implements Serializable{

    // 风格id
    private Long id;
    // 风格名称
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
