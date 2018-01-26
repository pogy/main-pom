package com.openJar.responses.api;

import com.openJar.beans.JdCategoryAttrValueJos;
import com.openJar.responses.Response;

import java.util.List;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:20
 */
public class JdCategoryAttrValueJosResponse extends Response {

    private List<JdCategoryAttrValueJos> jdCategoryAttrValueJos;

    public List<JdCategoryAttrValueJos> getJdCategoryAttrValueJos() {
        return jdCategoryAttrValueJos;
    }

    public void setJdCategoryAttrValueJos(List<JdCategoryAttrValueJos> jdCategoryAttrValueJos) {
        this.jdCategoryAttrValueJos = jdCategoryAttrValueJos;
    }
}
