package com.shigu.main4.tools;

import java.util.Date;
import java.util.List;

/** Oss文件属性
 * Created by Administrator on 2017/7/24.
 */
public class OssFile {
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
