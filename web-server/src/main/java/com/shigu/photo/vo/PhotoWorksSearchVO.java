package com.shigu.photo.vo;

public class PhotoWorksSearchVO {
    private Long id;
    private Long worksId;
    private String imgsrc;
    private String title;
    private String typeName;
    private String nick;
    private String address;
    private String publishedTime;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
    }

    public String getImgsrc() {
        return this.imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublishedTime() {
        return this.publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }
}
