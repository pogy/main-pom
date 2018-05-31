package com.shigu.main4.photo.vo;

import java.io.Serializable;

public class GoatAuthorVO extends PhotoAuthorVO implements Serializable {
    private Long worksId;

    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
    }
}
