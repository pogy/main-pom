package com.shigu.main4.item.services.utils;

import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.tools.RedisIO;
import com.taobao.api.domain.PropValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 更新属性值
 * Created by Licca on 17/5/21.
 */
@Service
public class UpdatePropValueService {

    @Autowired
    TaobaoPropValueMapper taobaoPropValueMallMapper;
    @Autowired
    RedisIO redisIO;

    @Async
    public void updatePropValue(Long cid,Long pid,String name,List<PropValue> pvlist){
        String cidPropTmp=redisIO.get("cidPropTmp_"+cid);
        if(cidPropTmp==null){
            redisIO.putStringTemp("cidPropTmp_"+cid,"1",1800);
            //如果数据库里没有,存一下
            try {
                List<TaobaoPropValue> taobaoPropValues = parseLocalPropValues(pvlist, cid, pid, name);
                if (taobaoPropValues != null && !taobaoPropValues.isEmpty()) {
                    System.err.println("类目信息长度 "+taobaoPropValues.size());
                    List<List<TaobaoPropValue>> partition = Lists.partition(taobaoPropValues,200);
                    for (List<TaobaoPropValue> item : partition){
                        UpdatePropValueTask task = new UpdatePropValueTask();
                        task.setTaobaoPropValueMapper(taobaoPropValueMallMapper);
                        task.setRedisIO(redisIO);
                        task.setCid(cid);
                        task.setTaobaoPropValues(item);

                        UpdatePropValueWorker.addQueue(task);
                    }
                }
            } finally {
                redisIO.del("cidPropTmp_"+cid);
            }
        }
    }

    /**
     *
     *=========================================================
     *@方法名：parseLocalItemProp
     *@功能： 把淘宝的改成本地对象
     *@return:TaobaoItemProp
     *=========================================================
     */
    private List<TaobaoPropValue> parseLocalPropValues(List<PropValue> pvlist, Long cid, Long pid, String pName){
        if(pvlist==null){
            return null;
        }
        List<TaobaoPropValue> lists=new ArrayList<>();
        for(PropValue pv:pvlist){
            TaobaoPropValue tpv=new TaobaoPropValue();
            tpv.setCid(cid);
            tpv.setPid(pid);
            tpv.setPropName(pName);
            if(pv.getIsParent()==null){
                tpv.setIsParent(0);
            }else{
                tpv.setIsParent(pv.getIsParent()?1:0);
            }
            tpv.setName(pv.getName());
            tpv.setNameAlias(pv.getNameAlias());
            tpv.setSortOrder(pv.getSortOrder());
            tpv.setStatus(pv.getStatus());
            tpv.setVid(pv.getVid());
            lists.add(tpv);
        }
        return lists;
    }
}
