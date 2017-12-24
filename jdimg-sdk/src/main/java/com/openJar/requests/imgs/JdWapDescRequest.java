package com.openJar.requests.imgs;


import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.imgs.JdWapDescResponse;

/**
 * 取得手机详情
 * Created by zhaohongbo on 17/1/19.
 */
public class JdWapDescRequest extends Request<JdWapDescResponse> {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"wapdesc.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"wapdesc.json";
    }
}
