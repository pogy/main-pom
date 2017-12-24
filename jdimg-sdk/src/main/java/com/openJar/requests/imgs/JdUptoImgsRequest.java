package com.openJar.requests.imgs;


import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.imgs.JdUptoImgsResponse;

/**
 * 让图片站完成图片上传
 * Created by zhaohongbo on 16/12/20.
 */
public class JdUptoImgsRequest extends Request<JdUptoImgsResponse> {

    private String imgurl;
    private String imagetitle;
    private String imagefilename;
    private String ip;
    private Long userid;
    private String session;
    private String nick;

    public String restApiUrl() {
        return JdImgEnum.REST+"uptoimgs.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"uptoimgs.json";
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(String imagetitle) {
        this.imagetitle = imagetitle;
    }

    public String getImagefilename() {
        return imagefilename;
    }

    public void setImagefilename(String imagefilename) {
        this.imagefilename = imagefilename;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
