package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 前台中的SKU一行数据
 * Created by zhaohongbo on 17/1/16.
 */
public class TdVO implements Serializable{

    public TdVO(Long pid, String value) {
        this.pid = pid;
        this.value = value;
    }

    public TdVO() {
    }

    /**
     * 本级pid
     */
    private Long pid;
    /**
     * 本级vid
     */
    private Long vid;
    /**
     * 本级标识ID
     */
    private String ids;
    /**
     * 值
     */
    private String value;
    /**
     * 占行数
     */
    private int rowspan=1;
    /**
     * 是否颜色,是为true
     */
    private boolean color;
    /**
     * 跟在这个td后面的所有td
     */
    private SkuRankVO skuRankVO;

    /**
     * 得到行头的id串
     * @return
     */
    public String getHeadIds(){
        if(ids!=null&&ids.contains("_")){
            return ids.split("_")[0];
        }else{
            return ids;
        }
    }

    public SkuRankVO getSkuRankVO() {
        return skuRankVO;
    }

    public void setSkuRankVO(SkuRankVO skuRankVO) {
        this.skuRankVO = skuRankVO;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }

    @Override
    public String toString() {
        return "TdVO{" +
                "isColor=" + color +
                ", rowspan=" + rowspan +
                ", value='" + value + '\'' +
                ", ids='" + ids + '\'' +
                ", vid=" + vid +
                ", pid=" + pid +
                '}';
    }
}
