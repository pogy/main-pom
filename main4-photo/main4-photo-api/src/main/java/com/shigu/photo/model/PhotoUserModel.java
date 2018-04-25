package com.shigu.photo.model;

import com.shigu.photo.bo.PhotoAuthApplyBO;
import com.shigu.photo.bo.PhotoUserInfoEditBO;
import com.shigu.photo.vo.PhotoUserVO;

/**
 * 路径: com.shigu.photo.model.PhotoUserModel
 * 工程: main-pom
 * 时间: 18-4-25 下午2:53
 * 创建人: wanghaoxiang
 * 描述:
 */
public interface PhotoUserModel {

    /**
     * 用户摄影信息
     * @return
     */
    PhotoUserVO photoUserInfo();

    /**
     * 申请身份认证
     * @param bo
     */
    void authApply(PhotoAuthApplyBO bo);

    /**
     * 身份认证通过
     */
    void applyPass();

    /**
     * 拒绝身份认证
     */
    void applyRefuse();

    /**
     * 修改用户信息
     * @param bo
     */
    void editUserInfo(PhotoUserInfoEditBO bo);

}
