package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ActivityDrawPrizePool implements Serializable {
    /**
     * 奖品奖池主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long prizeId;

    /**
     * 活动期次id
     */
	private Long pemId;

    /**
     * 奖品级别 如一等奖1 二等奖2
     */
	private Integer rank;

    /**
     * 奖品级别字符串  一等奖，二等奖。。。
     */
	private String rankStr;

    /**
     * 奖品名称 XXX手机。。
     */
	private String prizeName;

    /**
     * 奖品图片链接地址
     */
	private String prizeImgUrl;

    /**
     * 总奖品数量
     */
	private Integer totalNum;

    /**
     * 可抽取奖品数量
     */
	private Integer drawAbleNum;

    /**
     * 已被抽中奖品数量
     */
	private Integer drawedNum;

	public void setPrizeId(Long prizeId) {
		this.prizeId = prizeId;
	}

	public Long getPrizeId() {
		return this.prizeId;
	}

	public void setPemId(Long pemId) {
		this.pemId = pemId;
	}

	public Long getPemId() {
		return this.pemId;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRankStr(String rankStr) {
		this.rankStr = rankStr;
	}

	public String getRankStr() {
		return this.rankStr;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeImgUrl(String prizeImgUrl) {
		this.prizeImgUrl = prizeImgUrl;
	}

	public String getPrizeImgUrl() {
		return this.prizeImgUrl;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setDrawAbleNum(Integer drawAbleNum) {
		this.drawAbleNum = drawAbleNum;
	}

	public Integer getDrawAbleNum() {
		return this.drawAbleNum;
	}

	public void setDrawedNum(Integer drawedNum) {
		this.drawedNum = drawedNum;
	}

	public Integer getDrawedNum() {
		return this.drawedNum;
	}

}