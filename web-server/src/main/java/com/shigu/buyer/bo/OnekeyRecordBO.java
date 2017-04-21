package com.shigu.buyer.bo;

import com.shigu.tools.EncodeParamter;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 一键上传记录
 * Created by zhaohongbo on 17/3/13.
 */
public class OnekeyRecordBO implements Serializable{
    /**
     * 商品标题
     */
    private String title;
    /**
     * 目标平台
     */
    private String target;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    private Integer page;

    private Integer rows=12;

    public Integer getPage() {
        if(page==null||page<1){
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
//        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = EncodeParamter.iosToUtf8(title);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
