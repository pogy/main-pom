package com.shigu.main4.daifa.beans;

import java.io.Serializable;

public class Commodity implements Serializable {
	private String GoodsName;//商品名称

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
}
