package com.shigu.main4.ucenter.model.impl;

import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.exceptions.Bind3RdsException;
import com.shigu.main4.ucenter.model.BindOuterRdUser;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created By admin on 2017/12/18/13:09
 */
@Service
public class BindTbUser implements BindOuterRdUser {

    @Resource(name = "tae_mall_memberLicenseMapper")
    private MemberLicenseMapper memberLicenseMapper;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    /**
     * 是否准入 不准入直接抛出异常
     * @param phone
     * @param tempUser
     * @return
     */
    @Override
    public void admittance(String phone,Rds3TempUser tempUser) throws Main4Exception {
         /*
            新加情况2
            2、if(loginType == taobao){//如果是淘宝店
               if(shop.hasNick(sub_user_name) && telephone.hasStore){//如果淘宝昵称已经开过店，并且手机号下有店
                 禁入
               }
            }
             */
        ShiguShopExample shopExample=new ShiguShopExample();
        shopExample.createCriteria().andTbNickEqualTo(tempUser.getSubUserName()).andShopStatusEqualTo(0);
        List<ShiguShop> shops=shiguShopMapper.selectByExample(shopExample);
        ShiguShop shop=null;
        if (shops.size()>0) {
            shop=shops.get(0);
        }
        if (shop != null) {
            MemberLicense license = new MemberLicense();
            license.setLicenseType(4);
            license.setContext(phone);
            license.setLicenseFailure(1);
            license = memberLicenseMapper.selectOne(license);
            if (license != null) {
                shopExample.clear();
                shopExample.createCriteria().andUserIdEqualTo(license.getUserId()).andShopStatusEqualTo(0)
                        .andTbNickNotEqualTo(tempUser.getSubUserName());
                //需要查出非本昵称下的店铺，如果手机有非本昵称下的店铺，且本昵称有店，不准入
//                    ShiguShop shiguShop = new ShiguShop();
//                    shiguShop.setUserId(license.getUserId());
//                    shiguShop.setShopStatus(0);
                if (shiguShopMapper.countByExample(shopExample) > 0)
                    throw new Main4Exception("该手机号已绑定过档口");
            }
        }
    }

    /**
     * 绑定店铺
     * @param phone
     * @param tempUser
     * @param userId
     */
    @Override
    public void bindShop(String phone,Rds3TempUser tempUser,Long userId) throws Bind3RdsException {
        if (tempUser.getLoginFromType() == LoginFromType.TAOBAO) {
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andTbNickEqualTo(tempUser.getSubUserName()).andShopStatusEqualTo(0);
            List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shopExample);
            for (ShiguShop shiguShop : shiguShops) {
                if (shiguShop.getUserId() == null) {
                    shiguShop.setUserId(userId);
                    shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
                } else if(shiguShop.getUserId().equals(userId)){//除自己外
                    break;
                }else {
                    throw new Bind3RdsException("本淘宝账号[" + tempUser.getSubUserName() + "]对应店铺已经绑给其它用户，请先登陆其它用户解绑或联系客服处理");
                }
                break;
            }
            //查出用户名下的店铺非淘宝店铺
            shopExample.clear();
            shopExample.createCriteria().andTbNickIsNull().andShopStatusEqualTo(0).andUserIdEqualTo(userId);
            List<ShiguShop> untbShops=shiguShopMapper.selectByExample(shopExample);
            for(ShiguShop shop:untbShops){
                shop.setTbNick(tempUser.getSubUserName());
                shiguShopMapper.updateByPrimaryKeySelective(shop);
            }
        }
    }
}
