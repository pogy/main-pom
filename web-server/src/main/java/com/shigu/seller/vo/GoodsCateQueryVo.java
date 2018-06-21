package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: GoodsCateQueryVo
 * @Author: sy
 * @CreateDate: 2018/6/1 0001 13:23
 */
public class GoodsCateQueryVo implements Serializable{

    private long cnameId;

    public long getCnameId() {
        return cnameId;
    }

    public void setCnameId(long cnameId) {
        this.cnameId = cnameId;
    }
}
