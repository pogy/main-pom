package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsUpCountForsearch implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 商品id
     */
	private Long goodsId;

    /**
     * 商品上传次数
     */
	private Long goodsUpNum;

    /**
     * 
     */
	private Long remarker1;

    /**
     * 
     */
	private Long remarker2;

    /**
     * 
     */
	private Long remarker3;

    /**
     * 
     */
	private Long remarker4;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsUpNum(Long goodsUpNum) {
		this.goodsUpNum = goodsUpNum;
	}

	public Long getGoodsUpNum() {
		return this.goodsUpNum;
	}

	public void setRemarker1(Long remarker1) {
		this.remarker1 = remarker1;
	}

	public Long getRemarker1() {
		return this.remarker1;
	}

	public void setRemarker2(Long remarker2) {
		this.remarker2 = remarker2;
	}

	public Long getRemarker2() {
		return this.remarker2;
	}

	public void setRemarker3(Long remarker3) {
		this.remarker3 = remarker3;
	}

	public Long getRemarker3() {
		return this.remarker3;
	}

	public void setRemarker4(Long remarker4) {
		this.remarker4 = remarker4;
	}

	public Long getRemarker4() {
		return this.remarker4;
	}

}