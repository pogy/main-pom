package com.opentae.data.mall.beans;

import com.opentae.common.beans.MoreSiteBean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGoodsSingleSku extends MoreSiteBean implements Serializable {
    /**
     * skuId
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long skuId;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 
     */
	private Long colorPid;

    /**
     * 颜色vid
     */
	private Long colorVid;

    /**
     * 颜色名
     */
	private String colorName;

    /**
     * 颜色别名
     */
	private String colorPropertyAlias;

    /**
     * 颜色自定义名
     */
	private String colorInputStr;

    /**
     * 
     */
	private Long sizePid;

    /**
     * 尺码vid
     */
	private Long sizeVid;

    /**
     * 尺码名
     */
	private String sizeName;

    /**
     * 尺码别名
     */
	private String sizePropertyAlias;

    /**
     * 尺码自定义名
     */
	private String sizeInputStr;

    /**
     * 独立价格
     */
	private String priceString;

    /**
     * 库存数量
     */
	private Integer stockNum;

    /**
     * 
     */
	private Integer status;

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getSkuId() {
		return this.skuId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setColorPid(Long colorPid) {
		this.colorPid = colorPid;
	}

	public Long getColorPid() {
		return this.colorPid;
	}

	public void setColorVid(Long colorVid) {
		this.colorVid = colorVid;
	}

	public Long getColorVid() {
		return this.colorVid;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return this.colorName;
	}

	public void setColorPropertyAlias(String colorPropertyAlias) {
		this.colorPropertyAlias = colorPropertyAlias;
	}

	public String getColorPropertyAlias() {
		return this.colorPropertyAlias;
	}

	public void setColorInputStr(String colorInputStr) {
		this.colorInputStr = colorInputStr;
	}

	public String getColorInputStr() {
		return this.colorInputStr;
	}

	public void setSizePid(Long sizePid) {
		this.sizePid = sizePid;
	}

	public Long getSizePid() {
		return this.sizePid;
	}

	public void setSizeVid(Long sizeVid) {
		this.sizeVid = sizeVid;
	}

	public Long getSizeVid() {
		return this.sizeVid;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getSizeName() {
		return this.sizeName;
	}

	public void setSizePropertyAlias(String sizePropertyAlias) {
		this.sizePropertyAlias = sizePropertyAlias;
	}

	public String getSizePropertyAlias() {
		return this.sizePropertyAlias;
	}

	public void setSizeInputStr(String sizeInputStr) {
		this.sizeInputStr = sizeInputStr;
	}

	public String getSizeInputStr() {
		return this.sizeInputStr;
	}

	public void setPriceString(String priceString) {
		this.priceString = priceString;
	}

	public String getPriceString() {
		return this.priceString;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public Integer getStockNum() {
		return this.stockNum;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}