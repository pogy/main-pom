package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdAuthedInfoResponse;

public class JdAuthedInfoRequest extends Request<JdAuthedInfoResponse> {

    @Override
    public String restApiUrl() {
        return JdImgEnum.REST+"api/jdAuthedInfo.json";
    }
    @Override
    public String testApiUrl() {
        return JdImgEnum.TEST+"api/jdAuthedInfo.json";
    }

}
