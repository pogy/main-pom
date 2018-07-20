package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShopSize implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long sizeId;

    /**
     * 图片空间大小
     */
	private Long picSize;

    /**
     * 视频空间大小
     */
	private Long videoSize;

    /**
     * 店铺ID
     */
	private Long shopId;

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public Long getSizeId() {
		return this.sizeId;
	}

	public void setPicSize(Long picSize) {
		this.picSize = picSize;
	}

	public Long getPicSize() {
		return this.picSize;
	}

	public void setVideoSize(Long videoSize) {
		this.videoSize = videoSize;
	}

	public Long getVideoSize() {
		return this.videoSize;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

}