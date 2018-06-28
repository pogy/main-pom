package com.shigu.main4.daifa.utils;

import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.process.impl.PackDeliveryProcessImpl;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By admin on 2018/1/18/15:44
 */
public class WorkerMan {

    public static boolean isRun=false;

    private ExecutorService pool;

    private Map<Object,AtomicInteger> map=new HashMap<>();
    @Autowired
    private PackDeliveryProcess packDeliveryProcess;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private RedisIO redisIO;
    /**
     * 不可创建
     */
    private WorkerMan() {
        this.pool= Executors.newSingleThreadExecutor();
    }


    private ExecutorService getPool() {
        return pool;
    }

    public void start(){
        if(isRun){
            return;
        }
        isRun=true;
        try {
            DoQueryExpressCodeTask task=new DoQueryExpressCodeTask(packDeliveryProcess,redisIO,daifaTradeMapper);
            getPool().submit(task);
        } catch (Exception ignored) {
        }finally {
            isRun=false;
        }
    }
}
