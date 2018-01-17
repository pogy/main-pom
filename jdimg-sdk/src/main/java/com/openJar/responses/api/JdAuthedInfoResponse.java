package com.openJar.responses.api;

import com.openJar.beans.JdAuthedInfo;
import com.openJar.responses.Response;

/**
 * Created By admin on 2017/12/12/18:19
 */
public class JdAuthedInfoResponse extends Response {
    private JdAuthedInfo data;

    public JdAuthedInfo getData() {
        return this.data;
    }

    public void setData(JdAuthedInfo data) {
        this.data = data;
    }
}
