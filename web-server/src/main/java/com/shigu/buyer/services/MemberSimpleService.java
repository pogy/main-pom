package com.shigu.buyer.services;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.component.shiro.enums.CacheEnum;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.main4.vo.ShopBase;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.session.main4.tool.BeanMapper;
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
    UserBaseService userBaseService;

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
}
