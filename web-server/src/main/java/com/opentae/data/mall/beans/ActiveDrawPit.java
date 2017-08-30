package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ActiveDrawPit implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 几位坑
     */
	private Integer num;

    /**
     * 内容类型 shop店铺 goods商品
     */
	private String type;

    /**
     * 商品类别
     */
	private String goodsType;

    /**
     * 创建时间
     */
	private Date createTime;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsType() {
		return this.goodsType;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

}