package com.shigu.main4.ucenter.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguUserLastloginshop;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguUserLastloginshopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.UserShopService;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户的店铺信息
 *
 * @author shigu_zjb
 * @date 2017/02/22 13:40
 *
 */
@Service("userShopService")
public class UserShopServiceImpl implements UserShopService{


    @Resource(name = "tae_mall_shiguUserLastloginshopMapper")
    private ShiguUserLastloginshopMapper shiguUserLastLoginShopMapper;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_shiguMarketMapper")
    private ShiguMarketMapper shiguMarketMapper;

    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    /**
     * 按userId查出最近一次登陆的档口
     * @param userId
     * @return
     */
    @Override
    public ShopSession selShopByUserId(Long userId) {
        if(userId == null){
            return null;
        }
        ShiguUserLastloginshopExample example = new ShiguUserLastloginshopExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<ShiguUserLastloginshop> shiguUserLastloginshopList = shiguUserLastLoginShopMapper.selectByExample(example);
        if(shiguUserLastloginshopList == null || shiguUserLastloginshopList.size() == 0){
            return selShopSessionInAll(userId);
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shiguUserLastloginshopList.get(0).getShopId());
//        shiguShop.setShopStatus(0);
        shiguShop.setUserId(userId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        if(shiguShop == null){
            return null;
        }
        if(shiguShop.getShopStatus()  == 1){
            return selShopSessionInAll(userId);
        }
        ShopSession shopSession = new ShopSession();
        shopSession.setShopId(shiguShop.getShopId());
        shopSession.setFloorId(shiguShop.getFloorId());
        shopSession.setMarketId(shiguShop.getMarketId());
        shopSession.setShopNum(shiguShop.getShopNum());
        shopSession.setWebSite(shiguShop.getWebSite());
        shopSession.setTbNick(shiguShop.getTbNick());
        shopSession.setShopName(shiguShop.getShopName());
        shopSession.setType(shiguShop.getType());
        ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getMarketId(),
                FieldUtil.codeFields("market_id,market_name"));
        if(shiguMarket != null){
            shopSession.setMarket(shiguMarket.getMarketName());
        }

        ShiguMarket shiguMarketFloor = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getFloorId(),
                FieldUtil.codeFields("market_id,market_name"));
        if(shiguMarketFloor != null){
            shopSession.setFloor(shiguMarketFloor.getMarketName());
        }
        return shopSession;
    }

    /**
     * 查出当前用户所有可用店铺
     * @param userId
     * @return
     */
    @Override
    public List<ShopSession> selUsersAllShop(Long userId) {
        List<ShopSession> shopSessionList = new ArrayList<ShopSession>();
        if(userId == null){
            return shopSessionList;
        }
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andUserIdEqualTo(userId).andShopStatusEqualTo(0).andUserManagerEqualTo(1);
        List<ShiguShop> shiguShopList = shiguShopMapper.selectByExample(shiguShopExample);
        for (int i = 0; i < shiguShopList.size(); i++) {
            ShiguShop shiguShop = shiguShopList.get(i);

            ShopSession shopSession = new ShopSession();
            shopSession.setShopId(shiguShop.getShopId());
            shopSession.setFloorId(shiguShop.getFloorId());
            shopSession.setMarketId(shiguShop.getMarketId());
            shopSession.setShopNum(shiguShop.getShopNum());
            shopSession.setWebSite(shiguShop.getWebSite());
            shopSession.setTbNick(shiguShop.getTbNick());
            shopSession.setShopName(shiguShop.getShopName());
            shopSession.setType(shiguShop.getType());

            ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getMarketId(),
                    FieldUtil.codeFields("market_id,market_name"));
            if (shiguMarket != null) {
                shopSession.setMarket(shiguMarket.getMarketName());
            }

            ShiguMarket shiguMarketFloor = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getFloorId(),
                    FieldUtil.codeFields("market_id,market_name"));
            if (shiguMarketFloor != null) {
                shopSession.setFloor(shiguMarketFloor.getMarketName());
            }
            shopSessionList.add(shopSession);
        }
        return shopSessionList;
    }

    /**
     * 切换店铺
     * @param userId
     * @param shopId
     */
    @Override
    public void changeShop(Long userId, Long shopId) {
        ShiguUserLastloginshop shiguUserLastloginshop=shiguUserLastLoginShopMapper.selectByPrimaryKey(userId);
        if(shiguUserLastloginshop==null){
            shiguUserLastloginshop=new ShiguUserLastloginshop();
            shiguUserLastloginshop.setUserId(userId);
            shiguUserLastloginshop.setShopId(shopId);
            shiguUserLastLoginShopMapper.insertSelective(shiguUserLastloginshop);
        }else{
            shiguUserLastloginshop.setShopId(shopId);
            shiguUserLastLoginShopMapper.updateByPrimaryKeySelective(shiguUserLastloginshop);
        }
    }

    /**
     * 绑定淘宝用户到店铺
     * @param nick
     * @return
     */
    @Override
    public Long bindNickToShop(String nick) throws Main4Exception {
        if(StringUtils.isEmpty(nick)){
            return null;
        }
        MemberUserSubExample userSubExample = new MemberUserSubExample();
        userSubExample.createCriteria().andAccountTypeEqualTo(LoginFromType.TAOBAO.getAccountType())
                .andSubUserNameEqualTo(nick);
        List<MemberUserSub> userSubList = memberUserSubMapper.selectByExample(userSubExample);
        if(userSubList.size() == 0){
            throw new Main4Exception("用户不存在");
        }
        if(userSubList.size() > 1){
            throw new Main4Exception("该淘宝昵称被两个以上用户绑定");
        }
        ShiguShopExample shopExample = new ShiguShopExample();
        shopExample.createCriteria().andTbNickEqualTo(nick).andShopStatusEqualTo(0);
        List<ShiguShop> shiguShopList = shiguShopMapper.selectByExample(shopExample);
        if(shiguShopList.size() == 0){
            return null;
        }
        if(shiguShopList.size() > 1){
            throw new Main4Exception("该淘宝昵称被两个以上店铺绑定");
        }
        ShiguShop shiguShop = shiguShopList.get(0);
        shiguShop.setUserId(userSubList.get(0).getUserId());
        shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        return shiguShop.getShopId();
    }

    /**
     * 在所有档口中选择
     * @param userId
     * @return
     */
    private ShopSession selShopSessionInAll(Long userId){
        List<ShopSession> shopSessionList = selUsersAllShop(userId);
        if(shopSessionList == null || shopSessionList.size() == 0){
            return null;
        }
        ShopSession shopSession=shopSessionList.get(0);
        changeShop(userId,shopSession.getShopId());
        return shopSession;
    }

}
