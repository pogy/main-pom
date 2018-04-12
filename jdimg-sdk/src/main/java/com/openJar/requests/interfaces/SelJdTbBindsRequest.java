package com.openJar.requests.interfaces;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.interfaces.SelJdTbBindsResponse;

import javax.validation.constraints.NotNull;

public class SelJdTbBindsRequest extends Request<SelJdTbBindsResponse> {
    @NotNull(message = "cid is null")
    private Long cid;

    public Long getCid() {
        return this.cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }


    public String restApiUrl() {
        return JdImgEnum.REST+"api/selJdTbBind.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/selJdTbBind.json";
    }
}
