package com.shigu.main4.photo.process.impl;

import com.opentae.data.photo.beans.*;
import com.opentae.data.photo.examples.*;
import com.opentae.data.photo.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.photo.process.PhotoGoatProcess;
import com.shigu.main4.photo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("photoGoatProcess")
public class PhotoGoatProcessImpl implements PhotoGoatProcess {
    @Autowired
    ShiguPhotoGoatPlaceMapper shiguPhotoGoatPlaceMapper;
    @Autowired
    ShiguPhotoGoatBannerMapper shiguPhotoGoatBannerMapper;
    @Autowired
    ShiguPhotoGoatNavMapper shiguPhotoGoatNavMapper;
    @Autowired
    ShiguPhotoWorksMapper shiguPhotoWorksMapper;
    @Autowired
    ShiguPhotoStyleMapper shiguPhotoStyleMapper;
    @Autowired
    ShiguPhotoUserMapper shiguPhotoUserMapper;
    @Override
    public List<GoatMenuVO> selMenus() {
        //准备一级类目
        ShiguPhotoGoatNavExample shiguPhotoGoatNavExample=new ShiguPhotoGoatNavExample();
        shiguPhotoGoatNavExample.createCriteria().andParentNavIdEqualTo(0L);
        List<ShiguPhotoGoatNav> shiguPhotoGoatNavs = shiguPhotoGoatNavMapper.selectByExample(shiguPhotoGoatNavExample);
        Map<Integer,List<ShiguPhotoGoatNav>> map=BeanMapper.groupBy(shiguPhotoGoatNavs,"pageGuide",Integer.class);
        //准备二级类目
        shiguPhotoGoatNavExample.clear();
        shiguPhotoGoatNavExample.createCriteria().andParentNavIdNotEqualTo(0L);
        List<ShiguPhotoGoatNav> subShiguPhotoGoatNavs = shiguPhotoGoatNavMapper.selectByExample(shiguPhotoGoatNavExample);
        Map<Long,List<ShiguPhotoGoatNav>> subMap= BeanMapper.groupBy(subShiguPhotoGoatNavs,"parentNavId",Long.class);
        //准备风格数据
        List<Long> styleIds=subShiguPhotoGoatNavs.stream().filter(shiguPhotoGoatNav -> shiguPhotoGoatNav.getPageGuide()==1)
                .map(ShiguPhotoGoatNav::getTargetId).collect(Collectors.toList());
        Map<Long,String> styleMap=new HashMap<>();
        if(styleIds.size()>0){
            ShiguPhotoStyleExample shiguPhotoStyleExample=new ShiguPhotoStyleExample();
            shiguPhotoStyleExample.createCriteria().andStyleIdIn(styleIds);
            List<ShiguPhotoStyle> styles=shiguPhotoStyleMapper.selectByExample(shiguPhotoStyleExample);
            styleMap=styles.stream().collect(Collectors.toMap(ShiguPhotoStyle::getStyleId, ShiguPhotoStyle::getStyleName));
        }
        //准备作者数据
        List<Long> authorIds=subShiguPhotoGoatNavs.stream().filter(shiguPhotoGoatNav -> shiguPhotoGoatNav.getPageGuide()==2)
                .map(ShiguPhotoGoatNav::getTargetId).collect(Collectors.toList());
        Map<Long,String> userMap=new HashMap<>();
        if(authorIds.size()>0){
            ShiguPhotoUserExample shiguPhotoUserExample=new ShiguPhotoUserExample();
            shiguPhotoUserExample.createCriteria().andAuthorIdIn(authorIds);
            List<ShiguPhotoUser> shiguPhotoUsers = shiguPhotoUserMapper.selectByExample(shiguPhotoUserExample);
            userMap=shiguPhotoUsers.stream().collect(Collectors.toMap(ShiguPhotoUser::getAuthorId,ShiguPhotoUser::getUserName));
        }


        List<GoatMenuVO> goatMenuVOS=new ArrayList<>();
        //1.处理商品型
        List<ShiguPhotoGoatNav> list=map.get(1);
        if(list!=null&&list.size()>0){
            toMenuVOS(goatMenuVOS,list,styleMap,subMap);
        }
        //2.手动添加摄影机构
        GoatMenuVO vo=new GoatMenuVO();
        vo.setMenuId("photoOrg");
        vo.setMenuText("摄影机构");
        vo.setItems(new ArrayList<>());
        vo.getItems().add(new GoatMenuSubVO(2L,"摄影师"));
        vo.getItems().add(new GoatMenuSubVO(3L,"摄影公司"));
        goatMenuVOS.add(vo);
        //3.手动添加模特
        GoatMenuVO vo1=new GoatMenuVO();
        vo1.setMenuId("photoModel");
        vo1.setMenuText("网红模特");
        vo1.setItems(new ArrayList<>());
        vo1.getItems().add(new GoatMenuSubVO(0L,"男模"));
        vo1.getItems().add(new GoatMenuSubVO(1L,"女模"));
        goatMenuVOS.add(vo1);

        //4.添加作者
        List<ShiguPhotoGoatNav> shiguPhotoGoatNavs1=map.get(2);
        if(shiguPhotoGoatNavs1!=null&&shiguPhotoGoatNavs1.size()>0){
            toMenuVOS(goatMenuVOS,shiguPhotoGoatNavs1,userMap,subMap);
        }
        return goatMenuVOS;
    }
    private void toMenuVOS(List<GoatMenuVO> goatMenuVOS, List<ShiguPhotoGoatNav> list, Map<Long, String> finalMap, Map<Long,List<ShiguPhotoGoatNav>> subMap){
        list.forEach(shiguPhotoGoatNav -> {
            List<ShiguPhotoGoatNav> subs=subMap.get(shiguPhotoGoatNav.getNavId());
            if(subs==null||subs.size()==0){
                return;
            }
            GoatMenuVO vo=new GoatMenuVO();
            vo.setMenuId(shiguPhotoGoatNav.getPageGuide()==1?"photoWorks":"userHomePage");
            vo.setMenuText(shiguPhotoGoatNav.getNavName());
            vo.setItems(new ArrayList<>());
            for(ShiguPhotoGoatNav sub:subs){
                if(finalMap.get(sub.getTargetId())==null){
                    continue;
                }
                GoatMenuSubVO goatMenuSubVO=new GoatMenuSubVO();
                goatMenuSubVO.setId(sub.getTargetId());
                goatMenuSubVO.setText(finalMap.get(sub.getTargetId()));
                vo.getItems().add(goatMenuSubVO);
            }
            goatMenuVOS.add(vo);
        });
    }

