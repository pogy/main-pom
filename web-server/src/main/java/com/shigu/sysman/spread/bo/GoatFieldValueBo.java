package com.shigu.sysman.spread.bo;

import com.shigu.component.common.page.PageParameter;

/**
 * 广告数据值Bo
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:08
 *
 */
public class GoatFieldValueBo extends PageParameter{

    private Long vidId;

    private Long fId;

    private Long goatId;

    public Long getVidId() {
        return vidId;
    }

    public void setVidId(Long vidId) {
        this.vidId = vidId;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }
}
