package com.shigu.photo.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.photo.beans.ShiguPhotoUser;
import com.opentae.data.photo.beans.ShiguPhotoWorksStyle;
import com.opentae.data.photo.beans.ShiguPhotoWorks;
import com.opentae.data.photo.examples.ShiguPhotoCatExample;
import com.opentae.data.photo.examples.ShiguPhotoStyleExample;
import com.opentae.data.photo.examples.ShiguPhotoUserExample;
import com.opentae.data.photo.examples.ShiguPhotoWorksExample;
import com.opentae.data.photo.interfaces.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.SynPhotoUploadBO;
import com.shigu.photo.process.PhotoImgProcess;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.vo.PhotoCatVO;
import com.shigu.photo.vo.PhotoStyleVO;
import com.shigu.photo.vo.PhotoWorksVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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

    @Override
    public List<PhotoStyleVO> selPhotoStyleVos(Long userId) {
        List<Long> userIds= Collections.singletonList(-1L);
        if(userId!=null){
            userIds.add(userId);
        }
        ShiguPhotoStyleExample shiguPhotoStyleExample=new ShiguPhotoStyleExample();
        shiguPhotoStyleExample.createCriteria().andUserIdIn(userIds);
        shiguPhotoStyleExample.setOrderByClause("user_id asc,style_id asc");
        return BeanMapper.mapList(shiguPhotoStyleMapper.selectByExample(shiguPhotoStyleExample),PhotoStyleVO.class);
    }

    @Override
    public List<PhotoCatVO> selPhotoCatVos() {
        return BeanMapper.mapList(shiguPhotoCatMapper.selectByExample(new ShiguPhotoCatExample()),PhotoCatVO.class);
    }

    @Override
    public void uploadWorks(SynPhotoUploadBO bo) {
        ShiguPhotoWorks shiguPhotoWorks=new ShiguPhotoWorks();
        shiguPhotoWorks.setAuthorId(bo.getUserId());
        shiguPhotoWorks.setClicks(0L);
        shiguPhotoWorks.setCreateTime(new Date());
        shiguPhotoWorks.setForbidSave(bo.getForbidSave()==1);
        shiguPhotoWorks.setHavePrice(bo.getHavePrice()==1);
        shiguPhotoWorks.setLastModifyTme(shiguPhotoWorks.getCreateTime());
        shiguPhotoWorks.setPrice(shiguPhotoWorks.getHavePrice()? MoneyUtil.StringToLong(bo.getPriceString()):null);
        shiguPhotoWorks.setRemoveIs(false);
        shiguPhotoWorks.setTitle(bo.getTitle());
        shiguPhotoWorks.setWorksCid(bo.getCid());
        shiguPhotoWorks.setPicUrl(bo.getPicUtl());
        String images= StringUtils.join(bo.getImages().stream()
                .map(s -> photoImgProcess.moveImg(s)).collect(Collectors.toList()), ",");
        shiguPhotoWorks.setImages(images);
        shiguPhotoWorksMapper.insertSelective(shiguPhotoWorks);
        List<ShiguPhotoWorksStyle> shiguPhotoWorksStyles=new ArrayList<>();
        for(Long styleId:bo.getStyleId()){
            ShiguPhotoWorksStyle shiguPhotoWorksStyle=new ShiguPhotoWorksStyle();
            shiguPhotoWorksStyle.setStyleId(styleId);
            shiguPhotoWorksStyle.setWorksId(shiguPhotoWorks.getWorksId());
            shiguPhotoWorksStyles.add(shiguPhotoWorksStyle);
        }
        if(shiguPhotoWorksStyles.size()>0){
            shiguPhotoWorksStyleMapper.insertListNoId(shiguPhotoWorksStyles);
        }
    }

    @Override
    public ShiguPager<PhotoWorksVO> selPhotoWorksVos(PhotoWorksBO bo) {
        ShiguPager<PhotoWorksVO> pager=new ShiguPager<>();
        pager.setNumber(bo.getPage());
        ShiguPhotoWorksExample shiguPhotoWorksExample=new ShiguPhotoWorksExample();
        if(bo.getSort()!=null&&bo.getSort().getSql()!=null){
            shiguPhotoWorksExample.setOrderByClause(bo.getSort().getSql());
        }
        ShiguPhotoWorksExample.Criteria criteria = shiguPhotoWorksExample.createCriteria();
        if(bo.getAuthorId()!=null){
            criteria.andAuthorIdEqualTo(bo.getAuthorId());
        }else{
            if(bo.getStyleId()!=null){
                ShiguPhotoUserExample shiguPhotoUserExample=new ShiguPhotoUserExample();
                shiguPhotoUserExample.createCriteria().andUserTypeEqualTo(bo.getUserType());
                List<ShiguPhotoUser> us=shiguPhotoUserMapper.selectFieldsByExample(shiguPhotoUserExample, FieldUtil.codeFields("photo_user_id,user_id"));
                if(us.size()==0){
                    pager.calPages(0,10);
                    pager.setContent(new ArrayList<>());
                    return pager;
                }
                criteria.andAuthorIdIn(BeanMapper.getFieldList(us,"userId",Long.class));
            }
        }


        return null;
    }
}
