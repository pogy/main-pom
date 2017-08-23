package com.shigu.main4.ucenter.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.vo.OuterUser;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.SysUserSession;
import com.shigu.session.main4.enums.LoginFromType;

import java.util.List;

/**
 * 用户基本服务
 * Created by zhaohongbo on 17/2/15.
 */
public interface UserBaseService {
    /**
     * 按用户名查用户基准信息
     * @param userName
     * @return
     */
    PersonalSession selUserForSessionByUserName(String userName, LoginFromType type);

    /**
     * 按用户Id查询密码密文
     * @param userId
     * @return
     */
    String selUserPwdByUserId(Long userId);

    /**
     * 按用户名查系统用户基准信息
     * @param userName
     * @return
     */
    SysUserSession selSysForSessionByUserName(String userName);

    /**
     * 按用户ID查系统用户的密码
     * @param userId
     * @return
     */
    String selSysPwdByUserId(Long userId);

    /**
     * 查出用户基本信息，用于修改
     * @param userId 用户ID
     * @return
     */
    UserInfo selUserInfo(Long userId);

    /**
     * 修改用户基本信息
     * 需要清除用户信息缓存，重新取得放入session
     * @param userinfo
     * @return
     */
    int updateUserInfo(UserInfoUpdate userinfo) throws UpdateUserInfoException;

    /**
     * 查出用户的第三方绑定账户
     * @param userId 用户ID
     * @return 第三方绑定用户列表
     */
    List<OuterUser> selOuterUsers(Long userId);

    /**
     * 解绑第三方子账户
     * @param userId 用户ID
     * @param subUserId 第三方子账户
     */
    void unBindUser(Long userId,Long subUserId);

    /**
     * 查询淘宝nick用户
     * @param tbNick
     * @return
     */
    Long selTbOuterUser(String tbNick);

    String selUserPayPwdByUserId(Long userId) throws Main4Exception;

    Boolean selIsPayPwdByUserId(Long userId) throws Main4Exception;

    void setNewPayPwd(Long userId,String pwd) throws JsonErrException;
}
