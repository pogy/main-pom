package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguGoodsModified implements Serializable {
    private static final long serialVersionUID = -4174859720820653762L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long modifyId;

    private Long itemId;

    private Integer hasSetPiprice;

    private Integer hasSetPrice;

    private Integer hasSetTitle;

    private Integer hasSetGoodsno;

    private Integer hasModInstock;

    public Long getModifyId() {
        return modifyId;
    }

    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }

    public Integer getHasSetPiprice() {
        return hasSetPiprice;
    }

    public void setHasSetPiprice(Integer hasSetPiprice) {
        this.hasSetPiprice = hasSetPiprice;
    }

    public Integer getHasSetPrice() {
        return hasSetPrice;
    }

    public void setHasSetPrice(Integer hasSetPrice) {
        this.hasSetPrice = hasSetPrice;
    }

    public Integer getHasSetTitle() {
        return hasSetTitle;
    }

    public void setHasSetTitle(Integer hasSetTitle) {
        this.hasSetTitle = hasSetTitle;
    }

    public Integer getHasSetGoodsno() {
        return hasSetGoodsno;
    }

    public void setHasSetGoodsno(Integer hasSetGoodsno) {
        this.hasSetGoodsno = hasSetGoodsno;
    }

    public Integer getHasModInstock() {
        return hasModInstock;
    }

    public void setHasModInstock(Integer hasModInstock) {
        this.hasModInstock = hasModInstock;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
