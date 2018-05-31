package com.shigu.main4.daifa.utils;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.tools.RedisIO;

public class DoQueryExpressCodeTask implements Runnable{
    private PackDeliveryProcess packDeliveryProcess;
    private RedisIO redisIO;

    public DoQueryExpressCodeTask(PackDeliveryProcess packDeliveryProcess, RedisIO redisIO) {
        this.packDeliveryProcess = packDeliveryProcess;
        this.redisIO = redisIO;
    }

    @Override
    public void run() {
        String tidString;
        while ((tidString = redisIO.rpop("QueryExpressCodeThread", String.class))!=null){
            Long tid;
            try {
                tid=new Long(tidString);
            } catch (Exception e) {
                return;
            }
            try {
                packDeliveryProcess.queryExpressCode(tid);
            } catch (DaifaException ignored) {
            }
        }
    }
}
