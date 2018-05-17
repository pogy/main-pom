package com.shigu.photo.utils;

import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgUtil {
    @Autowired
    RedisIO redisIO;

    private final static String ossRemoveKey="OSS_REMOVE_QUEUE";
    public void addRemove(String uri){
        redisIO.rpush(ossRemoveKey,uri);
    }
}
