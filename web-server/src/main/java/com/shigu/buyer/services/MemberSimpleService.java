package com.shigu.buyer.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguBonusRecord;
import com.opentae.data.mall.examples.MemberUserSubExample;
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
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 查用户的淘宝昵称,如果有多个淘宝账号,只取第一个
     * @param userId
     * @return
     */
    public String selNick(Long userId){
        MemberUserSubExample subExample=new MemberUserSubExample();
        subExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(LoginFromType.TAOBAO.getAccountType());
        subExample.setStartIndex(0);
        subExample.setEndIndex(1);
        List<MemberUserSub> list=memberUserSubMapper.selectByConditionList(subExample);
        if(list.size()==0){
            return null;
        }
        return list.get(0).getSubUserName();
    }

    public void updateShopNick(Long shopId,String nick){
        ShopBase shop = shopBaseService.shopBaseForUpdate(shopId);
        shop.setTbNick(nick);
        shopBaseService.modifyShopBase(shopId, shop);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateUser(UserInfoUpdate userinfo) throws UpdateUserInfoException {
        //2、重取本用户登陆缓存
        int i=userBaseService.updateUserInfo(userinfo);
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

        return memberUser.getIsPayPassword()!=null && memberUser.getIsPayPassword()>0;
    }

    public String selUserPayPwdByUserId(Long userId) throws Main4Exception {
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(userId,"user_id,pay_password");
        if (memberUser == null) {
            throw new Main4Exception("没有用户信息");
        }
        return memberUser.getPayPassword();
    }

    public void savePayPassword(Long userId,String oldPwd,String newPwd) throws JsonErrException {
        String pwd = null;
        try {
            pwd = selUserPayPwdByUserId(userId);
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        if (!pwd.equals(EncryptUtil.encrypt(oldPwd))) {
            throw new JsonErrException("输入原支付密码有误");
        }
        userBaseService.setNewPayPwd(userId,newPwd);
    }

    public void setPayPassword(Long userId,String newPwd) throws JsonErrException{
        try {
            if (selIsPayPwdByUserId(userId)) {
                throw new JsonErrException("已经设置过支付密码");
            }
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        userBaseService.setNewPayPwd(userId,newPwd);
    }

    public boolean isPayPwdMatch(Long userId, String payPwd){
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
     * @param userId
     * @return
     */
    public String getUserBalance(Long userId) {
        if (userId == null) {
            return null;
        }
        Long balance = memberUserMapper.userBalance(userId);
        if (balance == null) {
            //如果还没有对应支付站账户，去创建账户
            paySdkClientService.tempcode(userId);
            balance = memberUserMapper.userBalance(userId);
        }
        return String.format("%.2f",balance * 0.01);
    }

    /**
     * 获取用户红包余额
     * @param thirdId
     * @return
     */
    public Long getUserBonusBalance(String thirdId) {
        if (StringUtils.isBlank(thirdId)) {
            return null;
        }
        return memberUserMapper.getUserBonusBalance(thirdId);
    }

    /**
     * 获取用户红包明细
     * @param thirdId
     * @return
     */
    public List<ShiguBonusRecord> getUserBonusRecord(String thirdId) {
        if (StringUtils.isBlank(thirdId)) {
            return null;
        }
        return memberUserMapper.getUserBonusRecord(thirdId);
    }

    /**
     * 获取用户的淘宝昵称
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
