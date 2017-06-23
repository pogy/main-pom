package com.shigu.main4.monitor.service.impl;

import com.shigu.main4.monitor.services.ItemBrowerFixService;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemBrowerFixServiceImpl implements ItemBrowerFixService {
    @Autowired
    private RedisIO redisIO;

    /**
     * 固化当前的浏览量数据
     * @param key
     */
    @Override
    public void fixNow(String key) {
        Map<String, String> itemFlowMap = redisIO.getJedis().hgetAll("item_flow");
//        redisIO.getJedis().hmset("item_flow_temp", itemFlowMap);
        redisIO.getJedis().del("item_flow");
        Map<String, List<String>> itemIpsMap = new HashMap<String, List<String>>();

        for (Map.Entry<String, String> entryItem : itemFlowMap.entrySet()) {
            String[] goodsIdExStr = entryItem.getKey().split("_");
            String currentGoodsIdStr = null;
            if (goodsIdExStr != null && 1 < goodsIdExStr.length) {
                currentGoodsIdStr = goodsIdExStr[0];
            }
            String currentIpStr = entryItem.getValue();

            List<String> ipList = itemIpsMap.get(currentGoodsIdStr);
            if (ipList == null) {
                ipList = new ArrayList<String>();
                itemIpsMap.put(currentGoodsIdStr, ipList);
            }
            ipList.add(currentIpStr);
        }

        for (Map.Entry<String,  List<String>> entryItem : itemIpsMap.entrySet()) {

        }
    }
}
