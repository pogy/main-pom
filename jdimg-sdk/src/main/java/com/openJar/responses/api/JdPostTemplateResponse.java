package com.openJar.responses.api;

import com.openJar.beans.JdPostTemplate;
import com.openJar.responses.Response;

import java.util.List;

/**
 * Created By admin on 2017/12/26/15:25
 */
public class JdPostTemplateResponse extends Response {
    private List<JdPostTemplate> jdPostTemplates;

    public List<JdPostTemplate> getJdPostTemplates() {
        return jdPostTemplates;
    }

    public void setJdPostTemplates(List<JdPostTemplate> jdPostTemplates) {
        this.jdPostTemplates = jdPostTemplates;
    }
}
