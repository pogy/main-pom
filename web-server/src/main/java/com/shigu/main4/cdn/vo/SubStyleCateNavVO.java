package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.SubStyleCateNavVO
 * 工程:main-pom
 * 时间:18-1-26下午6:44
 * 创建人:wanghaoxiang
 * 描述：子类目导航 风格频道
 */
public class SubStyleCateNavVO implements Serializable {

    //子类目名称
    private String text;
    //子类目所属pid
    private Long pid;
    //子类目id, 有cid没有keyword
    private Long cid;
    //类目keyword,有keyword没有cid
    private String searchName;

    public SubStyleCateNavVO(String text, Long pid, Long cid, String searchName) {
        this.text = text;
        this.pid = pid;
        this.cid = cid;
        this.searchName = searchName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
}
