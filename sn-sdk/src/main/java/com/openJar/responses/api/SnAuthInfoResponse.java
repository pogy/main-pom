package com.openJar.responses.api;

import com.openJar.beans.SnTokenInfo;
import com.openJar.responses.Response;

public class SnAuthInfoResponse extends Response {
    private SnTokenInfo data;

    public SnTokenInfo getData() {
        return data;
    }

    public void setData(SnTokenInfo data) {
        this.data = data;
    }
}
