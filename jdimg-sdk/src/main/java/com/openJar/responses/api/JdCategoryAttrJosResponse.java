package com.openJar.responses.api;

import com.openJar.beans.JdCategoryAttrJos;
import com.openJar.responses.Response;
import java.util.List;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:15
 */
public class JdCategoryAttrJosResponse extends Response {

    private List<JdCategoryAttrJos> jdCategoryAttrJos;

    public List<JdCategoryAttrJos> getJdCategoryAttrJos() {
        return jdCategoryAttrJos;
    }

    public void setJdCategoryAttrJos(List<JdCategoryAttrJos> jdCategoryAttrJos) {
        this.jdCategoryAttrJos = jdCategoryAttrJos;
    }
}
