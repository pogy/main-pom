package com.shigu.main4.daifa.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: ExpressCompanyVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 13:52
 */
public class ExpressCompanyVo implements Serializable{

    private Long courierId;
    private String courierName;

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }
}
