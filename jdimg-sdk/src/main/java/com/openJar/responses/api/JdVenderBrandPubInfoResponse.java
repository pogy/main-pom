package com.openJar.responses.api;

import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.responses.Response;

import java.util.List;

/**
 * Created By admin on 2017/12/25/15:25
 */
public class JdVenderBrandPubInfoResponse extends Response {

    private List<JdVenderBrandPubInfo> jdVenderBrandPubInfos;

    public List<JdVenderBrandPubInfo> getJdVenderBrandPubInfos() {
        return jdVenderBrandPubInfos;
    }

    public void setJdVenderBrandPubInfos(List<JdVenderBrandPubInfo> jdVenderBrandPubInfos) {
        this.jdVenderBrandPubInfos = jdVenderBrandPubInfos;
    }
}
