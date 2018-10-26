package com.shigu.main4.ucenter.services.impl;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShopeeUserInfo;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.ShopeeUserInfoMapper;
import com.shigu.main4.ucenter.bo.ShopeeUserBO;
import com.shigu.main4.ucenter.services.ShopeeUserService;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：ShopeeUserServiceImpl
 * 类路径： com.shigu.main4.ucenter.services.impl.ShopeeUserServiceImpl
 * 创建者： whx
 * 创建时间： 10/22/18 3:20 PM
 * 项目： main-pom
 * 描述：
 */
@Service("shopeeUserService")
public class ShopeeUserServiceImpl implements ShopeeUserService {

    @Autowired
    private ShopeeUserInfoMapper shopeeUserInfoMapper;
    @Autowired
    private MemberUserSubMapper memberUserSubMapper;

    @Override
    public void refreshShopeeUserInfo(ShopeeUserBO bo) {
        Long shopId = bo.getShopId();
        if (shopId != null) {
            ShopeeUserInfo shopeeUserInfo = new ShopeeUserInfo();
            BeanUtils.copyProperties(bo, shopeeUserInfo);
            if (shopeeUserInfoMapper.selectByPrimaryKey(shopId) == null) {
                shopeeUserInfoMapper.insertSelective(shopeeUserInfo);
            } else {
                shopeeUserInfoMapper.updateByPrimaryKeySelective(shopeeUserInfo);
            }
        }
    }

    @Override
    public ShopeeUserBO selShopeeInfo(Long userId) {
        MemberUserSub sub=new MemberUserSub();
        sub.setUserId(userId);
        sub.setAccountType(LoginFromType.SHOPEE.getAccountType());
        sub=memberUserSubMapper.selectOne(sub);
        if(sub!=null){
            ShopeeUserInfo shopeeUserInfo = shopeeUserInfoMapper.selectByPrimaryKey(new Long(sub.getSubUserKey()));
            if(shopeeUserInfo!=null){
                ShopeeUserBO vo=new ShopeeUserBO();
                BeanUtils.copyProperties(shopeeUserInfo, vo);
                return vo;
            }
        }
        return null;
    }
}
