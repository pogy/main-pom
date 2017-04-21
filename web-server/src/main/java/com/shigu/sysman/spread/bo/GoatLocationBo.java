package com.shigu.sysman.spread.bo;

import com.shigu.component.common.page.PageParameter;

/**
 * 广告位置Bo
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:08
 *
 */
public class GoatLocationBo extends PageParameter{

    private Long locationId;

    private String localCodeLike;

    private Boolean localOther = false;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocalCodeLike() {
        return localCodeLike;
    }

    public void setLocalCodeLike(String localCodeLike) {
        this.localCodeLike = localCodeLike;
    }

    public Boolean getLocalOther() {
        return localOther;
    }

    public void setLocalOther(Boolean localOther) {
        this.localOther = localOther;
    }
}
