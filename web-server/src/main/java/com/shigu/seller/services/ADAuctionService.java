package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.GoatActivity;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.model.Activity;
import com.shigu.main4.activity.service.ActivityDubboService;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.GoatActivityVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.seller.vo.SpreadTypeViewVo;
import com.shigu.seller.vo.WinnerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaohongbo on 17/5/13.
 */
@Service
public class ADAuctionService {
    @Autowired
    ActivityDubboService activityDubboService;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    public List<WinnerVo> selLedWinner(List<ActivityEnlistVO> enlistVOs){
        List<WinnerVo> result=new ArrayList<>();
        if (enlistVOs != null) {
//            LedActivity activity=activityFactory.selActivityByVo(term.selActivitys().get(0));
            if (enlistVOs.size()>0) {
                Set<Long> shopIdSet=new HashSet<>();
                for(int i=0;i<enlistVOs.size();i++){
                    ActivityEnlistVO vo=enlistVOs.get(i);
                    WinnerVo winnerVo=new WinnerVo();
                    winnerVo.setLxtel(vo.getTelephone());
                    winnerVo.setLxuser(vo.getName());
                    winnerVo.setNum(i+1L);
                    winnerVo.setShopId(vo.getShopId());
                    shopIdSet.add(vo.getShopId());
                    result.add(winnerVo);
                }
                List<Long> shopIds=new ArrayList<>(shopIdSet);
                List<ShopNumAndMarket> snams=shiguShopMapper.selShopNumAndMarkets(shopIds);
                Map<Long,ShopNumAndMarket> map= BeanMapper.list2Map(snams,"shopId",Long.TYPE);
                for(WinnerVo vo:result){
                    ShopNumAndMarket snam=map.get(vo.getShopId());
                    vo.setMarketText(snam.getMarket());
                    vo.setStoreNum(snam.getShopNum());
                }
            }

        }
        return result;
    }

    /**
     * 得到广告列表
     * @return
     */
    public List<SpreadTypeViewVo> selSellGoats(Long userId,String manOrWoman){
        //如果当前有在售,拿当前期,如果当前没在售,拿最后一期
        ActivityTermVO term=activityDubboService.selTermByTime(ActivityType.GOAT_SELL,new Date(),manOrWoman);
        boolean hdFinish=false;
        if(term == null){
            term=activityDubboService.selNowFinishedTerm(ActivityType.GOAT_SELL,new Date(),manOrWoman);
            if(term == null){
                return new ArrayList<>();
            }
            hdFinish=true;
        }
        List<GoatActivityVO> goats=activityDubboService.selActivityInTerm(term.getTermId());
        if (goats != null) {
            List<SpreadTypeViewVo> vos=new ArrayList<>();
            DecimalFormat df=new DecimalFormat("0.00");
            for(GoatActivityVO vo:goats){
                SpreadTypeViewVo viewVo=new SpreadTypeViewVo();
                viewVo.setId(vo.getActivityId());
                viewVo.setTitle(vo.getDescription());
                viewVo.setCount(vo.getNumber());
                Double price=vo.getPrice()/100d;
                viewVo.setPrice(df.format(price));
                viewVo.setBeginTime(vo.getTime());
                if(!hdFinish){
                    //查一下是否已经报过名
                    try {
                        viewVo.setHdFinish(activityDubboService.hasJoin(vo.getActivityId(),userId)?1:0);
                    } catch (ActivityException e) {
                        viewVo.setHdFinish(1);
                    }
                }else{
                    viewVo.setHdFinish(1);
                }
                vos.add(viewVo);
            }
            return vos;
        }
        return new ArrayList<>();
    }
}
