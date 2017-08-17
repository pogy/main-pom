package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksGoodsResponse;

import javax.validation.constraints.NotNull;

public class SelWorkUserGgoodsTasksGoodsRequest extends Request<SelWorkUserGgoodsTasksGoodsResponse>{
	@NotNull(message="用户ID不能为空")
	private Long daifaNahuoId;
	@NotNull(message="档口ID不能为空")
	private Long storeId;
	@NotNull(message="状态不能为空")
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

	@Override
    public String restApiUrl() {
        return HostEnum.REST_HOST + "selWorkUserGgoodsTasksGoods.json";
    }

    @Override
    public String testApiUrl() {
        return HostEnum.TEST_HOST + "selWorkUserGgoodsTasksGoods.json";
    }
}
