package com.shigu.daifa.bo;/**
 * Created by pc on 2017-09-21.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

/**
 *Created By pc on 2017-09-21/11:38
 *包裹入库
 */
public class PutInStorageBO {
    /**
     * 库存编号(货架编号)
     */
    private String stockCode;
    /**
     * 快递名
     */
    private String postName;
    /**
     * 快递单号
     */
    private String postCode;
    /**
     * 发货人手机号
     */
    private String telephone;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
