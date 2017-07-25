package com.shigu.main4.tools;

import java.util.Date;
import java.util.List;

/** Oss文件属性
 * Created by Administrator on 2017/7/24.
 */
public class OssFile {
    private String name;
    private Date lastModified;
    private long size;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified( Date lastModified ) {
        this.lastModified = lastModified;
    }

    public long getSize() {
        return size;
    }

    public void setSize( long size ) {
        this.size = size;
    }
}
