package com.shigu.main4.cron;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.cron.models.SingleSchedule;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 同步上传记录到Es
 * Created by zhaohongbo on 17/4/16.
 */
@Component
public class BulkUpToEs extends SingleSchedule {
    private static final Logger logger = LoggerFactory.getLogger(BulkUpToEs.class);
    @Autowired
    RedisIO redisIO;

    @Autowired
    ElasticConfiguration elasticConfiguration;

    int max = 100;
    String key = "bulk_up_to_es";

    /**
     * 商品3秒一次
     */
    @Override
    @Scheduled(cron = "0/1 * *  * * ? ")
    public void execute() {
        super.execute();
    }

    @Override
    public void doContext() {
//        System.out.println("up in");
        int result;
        try {
            result = super.doBulk(redisIO, key, max, (TransportClient) elasticConfiguration.client);
        } catch (Exception e) {
            logger.error("加入es失败",e);
            return;
        }
        if (result == max) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doContext();
        }
    }
}
