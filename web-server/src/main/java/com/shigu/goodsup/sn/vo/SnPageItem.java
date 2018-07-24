package com.shigu.goodsup.sn.vo;

import com.shigu.goodsup.jd.vo.JdPageItem;
import com.taobao.api.domain.Item;

import java.text.DecimalFormat;

/**
 * 页面显示要用的商品数据
 * @author zhaohongbo
 *
 */
public class SnPageItem extends JdPageItem{

	private Long SnCid;

	public Long getSnCid() {
		return SnCid;
	}

	public void setSnCid(Long snCid) {
		SnCid = snCid;
	}
}
