package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.SelTagHaveGgoodsResponse;


/**
 * Created by pc on 2016-03-22.
 */
public class SelTagHaveGgoodsRequest extends Request<SelTagHaveGgoodsResponse> {

    private Long daifaNahuoId;//拿货人id
    private Integer status;//1：拿货，2：缺货，3：标记有货时间
    private String barCodeMore;//条形码以（英文）逗号分开
    private Long haveGoodsTime;//有货时间（单位秒）

    

    public String restApiUrl() {
        return HostEnum.DAIFA_HOST+"selTagHaveGgoods.json";
    }

    public String testApiUrl() {
        return HostEnum.DAIFA_HOST+"selTagHaveGgoods.json";
    }

    public Long getDaifaNahuoId() {
        return daifaNahuoId;
    }

    public void setDaifaNahuoId(Long daifaNahuoId) {
        this.daifaNahuoId = daifaNahuoId;
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

    public Long getHaveGoodsTime() {
        return haveGoodsTime;
    }

    public void setHaveGoodsTime(Long haveGoodsTime) {
        this.haveGoodsTime = haveGoodsTime;
    }
}
