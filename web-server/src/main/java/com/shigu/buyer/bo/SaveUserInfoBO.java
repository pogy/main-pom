package com.shigu.buyer.bo;

import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * 保存用户信息
 * Created by zhaohongbo on 17/3/1.
 */
public class SaveUserInfoBO implements Serializable{
    /**
     * 姓名
     */
    @SafeHtml(message = "name包含非法页面标签")
    private String name;
    /**
     * 邮箱
     */
    @SafeHtml(message = "email包含非法页面标签")
    private String email;
    /**
     * qq号
     */
    @SafeHtml(message = "qq包含非法页面标签")
    private String qq;
    /**
     * 微信
     */
    @SafeHtml(message = "wx包含非法页面标签")
    private String wx;
    /**
     * 旺旺
     */
    @SafeHtml(message = "ww包含非法页面标签")
    private String ww;
    /**
     * 性别
     */
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 转化成用于更新的对象
     * @return
     */
    public UserInfoUpdate parseToUserInfo(){
        UserInfoUpdate userInfoUpdate=new UserInfoUpdate();
        userInfoUpdate.setEmail(email);
        userInfoUpdate.setImQq(qq);
        userInfoUpdate.setImWw(ww);
        userInfoUpdate.setImWx(wx);
        userInfoUpdate.setUserNick(name);
        if(sex!=null){
            userInfoUpdate.setSex(sex==-1?"保密":sex==0?"男":"女");
        }
        return userInfoUpdate;
    }
}
