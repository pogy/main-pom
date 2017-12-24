package com.openJar.requests.imgs;


import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.imgs.JdUptoPropImgResponse;

/**
 * 上传单张属性图
 * Created by zhaohongbo on 17/1/18.
 */
public class JdUptoPropImgRequest extends Request<JdUptoPropImgResponse> {
    /**
     * 商品数字ID，必选
     */
    private Long numIid;
    /**
     * 属性列表。调用taobao.itemprops.get获取类目属性，属性必须是颜色属性，再用taobao.itempropvalues.get取得vid。格式:pid:vid。
     */
    private String properties;
    /**
     * 属性图片内容。类型:JPG,GIF;图片大小不超过:3M
     支持的文件类型：gif,jpg,jpeg,png,bmp
     */
    private String url;
    /**
     * 属性图片ID。如果是新增不需要填写
     */
    private Long id;
    /**
     *图片位置
     */
    private Long position;
    /**
     * 授权session
     */
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"uptopropimg.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"uptopropimg.json";
    }
}
