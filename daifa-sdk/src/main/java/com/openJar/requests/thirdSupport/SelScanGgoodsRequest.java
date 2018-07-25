package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.SelScanGgoodsResponse;


/**
 * Created by pc on 2016-03-22.
 */
public class SelScanGgoodsRequest extends Request<SelScanGgoodsResponse> {

    private Long daifaNahuoId;
    

    public String restApiUrl() {
        return HostEnum.DAIFA_HOST+"selScanGgoods.json";
    }

    public String testApiUrl() {
        return HostEnum.DAIFA_HOST+"selScanGgoods.json";
    }

    public Long getDaifaNahuoId() {
        return daifaNahuoId;
    }

    public void setDaifaNahuoId(Long daifaNahuoId) {
        this.daifaNahuoId = daifaNahuoId;
    }
}
