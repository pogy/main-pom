package com.openJar.responses.api;

import com.openJar.beans.SdkJdWareAdd;
import com.openJar.responses.Response;
import java.util.List;

/**
 * Created By admin on 2017/12/24/14:14
 */
public class JdWareAddResponse extends Response {
    private SdkJdWareAdd data;

    public SdkJdWareAdd getData() {
        return this.data;
    }

    public void setData(SdkJdWareAdd data) {
        this.data = data;
    }
}
