package com.shigu.main4.data.translate;

import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguOuterFloorMapper;
import com.opentae.data.mall.interfaces.ShiguOuterMarketMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 系统市场数据导入逛市场展示表
 * Created by bugzy on 2017/5/19 0019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/ac.xml")
public class Market2OutMarket {

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShiguOuterMarketMapper shiguOuterMarketMapper;

    @Autowired
    private ShiguOuterFloorMapper shiguOuterFloorMapper;


    @Test
    public void trans(){
        String webSite = "cs";
        ShiguMarketExample marketExample = new ShiguMarketExample();
        marketExample.createCriteria().andWebSiteEqualTo(webSite);
        List<ShiguMarket> shiguMarkets = shiguMarketMapper.selectByExample(marketExample);
        int i = 1;
        Map<Long, List<ShiguMarket>> floorMap = new HashMap<>();
        for (ShiguMarket market : shiguMarkets) {
            if (market.getIsParent() == 1) {
                ShiguOuterMarket outerMarket = new ShiguOuterMarket();
                outerMarket.setMarketId(market.getMarketId());
                if (shiguOuterMarketMapper.selectOne(outerMarket) == null) {
                    outerMarket.setMarketName(market.getMarketName());
                    outerMarket.setSortOrder(i++);
                    outerMarket.setWebSite(webSite);
                    shiguOuterMarketMapper.insertSelective(outerMarket);
                }
            } else {
                List<ShiguMarket> floors = floorMap.get(market.getParentMarketId());
                if (floors == null) {
                    floors = new ArrayList<>();
                    floorMap.put(market.getParentMarketId(), floors);
                }
                floors.add(market);
            }
        }
        for (Map.Entry<Long, List<ShiguMarket>> entry : floorMap.entrySet()) {
            Long parent = entry.getKey();
            List<ShiguMarket> floors = entry.getValue();
            int sort = 90;
            List<ShiguOuterFloor> shiguOuterFloors = new ArrayList<>();
            for (ShiguMarket floor : floors) {
                ShiguOuterFloor outerFloor = new ShiguOuterFloor();
                outerFloor.setFloorIds(floor.getMarketId().toString());
                outerFloor = shiguOuterFloorMapper.selectOne(outerFloor);
                if (outerFloor == null) {
                    outerFloor = new ShiguOuterFloor();
                    outerFloor.setSortOrder(sort += 10);
                    outerFloor.setShowName(floor.getMarketName());
                    outerFloor.setFloorIds(floor.getMarketId().toString());
                    shiguOuterFloorMapper.insertSelective(outerFloor);
                }
                shiguOuterFloors.add(outerFloor);
            }

            if (!shiguOuterFloors.isEmpty()) {
                List<Long> floorsIds = BeanMapper.getFieldList(shiguOuterFloors, "outerFloorId", Long.class);
                ShiguOuterMarket outerMarket = new ShiguOuterMarket();
                outerMarket.setMarketId(parent);
                outerMarket = shiguOuterMarketMapper.selectOne(outerMarket);
                if (outerMarket != null) {
                    outerMarket.setOuterFloorIds(StringUtils.join(floorsIds, ","));
                    shiguOuterMarketMapper.updateByPrimaryKeySelective(outerMarket);
                }
            }
        }
    }
}