    @Override
    public List<GoatBannerVO> selBanner() {
        ShiguPhotoGoatBannerExample shiguPhotoGoatBannerExample=new ShiguPhotoGoatBannerExample();
        shiguPhotoGoatBannerExample.createCriteria().andPlaceNotEqualTo(-1);
        shiguPhotoGoatBannerExample.setOrderByClause("place asc");
        return shiguPhotoGoatBannerMapper.selectByExample(shiguPhotoGoatBannerExample)
                .stream().map(shiguPhotoGoatBanner -> {
                    GoatBannerVO vo=new GoatBannerVO();
                    vo.setHref(shiguPhotoGoatBanner.getUrl());
                    vo.setImgsrc(shiguPhotoGoatBanner.getBanner());
                    return vo;
                }).collect(Collectors.toList());
    }

    @Override
    public String selRightImg() {
        ShiguPhotoGoatBanner shiguPhotoGoatBanner=new ShiguPhotoGoatBanner();
        shiguPhotoGoatBanner.setPlace(-1);
        try {
            shiguPhotoGoatBanner = shiguPhotoGoatBannerMapper.selectOne(shiguPhotoGoatBanner);
            return shiguPhotoGoatBanner.getBanner();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<GoatAuthorVO> selModel() {
        return selAuthorId(2);
    }

    @Override
    public List<GoatAuthorVO> selOff() {
        return selAuthorId(3);
    }


    private List<GoatAuthorVO> selAuthorId(Integer pageGuide){
        ShiguPhotoGoatPlaceExample shiguPhotoGoatPlaceExample=new ShiguPhotoGoatPlaceExample();
        shiguPhotoGoatPlaceExample.createCriteria().andPageGuideEqualTo(pageGuide);
        shiguPhotoGoatPlaceExample.setOrderByClause("place asc");
        List<ShiguPhotoGoatPlace> shiguPhotoGoatPlaces = shiguPhotoGoatPlaceMapper.selectByExample(shiguPhotoGoatPlaceExample);
        if(shiguPhotoGoatPlaces.size()==0){
            return new ArrayList<>();
        }
        List<Long> worksIds=shiguPhotoGoatPlaces.stream().map(ShiguPhotoGoatPlace::getWorksId).collect(Collectors.toList());
        ShiguPhotoWorksExample shiguPhotoWorksExample=new ShiguPhotoWorksExample();
        shiguPhotoWorksExample.createCriteria().andWorksIdIn(worksIds);
        List<ShiguPhotoWorks> shiguPhotoWorks = shiguPhotoWorksMapper.selectByExample(shiguPhotoWorksExample);
        if(shiguPhotoWorks.size()==0){
            return new ArrayList<>();
        }
        Map<Long,ShiguPhotoWorks> map=shiguPhotoWorks.stream().collect(Collectors.toMap(ShiguPhotoWorks::getWorksId,o->o));

        List<Long> aids=shiguPhotoWorks.stream().map(ShiguPhotoWorks::getAuthorId).collect(Collectors.toList());
        ShiguPhotoUserExample shiguPhotoUserExample=new ShiguPhotoUserExample();
        shiguPhotoUserExample.createCriteria().andAuthorIdIn(aids);
        List<ShiguPhotoUser> shiguPhotoUsers=shiguPhotoUserMapper.selectByExample(shiguPhotoUserExample);
        if(shiguPhotoUsers.size()==0){
            return new ArrayList<>();
        }
        Map<Long,ShiguPhotoUser> userMap=shiguPhotoUsers.stream().collect(Collectors.toMap(ShiguPhotoUser::getAuthorId,o->o));


        return shiguPhotoGoatPlaces.stream().map(shiguPhotoGoatPlace -> {
            GoatAuthorVO vo=new GoatAuthorVO();
            ShiguPhotoWorks w=map.get(shiguPhotoGoatPlace.getWorksId());
            ShiguPhotoUser u=userMap.get(w.getAuthorId());
            vo.setAddress(u.getAddress());
            vo.setHeadImgSrc(u.getHeadImg());
            vo.setImgsrc(w.getPicUrl());
            vo.setUserId(u.getUserId());
            vo.setUserNick(u.getUserName());
            vo.setWorksId(w.getWorksId());
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PhotoWorksVO> selWorks() {
        ShiguPhotoGoatPlaceExample shiguPhotoGoatPlaceExample=new ShiguPhotoGoatPlaceExample();
        shiguPhotoGoatPlaceExample.createCriteria().andPageGuideEqualTo(1);
        shiguPhotoGoatPlaceExample.setOrderByClause("place asc");
        List<ShiguPhotoGoatPlace> shiguPhotoGoatPlaces = shiguPhotoGoatPlaceMapper.selectByExample(shiguPhotoGoatPlaceExample);
        if(shiguPhotoGoatPlaces.size()==0){
            return new ArrayList<>();
        }
        List<Long> worksIds=shiguPhotoGoatPlaces.stream().map(ShiguPhotoGoatPlace::getWorksId).collect(Collectors.toList());
        ShiguPhotoWorksExample shiguPhotoWorksExample=new ShiguPhotoWorksExample();
        shiguPhotoWorksExample.createCriteria().andWorksIdIn(worksIds);
        List<ShiguPhotoWorks> shiguPhotoWorks = shiguPhotoWorksMapper.selectByExample(shiguPhotoWorksExample);
        if(shiguPhotoWorks.size()==0){
            return new ArrayList<>();
        }
        Map<Long,ShiguPhotoWorks> map=shiguPhotoWorks.stream().collect(Collectors.toMap(ShiguPhotoWorks::getWorksId,o->o));

        List<Long> aids=shiguPhotoWorks.stream().map(ShiguPhotoWorks::getAuthorId).collect(Collectors.toList());
        ShiguPhotoUserExample shiguPhotoUserExample=new ShiguPhotoUserExample();
        shiguPhotoUserExample.createCriteria().andAuthorIdIn(aids);
        List<ShiguPhotoUser> shiguPhotoUsers=shiguPhotoUserMapper.selectByExample(shiguPhotoUserExample);
        if(shiguPhotoUsers.size()==0){
            return new ArrayList<>();
        }
        Map<Long,ShiguPhotoUser> userMap=shiguPhotoUsers.stream().collect(Collectors.toMap(ShiguPhotoUser::getAuthorId,o->o));

        return shiguPhotoGoatPlaces.stream().map(shiguPhotoGoatPlace -> {
            PhotoWorksVO vo=new PhotoWorksVO();
            ShiguPhotoWorks w=map.get(shiguPhotoGoatPlace.getWorksId());
            ShiguPhotoUser u=userMap.get(w.getAuthorId());
            vo.setAddress(u.getAddress());
            vo.setWorksId(w.getWorksId());
            vo.setAuthorId(u.getAuthorId());
            vo.setAuthorName(u.getUserName());
            vo.setContent(w.getContent());
            vo.setCreateTime(w.getCreateTime());
            vo.setPicUrl(w.getPicUrl());
            vo.setSex(u.getSex());
            vo.setTitle(w.getTitle());
            vo.setUserType(u.getUserType());
            return vo;
        }).collect(Collectors.toList());

    }
}
