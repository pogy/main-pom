package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguTemp implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 
     */
	private String flag;

    /**
     * 
     */
	private String key1;

    /**
     * 
     */
	private String key2;

    /**
     * 
     */
	private String key3;

    /**
     * 
     */
	private String key4;

    /**
     * 
     */
	private String key5;

    /**
     * 
     */
	private String key6;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey1() {
		return this.key1;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey2() {
		return this.key2;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getKey3() {
		return this.key3;
	}

	public void setKey4(String key4) {
		this.key4 = key4;
	}

	public String getKey4() {
		return this.key4;
	}

	public void setKey5(String key5) {
		this.key5 = key5;
	}

	public String getKey5() {
		return this.key5;
	}

	public void setKey6(String key6) {
		this.key6 = key6;
	}

	public String getKey6() {
		return this.key6;
	}

}