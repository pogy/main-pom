package com.shigu.buyer.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.custombeans.BalanceVO;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.MemberInviteMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.component.shiro.enums.CacheEnum;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.main4.vo.ShopBase;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户简单服务
 * Created by zhaohongbo on 17/3/23.
 */
@Service
public class MemberSimpleService {
    @Autowired
    MemberUserSubMapper memberUserSubMapper;

    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    EhCacheManager ehCacheManager;

    @Autowired
    MemberUserMapper memberUserMapper;

    @Autowired
    UserBaseService userBaseService;

    @Autowired
    PaySdkClientService paySdkClientService;

    @Autowired
    MemberInviteMapper memberInviteMapper;

    @Autowired
    ItemOrderMapper itemOrderMapper;

    /**
     * 查用户的淘宝昵称,如果有多个淘宝账号,只取第一个
     *
     * @param userId
     * @return
     */
    public String selNick(Long userId) {
        MemberUserSubExample subExample = new MemberUserSubExample();
        subExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(LoginFromType.TAOBAO.getAccountType());
        subExample.setStartIndex(0);
        subExample.setEndIndex(1);
        List<MemberUserSub> list = memberUserSubMapper.selectByConditionList(subExample);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0).getSubUserName();
    }

    public void updateShopNick(Long shopId, String nick) {
        ShopBase shop = shopBaseService.shopBaseForUpdate(shopId);
        shop.setTbNick(nick);
        shopBaseService.modifyShopBase(shopId, shop);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateUser(UserInfoUpdate userinfo) throws UpdateUserInfoException {
        //2、重取本用户登陆缓存
        int i = userBaseService.updateUserInfo(userinfo);
        //      a.清除cache名memberuserCache，其中memberuserCache的key为userName_登陆方式标志
        Session session = SecurityUtils.getSubject().getSession();
        PersonalSession sessionUser = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        Cache<Object, Object> cache = ehCacheManager.getCache(CacheEnum.MEMBERUSER_CACHE.getValue());
        cache.remove(sessionUser.getLoginName() + "_" + sessionUser.getLoginFromType().getValue());

        //      b.重取登陆对象，更新session中的session_user对象，
        PersonalSession ps = userBaseService.selUserForSessionByUserName(sessionUser.getLoginName(), sessionUser.getLoginFromType());
        session.setAttribute(SessionEnum.LOGIN_SESSION_USER.getValue(), ps);
        return i;
    }

    public Boolean selIsPayPwdByUserId(Long userId) throws Main4Exception {
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(userId, "user_id,is_pay_password");
        if (memberUser == null) {
            throw new Main4Exception("没有用户信息");
        }

        return memberUser.getIsPayPassword() != null && memberUser.getIsPayPassword() > 0;
    }

    public String selUserPayPwdByUserId(Long userId) throws Main4Exception {
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(userId, "user_id,pay_password");
        if (memberUser == null) {
            throw new Main4Exception("没有用户信息");
        }
        return memberUser.getPayPassword();
    }

    public void savePayPassword(Long userId, String oldPwd, String newPwd) throws JsonErrException {
        String pwd = null;
        try {
            pwd = selUserPayPwdByUserId(userId);
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        if (!pwd.equals(EncryptUtil.encrypt(oldPwd))) {
            throw new JsonErrException("输入原支付密码有误");
        }
        userBaseService.setNewPayPwd(userId, newPwd);
    }

    public void setPayPassword(Long userId, String newPwd) throws JsonErrException {
        try {
            if (selIsPayPwdByUserId(userId)) {
                throw new JsonErrException("已经设置过支付密码");
            }
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        userBaseService.setNewPayPwd(userId, newPwd);
    }
    public String getUserCreateTime(Long userId){
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        return DateFormatUtils.format(memberUser.getRegTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public boolean isPayPwdMatch(Long userId, String payPwd) {
        if (userId == null || StringUtils.isBlank(payPwd)) {
            return false;
        }
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        if (memberUser == null || StringUtils.isBlank(memberUser.getPayPassword())) {
            return false;
        }
        return memberUser.getPayPassword().equals(EncryptUtil.encrypt(payPwd));
    }

    /**
     * 获取用户余额,正常用户登陆后才会调用到这个接口，userId不会为空
     *
     * @param userId
     * @return
     */
    public BalanceVO getUserBalance(Long userId) {
        if (userId == null) {
            return null;
        }
        BalanceVO balanceVO = memberUserMapper.userBalanceInfo(userId);
        if (balanceVO == null) {
            //如果还没有对应支付站账户，去创建账户
            paySdkClientService.tempcode(userId);
            balanceVO = memberUserMapper.userBalanceInfo(userId);
        }
        // 星座宝账户不存在且账户创建失败
        if (balanceVO == null || balanceVO.getMoney() == null) {
            balanceVO = new BalanceVO();
            balanceVO.setMoney(0L);
            balanceVO.setBlockMoney(0L);
        }
        return balanceVO;
    }

    /**
     * 获取账户余额信息的json结果
     *
     * @param userId
     * @return
     */
    public JSONObject getUserBalanceShow(Long userId) {
        BalanceVO userBalance = getUserBalance(userId);
        if (userBalance == null) {
            return JsonResponseUtil.error("未查到错误信息");
        }
        //正常情况
        if (userBalance.getMoney() != null) {
            JSONObject result = JsonResponseUtil.success();
            result.element("balance", String.format("%.2f", userBalance.getMoney() * 0.01));
            if (userBalance.getBlockMoney() != null) {
                result.element("blockMoney", String.format("%.2f", userBalance.getBlockMoney() * 0.01));
            }
            return result;
        }
        return JsonResponseUtil.error("未查询到账户余额信息");
    }

    /**
     * 获取用户红包余额
     *
     * @param userId
     * @return
     */
    public Long getUserBonusBalance(Long userId) {
        if (userId == null) {
            return null;
        }
        List<Long> userBonusBalance = memberUserMapper.getUserBonusBalance(userId);
        if (userBonusBalance == null || userBonusBalance.isEmpty()) {
            return 0L;
        }
        Long total = 0L;
        for (Long item : userBonusBalance){
            if (item == null) {
                continue;
            }
            total += item;
        }
        return total;
    }

    /**
     * 获取用户红包明细
     *
     * @param userId
     * @return
     */
    public List<ShiguBonusRecord> getUserBonusRecord(Long userId) {
        if (userId == null) {
            return null;
        }
        return memberUserMapper.getUserBonusRecord(userId);
    }

    /**
     * 获取用户红包明细
     *
     * @param userId
     * @return
     */
    public Integer getUserFirstReduction(Long userId) {
        if (userId == null) {
            return -1;
        }
        MemberInvite memberInvite = new MemberInvite();
        memberInvite.setUserId(userId);
        List<MemberInvite> userList = memberInviteMapper.select(memberInvite);
        if (userList == null || userList.size() <= 0)
            return -1;
        ItemOrderExample itemOrderExample = new ItemOrderExample();
        itemOrderExample.createCriteria().andUserIdEqualTo(userId).andOrderStatusGreaterThan(1);
        List<ItemOrder> orderList = itemOrderMapper.selectByExample(itemOrderExample);
        if (orderList == null || orderList.size() <= 0)
            return 1;
        return 2;
    }

    /**
     * 获取用户的淘宝昵称
     *
     * @param userId
     * @return
     */
    public String getTaobaoNick(Long userId) {
        MemberUserSubExample memberUserSubExample = new MemberUserSubExample();
        MemberUserSubExample.Criteria criteria = memberUserSubExample.createCriteria();
        criteria.andUserIdEqualTo(userId)
                .andAccountTypeEqualTo(3)
                .andUseStatusEqualTo(1);
        List<MemberUserSub> memberUserSubList = memberUserSubMapper
                .selectFieldsByExample(memberUserSubExample, FieldUtil.codeFields("sub_user_key,sub_user_name"));
        if (memberUserSubList != null && !memberUserSubList.isEmpty()) {
            return memberUserSubList.get(0).getSubUserName();
        }
        return null;
    }
}
