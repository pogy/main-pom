package com.shigu.seller.services;

import com.opentae.data.mall.beans.SpreadAuctType;
import com.opentae.data.mall.examples.SpreadAuctTypeExample;
import com.opentae.data.mall.interfaces.SpreadAuctTypeMapper;
import com.shigu.seller.services.api.ADAuctionService;
import com.shigu.seller.vo.ADAuctionResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告活动服务
 * Created by zhaohongbo on 17/4/25.
 */
@Service
public class AuctionService {
    @Autowired
    private ADAuctionService adAuctionService;

    @Autowired
    private SpreadAuctTypeMapper spreadAuctTypeMapper;

    public List<ADAuctionResultVO> auctionResults(){
        List<SpreadAuctType> types=spreadAuctTypeMapper.selectByExample(new SpreadAuctTypeExample());
        List<ADAuctionResultVO> resultVOs=new ArrayList<>();
        for(SpreadAuctType t:types){
            ADAuctionResultVO vo=new ADAuctionResultVO();
            vo.setTitle(t.getName());
            vo.setGgList(adAuctionService.getWinners(t.getId()));
            resultVOs.add(vo);
        }
        return resultVOs;
    }
}
