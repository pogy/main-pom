package com.shigu.main4.daifa.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: ExpressProv
 * @Author: sy
 * @CreateDate: 2018/4/3 0003 15:18
 */
public class ExpressProv implements Serializable {
    private Long provId;
    private String provName;

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }
}
