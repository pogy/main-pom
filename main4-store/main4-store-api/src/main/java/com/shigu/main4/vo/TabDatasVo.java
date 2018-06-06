package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: TabDatasVo
 * @Author: sy
 * @CreateDate: 2018/5/31 0031 12:54
 */
public class TabDatasVo implements Serializable{
    private Integer noSetCateGoodsNum;
    private List<CatesVo> cates;

    public Integer getNoSetCateGoodsNum() {
        return noSetCateGoodsNum;
    }

    public void setNoSetCateGoodsNum(Integer noSetCateGoodsNum) {
        this.noSetCateGoodsNum = noSetCateGoodsNum;
    }

    public List<CatesVo> getCates() {
        return cates;
    }

    public void setCates(List<CatesVo> cates) {
        this.cates = cates;
    }
}
