package com.shigu.main4.item.tools;


/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.item.tools
 * @ClassName: CacheUtil
 * @Author: sy
 * @CreateDate: 2018/8/28 0028 15:40
 */
public class CacheUtil {

    public static Integer comparisonTimestamp(Long cacheTimestamp,Long redisTimestamp){
        if (redisTimestamp == null || cacheTimestamp == null)
            return 1;
        Long time = redisTimestamp-cacheTimestamp;
        return time.intValue();
    }
}
