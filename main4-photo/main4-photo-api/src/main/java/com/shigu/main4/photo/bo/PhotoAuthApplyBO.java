package com.shigu.main4.photo.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 路径: PhotoAuthApplyBO
 * 工程: main-pom
 * 时间: 18-4-25 下午3:59
 * 创建人: wanghaoxiang
 * 描述: 用户摄影基地身份认证申请
 */
public class PhotoAuthApplyBO implements Serializable {

    //用户名
    private String userName;

    //身份认证类型 1:模特,2:摄影师,3.摄影公司,4:场地
    private Integer authType;

    //认证手机号（只用以认证确实使用该手机号，之后可以修改)
    private String authPhone;

    //个人展示封面
    private String showImg;

    //二维码
    private String codeImg;

    //主风格ID
    private List<Long> mainStyleIds;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public String getCodeImg() {
        return codeImg;
    }

    public void setCodeImg(String codeImg) {
        this.codeImg = codeImg;
    }

    public List<Long> getMainStyleIds() {
        return mainStyleIds;
    }

    public void setMainStyleIds(List<Long> mainStyleIds) {
        this.mainStyleIds = mainStyleIds;
    }

    public String getAuthPhone() {
        return authPhone;
    }

    public void setAuthPhone(String authPhone) {
        this.authPhone = authPhone;
    }
}
