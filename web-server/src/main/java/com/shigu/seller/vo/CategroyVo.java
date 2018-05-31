package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: CategroyVo
 * @Author: sy
 * @CreateDate: 2018/5/9 0009 13:21
 */
public class CategroyVo implements Serializable{
    private Long cid;
    private String cName;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
