package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksStoresResponse;


public class SelWorkUserGgoodsTasksStoresRequest extends Request<SelWorkUserGgoodsTasksStoresResponse>{
	private Long daifaNahuoId;
	private Integer status;
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

    public String restApiUrl() {
        return HostEnum.REST_HOST + "selWorkUserGgoodsTasksStores.json";
    }

    public String testApiUrl() {
        return HostEnum.TEST_HOST + "selWorkUserGgoodsTasksStores.json";
    }
}
