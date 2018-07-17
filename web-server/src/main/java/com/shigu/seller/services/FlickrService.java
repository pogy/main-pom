package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.seller.vo.CategoryVo;
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
    private ShiguTaobaocatMapper shiguTaobaocatMapper;
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

        String clickstr = redisIO.get(FLICKR_PAGE_REDIS_TEMPORARY+suffix,String.class);
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

    public List<CategoryVo> getCategroy(){
        List<CategoryVo> categoryVoList = new ArrayList<>();
        CategoryVo c1 = new CategoryVo();
        c1.setCateId(30L);
        c1.setCateName("男装");
        categoryVoList.add(c1);
        CategoryVo c2 = new CategoryVo();
        c2.setCateId(16L);
        c2.setCateName("女装");
        categoryVoList.add(c2);
        CategoryVo c3 = new CategoryVo();
        c3.setCateId(50011740L);
        c3.setCateName("男鞋");
        categoryVoList.add(c3);
        CategoryVo c4 = new CategoryVo();
        c4.setCateId(50010404L);
        c4.setCateName("配饰");
        categoryVoList.add(c4);
        CategoryVo c5 = new CategoryVo();
        c5.setCateId(50006843L);
        c5.setCateName("女鞋");
        categoryVoList.add(c5);
        CategoryVo c6 = new CategoryVo();
        c6.setCateId(50006842L);
        c6.setCateName("箱包");
        categoryVoList.add(c6);
        return categoryVoList;
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

    public List<CategoryVo> getSubCategroy(Long cId){
        if (cId==null)
            return null;
        ShiguTaobaocat shiguTaobaocat = new ShiguTaobaocat();
        shiguTaobaocat.setParentCid(cId);
        List<ShiguTaobaocat> shiguTaobaocats = shiguTaobaocatMapper.select(shiguTaobaocat);
        if (shiguTaobaocats == null || shiguTaobaocats.size() <= 0)
            return null;
        List<CategoryVo> vos = new ArrayList<>();
        for (ShiguTaobaocat taobaocat : shiguTaobaocats) {
            CategoryVo vo = new CategoryVo();
            vo.setCateId(taobaocat.getCid());
            vo.setCateName(taobaocat.getCname());
            vos.add(vo);
        }
        return vos;
    }
}
