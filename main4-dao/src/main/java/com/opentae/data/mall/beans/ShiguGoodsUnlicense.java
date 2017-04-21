package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by wxc on 2017/2/22.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguGoodsUnlicense implements Serializable {
    @Transient
    private static final long serialVersionUID = -4787733080227774704L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long unlicenseId;

    private Long goodsId;

    private String unlicenseContext;

    public Long getUnlicenseId() {
        return unlicenseId;
    }

    public void setUnlicenseId(Long unlicenseId) {
        this.unlicenseId = unlicenseId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getUnlicenseContext() {
        return unlicenseContext;
    }

    public void setUnlicenseContext(String unlicenseContext) {
        this.unlicenseContext = unlicenseContext;
    }
}
