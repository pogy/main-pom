package com.shigu.main4.pay.utils;

import com.shigu.main4.common.util.UUIDGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名：PayLockV2
 * 类路径： com.shigu.main4.pay.utils.PayLockV2
 * 创建者： whx
 * 创建时间： 8/8/18 4:10 PM
 * 项目： main-pom
 * 描述： 支付锁 和ApiLockUtil配合完成锁操作 实际使用redis进行互斥操作 考虑要不要继承 ReentrantReadWriteLock，
 */
public class PayLockV2 {

    public static PayLockV2 getALock(String key) {
        if (key == null) {
            return null;
        }
        return new PayLockV2(key);
    }

    public static PayLockV2 getALock(String key, int expireTime) {
        if (key == null) {
            return null;
        }
        if (expireTime <= 0) {
            expireTime = 500;
        }
        return new  PayLockV2(key, expireTime);
    }


    private String key;

    private String requestId;

    private int expireTime;

    private AtomicInteger useTimes;

    public PayLockV2(String key) {
        this(key, 500);
    }

    public PayLockV2(String key, int expireTime) {
        this.key = key;
        this.expireTime = expireTime;
        geneteRequestId();
        useTimes = new AtomicInteger(0);
    }

    private void geneteRequestId() {
        requestId = UUIDGenerator.getUUID();
    }

    /**
     * 成功加锁和线程中重复使用锁时发起，记录锁的使用次数
     */
    public void incrementLockNum() {
        useTimes.addAndGet(1);
    }

    /**
     * 锁使用完后发起，查看锁在线程中还在使用中的次数
     * @return
     */
    public int decreaseLockNum() {
        return useTimes.addAndGet(-1);
    }

    /**
     * 获取锁已经使用的次数，大于零说明该线程已经获取到锁，小于等于零说明在该线程中没有获取到锁或已经使用完
     * @return
     */
    public int getUseTimes() {
        return useTimes.get();
    }

    public String getKey() {
        return key;
    }

    public String getRequestId() {
        return requestId;
    }

    public int getExpireTime() {
        return expireTime;
    }
}
