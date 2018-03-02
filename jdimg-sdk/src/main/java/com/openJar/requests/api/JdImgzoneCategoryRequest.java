package com.openJar.requests.api;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.JdImgzoneCategoryResponse;

public class JdImgzoneCategoryRequest extends Request<JdImgzoneCategoryResponse>{
    private Long jdUid;
    private String imgCategory;
    private Long parentCateId;


    public String restApiUrl() {
        return JdImgEnum.REST+"api/jdImgzoneCategory.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/jdImgzoneCategory.json";
    }

    public Long getJdUid() {
        return this.jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String getImgCategory() {
        return this.imgCategory;
    }

    public void setImgCategory(String imgCategory) {
        this.imgCategory = imgCategory;
    }

    public Long getParentCateId() {
        return this.parentCateId;
    }

    public void setParentCateId(Long parentCateId) {
        this.parentCateId = parentCateId;
    }
}
