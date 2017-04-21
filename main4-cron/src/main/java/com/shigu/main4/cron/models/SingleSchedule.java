package com.shigu.main4.cron.models;

import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 单线程执行
 * Created by zhaohongbo on 17/4/16.
 */
public abstract class SingleSchedule {

    private boolean hasDoing=false;
    private static final Logger logger = LoggerFactory.getLogger(SingleSchedule.class);

    public void execute(){
        if(hasDoing){
            return;
        }
        hasDoing=true;
        try {
            doContext();
        } catch (Exception e) {
            logger.error("定时执行异常",e);
        }finally {
            hasDoing=false;
        }
    }

    /**
     * 具体做的内容
     */
    public abstract void doContext();

    /**
     * 把数据bulk过来
     */
    public int doBulk(RedisIO redisIO, String key, int max, TransportClient client) throws ExecutionException, InterruptedException {
        List<SimpleElaBean> esbeans=selEsBeans(redisIO,key,max);
        if(esbeans.size()==0){
            return 0;
        }
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        //对esbean去重
        Map<String,SimpleElaBean> keyMap=new HashMap<>();
        List<SimpleElaBean> targetEsbean=new ArrayList<>(esbeans);
        for(SimpleElaBean b:esbeans){
            if(keyMap.containsKey(b.getPk())){
                targetEsbean.remove(b);
            }else{
                keyMap.put(b.getPk(),b);
            }
        }
        int i=0;
        for(SimpleElaBean seb:targetEsbean){
            try {
                bulkRequest.add(client.prepareIndex(seb.getIndex(), seb.getType(), seb.getPk()).setSource(seb.getSource()));
            } catch (Exception e) {
                logger.error("加入bulk失败",e);
            }
            i++;
        }
        if(i>0){
            bulkRequest.execute().get();
        }
        return esbeans.size();
    }

    /**
     * 把redis中数据查出
     * @param key
     * @param max
     * @return
     */
    public List<SimpleElaBean> selEsBeans(RedisIO redisIO,String key,int max){
        List<SimpleElaBean> esbeans=new ArrayList<>();
        for(int i=0;i<max;i++){
//            System.out.println(redisIO.rpop(key));
            SimpleElaBean seb=redisIO.lpop(key,SimpleElaBean.class);
            if (seb != null) {
                esbeans.add(seb);
            }else{
                break;
            }
        }
        return esbeans;
    }
}
