package com.shigu.order.vo;

/**
 * 退款申请记录
 * create zf 20170801
 */
public class RefundApplyRecordVO {
    /**
     * 	申请记录列表，按时间倒序，最新记录最前面, 除了申请状态其它状态都需要
     */
    private Integer userType;
    /**
     * 用户类型: 0平台客服，1普通用户, 除了申请状态其它状态都需要
     */
    private String userNickname;
    /**
     * 用户头像图片地址, 除了申请状态其它状态都需要
     */
    private String userHeadimg;
    /**
     * 记录创建时间, 除了申请状态其它状态都需要
     */
    private String recordTime;
    /**
     * 记录内容, 除了申请状态其它状态都需要
     */
    private String recordContent;

    /**
     * 获取 	申请记录列表，按时间倒序，最新记录最前面, 除了申请状态其它状态都需要
     */
    public Integer getUserType() {
        return this.userType;
    }

    /**
     * 设置 	申请记录列表，按时间倒序，最新记录最前面, 除了申请状态其它状态都需要
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取 用户类型: 0平台客服，1普通用户, 除了申请状态其它状态都需要
     */
    public String getUserNickname() {
        return this.userNickname;
    }

    /**
     * 设置 用户类型: 0平台客服，1普通用户, 除了申请状态其它状态都需要
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * 获取 用户头像图片地址, 除了申请状态其它状态都需要
     */
    public String getUserHeadimg() {
        return this.userHeadimg;
    }

    /**
     * 设置 用户头像图片地址, 除了申请状态其它状态都需要
     */
    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    /**
     * 获取 记录创建时间, 除了申请状态其它状态都需要
     */
    public String getRecordTime() {
        return this.recordTime;
    }

    /**
     * 设置 记录创建时间, 除了申请状态其它状态都需要
     */
    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 获取 记录内容, 除了申请状态其它状态都需要
     */
    public String getRecordContent() {
        return this.recordContent;
    }

    /**
     * 设置 记录内容, 除了申请状态其它状态都需要
     */
    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }
}
