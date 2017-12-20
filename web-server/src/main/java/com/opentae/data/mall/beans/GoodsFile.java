package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsFile implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 
     */
	private String fileKey;

    /**
     * 
     */
	private Long goodsId;

    /**
     * 1星座网盘，2外链网盘
     */
	private Integer type;

    /**
     * 密码
     */
	private String passwd;

    /**
     * 是否需要密码，0不需要，1需要
     */
	private Boolean needPwd;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getFileKey() {
		return this.fileKey;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setNeedPwd(Boolean needPwd) {
		this.needPwd = needPwd;
	}

	public Boolean getNeedPwd() {
		return this.needPwd;
	}

}