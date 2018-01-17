package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;

import java.util.List;

public class AllUpdataVo {
    /**
     *
     *  query
     query.id	        问题id
     pid	            主类目id
     cid	            子类目id
     mainCate		    主类目数据
     mainCate.id	    主类目id
     mainCate.name	    主类目名
     queTitle	        问题标题
     queAnswer          问题答案
     */

    private Integer id;
    private Integer pid;
    private Integer cid;
    private ShiguHelpcenterLevel1 mainCate;
    private String queTitle;
    private String queAnswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ShiguHelpcenterLevel1 getMainCate() {
        return mainCate;
    }

    public void setMainCate(ShiguHelpcenterLevel1 mainCate) {
        this.mainCate = mainCate;
    }

    public String getQueTitle() {
        return queTitle;
    }

    public void setQueTitle(String queTitle) {
        this.queTitle = queTitle;
    }

    public String getQueAnswer() {
        return queAnswer;
    }

    public void setQueAnswer(String queAnswer) {
        this.queAnswer = queAnswer;
    }
}
