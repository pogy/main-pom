package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguHelpcenterQuestion implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer id;

    /**
     * 问题描述
     */
	private String title;

    /**
     * 问题答案
     */
	private String answer;

    /**
     * 所属一级目录ID
     */
	private Integer gid;

    /**
     * 所属二级目录ID
     */
	private Integer cid;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return this.cid;
	}

	@Override
	public String toString() {
		return "ShiguHelpcenterQuestion{" +
				"id=" + id +
				", title='" + title + '\'' +
				", answer='" + answer + '\'' +
				", gid=" + gid +
				", cid=" + cid +
				'}';
	}
}