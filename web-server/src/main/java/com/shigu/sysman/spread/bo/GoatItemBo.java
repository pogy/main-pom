package com.shigu.sysman.spread.bo;

import com.shigu.component.common.page.PageParameter;

/**
 * 广告位Bo
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:08
 *
 */
public class GoatItemBo extends PageParameter{

    private Long itemId;

    private Long localId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }
}
