package com.shigu.main4.photo.model;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.photo.bo.PhotoAuthApplyBO;
import com.shigu.main4.photo.bo.PhotoUserInfoEditBO;
import com.shigu.main4.photo.vo.PhotoUserStatisticVO;
import com.shigu.main4.photo.vo.PhotoUserVO;

/**
 * 路径: PhotoUserModel
 * 工程: main-pom
 * 时间: 18-4-25 下午2:53
 * 创建人: wanghaoxiang
 * 描述:
 */
public interface PhotoUserModel {

    /**
     * 用户摄影信息
     *
     * @return
     */
    PhotoUserVO photoUserInfo();

    /**
     * 申请身份认证，同时只能进行一个申请
     *
     * @param bo
     */
    void authApply(PhotoAuthApplyBO bo) throws JsonErrException;

    /**
     * 身份认证通过
     *
     * @param logMessage 日志信息
     */
    void applyPass(String logMessage);

    /**
     * 拒绝身份认证
     *
     * @param logMessage 日志信息
     */
    void applyRefuse(String logMessage);

    /**
     * 修改用户信息
     *
     * @param bo
     */
    void editUserInfo(PhotoUserInfoEditBO bo);

    /**
     * 用户全部信息
     * @return
     */
    PhotoUserStatisticVO photoUserTotalInfo();

    /**
     * 获取用户作者id
     * @return
     */
    long getAuthId();

}
