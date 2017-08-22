package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksGoodsResponse;

public class SelWorkUserGgoodsTasksGoodsRequest extends Request<SelWorkUserGgoodsTasksGoodsResponse>{
	private Long daifaNahuoId;
	private Long storeId;
	private Integer status;
	
	private String codeMore;
	
	public String getCodeMore() {
		return codeMore;
	}

	public void setCodeMore(String codeMore) {
		this.codeMore = codeMore;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDaifaNahuoId() {
		return daifaNahuoId;
	}

	public void setDaifaNahuoId(Long daifaNahuoId) {
		this.daifaNahuoId = daifaNahuoId;
	}
	
	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

    public String restApiUrl() {
        return HostEnum.REST_HOST + "selWorkUserGgoodsTasksGoods.json";
    }

    public String testApiUrl() {
        return HostEnum.TEST_HOST + "selWorkUserGgoodsTasksGoods.json";
    }
}
