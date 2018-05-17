package com.shigu.main4.photo.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.photo.beans.*;
import com.opentae.data.photo.examples.*;
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
import com.shigu.photo.utils.ImgUtil;
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
    ShiguPhotoWorksAuthMapper shiguPhotoWorksAuthMapper;
    @Autowired
    ImgUtil imgUtil;
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
        shiguPhotoWorks.setContent(bo.getContent());
        String images = StringUtils.join(bo.getImages().stream()
                .map(s -> photoImgProcess.moveImg(s)).collect(Collectors.toList()), ",");
        String picUrl=photoImgProcess.moveImg(bo.getPicUrl());
        ShiguPhotoWorksAuth auth=new ShiguPhotoWorksAuth();
        auth.setAuthStatus(0);
        auth.setImages(images);
        auth.setPicUrl(picUrl);

        if(bo.getWorksId()==null){
            shiguPhotoWorks.setImages(images);
            shiguPhotoWorks.setPicUrl(picUrl);
            shiguPhotoWorks.setSearchOpen(0);
            shiguPhotoWorksMapper.insertSelective(shiguPhotoWorks);
            auth.setWorksId(shiguPhotoWorks.getWorksId());
            insertAuth(auth,false);
            insertWorksStyles(bo.getStyleId(),shiguPhotoWorks.getWorksId());
        }else{
            shiguPhotoWorks.setWorksId(bo.getWorksId());
            ShiguPhotoWorks tmp=shiguPhotoWorksMapper.selectByPrimaryKey(bo.getWorksId());
            shiguPhotoWorks.setSearchOpen(tmp.getSearchOpen());
            boolean isUpdateImage=false;
            if(tmp.getSearchOpen()==0){
                isUpdateImage=true;
            }
            List<String> newImgaes=new ArrayList<>(Arrays.asList(images.split(",")));
            newImgaes.add(picUrl);
            List<String> oldImages=new ArrayList<>(Arrays.asList(tmp.getImages().split(",")));
            oldImages.add(tmp.getPicUrl());
            newImgaes.removeIf(oldImages::contains);
            if(newImgaes.size()>0){
                isUpdateImage=true;
            }else{
                //获取本次修改中删除掉的图片
                List<String> newImgaes1=new ArrayList<>(Arrays.asList(images.split(",")));
                newImgaes1.add(picUrl);
                List<String> oldImages1=new ArrayList<>(Arrays.asList(tmp.getImages().split(",")));
                oldImages1.add(tmp.getPicUrl());
                oldImages1.removeIf(newImgaes1::contains);
                new HashSet<>(oldImages1).forEach(s -> {
                    imgUtil.addRemove(s);
                });
            }
            if(!isUpdateImage){
                shiguPhotoWorks.setImages(images);
                shiguPhotoWorks.setPicUrl(picUrl);
            }else{
                insertAuth(auth,false);
            }
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

    private void insertAuth(ShiguPhotoWorksAuth auth,boolean isThis){
        ShiguPhotoWorksAuth a=new ShiguPhotoWorksAuth();
        a.setWorksId(auth.getWorksId());
        a=shiguPhotoWorksAuthMapper.selectOne(a);
        if(a==null){
            try {
                shiguPhotoWorksAuthMapper.insertSelective(auth);
            } catch (Exception e) {
                if(!isThis){
                    insertAuth(auth,true);
                }
            }
        }else{
            auth.setWorksAuthId(a.getWorksAuthId());
            shiguPhotoWorksAuthMapper.updateByPrimaryKeySelective(auth);
        }
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
                bo.getSex(),
                bo.getIsAuthor());
        if(count>0){
            pager.setContent(shiguPhotoWorksMapper.selectShiguPhotoWorks(authorId,bo.getStyleId(),bo.getCid(),
                    bo.getUserTypes()!=null?StringUtils.join(bo.getUserTypes(),","):null,
                    bo.getTitle(),
                    bo.getSex(),
                    bo.getIsAuthor(),
                    bo.getSort().getSql(),
                    (bo.getPage() - 1) * bo.getPageSize(),
                    bo.getPageSize()));

            List<ShiguPhotoWorksAuth> auths=new ArrayList<>();
            if(bo.getIsAuthor()){
                List<Long> wids=pager.getContent().stream().map(PhotoWorksVO::getWorksId).collect(Collectors.toList());
                if(wids.size()>0){
                    ShiguPhotoWorksAuthExample shiguPhotoWorksAuthExample=new ShiguPhotoWorksAuthExample();
                    shiguPhotoWorksAuthExample.createCriteria().andWorksIdIn(wids);
                    auths=shiguPhotoWorksAuthMapper.selectByExample(shiguPhotoWorksAuthExample);
                }
            }
            Map<Long,Integer> authMap=auths.stream().collect(Collectors.toMap(ShiguPhotoWorksAuth::getWorksId,ShiguPhotoWorksAuth::getAuthStatus));
            pager.getContent().forEach(photoWorksVO -> {
                photoWorksVO.setAuthStatus(authMap.get(photoWorksVO.getWorksId()));
                if(photoWorksVO.getAuthStatus()==null){
                    photoWorksVO.setAuthStatus(1);
                }
            });
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

    @Override
    public ShiguPager<PhotoWorksAuthVO> selWorksAuths(int pageNo, int size, Integer status) {
        ShiguPhotoWorksAuthExample shiguPhotoWorksAuthExample=new ShiguPhotoWorksAuthExample();
        if(status!=null){
            shiguPhotoWorksAuthExample.createCriteria().andAuthStatusEqualTo(status);
        }
        ShiguPager<PhotoWorksAuthVO> pager=new ShiguPager<>();
        pager.setNumber(pageNo);
        List<PhotoWorksAuthVO> list=new ArrayList<>();
        int count=shiguPhotoWorksAuthMapper.countByExample(shiguPhotoWorksAuthExample);
        if(count>0){
            shiguPhotoWorksAuthExample.setStartIndex((pageNo-1)*size);
            shiguPhotoWorksAuthExample.setEndIndex(size);
            List<ShiguPhotoWorksAuth> shiguPhotoWorksAuths = shiguPhotoWorksAuthMapper.selectByConditionList(shiguPhotoWorksAuthExample);
            list.addAll(shiguPhotoWorksAuths.stream().map(shiguPhotoWorksAuth -> BeanMapper.map(shiguPhotoWorksAuth,PhotoWorksAuthVO.class)).collect(Collectors.toList()));
        }
        pager.setContent(list);
        pager.calPages(count,size);
        return pager;
    }

    @Override
    public void useAuth(Long worksAuthId, String msg, int applyStatus) {
        ShiguPhotoWorksAuth a=shiguPhotoWorksAuthMapper.selectByPrimaryKey(worksAuthId);
        if(applyStatus==1){
            ShiguPhotoWorks w=shiguPhotoWorksMapper.selectByPrimaryKey(a.getWorksId());
            List<String> newImgaes=new ArrayList<>(Arrays.asList(a.getImages().split(",")));
            newImgaes.add(a.getPicUrl());
            List<String> oldImages=new ArrayList<>(Arrays.asList(w.getImages().split(",")));
            oldImages.add(w.getPicUrl());
            oldImages.removeIf(newImgaes::contains);
            new HashSet<>(oldImages).forEach(s -> {
                imgUtil.addRemove(s);
            });
            w.setSearchOpen(1);
            w.setPicUrl(a.getPicUrl());
            w.setImages(a.getImages());
            shiguPhotoWorksMapper.updateByPrimaryKeySelective(w);
        }else{
            a.setMsg(msg);
        }
        a.setAuthStatus(applyStatus);
        shiguPhotoWorksAuthMapper.updateByPrimaryKeySelective(a);
    }
}
