package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguFlickr;
import com.opentae.data.mall.beans.ShiguFlickrPicture;
import com.opentae.data.mall.interfaces.ShiguFlickrMapper;
import com.opentae.data.mall.interfaces.ShiguFlickrPictureMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.storeservices.FlickrManageService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.storeservices.impl
 * @ClassName: FlickrManageServiceImpl
 * @Author: sy
 * @CreateDate: 2018/5/1 0001 14:03
 */

@Service("FlickrManageService")
public class FlickrManageServiceImpl implements FlickrManageService {

    @Autowired
    private ShiguFlickrMapper shiguFlickrMapper;
    @Autowired
    private ShiguFlickrPictureMapper shiguFlickrPictureMapper;

    @Autowired
    private OssIO ossIO;
    @Autowired
    private RedisIO redisIO;

    /**
     * 添加一个相册
     * @param name
     * @param storeId
     * @return
     */
    @Override
    public Integer addFlickr(String name, Long cId, String desc, Long storeId ,String webSite) {
        ShiguFlickr shiguFlickr = new ShiguFlickr();
        shiguFlickr.setCId(cId);
        shiguFlickr.setClicks(0l);
        shiguFlickr.setFName(name);
        shiguFlickr.setFDesc(desc);
        shiguFlickr.setFStatus(1);
        shiguFlickr.setClicks(0l);
        shiguFlickr.setStoreId(storeId);
        shiguFlickr.setWebSite(webSite);
        return shiguFlickrMapper.insertSelective(shiguFlickr);
    }

    /**
     * 修改一个相册
     * @param name
     * @param fId
     * @return
     */
    @Override
    public Integer updateFlickr(Long fId, String name, Long cId, String desc) {
        ShiguFlickr shiguFlickr = new ShiguFlickr();
        shiguFlickr.setFId(fId);
        shiguFlickr.setCId(cId);
        shiguFlickr.setFName(name);
        shiguFlickr.setFDesc(desc);
        return shiguFlickrMapper.updateByPrimaryKeySelective(shiguFlickr);
    }

    /**
     * 删除一个相册
     * @param fId
     * @return
     */
    @Override
    public Integer deleteFlickr(Long fId) {
        ShiguFlickrPicture shiguFlickrPicture = new ShiguFlickrPicture();
        shiguFlickrPicture.setPicStatus(1);
        shiguFlickrPicture.setFId(fId);
        List<ShiguFlickrPicture> pictureList = shiguFlickrPictureMapper.select(shiguFlickrPicture);
        if (pictureList.size() > 0){
            pictureList.forEach(picture ->{
                String url = picture.getPicUrl().replaceAll("http://imgs.571xz.net/","");
                boolean b = ossIO.deleteFile(url);
                if (b == true){
                    ShiguFlickrPicture sfp = new ShiguFlickrPicture();
                    sfp.setPicId(picture.getPicId());
                    sfp.setPicStatus(-1);
                    shiguFlickrPictureMapper.updateByPrimaryKey(sfp);
                }
            });
        }
        ShiguFlickr shiguFlickr = new ShiguFlickr();
        shiguFlickr.setFId(fId);
        shiguFlickr.setFStatus(-1);
        return shiguFlickrMapper.updateByPrimaryKeySelective(shiguFlickr);
    }

    /**
     * 店铺后台获取所有相册
     * @param storeId
     * @return
     */
    @Override
    public List<FlickrVo> getStroeFlickrbyStoreId(Long storeId) {
        ShiguFlickr shiguFlickr = new ShiguFlickr();
        shiguFlickr.setStoreId(storeId);
        shiguFlickr.setFStatus(1);
        List<ShiguFlickr> shiguFlickrList = shiguFlickrMapper.select(shiguFlickr);
        if (shiguFlickrList.size() <= 0){
            return null;
        }
        SimpleDateFormat time = new SimpleDateFormat("yyyy-mm-dd");
        List<FlickrVo> storeFlickrAllList = new ArrayList<>();
        shiguFlickrList.forEach(flickr -> {
            FlickrVo flickrAll = new FlickrVo();
            flickrAll.setfId(flickr.getFId());
            flickrAll.setCover(flickr.getFCover());
            flickrAll.setcId(flickr.getCId());
            flickrAll.setClicks(flickr.getClicks());
            flickrAll.setDesc(flickr.getFDesc());
            if (shiguFlickrMapper.countFlickrPicture(flickr.getFId(),1)==null) {
                flickrAll.setNumber(0);
            }else {
                flickrAll.setNumber(shiguFlickrMapper.countFlickrPicture(flickr.getFId(), 1));
            }
            flickrAll.setCreateTime(DateUtil.formateDate(flickr.getCreateTime()));
            flickrAll.setName(flickr.getFName());
            storeFlickrAllList.add(flickrAll);
        });
        return storeFlickrAllList;
    }

