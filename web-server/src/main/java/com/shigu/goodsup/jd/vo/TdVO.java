package com.shigu.goodsup.jd.vo;

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
    public TdVO(Long pid, Long vid, String ids, String value, boolean price, boolean num) {
        this.pid = pid;
        this.vid = vid;
        this.ids = ids;
        this.value = value;
        this.price = price;
        this.num = num;
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
     * 是否价格
     */
    private boolean price;
    /**
     * 是否数量
     */
    private boolean num;
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

    /**
     * 获取 是否价格
     */
    public boolean isPrice() {
        return this.price;
    }

    /**
     * 设置 是否价格
     */
    public void setPrice(boolean price) {
        this.price = price;
    }

    /**
     * 获取 是否数量
     */
    public boolean isNum() {
        return this.num;
    }

    /**
     * 设置 是否数量
     */
    public void setNum(boolean num) {
        this.num = num;
    }
}
