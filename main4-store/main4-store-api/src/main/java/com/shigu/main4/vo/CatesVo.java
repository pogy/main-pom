package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: CatesVo
 * @Author: sy
 * @CreateDate: 2018/5/31 0031 12:56
 */
public class CatesVo implements Serializable{
    private Long cnameId;
    private String cname;
    private Integer cnameNum;

    public Long getCnameId() {
        return cnameId;
    }

    public void setCnameId(Long cnameId) {
        this.cnameId = cnameId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCnameNum() {
        return cnameNum;
    }

    public void setCnameNum(Integer cnameNum) {
        this.cnameNum = cnameNum;
    }
}
