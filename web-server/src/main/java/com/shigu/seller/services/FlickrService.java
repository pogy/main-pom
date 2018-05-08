package com.shigu.seller.services;

import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.spread.services.ObjFormFlickrRedis;
import com.shigu.spread.services.RedisForFlickrPage;
import org.apache.commons.lang3.StringUtils;
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
    private RedisForFlickrPage redisForFlickrPage;
    @Autowired
    private RedisIO redisIO;
    @Autowired
    private OssIO ossIO;

    private String FLICKR_PAGE_REDIS_TEMPORARY = "flickr_page_redis_temporary_";   //相册redis缓存key的前缀  Temporary click

    final String URL_FLAG="/flickrImgs/temp/";//临时图片地址标志
    final String URL_NORMAL="/flickrImgs/";//正式图片地址

    public ObjFormFlickrRedis<Long> selreadCount(String suffix,Long readNumber) {
        return new ObjFormFlickrRedis<Long>(redisForFlickrPage,suffix,Long.class) {
            @Override
            public Long selReal() {
                return readNumber;
            }
        };
    }

    public Long temporaryClicks(String suffix){

        String clickstr = redisIO.get(FLICKR_PAGE_REDIS_TEMPORARY+suffix);
        if (clickstr == null || clickstr == ""){
            return 0l;
        }
        return Long.valueOf(clickstr);
    }

    public Boolean isUpload(Long shopId){
     Long useSize = ossIO.getFileAllSizeInfo(URL_NORMAL+shopId+"/");
     Long lsSize = ossIO.getFileAllSizeInfo(URL_FLAG+shopId+"/");
     Long allSize = 1073741824l;
     if ((allSize-useSize) < lsSize){
         return false;
     }
        return true;
    }

    /**
     * 移动图片
     */
    public String banjia(String url){
        String targetUrl=url;
        if (StringUtils.isNotBlank(url)&&url.contains(URL_FLAG)) {
            String srcFilePath=url.substring(url.indexOf(URL_FLAG),url.length());
            String targetFilePath=srcFilePath.replace(URL_FLAG,URL_NORMAL);
            if (srcFilePath.length()>0) {
                srcFilePath=srcFilePath.substring(1,srcFilePath.length());
            }
            if (targetFilePath.length()>0) {
                targetFilePath=targetFilePath.substring(1,targetFilePath.length());
            }
            targetUrl=url.replace(URL_FLAG,URL_NORMAL);
            ossIO.moveFile(srcFilePath,targetFilePath);
        }
        return targetUrl;
    }


}
