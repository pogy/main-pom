package com.shigu.jd.img;

import java.util.concurrent.*;

/**
 * Created By admin on 2018/1/18/15:44
 */
public class WorkerMan {

    private static volatile WorkerMan workerMan;

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
}
