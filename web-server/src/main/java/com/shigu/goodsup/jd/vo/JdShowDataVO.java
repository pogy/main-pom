package com.shigu.goodsup.jd.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created By admin on 2017/12/15/16:06
 */
public class JdShowDataVO implements Serializable{

    private static final long serialVersionUID = -8117932286540806237L;
    private String goodsCat;
    private Long jdUserId;
    private PropsVO props;
    private JdPageItem items;
    private List storeCats;
    private List deliveyList;
    private String token;
    private Long erverDyTemplateId;//此前用过的快递模板ID

    public String getGoodsCat() {
        return this.goodsCat;
    }

    public void setGoodsCat(String goodsCat) {
        this.goodsCat = goodsCat;
    }


    public PropsVO getProps() {
        return this.props;
    }

    public void setProps(PropsVO props) {
        this.props = props;
    }

    public JdPageItem getItems() {
        return this.items;
    }

    public void setItems(JdPageItem items) {
        this.items = items;
    }

    public List getStoreCats() {
        return this.storeCats;
    }

    public void setStoreCats(List storeCats) {
        this.storeCats = storeCats;
    }

    public List getDeliveyList() {
        return this.deliveyList;
    }

    public void setDeliveyList(List deliveyList) {
        this.deliveyList = deliveyList;
    }

    public Long getJdUserId() {
        return this.jdUserId;
    }

    public void setJdUserId(Long jdUserId) {
        this.jdUserId = jdUserId;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Long getErverDyTemplateId() {
        return erverDyTemplateId;
    }

    public void setErverDyTemplateId(Long erverDyTemplateId) {
        this.erverDyTemplateId = erverDyTemplateId;
    }
}
