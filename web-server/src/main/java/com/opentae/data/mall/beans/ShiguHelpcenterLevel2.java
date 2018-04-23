package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguHelpcenterLevel2 implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer cid;

    /**
     * 
     */
	private String name;

    /**
     * 
     */
	private Integer gid;

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getGid() {
		return this.gid;
	}

}