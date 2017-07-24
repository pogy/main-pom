package com.shigu.main4.tools;

import java.util.Date;
import java.util.List;

/** Oss文件属性
 * Created by Administrator on 2017/7/24.
 */
public class OssFile {
    private int type;//0表示文件；1表示目录
    private String name;
    private Date lastModified;
    private long size;
    private List<Long> relateedList;//关联的商品id

    public int getType() {
        return type;
    }

    public void setType( int type ) {
        this.type = type;
    }

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

    public List<Long> getRelateedList() {
        return relateedList;
    }

    public void setRelateedList( List<Long> relateedList ) {
        this.relateedList = relateedList;
    }
}
