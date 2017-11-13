package com.openJar.requests.app;

import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.CatResponse;
import com.openJar.responses.app.CatSearchResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名：CatSearchRequest
 * 类路径：com.openJar.requests.app.CatSearchRequest
 * 创建者：任真飞
 * 创建时间：2017-11-13 13:05
 * 项目：main-pom
 * 描述：
 */
public class CatSearchRequest extends Request<CatSearchResponse> {
    //分站标识	必须
    @NotNull(message = "webSite is null")
    private String webSite;
    //1男装，2女装	必须
    @NotNull(message = "type is null")
    private Integer type;
    public String getWebSite(){
        return webSite;
    }

    public void setWebSite(String webSite){
        this.webSite=webSite;
    }

    public Integer getType(){
        return type;
    }

    public void setType(Integer type){
        this.type=type;
    }

    public String testApiUrl(){
        return HostEnum.TEST+"catSearch.json";
    }

    public String restApiUrl(){
        return HostEnum.REST+"catSearch.json";
    }
}