    /**
     * 店铺后台获取相册里的所有图片
     * @param fId
     * @return
     */
    @Override
    public FlickrPicInfoVo getFlickrPictureList(Long fId) {
        ShiguFlickr shiguFlickr = shiguFlickrMapper.selectByPrimaryKey(fId);
        FlickrPicInfoVo flickrPicInfoVo = new FlickrPicInfoVo();
        flickrPicInfoVo.setTitle(shiguFlickr.getFName());
        flickrPicInfoVo.setCover(shiguFlickr.getFCover());
        flickrPicInfoVo.setPicCount(0);
        ShiguFlickrPicture shiguFlickrPicture = new ShiguFlickrPicture();
        shiguFlickrPicture.setFId(fId);
        shiguFlickrPicture.setPicStatus(1);
        List<ShiguFlickrPicture> shiguFlickrPictureList = shiguFlickrPictureMapper.select(shiguFlickrPicture);
        if (shiguFlickrPictureList.size() <= 0){
            flickrPicInfoVo.setGoodsPics(new ArrayList<>());
            return flickrPicInfoVo;
        }
        SimpleDateFormat time = new SimpleDateFormat("yyyy-mm-dd");
        List<FlickrPictureVo> flickrPictureVoList = new ArrayList<>();
        shiguFlickrPictureList.forEach(picture -> {
            FlickrPictureVo flickrPictureVo = new FlickrPictureVo();
            flickrPictureVo.setImgSrc(picture.getPicUrl());
            flickrPictureVo.setGoodsPicId(picture.getPicId());
            flickrPictureVo.setCreated(time.format(picture.getCreateTime()));
            flickrPictureVoList.add(flickrPictureVo);
        });
        flickrPicInfoVo.setPicCount(flickrPictureVoList.size());
        flickrPicInfoVo.setGoodsPics(flickrPictureVoList);
        return flickrPicInfoVo;
    }

    /**
     * 批量添加相册图片
     * @param fId
     * @param picUrlList
     * @return
     */
    @Override
    public Integer addFlickrPicture(Long fId, List<String> picUrlList) {
        if (picUrlList.size() <=0){
            return null;
        }
        List<ShiguFlickrPicture> shiguFlickrPictures = new ArrayList<>();
        for (int i = 0; i <picUrlList.size() ; i++) {
            ShiguFlickrPicture shiguFlickrPicture = new ShiguFlickrPicture();
            shiguFlickrPicture.setPicStatus(1);
            shiguFlickrPicture.setFId(fId);
            shiguFlickrPicture.setPicUrl(picUrlList.get(i));
            shiguFlickrPictures.add(shiguFlickrPicture);
        }
        List<String> picUrl = shiguFlickrMapper.selectPicTwo(fId,1);
        if (picUrl.size() <= 0) {
            ShiguFlickr shiguFlickr = new ShiguFlickr();
            shiguFlickr.setFId(fId);
            shiguFlickr.setFCover(shiguFlickrPictures.get(0).getPicUrl());
            Integer b = shiguFlickrMapper.updateByPrimaryKeySelective(shiguFlickr);
            if (b <= 0) {
                return b;
            }
        }
        return shiguFlickrPictureMapper.insertListNoId(shiguFlickrPictures);
    }

    /**
     * 删除相册图片
     * @param picId
     * @return
     */
    @Override
    public Integer deleteFlickrPicture(Long picId) {
        ShiguFlickrPicture picture = shiguFlickrPictureMapper.selectByPrimaryKey(picId);
        String url = picture.getPicUrl().replaceAll("http://imgs.571xz.net/","");
        boolean b = ossIO.deleteFile(url);
        if (b == false){
            return -1;
        }
        List<String> picUrl = shiguFlickrMapper.selectPicTwo(picture.getFId(),1);
        if (picture.getPicUrl().equalsIgnoreCase(picUrl.get(0))){
            ShiguFlickr shiguFlickr = new ShiguFlickr();
            shiguFlickr.setFId(picture.getFId());
                if (picUrl.size() <= 1){
                    shiguFlickr.setFCover("");
                }else{
                    shiguFlickr.setFCover(picUrl.get(1));
                }
            shiguFlickrMapper.updateByPrimaryKeySelective(shiguFlickr);
        }
        ShiguFlickrPicture shiguFlickrPicture = new ShiguFlickrPicture();
        shiguFlickrPicture.setPicId(picId);
        shiguFlickrPicture.setPicStatus(-1);
        return shiguFlickrPictureMapper.updateByPrimaryKeySelective(shiguFlickrPicture);
    }

    /**
     * 获取相册编辑信息
     * @param fId
     * @return
     */
    @Override
    public FlickrInfoVo getFlickrEditInfo(Long fId) {
        ShiguFlickr shiguFlickr = shiguFlickrMapper.selectByPrimaryKey(fId);
        FlickrInfoVo infoVo = new FlickrInfoVo();
        infoVo.setfId(shiguFlickr.getFId());
        infoVo.setfDesc(shiguFlickr.getFDesc());
        infoVo.setcId(shiguFlickr.getCId());
        infoVo.setfName(shiguFlickr.getFName());
        return infoVo;
    }

