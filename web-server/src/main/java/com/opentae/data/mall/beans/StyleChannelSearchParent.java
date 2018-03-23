package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class StyleChannelSearchParent implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 兼容现有前端请求，改动最小
     */
	private Long searchPid;

    /**
     * 搜索类型，男装，女装。。。
     */
	private String searchType;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setSearchPid(Long searchPid) {
		this.searchPid = searchPid;
	}

	public Long getSearchPid() {
		return this.searchPid;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchType() {
		return this.searchType;
	}

}