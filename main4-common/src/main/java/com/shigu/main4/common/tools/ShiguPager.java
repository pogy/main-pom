package com.shigu.main4.common.tools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShiguPager<T> implements Serializable {
    private static final long serialVersionUID = -8361541285585478461L;

    /** 分页数据 */
    private List<T> content;

    /** 当前页 */
    private int number;

    /** 总页数 */
    private int totalPages;

    /** 总记录数 */
    private int totalCount;

    /**
     *  拿到翻页信息
     * @return
     */
    public String selPageOption(int size){
        return this.totalCount+","+size+","+number;
    }

    /**
     * 计算分页
     * @param totalCount
     * @param pageSize
     */
    public void calPages(int totalCount, int pageSize){
        if(pageSize<=0){
            return ;
        }
        int totalPages = totalCount / pageSize + ((totalCount % pageSize == 0) ? 0 : 1);
        this.setTotalPages(totalPages);
        this.setTotalCount(totalCount);
    }

    public List<T> getContent() {
        if(this.content == null){
            this.content = new ArrayList<T>();
        }
        return content;
    }

    public void setContent(List<T> content) {
        if(content == null){
            this.content = new ArrayList<T>();
            return;
        }
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
