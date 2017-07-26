package com.shigu.seller.vo;


import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class GoodsFileVO {
    private String fileId;
    private String fileType;
    private String filename;
    private Date fileCreateTime;
    private double fileSize;

    public String getFileId() {
        return fileId;
    }

    public void setFileId( String fileId ) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType( String fileType ) {
        this.fileType = fileType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename( String filename ) {
        this.filename = filename;
    }

    public Date getFileCreateTime() {
        return fileCreateTime;
    }

    public void setFileCreateTime( Date fileCreateTime ) {
        this.fileCreateTime = fileCreateTime;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize( double fileSize ) {
        this.fileSize = fileSize;
    }
}

