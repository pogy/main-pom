package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/5/31.
 * 访问下载数据
 * @author gtx
 * @description
 * @since
 */
public class LineDataVO implements Serializable {
    /**
     * 项目标题
     */
    private String title;
    /**
     * 实际数据
     */
    private List<DataListVO> dataList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataListVO> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListVO> dataList) {
        this.dataList = dataList;
    }
}
