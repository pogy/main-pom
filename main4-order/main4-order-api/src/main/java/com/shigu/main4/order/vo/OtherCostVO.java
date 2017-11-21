package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-30/15:33
 */
public class OtherCostVO implements Serializable {

    private static final long serialVersionUID = -2898991465426022439L;

    /**快递费用 分*/
    private Long postPrice;
    /**服务费用 分*/
    private Long servicePrice;
    /**服务费详情*/
    private List<ServiceInfosTextVO> serviceInfosText;

    public Long getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    public Long getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Long servicePrice) {
        this.servicePrice = servicePrice;
    }

    public List<ServiceInfosTextVO> getServiceInfosText() {
        return serviceInfosText;
    }

    public void setServiceInfosText(List<ServiceInfosTextVO> serviceInfosText) {
        this.serviceInfosText = serviceInfosText;
    }
}

