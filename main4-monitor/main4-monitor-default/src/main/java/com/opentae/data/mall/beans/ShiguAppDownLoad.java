package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguAppDownLoad implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer id;

    /**
     * 1 安卓  2 IOS
     */
	private Integer terminalType;

    /**
     * app下载量
     */
	private Long downLoadNum;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setTerminalType(Integer terminalType) {
		this.terminalType = terminalType;
	}

	public Integer getTerminalType() {
		return this.terminalType;
	}

	public void setDownLoadNum(Long downLoadNum) {
		this.downLoadNum = downLoadNum;
	}

	public Long getDownLoadNum() {
		return this.downLoadNum;
	}

}