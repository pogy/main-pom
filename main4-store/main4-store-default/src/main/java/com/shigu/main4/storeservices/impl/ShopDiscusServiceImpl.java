package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.DiscusRecord;
import com.opentae.data.mall.beans.DiscusScore;
import com.opentae.data.mall.examples.DiscusRecordExample;
import com.opentae.data.mall.interfaces.DiscusRecordMapper;
import com.opentae.data.mall.interfaces.DiscusScoreMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopDiscusService;
import com.shigu.main4.vo.Discus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 店铺评论服务
 *
 * @author shigu_zjb
 * @date 2017/02/22 18:03
 *
 */
@Service("shopDiscusService")
public class ShopDiscusServiceImpl implements ShopDiscusService {

    @Resource(name = "tae_mall_discusRecordMapper")
    private DiscusRecordMapper discusRecordMapper;

    @Resource(name = "tae_mall_discusScoreMapper")
    private DiscusScoreMapper discusScoreMapper;

    /**
     * 查评分的平均值
     * @param shopId
     * @return
     */
    @Override
    public Double selScoreAvg(Long shopId) {
        if(shopId == null){
            return  0.00;
        }
        Double avgScoreDouble = discusScoreMapper.selectAvgScore(shopId);
        if(avgScoreDouble == null){
            avgScoreDouble = 0.00;
        }
        return avgScoreDouble;
    }

    /**
     * 查分页数据
     * @param shopId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public ShiguPager<Discus> selDiscusByShopId(Long shopId, Integer pageNo, Integer pageSize) {
        if(shopId == null || pageNo == null || pageSize == null){
            return null;
        }
        int startRows = (pageNo - 1) * pageSize;
        List<DiscusRecord> discusRecordList = discusRecordMapper.selectShopDiscusRecord(shopId, startRows, pageSize);
        if(discusRecordList == null || discusRecordList.size() == 0){
            return null;
        }
        int count = discusRecordMapper.selectShopDiscusRecordCount(shopId);
        List<Discus> discuseList = new ArrayList<Discus>();
        for (int i = 0; i < discusRecordList.size(); i++) {
            DiscusRecord discusRecord = discusRecordList.get(i);
            if(discusRecord == null){
                count --;
                return null;
            }
            Discus discus = new Discus();
            discus.setSay(discusRecord.getMsgContext());
            discus.setGiveScore(discusRecord.getScoreNum());
            discus.setWho(discusRecord.getUserName());
            discuseList.add(discus);
        }
        ShiguPager<Discus> shiguPager = new ShiguPager<Discus>();
        shiguPager.setContent(discuseList);
        shiguPager.setNumber(pageNo);
        shiguPager.calPages(count, pageSize);
        return shiguPager;
    }

    @Override
    public int countAllDiscusByShopId(Long shopId) {
        DiscusRecordExample example=new DiscusRecordExample();
        example.createCriteria().andStoreIdEqualTo(shopId);
        return discusRecordMapper.countByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addDiscus(Discus discus) {
        Date d=new Date();
        DiscusRecord record=new DiscusRecord();
        record.setUserId(discus.getUserId());
        record.setCreatedTime(d);
        record.setMsgContext(discus.getSay());
        record.setDoLocation(discus.getIp());
        discusRecordMapper.insertSelective(record);
        DiscusScore score=new DiscusScore();
        score.setStoreId(discus.getStoreId());
        score.setWebSite(discus.getWebSite());
        score.setCreatedTime(d);
        score.setScoreNum(discus.getGiveScore());
        score.setUserId(discus.getUserId());
        discusScoreMapper.insertSelective(score);
    }
}
