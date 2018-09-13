package com.shigu.main4.pay.utils;

import com.shigu.main4.pay.exceptions.XzbLockException;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 类名：ApiLockUtil
 * 类路径： com.shigu.main4.pay.utils.ApiLockUtil
 * 创建者： whx
 * 创建时间： 8/8/18 4:48 PM
 * 项目： main-pom
 * 描述：
 */
// todo: 容器内线程锁获取失败处理
@Service
public class ApiLockUtil {

    @Autowired
    private RedisIO redisIO;

    // 线程独立
    private ThreadLocal<ConcurrentHashMap<String, PayLockV2>> threadLocal;

    private ConcurrentHashMap<String, PayLockV2> lockMap = new ConcurrentHashMap<>();

    /**
     * 星座宝用户的key
     * @param accountId
     * @return
     */
    public PayLockV2 xzbKey(Long accountId){
        return getLock("xzb_"+accountId);
    }

    /**
     * 得到卷的key
     * @param accountId
     * @return
     */
    public PayLockV2 volumeKey(Long accountId){
        return getLock("volume_"+accountId);
    }

    /**
     * 支付宝的key获取
     * @param accountId
     * @return
     */
    public PayLockV2 alipayKey(Long accountId){
        return getLock("alipay_"+accountId);
    }

    /**
     * 红包支付key获取
     * @param accountId
     * @return
     */
    public PayLockV2 redPackPayKey(Long accountId){
        return getLock("redPackPay_"+accountId);
    }

    /**
     * 微信的Key获取
     * @param accountId
     * @return
     */
    public PayLockV2 wxKey(Long accountId){
        return getLock("wx_"+accountId);
    }

    /**
     * 店铺的Key获取
     * @param storeId
     * @return
     */
    public PayLockV2 storeKey(Long storeId){
        return getLock("store_"+storeId);
    }

    /**
     * 销毁锁
     * @param lock
     */
    public void destoryLock(PayLockV2 lock) {
        int useTimes = lock.decreaseLockNum();
        // 锁在线程中已经完成工作，释放锁
        if (useTimes <= 0) {
            releaseLock(lock);
            redisIO.releaseLock(lock.getKey(), lock.getRequestId());
        }

    }

    /**
     * 尝试加锁
     * @param payLockV2
     * @return
     */
    public boolean tryLock(PayLockV2 payLockV2) throws XzbLockException {
        // 原本线程已经成功获取了锁，可以继续使用，并记录锁的使用次数
        if (payLockV2.getUseTimes() > 0) {
            payLockV2.incrementLockNum();
            return true;
        }
        // 原本没有获取到锁，尝试加锁
        boolean success = redisIO.tryLock(payLockV2.getKey(), payLockV2.getRequestId(), payLockV2.getExpireTime());
        if (success) {
            payLockV2.incrementLockNum();
            return true;
        }
        throw new XzbLockException("获取锁" + payLockV2.getKey() + "失败");
    }

    /**
     * 一个线程对一个key有唯一的锁对象
     * @param key
     * @return
     */
    public PayLockV2 getLock(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        if (threadLocal == null) {
            threadLocal = new ThreadLocal<>();
        }
        ConcurrentHashMap<String, PayLockV2> lockMap = threadLocal.get();
        if (lockMap == null) {
            lockMap = new ConcurrentHashMap<String, PayLockV2>();
            threadLocal.set(lockMap);
        }
        PayLockV2 lock = lockMap.get(key);
        if (lock == null) {
            lock = PayLockV2.getALock(key);
            lockMap.put(key, lock);
        }
        return lock;
    }

    /**
     * 锁使用完，释放锁
     * @param lock
     */
    public void releaseLock(PayLockV2 lock) {
        if (threadLocal == null) {
            return;
        }
        ConcurrentHashMap<String, PayLockV2> lockMap = threadLocal.get();
        if (lockMap == null) {
            return;
        }
        lockMap.remove(lock.getKey());
        if (lockMap.size() == 0) {
            threadLocal.remove();
            threadLocal = null;
        }

    }
}
