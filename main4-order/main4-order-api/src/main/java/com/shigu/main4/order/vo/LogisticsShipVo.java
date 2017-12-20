package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pc on 2017-07-26.
 * 运送中的物流信息
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class LogisticsShipVo implements Serializable{
    private String postName;
    private String postCode;
    private List<LogisticsShipDetail> detail;

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

    public List<LogisticsShipDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<LogisticsShipDetail> detail) {
        this.detail = detail;
    }
}
