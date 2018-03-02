package com.shigu.main4.ucenter.util;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    public List<ShiguGoodsTinyVO> start(PackageTask task) throws Main4Exception {
        try {
            return getPool().submit(task).get(timeOut,TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            if(e.getCause() instanceof  Main4Exception){
                throw (Main4Exception)e.getCause();
            }
            throw new Main4Exception("数据包解析失败");
        } catch (Exception e) {
            throw new Main4Exception("数据包解析失败");
        }
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
