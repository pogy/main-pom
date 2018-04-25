package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class DaifaGgoodsMistake implements Serializable {
    /**
     * 0
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long mistakeId;

    /**
     * 
     */
	private Long tasksId;

    /**
     * 
     */
	private Long daifaWorkerId;

	public void setMistakeId(Long mistakeId) {
		this.mistakeId = mistakeId;
	}

	public Long getMistakeId() {
		return this.mistakeId;
	}

	public void setTasksId(Long tasksId) {
		this.tasksId = tasksId;
	}

	public Long getTasksId() {
		return this.tasksId;
	}

	public void setDaifaWorkerId(Long daifaWorkerId) {
		this.daifaWorkerId = daifaWorkerId;
	}

	public Long getDaifaWorkerId() {
		return this.daifaWorkerId;
	}

}