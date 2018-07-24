package com.shigu.seller.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/7/26.
 */
public class GoodsFileVO implements Comparable<GoodsFileVO>{
    private String fileId;
    private String fileType;
    private String fileName;
    private long fileCreateTime;
    private String fileSize;
    private String unit;


    private boolean hasLinkGoods;


    public boolean isHasLinkGoods() {
        return hasLinkGoods;
    }

    public void setHasLinkGoods(boolean hasLinkGoods) {
        this.hasLinkGoods = hasLinkGoods;
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
        if(StringUtils.isNotEmpty(fileName)&&fileName.contains("/")){
            String name=fileName;
            if(name.endsWith("/")){
                name=name.substring(0,name.length()-1);
            }
            if(name.contains("/")){
                return name.substring(name.lastIndexOf("/")+1,name.length());
            }else{
                return name;
            }
        }
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

    @Override
    public int compareTo(GoodsFileVO o) {
        if(o.getFileType().equals(this.getFileType())){
            return o.getFileCreateTime()>this.getFileCreateTime()?1:-1;
        }
        switch (o.getFileType()){
            case "folder":
                if(!this.getFileType().equals("folder"))
                    return 1;
            case "picBkg":
                switch (this.getFileType()){
                    case "other":return 1;
                    case "folder":return -1;
                }
            case "other":if(!this.getFileType().equals("other"))return -1;
        }
        return 0;
    }
}

