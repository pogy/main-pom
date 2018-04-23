package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class JdTbBind extends OpenBean {
    /**
     * 
     */
	private Long bindId;

    /**
     * 
     */
	private Long jdCid;

    /**
     * 
     */
	private Long tbCid;

    /**
     * 
     */
	private Integer sex;

	public void setBindId(Long bindId) {
		this.bindId = bindId;
	}

	public Long getBindId() {
		return this.bindId;
	}

	public void setJdCid(Long jdCid) {
		this.jdCid = jdCid;
	}

	public Long getJdCid() {
		return this.jdCid;
	}

	public void setTbCid(Long tbCid) {
		this.tbCid = tbCid;
	}

	public Long getTbCid() {
		return this.tbCid;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}

}