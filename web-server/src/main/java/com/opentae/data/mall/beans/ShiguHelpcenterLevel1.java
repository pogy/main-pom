package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguHelpcenterLevel1 implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer pid;

    /**
     * 
     */
	private String name;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public ShiguHelpcenterLevel1() {
	}

	@Override
	public String toString() {
		return "ShiguHelpcenterLevel1{" +
				"pid=" + pid +
				", name='" + name + '\'' +
				'}';
	}
}