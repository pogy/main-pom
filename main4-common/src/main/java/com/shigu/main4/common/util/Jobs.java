package com.shigu.main4.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 乔布斯搞笑县城-人物矗立对咧
 * Created by wxc on 2017/4/27 0027.
 */
public abstract class Jobs <E> {
    private static final Logger logger = LoggerFactory.getLogger(Jobs.class);

    /**
     * 工作线程池
     */
    private List<Frame> pool;

    /**
     * 任务池
     */
    private LinkedBlockingQueue<E> queue = new LinkedBlockingQueue<>();

    public Jobs() {
        this(5);
    }

    /**
     * 指定工作线程数，以及任务处理者
     * @param totalThread 线程数
     */
    public Jobs(int totalThread) {
        if (totalThread < 1) {
            logger.warn("Threads size must great than 0.");
            totalThread = 5;
        }
        pool = new ArrayList<>(totalThread);
        // 启动工作线程
        for (int i = 0; i < totalThread; i++) {
            Frame frame = new Frame();
            pool.add(frame);
            Thread thread = new Thread(frame, "worker-" + i);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }
    }

    public abstract void doWork(E e) throws Exception;


    /**
     * 向任务池添加任务
     * @param e 任务单元
     */
    public void addJob(E e) {
        try {
            queue.put(e);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 介入当前线程并打印work线程工作情况，任务全部完成时返回
     */
    public void join() {
        while (true) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (status() == 0) {
                break;
            }
        }
    }

    /**
     * 统计工作中的线程数
     * @return 正在运行
     */
    public int running() {
        int i = 0;
        for (Frame frame : pool) {
            if (!frame.free) {
                i++;
            }
        }
        return i;
    }

    /**
     *
     * @return 0: 工作线程已经空闲， >0 工作中的线程数
     */
    public int status() {
        int running = running();
        logger.info("job size:" + queue.size() + ", running-worker:" + running);
        return running;
    }

    private class Frame implements Runnable {

        public boolean free = true;

        @Override
        public void run() {
            while (true) {
                free = true;
                try {
                    E take = queue.take();
                    free = false;
                    doWork(take);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
