package com.shigu.main4.cdn.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 路径:com.shigu.main4.cdn.vo.StyleCateNavVO
 * 工程:main-pom
 * 时间:18-1-26下午6:45
 * 创建人:wanghaoxiang
 * 描述：类目导航 风格频道
 */
public class StyleCateNavVO implements Serializable {
    //类目标记
    private String id;
    //子类目导航
    private List<SubStyleCateNavVO> detailitems;

    public StyleCateNavVO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SubStyleCateNavVO> getDetailitems() {
        if (detailitems == null) {
            detailitems = new ArrayList<>();
        }
        return detailitems;
    }

    public void setDetailitems(List<SubStyleCateNavVO> detailitems) {
        this.detailitems = detailitems;
    }
}
