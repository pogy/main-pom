package com.shigu.seller.services.api.impl;

import com.opentae.data.mall.beans.SpreadAuctScren;
import com.opentae.data.mall.beans.SpreadAuctShop;
import com.opentae.data.mall.beans.SpreadAuctType;
import com.opentae.data.mall.examples.SpreadAuctTypeExample;
import com.opentae.data.mall.interfaces.SpreadAuctScrenMapper;
import com.opentae.data.mall.interfaces.SpreadAuctShopMapper;
import com.opentae.data.mall.interfaces.SpreadAuctTypeMapper;
import com.shigu.component.shiro.SimpleRolePermissionReader;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.seller.bo.AuctionApplyBo;
import com.shigu.seller.services.api.ADAuctionService;
import com.shigu.seller.vo.SpreadTypeViewVo;
import com.shigu.seller.vo.WinnerVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * 广告竞拍SERVICE
 * @author shigu_zjb
 * @date 2017/3/22 18:24
 *
 */
@Service("aDAuctionService")
public class ADAuctionServiceImpl implements ADAuctionService{

    @Autowired
    private SpreadAuctScrenMapper spreadAuctScrenMapper;

    @Autowired
    private SpreadAuctShopMapper spreadAuctShopMapper;

    @Autowired
    private SpreadAuctTypeMapper spreadAuctTypeMapper;

    /**
     * 广告区域列表
     * @return
     */
    public List<SpreadTypeViewVo> getSpreadAuctTypeList(){
        SpreadAuctTypeExample spreadAuctTypeExample = new SpreadAuctTypeExample();
        spreadAuctTypeExample.createCriteria().andDisEnabledEqualTo(false);
        List<SpreadAuctType> auctTypeList = spreadAuctTypeMapper.selectByExample(spreadAuctTypeExample);
        List<SpreadTypeViewVo> typeViewVoList = new ArrayList<SpreadTypeViewVo>();
        // 当前投放时间
        for (int i = 0; i < auctTypeList.size(); i++) {
            SpreadAuctType spreadAuctType = auctTypeList.get(i);
            // 取当前活动
            SpreadAuctScren auctScren = getCurrentAuction(spreadAuctType.getId());
            if(auctScren == null){
                // 为空取下次活动时间的投放
                auctScren = spreadAuctScrenMapper.selectSpreadScrenPre(spreadAuctType.getId());
            }
            if(auctScren != null){
                auctTypeList.get(i).setDelverStartTime(auctScren.getDelverStartTime());
                auctTypeList.get(i).setDetDelverEndTime(auctScren.getDelverEndTime());
            }
            SpreadTypeViewVo spreadTypeViewVo = new SpreadTypeViewVo();
            spreadTypeViewVo.setId(spreadAuctType.getId());
            spreadTypeViewVo.setCount(spreadAuctType.getSpreadNum().intValue());
            spreadTypeViewVo.setBeginTime(DateUtil.dateToString(spreadAuctType.getDelverStartTime(),DateUtil.patternA));
            spreadTypeViewVo.setEndTime(DateUtil.dateToString(spreadAuctType.getDetDelverEndTime(),DateUtil.patternA));
            spreadTypeViewVo.setHdFinish(auctScren==null?1:(auctScren.getEndTime().getTime()<System.currentTimeMillis()?1:0));
            spreadTypeViewVo.setPrice(String.valueOf(spreadAuctType.getPrice()/100));
            spreadTypeViewVo.setTitle(spreadAuctType.getName());
            typeViewVoList.add(spreadTypeViewVo);
        }
        return typeViewVoList;
    }

    /**
     * 获取用户最近一次竞拍
     * @param shopId 店铺ID
     * @return
     */
    @Override
    public SpreadAuctShop checkWin(Long shopId, Long spreadTypeId) {
        // 获取最近一次场次
        SpreadAuctScren spreadAuctScren = spreadAuctScrenMapper.selectSpreadScrenNow(spreadTypeId);
        if(spreadAuctScren == null){
            // 竞拍从未开始
            return null;
        }
        List<SpreadAuctShop> spreadAuctShopList = spreadAuctShopMapper.selectSpreadShopListByBo(shopId, spreadAuctScren.getId(), null);
        if(spreadAuctShopList == null || spreadAuctShopList.size() == 0){
            return null;
        }
        return spreadAuctShopList.get(0);
    }