    /**
     * 获取店铺展示相册
     * @param cId
     * @return
     */
    @Override
    public ShiguPager<ShopFlickrsVo> getFlickrbyShop(Long shopId,Long cId,Integer pageNo, Integer pageSize) {
        ShiguPager<ShopFlickrsVo> pager = new ShiguPager<>();
        if (pageNo==null || pageNo < 1)
            pageNo = 1;
        if (pageSize==null ||pageSize < 1)
            pageSize = 10;
        pager.setNumber(pageNo);
        int pageno = (pageNo-1)*pageSize;
        int count = shiguFlickrMapper.countFlickr(1);
        pager.calPages(count, pageSize);
        if (count > 0) {
            List<FlickrShow> showList = shiguFlickrMapper.selectFlickrByShop(shopId,cId,"cs",1,pageno,pageSize);
            if (showList.size() <=0 ){
                return null;
            }
            SimpleDateFormat time = new SimpleDateFormat("yyyy-mm-dd");
            List<ShopFlickrsVo> flickrVos = new ArrayList<>();
            showList.forEach(flickrShow -> {
                ShopFlickrsVo flickrVo = new ShopFlickrsVo();
                flickrVo.setId(flickrShow.getfId());
                flickrVo.setTitle(flickrShow.getName());
                flickrVo.setReadCount(flickrShow.getClicks());
                flickrVo.setCover(flickrShow.getCover());
                flickrVo.setPicCount(flickrShow.getNumber());
                flickrVo.setCreated(time.format(flickrShow.getCreateTime()));
                flickrVos.add(flickrVo);
            });
            pager.setContent(BeanMapper.mapList(flickrVos, ShopFlickrsVo.class));
        }
        return pager;
    }

    /**
     * 获取相册的展示信息
     * @param fId
     * @return
     */
    @Override
    public FlickrDetailsVo getFlickrShow(Long fId) {
        if (fId == null){
            return null;
        }
        ShiguFlickr shiguFlickr = shiguFlickrMapper.selectByPrimaryKey(fId);
        ShiguFlickrPicture shiguFlickrPicture = new ShiguFlickrPicture();
        shiguFlickrPicture.setFId(fId);
        shiguFlickrPicture.setPicStatus(1);
        List<ShiguFlickrPicture> shiguFlickrPictureList = shiguFlickrPictureMapper.select(shiguFlickrPicture);
        FlickrDetailsVo vo = new FlickrDetailsVo();
        vo.setfId(shiguFlickr.getFId());
        vo.setName(shiguFlickr.getFName());
        vo.setDesc(shiguFlickr.getFDesc());
        vo.setStoreId(shiguFlickr.getStoreId());
        List<PicturesVo> picVos = new ArrayList<>();
        if (shiguFlickrPictureList.size() > 0){
            vo.setNumber(Long.valueOf(shiguFlickrPictureList.size()));
            for (int i = 0; i <shiguFlickrPictureList.size() ; i++) {
                PicturesVo p = new PicturesVo();
                p.setCreateTime(DateUtil.dateToString(shiguFlickrPictureList.get(i).getCreateTime(),DateUtil.patternD));
                p.setPicUrl(shiguFlickrPictureList.get(i).getPicUrl());
                picVos.add(p);
            }
        }else {
            vo.setNumber(0l);
        }
        vo.setPictures(picVos);
        Jedis jedis = redisIO.getJedis();
        jedis.incrBy("flickr_page_redis_temporary_"+vo.getfId(),1);
        return vo;
//        FlickrDetails flickrDetails = shiguFlickrMapper.selectFlickrPictureByfId(fId,1);
//        FlickrDetailsVo vo = new FlickrDetailsVo();
//        vo.setName(flickrDetails.getName());
//        vo.setDesc(flickrDetails.getDesc());
//        vo.setNumber(flickrDetails.getNumber());
//        vo.setStoreId(flickrDetails.getStoreId());
//        String[] pics = flickrDetails.getPicUrls().split(",");
//        List<String> picList = new ArrayList<>();
//        Jedis jedis = redisIO.getJedis();
//        jedis.incrBy("flickr_page_redis_temporary_"+flickrDetails.getfId(),1);
//        if (pics == null || pics.length <= 0){
//            vo.setPictures(picList);
//            return vo;
//        }
//        for (int i = 0; i < pics.length ; i++) {
//            picList.add(pics[i]);
//        }
//        return vo;
    }

    public ShiguPager<FlickrHomeVo> getFlickrByCategory(Long cId,Integer pageNo, Integer pageSize) {
        ShiguPager<FlickrHomeVo> pager = new ShiguPager<>();
        if (pageNo==null || pageNo < 1)
            pageNo = 1;
        if (pageSize==null ||pageSize < 1)
            pageSize = 10;
        pager.setNumber(pageNo);
        int pageno = (pageNo-1)*pageSize;
        int count = shiguFlickrMapper.countFlickr(1);
        pager.calPages(count, pageSize);
        if (count > 0) {
            List<FlickrHomeVo> showList = shiguFlickrMapper.selectFlickrByCategory(cId,"cs",1,pageno,pageSize);
            if (showList.size() <=0 ){
                return null;
            }
            pager.setContent(BeanMapper.mapList(showList, FlickrHomeVo.class));
        }
        return pager;
    }
}
