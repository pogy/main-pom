package com.openJar.requests.thirdSupport;


import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.ShortCompleteCheckedResponse;

import java.util.List;

/**
 * Created by lys on 2017-02-20.
 *快捷完成拿货接口
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public class ShortCompleteCheckedRequest extends Request<ShortCompleteCheckedResponse> {

    private Long workId;//拿货人id

    private String barCodeMore;//条形码以，为分割
    private Integer status;//1拿货完成2缺货完成

    private List<String> weightCodeList;

    private List<String> piPriceCodeList;
    public String restApiUrl() {
        return HostEnum.REST_HOST+"shortCompleteChecked.json";
    }

    public String testApiUrl() {
        return HostEnum.TEST_HOST+"shortCompleteChecked.json";
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public String getBarCodeMore() {
        return barCodeMore;
    }

    public void setBarCodeMore(String barCodeMore) {
        this.barCodeMore = barCodeMore;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    public List<String> getWeightCodeList() {
        return this.weightCodeList;
    }

    public void setWeightCodeList(List<String> weightCodeList) {
        this.weightCodeList = weightCodeList;
    }

    public List<String> getPiPriceCodeList() {
        return this.piPriceCodeList;
    }

    public void setPiPriceCodeList(List<String> piPriceCodeList) {
        this.piPriceCodeList = piPriceCodeList;
    }
}
