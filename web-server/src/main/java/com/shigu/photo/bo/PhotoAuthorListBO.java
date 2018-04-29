package com.shigu.photo.bo;

public class PhotoAuthorListBO {

    private Integer crid;
    private Integer coid;
    private Long sid;
    private String keyword;
    private Integer page;

    public Integer getCrid() {
        return this.crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Long getSid() {
        return this.sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCoid() {
        return this.coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }
}
