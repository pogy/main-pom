package com.shigu.sysman.shop.service;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguShopApply;
import com.opentae.data.mall.interfaces.*;
import com.shigu.component.common.taobao.TaobaoOpenClient;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.vo.DmlReason;
import com.shigu.services.DubboAllService;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.sysman.shop.bo.ShopApplyBo;
import com.shigu.sysman.shop.bo.ShopBo;
import com.shigu.sysman.shop.vo.ShiguShopVo;
import com.shigu.sysman.taobao.service.TaobaoOpenService;
import com.shigu.tb.finder.exceptions.TbTmcException;
import com.shigu.tb.finder.services.TaobaoSynService;
import com.shigu.tb.finder.services.TaobaoTmcService;
import com.taobao.api.ApiException;
import com.taobao.api.domain.TmcUser;
import com.taobao.api.response.ShopGetResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 店铺SERVICE
 *
 * @author shigu_zjb
 *
 */
@Service("shopService")
public class ShopService {

    private static final Logger logger = LoggerFactory.getLogger(ShopService.class);


    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguShopApplyMapper shiguShopApplyMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private MemberUserSubMapper memberUserSubMapper;

    @Autowired
    private ShopBaseService shopBaseService;

    @Autowired
    private ShopRegistService shopRegistService;

    @Autowired
    private DubboAllService dubboAllService;

