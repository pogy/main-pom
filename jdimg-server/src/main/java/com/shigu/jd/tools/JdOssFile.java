package com.shigu.jd.tools;

/** Oss文件属性
 * Created by Administrator on 2017/7/24.
 */
public class JdOssFile {
    private String fileId;
    private String fileType;
    private String fileName;
    private long fileCreateTime;
    private String fileSize;

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
}
