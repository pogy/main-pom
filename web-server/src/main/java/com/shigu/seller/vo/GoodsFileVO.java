package com.shigu.seller.vo;


import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class GoodsFileVO {
    private String fileId;
    private String fileType;
    private String fileName;
    private long fileCreateTime;
    private String fileSize;
    private String unit;


    private boolean isRoot;

    private boolean hasLinkGoods;

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public boolean isHasLinkGoods() {
        return hasLinkGoods;
    }

    public void setHasLinkGoods(boolean hasLinkGoods) {
        this.hasLinkGoods = hasLinkGoods;
    }

    public boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot( boolean root ) {
        isRoot = root;
    }

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }

    public long getFileCreateTime() {
        return fileCreateTime;
    }

    public void setFileCreateTime( long fileCreateTime ) {
        this.fileCreateTime = fileCreateTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize( String fileSize ) {
        this.fileSize = fileSize;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit( String unit ) {
        this.unit = unit;
    }
}