    @Autowired
    private TaobaoOpenService taobaoOpenService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private UserBaseService userBaseService;
    /**
     * 店铺分页
     * @param shopBo
     * @return
     */
    public ShiguPager<ShiguShopVo> findShiguShopPageByBo(ShopBo shopBo){
        ShiguPager<ShiguShopVo> shopPager = new ShiguPager<ShiguShopVo>();
        List<ShiguShop> shiguShopList = shiguShopMapper.selectShopListByBo(shopBo.getWebsite(),shopBo.getUserName(),
                shopBo.getUserId(),shopBo.getMarketId(),shopBo.getFloorId(), shopBo.getShopId(),shopBo.getTaobaoUrl(),
                shopBo.getTbNick(), shopBo.getShopNum(),shopBo.getStartRow(),shopBo.getPageSize());
        List<ShiguShopVo> shiguShopVoList = BeanMapper.mapList(shiguShopList,ShiguShopVo.class);
        List<String> nickList = new ArrayList<String>();
        for(int i = 0;i<shiguShopList.size();i++){
            ShiguShopVo shiguShopVo = shiguShopVoList.get(i);
            if(StringUtils.isEmpty(shiguShopVo.getTbNick())){
                continue;
            }
            int shopAuthState = shopBaseService.panssShopAuthState(shiguShopVo.getFreshTime(),shiguShopVo.getExpiresIn());
            shiguShopVoList.get(i).setShopAuthState(shopAuthState);
            nickList.add(shiguShopVo.getTbNick());
        }
        try{
            // 调用接口
            Map<String,TmcUser> tmcStatusMap = dubboAllService.getTaobaoTmcService().listTmc(nickList);
            for(String key : tmcStatusMap.keySet()){
                for(int i = 0;i<shiguShopVoList.size();i++){
                    ShiguShopVo shiguShopVo = shiguShopVoList.get(i);
                    if(StringUtils.equals(shiguShopVo.getTbNick(),key)){
                        TmcUser tmcUser = tmcStatusMap.get(key);
                        if(tmcUser == null){
                            break;
                        }
                        shiguShopVoList.get(i).setTmcStatus(tmcUser.getIsValid());
                        shiguShopVoList.get(i).setTmcFirstTime(tmcUser.getCreated());
                        shiguShopVoList.get(i).setTmcLastTime(tmcUser.getModified());
                        shiguShopVoList.get(i).setValid(tmcUser.getIsValid());
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("调用获取店铺队列dubbo接口发生错误>>error:" + e.toString());
        }
        int shopCount = shiguShopMapper.selectShopCountByBo(shopBo.getWebsite(),shopBo.getUserName(),
                shopBo.getUserId(),shopBo.getMarketId(),shopBo.getFloorId(), shopBo.getShopId(),shopBo.getTaobaoUrl(),
                shopBo.getShopName(), shopBo.getShopNum());
        shopPager.setNumber(shopBo.getCurrentPage());
        shopPager.setContent(shiguShopVoList);
        shopPager.calPages(shopCount, shopBo.getPageSize());
        return shopPager;
    }

    /**
     * 店铺入驻审核列表
     * @param shopApplyBo
     * @return
     */
    public ShiguPager<ShiguShopApply> findShopApplyPagerByBo(ShopApplyBo shopApplyBo){
        ShiguPager<ShiguShopApply> shopPager = new ShiguPager<ShiguShopApply>();
        List<ShiguShopApply> shopApplyList = shiguShopApplyMapper.selectShopApplyListByBo(shopApplyBo.getApplyId(),
                shopApplyBo.getShopNum(), shopApplyBo.getApplyStatus(),shopApplyBo.getCanExamine(),
                shopApplyBo.getWebsite(),shopApplyBo.getStartRow(), shopApplyBo.getPageSize());
        int applyCount = shiguShopApplyMapper.selectShopApplyCountByBo(shopApplyBo.getApplyId(),shopApplyBo.getShopNum(),
                shopApplyBo.getApplyStatus(),shopApplyBo.getCanExamine(), shopApplyBo.getWebsite());
        shopPager.setNumber(shopApplyBo.getCurrentPage());
        shopPager.setContent(shopApplyList);
        shopPager.calPages(applyCount, shopApplyBo.getPageSize());
        return shopPager;
    }

    /**
     * 店铺申请
     * @param applyId
     * @return
     */
    public ShiguShopApply findShopApplyById(Long applyId){
        if(applyId == null){
            return null;
        }
        ShiguShopApply shiguShopApply = shiguShopApplyMapper.selectByPrimaryKey(applyId);
        return shiguShopApply;
    }

    /**
     * 店铺入驻申请
     * @param shiguShopApply
     */
    public void updateShopApply(ShiguShopApply shiguShopApply) throws Main4Exception {
        if(shiguShopApply == null || shiguShopApply.getRuzhuId() == null){
            return;
        }
        if(!StringUtils.isEmpty(shiguShopApply.getTbNick())){
            ShopGetResponse getResponse = taobaoOpenService.getShopGetResponse(shiguShopApply.getTbNick());
            if(getResponse == null || !getResponse.isSuccess()){
                throw new Main4Exception("淘宝昵称：" + shiguShopApply.getTbNick() + " 下找不到店铺信息");
            }
            shiguShopApply.setTbshopId(getResponse.getShop().getSid().toString());
            String tbUrl = "http://shop${shopId}.taobao.com".replace("${shopId}", shiguShopApply.getTbshopId());
            shiguShopApply.setTbUrl(tbUrl);
            if(!StringUtils.isEmpty(tbUrl)){
                shiguShopApply.setCanExamine(1);
            }
        }
        shiguShopApplyMapper.updateByPrimaryKeySelective(shiguShopApply);
    }

    /**
     * 店铺审核通过
     * @param applyId
     */
    @Transactional
    public void examineShopPanss(Long applyId) throws Main4Exception{
        Long shopId = shopRegistService.toExamine(applyId);
        // 推送
        String tbNick = tbNickByShopId(shopId);
        if(!StringUtils.isEmpty(tbNick)){
            try{
                dubboAllService.getTaobaoTmcService().addToTmc(tbNick);
                dubboAllService.getTaobaoSynService().synOneShopAsyn(shopId,tbNick);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("店铺审核通过 推送失败>>error:" + e.toString());
            }
        }
    }


    /**
     * 全店抓取
     * @param shopId
     */
    public void synShop(Long shopId) throws Main4Exception, ApiException {
        if(shopId == null){
            throw new Main4Exception("全店抓取店鋪ID为空");
        }
        String tbNick = tbNickByShopId(shopId);
        if(StringUtils.isEmpty(tbNick)){
            throw new Main4Exception("不是淘宝店铺无法抓取");
        }
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        shiguGoodsTinyMapper.udpateGoodsModifiedForSynShop(shiguShop.getWebSite(), shopId);
        dubboAllService.getTaobaoSynService().synOneShop(shopId,tbNick);
        dubboAllService.getTaobaoTmcService().addToTmc(tbNick);
    }

    /**
     * 获取淘宝NICK
     * @param shopId
     * @return
     * @throws Main4Exception
     */
    public String tbNickByShopId(Long shopId) throws Main4Exception{
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shopId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        if(shiguShop == null){
            throw new Main4Exception("店铺信息有误");
        }
        String tbNick = shiguShop.getTbNick();
        //为什么要去查?????
//        if(StringUtils.isEmpty(tbNick)){
//            // 查询用户淘宝昵称
//            MemberUser memberUser = new MemberUser();
//            memberUser.setUserId(shiguShop.getUserId());
//            memberUser = memberUserMapper.selectOne(memberUser);
//            if(memberUser != null){
//                tbNick = memberUser.getImAliww();
//            }
//        }
        return tbNick;
    }

    /**
     * 开店
     * @param shopId
     * @param dmlReason
     */
    @Transactional
    public void openShop(Long shopId, DmlReason dmlReason) throws Exception {
        shopBaseService.openShop(shopId ,dmlReason);
        String tbNick = tbNickByShopId(shopId);
        String tmcErrorMsg = null;
        shopBandUser(shopId);
        if(!StringUtils.isEmpty(tbNick)){
            // 推送
            try{
                dubboAllService.getTaobaoTmcService().addToTmc(tbNick);
                dubboAllService.getTaobaoSynService().synOneShopAsyn(shopId,tbNick);
            }catch (TbTmcException tmce){
                tmce.printStackTrace();
                tmcErrorMsg = tmce.getMessage();
            }catch (Exception e){
                e.printStackTrace();
                logger.error("开店推送失败>>error:" + e.toString());
            }
        }
    }

    /**
     * 店铺绑定用户
     * @param shopId
     */
    public void shopBandUser(Long shopId){
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shopId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        if (shiguShop == null || shiguShop.getUserId() != null) {
            return;
        }
        if (StringUtils.isEmpty(shiguShop.getTbNick())) {
            return;
        }
        // 查询用户淘宝昵称
        MemberUserSub userSub = new MemberUserSub();
        userSub.setSubUserName(shiguShop.getTbNick());
        userSub.setAccountType(LoginFromType.TAOBAO.getAccountType());
        userSub = memberUserSubMapper.selectOne(userSub);
        if (userSub == null) {
            return;
        }
        shiguShop.setUserId(userSub.getUserId());
        shiguShopMapper.updateByPrimaryKey(shiguShop);
        //添加到ES
        shopBaseService.addToEs(shiguShop.getShopId());
    }

    /**
     * 关店
     * @param shopId
     * @param dmlReason
     */
    @Transactional
    public void closeShop(Long shopId, DmlReason dmlReason) throws Main4Exception {
        shopBaseService.closeShop(shopId, dmlReason);
        String tbNick = tbNickByShopId(shopId);
        if(!StringUtils.isEmpty(tbNick)){
            try{
                dubboAllService.getTaobaoTmcService().removeTmc(tbNick);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("关店推送失败>>error:" + e.toString());
            }
        }
    }

    /**
     * 查找店铺
     * @param shopId
     * @return
     */
    public ShiguShop findShopByShopId(Long shopId){
        if(shopId == null){
            return null;
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shopId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        return shiguShop;
    }

    /**
     * 修改店铺
     * @param shiguShop
     */
    public void updateShop(ShiguShop shiguShop) throws Main4Exception {
        if(shiguShop == null || shiguShop.getShopId() == null){
            return;
        }
        Long tbShopId = null;
        if(!StringUtils.isEmpty(shiguShop.getTbNick())){
            ShopGetResponse rsp = taobaoOpenService.getShopGetResponse(shiguShop.getTbNick());
            if(rsp ==null || !rsp.isSuccess()){
                throw new Main4Exception("获取不到淘宝店铺信息");
            }
            tbShopId = rsp.getShop().getSid();
        }
        // 更新淘宝链接
        Long userId=userBaseService.selTbOuterUser(shiguShop.getTbNick());
        shopBaseService.changeTbLink(userId,shiguShop.getShopId(), shiguShop.getTbNick(), tbShopId);
        shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        shopBaseService.addToEs(shiguShop.getShopId());
    }


    /**
     * 档口迁移
     * @param shopId
     * @param toMarketId
     * @param toFloorId
     * @param shopNum
     */
    public void qyshop(Long shopId, Long toMarketId, Long toFloorId, String shopNum) throws Main4Exception {
        if(shopId == null || toMarketId == null || toFloorId == null || StringUtils.isEmpty(shopNum)){
            return;
        }
        shopBaseService.moveMarket(shopId,toMarketId,toFloorId,shopNum);
    }



}
