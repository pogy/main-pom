package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

/**
 * 类名：AppUser
 * 类路径：com.openJar.beans.app.AppUser
 * 创建者：任真飞
 * 创建时间：2017-09-22 17:12
 * 项目：main-pom
 * 描述：
 */
public class AppUser extends OpenBean {
    //用户ID	必须
    private Long userId;
    //是否档口卖家	必须
    private Boolean imSeller;
    //头像
    private String imgsrc;
    //用户昵称	必须
    private String userNick;
    //每个用户，每次登陆的唯一码	必须
    private String token;
    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId=userId;
    }

    public Boolean getImSeller(){
        return imSeller;
    }

    public void setImSeller(Boolean imSeller){
        this.imSeller=imSeller;
    }

    public String getImgsrc( String headUrl ){
        return imgsrc;
    }

    public void setImgsrc(String imgsrc){
        this.imgsrc=imgsrc;
    }

    public String getUserNick( String userNick ){
        return this.userNick;
    }

    public void setUserNick(String userNick){
        this.userNick=userNick;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token=token;
    }

}