package com.shigu.helpcenter.vo;

public class Query {
    /**
     * id  回填问题ID
     * keyword  回填搜索关键字
     * cid 回填二级目录CID
     * pid 回填一级目录PID
     */
    private Integer id;
    private String keyword;
    private Integer cid;
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
