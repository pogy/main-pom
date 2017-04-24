package com.shigu.main4.vo.fitment;

import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.vo.FitmentModule;

/**
 * 宽幅图片
 * Created by Administrator on 2017/4/18 0018.
 */
public class WideImageModule extends FitmentModule {

    private String picUrl="http://img.alicdn.com/tps/TB1iG39KXXXXXbBXVXXXXXXXXXX-1920-540.png";
    private String targetUrl="javascript:;";

    @Override
    public Integer getModuleType() {
        return FitmentModuleType.WideImage.value;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
