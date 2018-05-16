package com.shigu.main4.photo.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.photo.beans.*;
import com.opentae.data.photo.examples.ShiguPhotoCatExample;
import com.opentae.data.photo.examples.ShiguPhotoStyleExample;
import com.opentae.data.photo.examples.ShiguPhotoWorksExample;
import com.opentae.data.photo.examples.ShiguPhotoWorksStyleExample;
import com.opentae.data.photo.interfaces.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.bo.SynPhotoUploadBO;
import com.shigu.main4.photo.exceptions.PhotoException;
import com.shigu.main4.photo.process.PhotoImgProcess;
import com.shigu.main4.photo.process.PhotoUserProcess;
import com.shigu.main4.photo.process.PhotoWorksProcess;
import com.shigu.main4.photo.vo.*;
import com.shigu.main4.tools.RedisIO;
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
    PhotoUserProcess photoUserProcess;


    @Autowired
    RedisIO redisIO;

    //浏览量缓存
    private final String WORKS_CLICK_TEMP_RESTORE_PREFIX = "works_flow_";

    //被点击过的作品id列表，用来固化浏览量
    private final String CLICKED_WORKS_FLAG = "work_flow_list";

    @Override
    public List<PhotoStyleVO> selPhotoStyleVos(Long userId) {
        List<Long> authorIds = new ArrayList<>(Collections.singletonList(-1L));
        if (userId != null) {
            PhotoUserVO photoUserVO = photoUserProcess.userBaseInfo(userId);
            authorIds.add(photoUserVO.getAuthorId());
        }
        ShiguPhotoStyleExample shiguPhotoStyleExample = new ShiguPhotoStyleExample();
        shiguPhotoStyleExample.createCriteria().andAuthorIdIn(authorIds);
        shiguPhotoStyleExample.setOrderByClause("author_id asc,style_id asc");
        return BeanMapper.mapList(shiguPhotoStyleMapper.selectByExample(shiguPhotoStyleExample), PhotoStyleVO.class);
    }

    @Override
    public List<PhotoCatVO> selPhotoCatVos() {
        return BeanMapper.mapList(shiguPhotoCatMapper.selectByExample(new ShiguPhotoCatExample()), PhotoCatVO.class);
    }

    @Override
    public PhotoWorksUpdateVO selPhotoSingel(Long worksId) {
        PhotoWorksUpdateVO vo = BeanMapper.map(shiguPhotoWorksMapper.selectByPrimaryKey(worksId), PhotoWorksUpdateVO.class);
        ShiguPhotoWorksStyleExample shiguPhotoWorksStyleExample = new ShiguPhotoWorksStyleExample();
        shiguPhotoWorksStyleExample.createCriteria().andWorksIdEqualTo(worksId);
        List<ShiguPhotoWorksStyle> shiguPhotoWorksStyles = shiguPhotoWorksStyleMapper.selectByExample(shiguPhotoWorksStyleExample);
        vo.setStyleIds(shiguPhotoWorksStyles.stream().map(ShiguPhotoWorksStyle::getStyleId).collect(Collectors.toList()));
        return vo;
    }

    @Override
    public void uploadWorks(SynPhotoUploadBO bo) throws PhotoException {
        PhotoUserVO photoUserVO = photoUserProcess.userBaseInfo(bo.getUserId());
        if(bo.getWorksId()!=null){
            ShiguPhotoWorks shiguPhotoWorks = shiguPhotoWorksMapper.selectByPrimaryKey(bo.getWorksId());
            if(shiguPhotoWorks==null){
                throw new PhotoException("作品不存在");
            }
            if(!shiguPhotoWorks.getAuthorId().equals(photoUserVO.getAuthorId())){
                throw new PhotoException("作品所属错误");
            }
        }
        ShiguPhotoWorks shiguPhotoWorks = new ShiguPhotoWorks();
        shiguPhotoWorks.setAuthorId(photoUserVO.getAuthorId());
        shiguPhotoWorks.setClicks(0L);
        shiguPhotoWorks.setCreateTime(new Date());
        shiguPhotoWorks.setForbidSave(bo.getForbidSave() == 1);
        shiguPhotoWorks.setHavePrice(bo.getHavePrice() == 1);
        shiguPhotoWorks.setLastModifyTme(shiguPhotoWorks.getCreateTime());
        shiguPhotoWorks.setPrice(shiguPhotoWorks.getHavePrice() ? MoneyUtil.StringToLong(bo.getPriceString()) : null);
        shiguPhotoWorks.setRemoveIs(false);
        shiguPhotoWorks.setTitle(bo.getTitle());
        shiguPhotoWorks.setWorksCid(bo.getCid());
        shiguPhotoWorks.setPicUrl(photoImgProcess.moveImg(bo.getPicUrl()));
        shiguPhotoWorks.setContent(bo.getContent());
        String images = StringUtils.join(bo.getImages().stream()
                .map(s -> photoImgProcess.moveImg(s)).collect(Collectors.toList()), ",");
        shiguPhotoWorks.setImages(images);
        if(bo.getWorksId()==null){
            shiguPhotoWorksMapper.insertSelective(shiguPhotoWorks);
            insertWorksStyles(bo.getStyleId(),shiguPhotoWorks.getWorksId());
        }else{
            shiguPhotoWorks.setWorksId(bo.getWorksId());
            shiguPhotoWorksMapper.updateByPrimaryKeySelective(shiguPhotoWorks);
            if(bo.getStyleId()!=null&&bo.getStyleId().size()>0){
                ShiguPhotoWorksStyleExample shiguPhotoWorksStyleExample=new ShiguPhotoWorksStyleExample();
                shiguPhotoWorksStyleExample.createCriteria().andWorksIdEqualTo(bo.getWorksId());
                shiguPhotoWorksStyleMapper.deleteByExample(shiguPhotoWorksStyleExample);
                insertWorksStyles(bo.getStyleId(),bo.getWorksId());
            }
        }
    }

    @Override
    public void removeWorks(Long worksId,Long userId) {
        PhotoUserVO photoUserVO = photoUserProcess.userBaseInfo(userId);
        ShiguPhotoWorksExample shiguPhotoWorksExample=new ShiguPhotoWorksExample();
        shiguPhotoWorksExample.createCriteria().andWorksIdEqualTo(worksId).andAuthorIdEqualTo(photoUserVO.getAuthorId());
        ShiguPhotoWorks w=new ShiguPhotoWorks();
        w.setRemoveIs(true);
        shiguPhotoWorksMapper.updateByExampleSelective(w,shiguPhotoWorksExample);
    }

    private void insertWorksStyles(List<Long> styles,Long worksId){
        List<ShiguPhotoWorksStyle> shiguPhotoWorksStyles = new ArrayList<>();
        for (Long styleId : styles) {
            ShiguPhotoWorksStyle shiguPhotoWorksStyle = new ShiguPhotoWorksStyle();
            shiguPhotoWorksStyle.setStyleId(styleId);
            shiguPhotoWorksStyle.setWorksId(worksId);
            shiguPhotoWorksStyles.add(shiguPhotoWorksStyle);
        }
        if (shiguPhotoWorksStyles.size() > 0) {
            shiguPhotoWorksStyleMapper.insertListNoId(shiguPhotoWorksStyles);
        }
    }

    @Override
    public ShiguPager<PhotoWorksVO> selPhotoWorksVos(PhotoWorksBO bo) throws PhotoException {
        Long authorId=null;
        if(bo.getUserId()!=null){
            PhotoUserVO photoUserVO = photoUserProcess.userBaseInfo(bo.getUserId());
            if(photoUserVO==null){
                throw new PhotoException("作者信息不存在");
            }
            authorId=photoUserVO.getAuthorId();
        }
        ShiguPager<PhotoWorksVO> pager = new ShiguPager<>();
        pager.setNumber(bo.getPage());
        pager.setContent(new ArrayList<>());
        int count=shiguPhotoWorksMapper.selectShiguPhotoWorksCount(authorId,bo.getStyleId(),bo.getCid(),
                bo.getUserTypes()!=null?StringUtils.join(bo.getUserTypes(),","):null,
                bo.getTitle(),
                bo.getSex());
        if(count>0){
            pager.setContent(shiguPhotoWorksMapper.selectShiguPhotoWorks(authorId,bo.getStyleId(),bo.getCid(),
                    bo.getUserTypes()!=null?StringUtils.join(bo.getUserTypes(),","):null,
                    bo.getTitle(),
                    bo.getSex(),
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
        ShiguPhotoUser author = shiguPhotoUserMapper.selectByPrimaryKey(works.getAuthorId());
        vo.setUserId(author.getUserId());
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
        redisIO.put(worksFlag, clickVO);
        return clickVO;
    }

    @Override
    public PhotoWorksClickVO incrementClicks(Long worksId) {
        String worksFlag = WORKS_CLICK_TEMP_RESTORE_PREFIX + worksId;
        PhotoWorksClickVO clickVO = getClicks(worksId);
        clickVO.setTotalClick(clickVO.getTotalClick() + 1);
        clickVO.setAddClick(clickVO.getAddClick() + 1);
        // 缓存15分钟
        redisIO.put(worksFlag, clickVO);
        // 将作品加入处理队列
        Jedis jedis = null;
        try {
            jedis = redisIO.getJedis();
            jedis.sadd(CLICKED_WORKS_FLAG, worksFlag);
        } catch (Exception e) {
        } finally {
            if (jedis != null) {
                redisIO.returnJedis(jedis);
            }
        }
        return clickVO;
    }

    /**
     * 固化点击量
     */
    public void fixClicks() {
        Jedis jedis = null;
        Set<String> clickedWorksIds = null;
        try {
            jedis = redisIO.getJedis();
            clickedWorksIds = jedis.smembers(CLICKED_WORKS_FLAG);
            jedis.del(CLICKED_WORKS_FLAG);
        } catch (Exception ignore) {
        } finally {
            if (redisIO != null) {
                redisIO.returnJedis(jedis);
            }
        }
        if (clickedWorksIds == null || clickedWorksIds.size() == 0) {
            return;
        }
        PhotoWorksClickVO click = null;
        ShiguPhotoWorks works = null;
        for (String key : clickedWorksIds) {
            try {
                Long worksId = Long.valueOf(key.replace(WORKS_CLICK_TEMP_RESTORE_PREFIX, ""));
                click = redisIO.get(key, PhotoWorksClickVO.class);
                if (click != null) {
                    works = shiguPhotoWorksMapper.selectFieldsByPrimaryKey(worksId, FieldUtil.codeFields("works_id,clicks"));
                    if (works != null) {
                        works.setClicks((works.getClicks() == null ? 0 : works.getClicks()) + click.getAddClick());
                        shiguPhotoWorksMapper.updateByPrimaryKeySelective(works);
                    }
                }
            } catch (Exception ignore) {
            }
            redisIO.del(key);
        }
    }
}
