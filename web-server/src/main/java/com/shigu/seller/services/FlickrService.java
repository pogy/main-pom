package com.shigu.seller.services;

import com.shigu.main4.cdn.vo.IndexNavVO;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.vo.TextGoatVO;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.RedisForFlickrPage;
import com.shigu.spread.vo.ItemSpreadVO;
import com.shigu.tools.KeyWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.services
 * @ClassName: FlickrService
 * @Author: sy
 * @CreateDate: 2018/5/3 0003 19:56
 */

@Service
public class FlickrService {

    @Autowired
    RedisForFlickrPage redisForFlickrPage;

    public ObjFromCache<Long> selreadCount(String suffix,Long readNumber) {
        return new ObjFromCache<Long>(redisForFlickrPage,suffix,Long.class) {
            @Override
            public Long selReal() {
                return readNumber;
            }
        };
    }

}
