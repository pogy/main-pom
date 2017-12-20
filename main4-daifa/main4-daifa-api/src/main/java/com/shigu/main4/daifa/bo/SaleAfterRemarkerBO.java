package com.shigu.main4.daifa.bo;/**
 * Created by pc on 2017-09-19.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import java.io.Serializable;

/**
 *Created By pc on 2017-09-19/15:54
 *
 */
public class SaleAfterRemarkerBO implements Serializable {

    private static final long serialVersionUID = 8166071103422697203L;

    /**
     * 主单ID
     */
    private Long  afterSaleId;

    /**
     * 代发备注
     */
    private String remark;

    public Long getAfterSaleId() {
        return afterSaleId;
    }

    public void setAfterSaleId(Long afterSaleId) {
        this.afterSaleId = afterSaleId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
