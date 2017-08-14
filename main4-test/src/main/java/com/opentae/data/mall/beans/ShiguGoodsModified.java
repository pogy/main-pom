package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGoodsModified implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long modifyId;

    /**
     * 0代表没有改过批发价，1代表改过
     */
	private Integer hasSetPiprice;

    /**
     * 0代表没有改过，1代表改过
     */
	private Integer hasSetPrice;

    /**
     * 0代表没有改过标题，1代表改过
     */
	private Integer hasSetTitle;

    /**
     * 0代表没有改过货号，1代表改过
     */
	private Integer hasSetGoodsno;

    /**
     * 商品ID
     */
	private Long itemId;

    /**
     * 0代表没有做过下架，1代表改过
     */
	private Integer hasModInstock;

	public void setModifyId(Long modifyId) {
		this.modifyId = modifyId;
	}

	public Long getModifyId() {
		return this.modifyId;
	}

	public void setHasSetPiprice(Integer hasSetPiprice) {
		this.hasSetPiprice = hasSetPiprice;
	}

	public Integer getHasSetPiprice() {
		return this.hasSetPiprice;
	}

	public void setHasSetPrice(Integer hasSetPrice) {
		this.hasSetPrice = hasSetPrice;
	}

	public Integer getHasSetPrice() {
		return this.hasSetPrice;
	}

	public void setHasSetTitle(Integer hasSetTitle) {
		this.hasSetTitle = hasSetTitle;
	}

	public Integer getHasSetTitle() {
		return this.hasSetTitle;
	}

	public void setHasSetGoodsno(Integer hasSetGoodsno) {
		this.hasSetGoodsno = hasSetGoodsno;
	}

	public Integer getHasSetGoodsno() {
		return this.hasSetGoodsno;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setHasModInstock(Integer hasModInstock) {
		this.hasModInstock = hasModInstock;
	}

	public Integer getHasModInstock() {
		return this.hasModInstock;
	}

}