    /**
     * 获取上次拍卖买受人名单
     * @return
     */
    @Override
    public List<WinnerVo> getWinners(Long spreadTypeId) {
        SpreadAuctScren spreadAuctScren = spreadAuctScrenMapper.selectSpreadScrenPre(spreadTypeId);
        if(spreadAuctScren == null){
            // 竞拍从未开始
            return Collections.emptyList();
        }
        // 竞拍上一次已结束
        Boolean draw = true;
        List<SpreadAuctShop> spreadAuctShopList = spreadAuctShopMapper.selectSpreadShopListByBo(null, spreadAuctScren.getId() ,draw);
        List<WinnerVo> winnerVoList = new ArrayList<WinnerVo>();
        for(int i = 0;i<spreadAuctShopList.size();i++){
            WinnerVo winnerVo = new WinnerVo();
            SpreadAuctShop spreadAuctShop = spreadAuctShopList.get(i);
            winnerVo.setLxtel(spreadAuctShop.getContactsPhone());
            winnerVo.setLxuser(spreadAuctShop.getContactsName());
            winnerVo.setMarketText(spreadAuctShop.getMarketName());
            winnerVo.setStoreNum(spreadAuctShop.getShopNum());
            winnerVoList.add(winnerVo);
        }
        return winnerVoList;
    }

    /**
     * 下一次竞拍时间
     * @return
     */
    @Override
    public Date nextAuctionTime(Long spreadTypeId) {
        SpreadAuctScren spreadAuctScren = spreadAuctScrenMapper.selectSpreadScrenNext(spreadTypeId);
        if(spreadAuctScren == null){
            return null;
        }
        return spreadAuctScren.getStartTime();
    }

    /**
     * 提交申请
     * @param bo 申请信息
     */
    @Override
    public void applyAuction(AuctionApplyBo bo) throws Main4Exception {
        if(bo == null){
            return;
        }
        // 判断是否结束
        SpreadAuctScren spreadAuctScren = spreadAuctScrenMapper.selectByPrimaryKey(bo.getId());
//        if(spreadAuctScren == null || spreadAuctScren.getStartTime().after(new Date()) ||spreadAuctScren.getEndTime().before(new Date())){
//            throw new Main4Exception("竞拍还未开始或一结束，无法提交申请");
//        }
        SpreadAuctShop spreadAuctShop = new SpreadAuctShop();
        spreadAuctShop.setShopId(bo.getShopId());
        spreadAuctShop.setContactsName(bo.getLxuser());
        spreadAuctShop.setContactsPhone(bo.getLxtel());
        spreadAuctShop.setDraw(false);
        spreadAuctShop.setScrenId(spreadAuctScren.getId());
        spreadAuctShop.setCreateTime(new Date());
        spreadAuctShop.setModifyTime(new Date());
        spreadAuctShop.setEnabled(false);
        spreadAuctShopMapper.insertSelective(spreadAuctShop);
    }

    /**
     * 获取当前进行中的拍卖
     * @return
     */
    @Override
    public SpreadAuctScren getCurrentAuction(Long spreadTypeId) {
        SpreadAuctScren spreadAuctScren = spreadAuctScrenMapper.selectSpreadScrenNow(spreadTypeId);
        return spreadAuctScren;
    }

    /**
     * 活动规则
     * @param spreadTypeId
     * @return
     */
    @Override
    public String getActRulesDesc(Long spreadTypeId) {
        // 取当前活动
        SpreadAuctScren auctScren = getCurrentAuction(spreadTypeId);
        if(auctScren == null){
            // 为空取下次活动时间的投放
            auctScren = spreadAuctScrenMapper.selectSpreadScrenNext(spreadTypeId);
        }
        if(auctScren == null){
            return null;
        }
        return auctScren.getActiveRuleDesc();
    }

    /**
     * 活动数据
     * @param screnById
     * @return
     */
    public SpreadAuctScren getSpreadScrenById(Long screnById){
        SpreadAuctScren spreadAuctScren = spreadAuctScrenMapper.selectByPrimaryKey(screnById);
        return spreadAuctScren;
    }
}
