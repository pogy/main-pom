package com.shigu.main4.item.services.utils;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.tools.RedisIO;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by gtx on 2018/4/26.
 * 更新类目属性任务
 * @author gtx
 * @description
 * @since
 */
public class UpdatePropValueTask implements Callable {

    private RedisIO redisIO;

    private TaobaoPropValueMapper taobaoPropValueMapper;

    private List<TaobaoPropValue> taobaoPropValues;

    private Long cid;


    @Override
    public Object call() throws Exception {
        boolean flag = false;
        if (cid == null || taobaoPropValues == null
                || taobaoPropValues.isEmpty() || redisIO == null
                || taobaoPropValueMapper == null) {
            flag = true;
        }
        if (!flag) {
            System.err.println("更新类目信息==============================");
            TaobaoPropValueExample vexample=new TaobaoPropValueExample();
            vexample.createCriteria().andCidEqualTo(cid).andPidEqualTo(20000L);
            taobaoPropValueMapper.deleteByExample(vexample);
            taobaoPropValueMapper.insertListNoId(taobaoPropValues);
        }
        //执行结束后取redis任务加入队列
        Jedis jedis = null;
        try {
            jedis = redisIO.getJedis();
            Long llen = jedis.llen(UpdatePropValueWorker.UPDATE_PROP_VALUE_KEY);
            if (llen != null && llen > 0) {
                String lpop = jedis.lpop(UpdatePropValueWorker.UPDATE_PROP_VALUE_KEY);
                UpdatePropValueTask updatePropValueTask = JSON.parseObject(lpop, UpdatePropValueTask.class);

                updatePropValueTask.setRedisIO(redisIO);
                updatePropValueTask.setTaobaoPropValueMapper(taobaoPropValueMapper);

                UpdatePropValueWorker.addQueue(updatePropValueTask);
            }
        } finally {
            if (jedis != null) {
                redisIO.returnJedis(jedis);
            }
        }

        return null;
    }

    public RedisIO getRedisIO() {
        return redisIO;
    }

    public void setRedisIO(RedisIO redisIO) {
        this.redisIO = redisIO;
    }

    public TaobaoPropValueMapper getTaobaoPropValueMapper() {
        return taobaoPropValueMapper;
    }

    public void setTaobaoPropValueMapper(TaobaoPropValueMapper taobaoPropValueMapper) {
        this.taobaoPropValueMapper = taobaoPropValueMapper;
    }

    public List<TaobaoPropValue> getTaobaoPropValues() {
        return taobaoPropValues;
    }

    public void setTaobaoPropValues(List<TaobaoPropValue> taobaoPropValues) {
        this.taobaoPropValues = taobaoPropValues;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
