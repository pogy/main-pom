package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动抽奖坑位
 *
 */
public class ActiveDrawPit implements Serializable{

	public final static String TYPE_GOODS = "goods";
	public final static String TYPE_SHOP = "shop";

	public final static String GOODS_TYPE_FA = "fa";
	public final static String GOODS_TYPE_DAILY = "daily";

	/** 主键ID */
	@Id
	@GeneratedValue(
			generator = "JDBC"
	)
	private Long id;

	/** 几位坑 */
	private Integer num;

	/** 内容类型 shop店铺 goods商品 */
	private String type;

	/** 商品类别 */
	private String goodsType;

	/** 创建时间 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
}
