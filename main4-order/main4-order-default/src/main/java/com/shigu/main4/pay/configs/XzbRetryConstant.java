package com.shigu.main4.pay.configs;

/**
 * 类名：XzbRetryConstant
 * 类路径： com.shigu.main4.pay.configs.XzbRetryConstant
 * 创建者： whx
 * 创建时间： 9/17/18 12:50 PM
 * 项目： main-pom
 * 描述： 星座宝失败重试设置
 */
public class XzbRetryConstant {

    // 获取锁失败重试次数 默认3次
    private Integer lockRetryTimes = 3;

    // 获取锁失败等待重试毫秒数 默认300ms
    private Integer lockFailedRetryTimeMs = 300;

    public Integer getLockRetryTimes() {
        return lockRetryTimes;
    }

    public void setLockRetryTimes(Integer lockRetryTimes) {
        this.lockRetryTimes = lockRetryTimes;
    }

    public Integer getLockFailedRetryTimeMs() {
        return lockFailedRetryTimeMs;
    }

    public void setLockFailedRetryTimeMs(Integer lockFailedRetryTimeMs) {
        this.lockFailedRetryTimeMs = lockFailedRetryTimeMs;
    }
}
