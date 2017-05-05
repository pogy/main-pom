package com.shigu.sysman.shop.service;

import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.component.encrypt.EncryptUtil;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.main4.vo.ShopRegister;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * 濮院注册店铺
 * Created by Administrator on 2017/5/3 0003.
 */
@Service
public class PuyuanShopRegistService {

    @Autowired
    private UserLicenseService userLicenseService;

    @Autowired
    private ShopRegistService shopRegistService;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private MemberUserSubMapper memberUserSubMapper;

    @Autowired
    private ShopBaseService shopBaseService;

    @Transactional
    public void register(RegisterUser user, ShopRegister shop) throws Main4Exception {

        //1、调用注册用户接口(账号密码靠输入)
        MemberUser memberUser = new MemberUser();
        memberUser.setUserNick(user.getUserNick());
        memberUser.setRegTime(new Date());
        memberUserMapper.insertSelective(memberUser);
        Long userId = memberUser.getUserId();
        String phone = String.valueOf((20000000000L + userId));
        user.setTelephone(phone);
        memberUser.setUserName(phone);
        memberUser.setLoginPhone(phone);
        memberUserMapper.updateByPrimaryKeySelective(memberUser);

        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setSubUserName(user.getTelephone());
        memberUserSub.setUserId(memberUser.getUserId());

        String encryptPwd = EncryptUtil.encrypt(user.getPassword());

        memberUserSub.setSubUserPassword(encryptPwd);
        memberUserSub.setSubUserKey(UUID.randomUUID().toString().replace("-",""));
        memberUserSub.setAccountType(LoginFromType.PHONE.getAccountType());
        memberUserSub.setLogins(0L);
        memberUserSub.setUseStatus(1L);
        memberUserSubMapper.insertSelective(memberUserSub);
        userLicenseService.passwordSafeCheck(userId, user.getPassword());
        userLicenseService.bindNotUserCanRegist(userId, user.getTelephone());

        //2、绑定手机(手机号20000000000+userId)

        //3、申请开店
        shop.setUserId(memberUser.getUserId());
        shop.setWebSite("jx");
        shop.setCanExamine(true);
//
        long registId = shopRegistService.registShop(shop);

        //4、审核通过
        shopBaseService.addToEs(shopRegistService.toExamine(registId));

    }
}
