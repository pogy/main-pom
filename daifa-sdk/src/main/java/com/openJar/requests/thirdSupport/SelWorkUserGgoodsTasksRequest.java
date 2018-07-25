package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksResponse;

/**
 * @ProjectName: main-pom
 * @Package: com.openJar.requests.thirdSupport
 * @ClassName: SelWorkUserGgoodsTasksRequest
 * @Author: sy
 * @CreateDate: 2018/7/19 0019 13:24
 */
public class SelWorkUserGgoodsTasksRequest extends Request<SelWorkUserGgoodsTasksResponse> {
    private Long daifaNahuoId;

    public Long getDaifaNahuoId() {
        return daifaNahuoId;
    }

    public void setDaifaNahuoId(Long daifaNahuoId) {
        this.daifaNahuoId = daifaNahuoId;
    }

    public String restApiUrl() {
        return HostEnum.DAIFA_HOST + "selWorkUserGgoodsTasks.json";
    }

    public String testApiUrl() {
        return HostEnum.DAIFA_HOST + "selWorkUserGgoodsTasks.json";
    }
}
