package com.shigu.main4.ucenter.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.MemberInvite;
import com.opentae.data.mall.beans.MemberInviteCode;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.MemberUserExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.MemberInviteCodeMapper;
import com.opentae.data.mall.interfaces.MemberInviteMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.ucenter.services.MemberInviteService;
import com.shigu.main4.ucenter.vo.InvitedUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类名：MemberInviteServiceImpl
 * 类路径：package com.shigu.main4.ucenter.services.impl.MemberInviteServiceImpl
 * 创建者：whx
 * 创建时间：7/16/18 3:54 PM
 * 项目：main-pom
 * 描述：
 */

@Service("memberInviteService")
public class MemberInviteServiceImpl implements MemberInviteService {

    @Autowired
    private MemberInviteCodeMapper memberInviteCodeMapper;

    @Autowired
    private MemberInviteMapper memberInviteMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    /**
     * 获取用户邀请码
     * @param userId 非空
     * @return
     */
    @Override
    public String userInviteCode(Long userId) {
        String inviteCode = null;
        MemberInviteCode memberInviteCode = new MemberInviteCode();
        memberInviteCode.setUserId(userId);
        MemberInviteCode select = memberInviteCodeMapper.selectOne(memberInviteCode);
        if (select == null) {
            select = memberInviteCode;
            select.setUserInviteCode(generateInviteCode());
            memberInviteCodeMapper.insertSelective(select);
        }
        return select.getUserInviteCode();
    }

    /**
     * 生成唯一邀请码
     * @return
     */
    protected String generateInviteCode() {
        String inviteCode = null;
        MemberInviteCode memberInviteCode = new MemberInviteCode();
        do {
            inviteCode = StringUtil.str10To37Str();
            memberInviteCode.setUserInviteCode(inviteCode);
        } while (memberInviteCodeMapper.selectCount(memberInviteCode) > 0);
        return inviteCode;
    }

    /**
     * 根据邀请码获取邀请人id，没有邀请码或邀请码错误返回null
     * @param inviteCode
     * @return
     */
    @Override
    public Long findUserByInviteCode(String inviteCode) {
        if (StringUtils.isBlank(inviteCode)) {
            return null;
        }
        MemberInviteCode memberInviteCode = new MemberInviteCode();
        memberInviteCode.setUserInviteCode(inviteCode);
        MemberInviteCode invitedUser = memberInviteCodeMapper.selectOne(memberInviteCode);
        if (invitedUser == null) {
            return null;
        }
        return invitedUser.getUserId();
    }

    /**
     * 邀请注册的用户信息列表
     * @param invitedUserId 邀请人用户id
     * @return
     */
    @Override
    public List<InvitedUser> inviteUserInfoList(Long invitedUserId) {
        List<InvitedUser> invitedUsers = new ArrayList<>();
        //获取有效受邀请人
        MemberInvite memberInvite = new MemberInvite();
        memberInvite.setInviteUserId(invitedUserId);
        memberInvite.setValid(0);
        //受邀请人列表
        List<MemberInvite> inviteUserList = memberInviteMapper.select(memberInvite);
        if (inviteUserList.size()>0) {
            List<Long> inviteUserIds = inviteUserList.stream().map(MemberInvite::getUserId).collect(Collectors.toList());
            //查看邀请用户是否有交易完成订单信息
            ItemOrderExample itemOrderExample = new ItemOrderExample();
            itemOrderExample.createCriteria().andUserIdIn(inviteUserIds).andOrderStatusEqualTo(4);
            //完成过交易的用户
            Set<Long> orderFinishUserId = itemOrderMapper.selectFieldsByExample(itemOrderExample, FieldUtil.codeFields("user_id")).stream().map(ItemOrder::getUserId).collect(Collectors.toSet());
            MemberUserExample memberUserExample = new MemberUserExample();
            memberUserExample.createCriteria().andUserIdIn(inviteUserIds);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //用户信息
            invitedUsers = memberUserMapper.selectByExample(memberUserExample).stream().map(user -> {
                InvitedUser invitedUser = new InvitedUser();
                invitedUser.setUserId(user.getUserId());
                invitedUser.setHeadImg(user.getPortraitUrl());
                invitedUser.setTelephone(user.getLoginPhone());
                invitedUser.setRegisteDate(sdf.format(user.getRegTime()));
                //用户有已经完成订单，显示2下单成功，否则为1已经注册
                invitedUser.setUserState(orderFinishUserId.contains(user.getUserId())?2:1);
                return invitedUser;
            }).collect(Collectors.toList());
        }
        return invitedUsers;
    }
}
