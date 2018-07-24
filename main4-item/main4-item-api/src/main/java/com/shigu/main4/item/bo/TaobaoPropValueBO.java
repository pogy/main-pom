package com.shigu.main4.item.bo;

import java.io.Serializable;

public class TaobaoPropValueBO implements Serializable {
    /**
     * 
     */
	private Long cid;

    /**
     * 
     */
	private Long pid;

    /**
     * 
     */
	private String propName;

    /**
     * 
     */
	private Long vid;

    /**
     * 
     */
	private String name;

	private Boolean isColor;




	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropName() {
		return this.propName;
	}

	public void setVid(Long vid) {
		this.vid = vid;
	}

	public Long getVid() {
		return this.vid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

    public Boolean getIsColor() {
        return this.isColor;
    }

    public void setIsColor(Boolean isColor) {
        this.isColor = isColor;
    }
}