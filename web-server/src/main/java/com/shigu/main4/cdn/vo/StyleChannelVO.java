package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.StyleChannelVO
 * 工程:main-pom
 * 时间:18-1-25下午3:20
 * 创建人:wanghaoxiang
 * 描述：风格馆数据
 */
public class StyleChannelVO implements Serializable {

    //风格大类ID
    private Long spid;
    //风格大类名称
    private String sname;
    //风格描述
    private String desc;
    //风格图片
    private String imgsrc;

    public Long getSpid() {
        return spid;
    }

    public void setSpid(Long spid) {
        this.spid = spid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
