package com.shigu.sysman.shop.service;


import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import com.opentae.data.mall.interfaces.ShiguOuterFloorMapper;
import com.opentae.data.mall.interfaces.ShiguOuterMarketMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.sysman.shop.bo.ShiguOuterMarketBo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 市场展现CONTROLLER
 *
 * @author shigu_zjb
 * @date 2017/3/24 17:54
 *
 */
@Service
public class ShiguOutMarketService {

    @Autowired
    private ShiguOuterMarketMapper shiguOuterMarketMapper;

    @Autowired
    private ShiguMarketService shiguMarketService;

    @Autowired
    private ShiguOuterFloorMapper shiguOuterFloorMapper;


    /**
     * 市场展示列表
     * @param outerMarketBo
     * @return
     */
    public List<ShiguOuterMarket> findUuterMarketList(ShiguOuterMarketBo outerMarketBo){
        if(outerMarketBo == null || StringUtils.isEmpty(outerMarketBo.getWebsite())){
            return Collections.EMPTY_LIST;
        }
        List<ShiguOuterMarket> outerMarketList = shiguOuterMarketMapper.selOuterMarketListByBo(outerMarketBo.getWebsite());
        return outerMarketList;
    }

    /**
     * 市场展示ID
     * @param outMarketId
     * @return
     */
    public ShiguOuterMarket getOutMarketById(Long outMarketId){
        if(outMarketId == null){
            return null;
        }
        ShiguOuterMarket shiguOuterMarket = shiguOuterMarketMapper.selectByPrimaryKey(outMarketId);
        if(shiguOuterMarket.getMarketId()!=null&&shiguOuterMarket.getMarketId()!=-1){
            ShiguMarket shiguMarket = shiguMarketService.getShiguMarketById(shiguOuterMarket.getMarketId());
            if(shiguMarket != null){
                shiguOuterMarket.setPointMarketName(shiguMarket.getMarketName());
            }
        }
        return shiguOuterMarket;
    }

    /**
     * 新增市场展示
     * @param outerMarket
     */
    public void addOuterMarket(ShiguOuterMarket outerMarket){
        if(outerMarket == null){
            return;
        }
        shiguOuterMarketMapper.insertSelective(outerMarket);
    }

    /**
     * 更新市场展示
     * @param outerMarket
     */
    public void updateOuterMarket(ShiguOuterMarket outerMarket){
        if(outerMarket == null){
            return;
        }
        shiguOuterMarketMapper.updateByPrimaryKeySelective(outerMarket);
    }

    /**
     * 批量删除市场
     * @param ids
     */
    @Transactional
    public void delOuterMarket(String [] ids) throws Main4Exception {
        if(ids == null || ids.length == 0){
            return;
        }
        for(int i = 0;i<ids.length;i++){
            ShiguOuterMarket outerMarket = shiguOuterMarketMapper.selectByPrimaryKey(Long.valueOf(ids[i]));
            if(outerMarket == null){
                throw new Main4Exception("市场数据有误");
            }
            if(!StringUtils.isEmpty(outerMarket.getOuterFloorIds())){
                //throw new Main4Exception("市场名称为：" + outerMarket.getMarketName() + " 下存在楼层，请先删除楼层");
                String [] floorIds = outerMarket.getOuterFloorIds().split(",");
                delOutFloor(floorIds,outerMarket.getRuleId());
            }
            shiguOuterMarketMapper.deleteByPrimaryKey(Long.valueOf(ids[i]));
        }
    }

    /**
     * 删除楼层 此处加是为了避免相互依赖调用
     * @param outFloorIds
     */
    @Transactional
    public void delOutFloor(String [] outFloorIds, Long ruleId) throws Main4Exception {
        if(outFloorIds == null || outFloorIds.length == 0){
            return;
        }
        for (int i = 0; i < outFloorIds.length; i++) {
            Long outFloorId = Long.valueOf(outFloorIds[i]);
            ShiguOuterFloor outerFloor = shiguOuterFloorMapper.selectByPrimaryKey(outFloorId);
            if(outerFloor == null){
                return;
            }
            shiguOuterFloorMapper.deleteByPrimaryKey(outFloorId);
        }
    }


    /**
     * 移除楼层
     * @param outFloorIds
     */
    @Transactional
    public void removeOuterFloor(String [] outFloorIds, Long ruleId){
        if(outFloorIds == null || outFloorIds.length == 0){
            return;
        }
        ShiguOuterMarket outerMarket = shiguOuterMarketMapper.selectByPrimaryKey(ruleId);
        if(outerMarket == null){
            return;
        }
        if(StringUtils.isEmpty(outerMarket.getOuterFloorIds())){
           return;
        }
        String [] outerFloorIds = outerMarket.getOuterFloorIds().split(",");
        List<String> outFloorsList = Arrays.asList(outFloorIds);
        List<String> outMarketLists = new ArrayList<>(Arrays.asList(outerFloorIds));
        outMarketLists.removeAll(outFloorsList);
        String [] floorIds = outMarketLists.toArray(new String[outMarketLists.size()]);
        outerMarket.setOuterFloorIds(StringUtils.join(floorIds,","));
        shiguOuterMarketMapper.updateByPrimaryKey(outerMarket);
    }
}
