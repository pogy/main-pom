package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created by pc on 2017-07-25.
 * 申请退货 申请记录操作用户及其操作
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ApplyOperaterVo implements Serializable{
    private Integer userType;//用户类型0平台客服1普通用户
    private String userNickname;//用户昵称
    private String userHeadimg;//用户头像地址
    private String recordTime;//记录创建时间 yyyy-MM-dd HH:mm:ss
    private String recordContent;//记录内容, 除子申请状态其它状态都需要

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }
}
