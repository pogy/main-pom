package com.shigu.component.common.page;

import java.io.Serializable;

/**
 * 分页参数类
 * 
 */
public class PageParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int DEFAULT_PAGE_SIZE = 20;
    
    public static final boolean PAGE_BOOLEAN_FALSE = false;
    public static final boolean PAGE_BOOLEAN_TRUE = true;

    private int pageSize;// 一页总条数
    private int currentPage;// 当前页
    private int prePage;// 上一页
    private int nextPage;// 下一页
    private int totalPage;// 总页数
    private int totalCount;// 总记录数
    private boolean pageBoolean = false;// 是否分页
    private int startRow;//  起始行

    public PageParameter() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.nextPage = currentPage + 1;
        this.prePage = currentPage - 1;
        this.startRow = (this.currentPage - 1) * this.pageSize;
    }

    /**
     * 
     * @param currentPage
     * @param pageSize
     */
    public PageParameter(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.nextPage = currentPage + 1;
        this.prePage = currentPage - 1;
        this.startRow = (this.currentPage - 1) * this.pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.nextPage = currentPage + 1;
        this.prePage = currentPage - 1;
        this.startRow = (this.currentPage - 1) * this.pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.startRow = (this.currentPage - 1) * this.pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

	public boolean isPageBoolean() {
		return pageBoolean;
	}

	public void setPageBoolean(boolean pageBoolean) {
		this.pageBoolean = pageBoolean;
	}

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
}
