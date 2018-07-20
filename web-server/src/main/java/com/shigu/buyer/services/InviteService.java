package com.shigu.buyer.services;

import com.shigu.main4.order.bo.VoucherBO;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.ucenter.services.MemberInviteService;
import com.shigu.main4.ucenter.vo.InvitedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名：InviteService
 * 类路径： com.shigu.buyer.services.InviteService
 * 创建者： whx
 * 创建时间： 7/18/18 6:51 PM
 * 项目： main-pom
 * 描述：
 */
@Service
public class InviteService {

    @Autowired
    private MemberInviteService memberInviteService;

    @Autowired
    private ItemOrderService itemOrderService;

    /**
     * 根据邀请码获取邀请人id，没有邀请码或邀请码错误返回null
     * @param inviteCode
     * @return
     */
    public Long findUserByInviteCode(String inviteCode) {
        return memberInviteService.findUserByInviteCode(inviteCode);
    }

    /**
     * 获取用户邀请码
     * @param userId 非空
     * @return
     */
    public String userInviteCode(Long userId){
        return memberInviteService.userInviteCode(userId);
    }

    /**
     * 邀请注册的用户信息列表
     * @param invitedUserId 邀请人用户id
     * @return
     */
    public List<InvitedUser> inviteUserInfoList(Long invitedUserId){
        return memberInviteService.inviteUserInfoList(invitedUserId);
    }

    /**
     * 推广活动受到邀请注册优惠券发送
     * @param userId
     */
    public void giveVoucher(Long userId) {
        // 邀请新人活动
        String INVITE_VOUCHER_TAG = "INVITE_VOUCHER_TAG";
        VoucherBO bo = new VoucherBO();
        bo.setUserId(userId);
        bo.setVoucherAmount(1000L);
        bo.setVoucherTag(INVITE_VOUCHER_TAG);
        bo.setGuaranteePeriod(30);
        bo.setVoucherInfo("填写邀请码注册首单减免");
        itemOrderService.giveVoucher(bo);
    }
}
