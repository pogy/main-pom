package com.openJar.responses.thirdSupport;

import com.openJar.beans.WorkUserGgoodsTasksCounts;
import com.openJar.beans.WorkUserGgoodsTasksMarket;
import com.openJar.responses.Response;

import java.util.List;

public class SelWorkUserGgoodsTasksStoresResponse extends Response{
	private List<WorkUserGgoodsTasksMarket> markets;
	private WorkUserGgoodsTasksCounts counts;
	public WorkUserGgoodsTasksCounts getCounts() {
		return counts;
	}

	public void setCounts(WorkUserGgoodsTasksCounts counts) {
		this.counts = counts;
	}

	public List<WorkUserGgoodsTasksMarket> getMarkets() {
		return markets;
	}

	public void setMarkets(List<WorkUserGgoodsTasksMarket> markets) {
		this.markets = markets;
	}

}
