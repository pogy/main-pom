package com.openJar.responses.interfaces;

import com.openJar.beans.JdPropValue;
import com.openJar.responses.Response;

import java.util.List;

public class SelJdPropValuesResponse extends Response{
    private List<JdPropValue> datas;

    public List<JdPropValue> getDatas() {
        return this.datas;
    }

    public void setDatas(List<JdPropValue> datas) {
        this.datas = datas;
    }
}
