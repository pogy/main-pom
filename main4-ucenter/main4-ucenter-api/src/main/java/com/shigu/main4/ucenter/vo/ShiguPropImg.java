package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：ShiguPropImg
 * @文件路径：com.shigu.main4.ucenter.vo.ShiguPropImg
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/4 15:14
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ShiguPropImg implements Serializable {
    /**
     * 属性ID
     */
    private Long pid;
    /**
     * 属性值ID
     */
    private Long vid;
    /**
     * 属性图链接
     */
    private String url;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}