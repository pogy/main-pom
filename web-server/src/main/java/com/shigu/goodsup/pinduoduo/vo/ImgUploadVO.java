package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/6/26.
 *
 * @author gtx
 * @since
 */
public class ImgUploadVO implements Serializable {
    private List<String> pddImgUrls;
    private String tempCode;
    private int num;

    public List<String> getPddImgUrls() {
        return pddImgUrls;
    }

    public void setPddImgUrls(List<String> pddImgUrls) {
        this.pddImgUrls = pddImgUrls;
    }

    public String getTempCode() {
        return tempCode;
    }

    public void setTempCode(String tempCode) {
        this.tempCode = tempCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
