package com.openJar.requests.thirdSupport;


import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.ShortCompleteResponse;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by lys on 2017-02-20.
 *快捷完成拿货接口
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public class ShortCompleteRequest extends Request<ShortCompleteResponse> {

    @NotNull(message = "workerId is null")
    private Long workId;//拿货人id
    @NotNull(message = "storeNumId is null")
    private Long storeNumId;//档口号id

    @NotNull(message = "status is null")
    private Integer status;//1拿货完成2缺货完成

    @NotNull(message = "barCodeMore is null")
    private String barCodeMore;//条形码以，为分割

    private List<String> notCodeSets;
    
    
    public List<String> getNotCodeSets() {
		return notCodeSets;
	}

	public void setNotCodeSets(List<String> notCodeSets) {
		this.notCodeSets = notCodeSets;
	}

	@Override
    public String restApiUrl() {
        return HostEnum.REST_HOST+"shortComplete.json";
    }

    @Override
    public String testApiUrl() {
        return HostEnum.TEST_HOST+"shortComplete.json";
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Long getStoreNumId() {
        return storeNumId;
    }

    public void setStoreNumId(Long storeNumId) {
        this.storeNumId = storeNumId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBarCodeMore() {
        return barCodeMore;
    }

    public void setBarCodeMore(String barCodeMore) {
        this.barCodeMore = barCodeMore;
    }
}
