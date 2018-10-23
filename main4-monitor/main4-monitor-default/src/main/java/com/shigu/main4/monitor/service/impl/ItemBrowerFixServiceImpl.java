package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.shigu.main4.monitor.services.ItemBrowerFixService;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service("itemBrowerFixService")
public class ItemBrowerFixServiceImpl implements ItemBrowerFixService {
    @Autowired
    private RedisIO redisIO;

    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    /**
     * 固化当前的浏览量数据
     * @param key
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void fixNow(String key) {
        Jedis jedis = redisIO.getJedis();
        try {
            Map<String, String> itemFlowMap = jedis.hgetAll(key);//key:item_flow
            if (0 == itemFlowMap.size()) {
                return;
            }

            jedis.hmset(key + "_temp", itemFlowMap);
            jedis.del(key);

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
            for (Map.Entry<String, List<String>> entryItem : itemIpsMap.entrySet()) {
                try {
                    GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
                    goodsCountForsearch.setClick(new Long(entryItem.getValue().size()));
                    goodsCountForsearch.setClickIp(new Long(new HashSet(entryItem.getValue()).size()));
                    goodsCountForsearch.setGoodsId(Long.valueOf(entryItem.getKey()));

                    ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsCountForsearch.getGoodsId());
                    if (shiguGoodsIdGenerator != null) {
                        goodsCountForsearch.setWebSite(shiguGoodsIdGenerator.getWebSite());
                    }
                    goodsCountForsearchList.add(goodsCountForsearch);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            goodsCountForsearchMapper.insertOrUpdateForAdd(goodsCountForsearchList);
            jedis.del(key + "_temp");
        }finally {
            redisIO.returnJedis(jedis);
        }
    }
}
