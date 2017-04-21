package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wxc on 2017/2/27.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShiguPropImgs implements Serializable {
    private static final long serialVersionUID = 2375046469908036423L;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long propimgId;
    private Long itemId;
    private String propimgs;

    public Long getPropimgId() {
        return propimgId;
    }

    public void setPropimgId(Long propimgId) {
        this.propimgId = propimgId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getPropimgs() {
        return propimgs;
    }

    public void setPropimgs(String propimgs) {
        this.propimgs = propimgs;
    }
}
