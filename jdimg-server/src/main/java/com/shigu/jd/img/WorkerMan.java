package com.shigu.jd.img;

import com.shigu.jd.img.exceptions.ImgThreadOverloadException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By admin on 2018/1/18/15:44
 */
public class WorkerMan {

    private static volatile WorkerMan workerMan;

    private int userMaxNum=10;

    private ExecutorService pool;
    /**
     * 队列最大长度默认200
     */
    private int maxQueue = 200;
    /**
     * 每个任务最大执行时间 单位秒
     * 默认10分钟
     */
    private int timeOut = 60 * 10;

    /**
     *默认线程数
     */
    private int threadNum = Runtime.getRuntime().availableProcessors() * 2;

    private Map<Object,AtomicInteger> map=new HashMap<>();

    /**
     * 不可创建
     */
    private WorkerMan() {
        this.pool= new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(maxQueue));
    }

    public static WorkerMan getInstance () {
        if (workerMan == null) {
            synchronized (WorkerMan.class) {
                if (workerMan == null) {
                    workerMan = new WorkerMan();
                }
            }
        }
        return workerMan;
    }

    public ExecutorService getPool() {
        return pool;
    }

    public String start(UploadImgTask task) throws InterruptedException, ExecutionException, TimeoutException, ImgThreadOverloadException {
        mapPut(task.getJdUid(),true);
        try {
            return getPool().submit(task).get(timeOut,TimeUnit.SECONDS);
        } finally {
            mapPut(task.getJdUid(),false);
        }
    }
    private synchronized void mapPut(Object jdUid,boolean isAdd) throws ImgThreadOverloadException {
        AtomicInteger num=map.get(jdUid);
        if(!isAdd){
            if(num==null){
                return;
            }
            num.addAndGet(-1);
        }else{
            if(num==null){
                num=new AtomicInteger(0);
            }
            if(num.get()>=userMaxNum){
                throw new ImgThreadOverloadException();
            }
            num.addAndGet(1);
        }
        map.put(jdUid,num);
    }
    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getMaxQueue() {
        return maxQueue;
    }

    public void setMaxQueue(int maxQueue) {
        this.maxQueue = maxQueue;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public int getUserMaxNum() {
        return userMaxNum;
    }

    public void setUserMaxNum(int userMaxNum) {
        this.userMaxNum = userMaxNum;
    }
}
