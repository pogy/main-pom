package com.openJar.requests.interfaces;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.interfaces.SelShiguJdCatResponse;

import javax.validation.constraints.NotNull;

public class SelShiguJdCatRequest extends Request<SelShiguJdCatResponse>{
    @NotNull(message = "cid is null")
    private Long cid;

    public Long getCid() {
        return this.cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/selShiguJdCat.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/selShiguJdCat.json";
    }
}
