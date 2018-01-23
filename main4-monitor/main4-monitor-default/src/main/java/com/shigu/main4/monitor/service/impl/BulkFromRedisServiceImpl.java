package com.shigu.main4.monitor.service.impl;

import com.shigu.main4.monitor.services.BulkFromRedisService;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 批量bulk到Es
 * Created by zhaohongbo on 17/4/15.
 */
@Service("bulkFromRedisService")
public class BulkFromRedisServiceImpl implements BulkFromRedisService {

    /**
     * 300条每次,到es
     */
    private int howmuch=300;
    /**
     * 是否有流量正在执行
     */
    private boolean flowHasDoing=false;
    /**
     * 是否有商品任务在执行
     */
    private boolean goodsHasDoing=false;

    @Autowired
    RedisIO redisIO;

    private String flowlistName="bulk_flow_to_es";

    private String goodslistName="bulk_goods_to_es";

    /**
     * 3秒钟一次,导到es
     */
    @Override
    public void bulkFlowTmc() {
        if(flowHasDoing){
            return;
        }
        flowHasDoing=true;
        try {
            //System.out.println("bulk flow"+new Date());
        } finally {
            flowHasDoing=false;
        }
    }

    @Override
    public void bulkGoodsTmc() {
        if(goodsHasDoing){
            return;
        }
        goodsHasDoing=true;
        try {
            //System.out.println("bulk goods"+new Date());
        } finally {
            goodsHasDoing=false;
        }
    }


}
