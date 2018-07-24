package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class GoodsCountForsearch implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long searchId;

    /**
     * 0
     */
	private Long goodsId;

    /**
     * 0
     */
	private Long click;

    /**
     * ip
     */
	private Long clickIp;

    /**
     * 交易量
     */
	private Long trade;

    /**
     * 上款次数
     */
	private Long up;

    /**
     * 上款人数
     */
	private Long upMan;

    /**
     * 0没做过广告，1做过广告
     */
	private Integer hadGoat;

    /**
     * 
     */
	private String webSite;

    /**
     * 
     */
	private Date flowFixedTime;

    /**
     * 是否有大图，0没有，1有
     */
	private Integer hadBigzip;

    /**
     * 面料
     */
	private String fabric;

    /**
     * 里料
     */
	private String infabric;

    /**
     * 视频链接地址
     */
	private String videoUrl;

    /**
     * 是否设置了视频链接，给opensearch提供搜索项
     */
	private Integer hadVideo;

    /**
     * 0是没有 1是有
     */
	private Integer hadStyle;

    /**
     * 风格名称  应对商品库风格查询
     */
	private String styleName;

    /**
     * 风格id
     */
	private Long sid;

    /**
     * 具体商品风格id，shigu_style中具体风格id
     */
	private Long styleId;

    /**
     * 
     */
	private Long parentStyleId;

    /**
     * 商品风格频道搜索权重
     */
	private Long styleSearchScore;

	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}

	public Long getSearchId() {
		return this.searchId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setClick(Long click) {
		this.click = click;
	}

	public Long getClick() {
		return this.click;
	}

	public void setClickIp(Long clickIp) {
		this.clickIp = clickIp;
	}

	public Long getClickIp() {
		return this.clickIp;
	}

	public void setTrade(Long trade) {
		this.trade = trade;
	}

	public Long getTrade() {
		return this.trade;
	}

	public void setUp(Long up) {
		this.up = up;
	}

	public Long getUp() {
		return this.up;
	}

	public void setUpMan(Long upMan) {
		this.upMan = upMan;
	}

	public Long getUpMan() {
		return this.upMan;
	}

	public void setHadGoat(Integer hadGoat) {
		this.hadGoat = hadGoat;
	}

	public Integer getHadGoat() {
		return this.hadGoat;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setFlowFixedTime(Date flowFixedTime) {
		this.flowFixedTime = flowFixedTime;
	}

	public Date getFlowFixedTime() {
		return this.flowFixedTime;
	}

	public void setHadBigzip(Integer hadBigzip) {
		this.hadBigzip = hadBigzip;
	}

	public Integer getHadBigzip() {
		return this.hadBigzip;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getFabric() {
		return this.fabric;
	}

	public void setInfabric(String infabric) {
		this.infabric = infabric;
	}

	public String getInfabric() {
		return this.infabric;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setHadVideo(Integer hadVideo) {
		this.hadVideo = hadVideo;
	}

	public Integer getHadVideo() {
		return this.hadVideo;
	}

	public void setHadStyle(Integer hadStyle) {
		this.hadStyle = hadStyle;
	}

	public Integer getHadStyle() {
		return this.hadStyle;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleName() {
		return this.styleName;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Long getStyleId() {
		return this.styleId;
	}

	public void setParentStyleId(Long parentStyleId) {
		this.parentStyleId = parentStyleId;
	}

	public Long getParentStyleId() {
		return this.parentStyleId;
	}

	public void setStyleSearchScore(Long styleSearchScore) {
		this.styleSearchScore = styleSearchScore;
	}

	public Long getStyleSearchScore() {
		return this.styleSearchScore;
	}

}