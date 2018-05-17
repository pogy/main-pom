package com.shigu.main4.bo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.bo
 * @ClassName: FlickrAddBo
 * @Author: sy
 * @CreateDate: 2018/5/1 0001 12:42
 */
public class FlickrAddBo implements Serializable{

    private String fName;
    private String fDdesc;
    private Long pId;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfDdesc() {
        return fDdesc;
    }

    public void setfDdesc(String fDdesc) {
        this.fDdesc = fDdesc;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }
}
