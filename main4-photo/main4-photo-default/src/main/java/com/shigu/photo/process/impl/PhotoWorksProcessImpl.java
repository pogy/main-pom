package com.shigu.photo.process.impl;

import com.opentae.data.photo.beans.*;
import com.opentae.data.photo.examples.ShiguPhotoCatExample;
import com.opentae.data.photo.examples.ShiguPhotoStyleExample;
import com.opentae.data.photo.interfaces.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.tools.RedisIO;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.SynPhotoUploadBO;
import com.shigu.photo.process.PhotoImgProcess;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;

@Service("photoWorksProcess")
public class PhotoWorksProcessImpl implements PhotoWorksProcess {
    @Autowired
    ShiguPhotoStyleMapper shiguPhotoStyleMapper;
    @Autowired
    ShiguPhotoCatMapper shiguPhotoCatMapper;
    @Autowired
    PhotoImgProcess photoImgProcess;
    @Autowired
    ShiguPhotoWorksMapper shiguPhotoWorksMapper;
    @Autowired
    ShiguPhotoUserMapper shiguPhotoUserMapper;
    @Autowired
    ShiguPhotoWorksStyleMapper shiguPhotoWorksStyleMapper;
    @Autowired
    ShiguPhotoUserPraiseMapper shiguPhotoUserPraiseMapper;
    @Autowired
    RedisIO redisIO;

    //浏览量缓存
    private final String WORKS_CLICK_TEMP_RESTORE_PREFIX = "works_flow_";

    //被点击过的作品id列表，用来固化浏览量
    private final String CLICKED_WORKS_FLAG = "work_flow_list";

    @Override
    public List<PhotoStyleVO> selPhotoStyleVos(Long userId) {
        List<Long> userIds = Collections.singletonList(-1L);
        if (userId != null) {
            userIds.add(userId);
        }
        ShiguPhotoStyleExample shiguPhotoStyleExample = new ShiguPhotoStyleExample();
        shiguPhotoStyleExample.createCriteria().andUserIdIn(userIds);
        shiguPhotoStyleExample.setOrderByClause("user_id asc,style_id asc");
        return BeanMapper.mapList(shiguPhotoStyleMapper.selectByExample(shiguPhotoStyleExample), PhotoStyleVO.class);
    }

    @Override
    public List<PhotoCatVO> selPhotoCatVos() {
        return BeanMapper.mapList(shiguPhotoCatMapper.selectByExample(new ShiguPhotoCatExample()), PhotoCatVO.class);
    }

    @Override
    public void uploadWorks(SynPhotoUploadBO bo) {
        ShiguPhotoWorks shiguPhotoWorks = new ShiguPhotoWorks();
        shiguPhotoWorks.setAuthorId(bo.getUserId());
        shiguPhotoWorks.setClicks(0L);
        shiguPhotoWorks.setCreateTime(new Date());
        shiguPhotoWorks.setForbidSave(bo.getForbidSave() == 1);
        shiguPhotoWorks.setHavePrice(bo.getHavePrice() == 1);
        shiguPhotoWorks.setLastModifyTme(shiguPhotoWorks.getCreateTime());
        shiguPhotoWorks.setPrice(shiguPhotoWorks.getHavePrice() ? MoneyUtil.StringToLong(bo.getPriceString()) : null);
        shiguPhotoWorks.setRemoveIs(false);
        shiguPhotoWorks.setTitle(bo.getTitle());
        shiguPhotoWorks.setWorksCid(bo.getCid());
        shiguPhotoWorks.setPicUrl(bo.getPicUtl());
        String images = StringUtils.join(bo.getImages().stream()
                .map(s -> photoImgProcess.moveImg(s)).collect(Collectors.toList()), ",");
        shiguPhotoWorks.setImages(images);
        shiguPhotoWorksMapper.insertSelective(shiguPhotoWorks);
        List<ShiguPhotoWorksStyle> shiguPhotoWorksStyles = new ArrayList<>();
        for (Long styleId : bo.getStyleId()) {
            ShiguPhotoWorksStyle shiguPhotoWorksStyle = new ShiguPhotoWorksStyle();
            shiguPhotoWorksStyle.setStyleId(styleId);
            shiguPhotoWorksStyle.setWorksId(shiguPhotoWorks.getWorksId());
            shiguPhotoWorksStyles.add(shiguPhotoWorksStyle);
        }
        if (shiguPhotoWorksStyles.size() > 0) {
            shiguPhotoWorksStyleMapper.insertListNoId(shiguPhotoWorksStyles);
        }
    }

