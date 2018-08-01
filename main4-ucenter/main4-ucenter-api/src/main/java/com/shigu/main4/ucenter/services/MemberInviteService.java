package com.shigu.main4.ucenter.services;

import com.shigu.main4.ucenter.vo.InvitedUser;

import java.util.List;

/**
 * 类名：MemberInviteService
 * 类路径：package com.shigu.main4.ucenter.services.MemberInviteService
 * 创建者：whx
 * 创建时间：7/16/18 3:53 PM
 * 项目：main-pom
 * 描述：用户邀请码推广相关
 */
public interface MemberInviteService {

    /**
     * 获取用户邀请码
     * @param userId 非空
     * @return
     */
    String userInviteCode(Long userId);

    /**
     * 根据邀请码获取邀请人id，没有邀请码或邀请码错误返回null
     * @param inviteCode
     * @return
     */
    Long findUserByInviteCode(String inviteCode);

    /**
     * 邀请注册的用户信息列表
     * @param invitedUserId 邀请人用户id
     * @return
     */
    List<InvitedUser> inviteUserInfoList(Long invitedUserId);
}
