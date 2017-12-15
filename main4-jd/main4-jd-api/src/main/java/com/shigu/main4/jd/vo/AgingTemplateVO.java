package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/14/17:17
 */
public class AgingTemplateVO implements Serializable {

    private static final long serialVersionUID = -6882396635046474340L;

    private Long templateId;
    private String templateName;

    public AgingTemplateVO() {
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