    @Override
    public ShiguPager<PhotoWorksVO> selPhotoWorksVos(PhotoWorksBO bo) {
        ShiguPager<PhotoWorksVO> pager = new ShiguPager<>();
        pager.setNumber(bo.getPage());
        int count = shiguPhotoWorksMapper.selectShiguPhotoWorksCount(bo.getStyleId(),
                bo.getUserType(),
                bo.getSubUserType());
        if (count > 0) {
            pager.setContent(shiguPhotoWorksMapper.selectShiguPhotoWorks(bo.getStyleId(),
                    bo.getUserType(),
                    bo.getSubUserType(),
                    bo.getSort().getSql(),
                    (bo.getPage() - 1) * bo.getPageSize(),
                    bo.getPageSize()));
        }
        pager.calPages(count, bo.getPageSize());
        return pager;
    }

    @Override
    public PhotoWorkDetailVO selPhotoWorkDetail(Long worksId) {
        if (worksId == null) {
            return null;
        }
        ShiguPhotoWorks works = shiguPhotoWorksMapper.selectByPrimaryKey(worksId);
        if (works == null) {
            return null;
        }
        PhotoWorkDetailVO vo = BeanMapper.map(works, PhotoWorkDetailVO.class);
        vo.setImgs(works.getImages());
        if (!works.getHavePrice() || works.getPrice() == null) {
            vo.setPriceStr("私聊");
        } else {
            vo.setPriceStr(String.format("%.2f", works.getPrice() * 0.01));
        }
        vo.setStylesStr("");
        ShiguPhotoWorksStyle worksStylequery = new ShiguPhotoWorksStyle();
        worksStylequery.setWorksId(worksId);
        List<ShiguPhotoWorksStyle> worksStyles = shiguPhotoWorksStyleMapper.select(worksStylequery);
        if (worksStyles.size() > 0) {
            ShiguPhotoStyleExample styleExample = new ShiguPhotoStyleExample();
            styleExample.createCriteria().andStyleIdIn(BeanMapper.getFieldList(worksStyles, "styleId", Long.class));
            Set<String> styleNames = shiguPhotoStyleMapper.selectByExample(styleExample).stream().map(ShiguPhotoStyle::getStyleName).collect(Collectors.toSet());
            vo.setStylesStr(StringUtils.join(styleNames, "、"));
        }

        //有效点赞数值
        ShiguPhotoUserPraise praiseCountQuery = new ShiguPhotoUserPraise();
        praiseCountQuery.setWorksId(worksId);
        praiseCountQuery.setStatus(1);
        vo.setPraiseNum(shiguPhotoUserPraiseMapper.selectCount(praiseCountQuery));
        return vo;
    }

    @Override
    public PhotoWorksClickVO getClicks(Long worksId) {
        if (worksId == null) {
            return null;
        }
        String worksFlag = WORKS_CLICK_TEMP_RESTORE_PREFIX + worksId;
        PhotoWorksClickVO clickVO = redisIO.get(worksFlag, PhotoWorksClickVO.class);
        if (clickVO == null) {
            ShiguPhotoWorks works = shiguPhotoWorksMapper.selectByPrimaryKey(worksId);
            if (works == null) {
                return null;
            }
            clickVO = new PhotoWorksClickVO();
            clickVO.setWorksId(worksId);
            clickVO.setTotalClick(works.getClicks());
            clickVO.setAddClick(0);
        }
        redisIO.putTemp(worksFlag, clickVO, 60 * 15);
        return clickVO;
    }

    @Override
    public PhotoWorksClickVO incrementClicks(Long worksId) {
        String worksFlag = WORKS_CLICK_TEMP_RESTORE_PREFIX + worksId;
        PhotoWorksClickVO clickVO = getClicks(worksId);
        clickVO.setTotalClick(clickVO.getTotalClick() + 1);
        clickVO.setAddClick(clickVO.getAddClick() + 1);
        // 缓存15分钟
        redisIO.putTemp(worksFlag, clickVO, 60 * 15);
        // 将作品加入处理队列
        try {
            Jedis jedis = redisIO.getJedis();
            jedis.sadd(CLICKED_WORKS_FLAG, worksFlag);
        } catch (Exception e) {

        } finally {

        }

        return clickVO;
    }

    //固化点击量
    public void fixClicks() {
        try {
            Jedis jedis = redisIO.getJedis();
            Set<String> clickedWorksIds = jedis.smembers(CLICKED_WORKS_FLAG);
            String[] worksIds = clickedWorksIds.toArray(new String[0]);
            jedis.rpush(CLICKED_WORKS_FLAG+"_temp",worksIds);
            jedis.del(CLICKED_WORKS_FLAG);
            redisIO.returnJedis(jedis);
            jedis = redisIO.getJedis();

            //所有未处理的点击量
            Set<String> totalClickedWorksIds = jedis.smembers(CLICKED_WORKS_FLAG + "_temp");

            if (totalClickedWorksIds == null || totalClickedWorksIds.size()==0) {

            }

        } catch (Exception e) {

        } finally {

        }

    }


}
