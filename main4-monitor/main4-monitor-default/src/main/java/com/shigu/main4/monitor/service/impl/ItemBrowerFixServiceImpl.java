package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.shigu.main4.monitor.services.ItemBrowerFixService;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("itemBrowerFixService")
public class ItemBrowerFixServiceImpl implements ItemBrowerFixService {
    @Autowired
    private RedisIO redisIO;

    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;

    /**
     * 固化当前的浏览量数据
     * @param key
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void fixNow(String key) {
        Map<String, String> itemFlowMap = redisIO.getJedis().hgetAll(key);//key:item_flow
        if (0 == itemFlowMap.size()) {
            return;
        }

        redisIO.getJedis().hmset(key + "_temp", itemFlowMap);
        redisIO.getJedis().del(key);

        Map<String, List<String>> itemIpsMap = new HashMap<String, List<String>>();

        for (Map.Entry<String, String> entryItem : itemFlowMap.entrySet()) {
            String[] goodsIdExStr = entryItem.getKey().split("_");
            String currentGoodsIdStr = goodsIdExStr[0];
            String currentIpStr = entryItem.getValue();
            List<String> ipList = itemIpsMap.get(currentGoodsIdStr);
            if (ipList == null) {
                ipList = new ArrayList<String>();
                itemIpsMap.put(currentGoodsIdStr, ipList);
            }
            ipList.add(currentIpStr);
        }

        List<GoodsCountForsearch> goodsCountForsearchList = new ArrayList<GoodsCountForsearch>();
        for (Map.Entry<String,  List<String>> entryItem : itemIpsMap.entrySet()) {
            GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
            goodsCountForsearch.setClick(new Long(entryItem.getValue().size()));
            goodsCountForsearch.setClickIp(new Long(new HashSet(entryItem.getValue()).size()));
            goodsCountForsearch.setGoodsId(Long.valueOf(entryItem.getKey()));
            goodsCountForsearch.setTrade(0L);
            goodsCountForsearch.setUp(0L);
            goodsCountForsearch.setUpMan(0L);
            goodsCountForsearch.setHadGoat(0);
            goodsCountForsearch.setWebSite("hz");
            goodsCountForsearchList.add(goodsCountForsearch);
        }
        goodsCountForsearchMapper.insertOrUpdateForAdd(goodsCountForsearchList);
        redisIO.getJedis().del(key + "_temp");
    }
}
