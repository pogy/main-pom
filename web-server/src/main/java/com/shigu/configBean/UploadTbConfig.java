package com.shigu.configBean;

/**
 * 路径: com.shigu.configBean.UploadTbConfig
 * 工程: main-pom
 * 时间: 18-5-15 下午12:10
 * 创建人: wanghaoxiang
 * 描述: 与淘宝上传站交互配置
 */
public class UploadTbConfig {

    //淘宝上传站域名
    private String uploadTbDomain;

    // 淘宝登陆成功回跳淘宝上传站地址
    private String tbLoginSuccessUrl;

    public String getUploadTbDomain() {
        return uploadTbDomain;
    }

    public void setUploadTbDomain(String uploadTbDomain) {
        this.uploadTbDomain = uploadTbDomain;
    }

    public String getTbLoginSuccessUrl() {
        return tbLoginSuccessUrl;
    }

    public void setTbLoginSuccessUrl(String tbLoginSuccessUrl) {
        this.tbLoginSuccessUrl = tbLoginSuccessUrl;
    }
}
