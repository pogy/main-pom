package com.shigu.main4.vo.fitment;

import com.shigu.main4.enums.FitmentModuleType;

/**
 * 自定义模块
 * Created by Administrator on 2017/4/18 0018.
 */
public class CustomModule extends TitleShowModule {
    public CustomModule() {
        this.setTitle("自定义内容区");
    }

    private String content = "<p style=\"text-align: center; padding: 20px 0 30px;\">自定义内容，可以用来展示店铺特色的宝贝、活动。</p>";

    public String getContent() {
        if (content != null) {
            content=content.replaceAll("网商园","").replace("(?i)wsy.com","").replace("(?i)wsy","");
        }
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Integer getModuleType() {
        return FitmentModuleType.Custom.value;
    }
}
