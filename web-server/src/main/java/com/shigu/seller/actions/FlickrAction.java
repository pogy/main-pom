package com.shigu.seller.actions;

import com.shigu.main4.storeservices.FlickrManageService;
import com.shigu.main4.vo.FlickrVo;
import com.shigu.seller.vo.PhotoAlbumVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.services.ObjFromCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.actions
 * @ClassName: FlickrAction
 * @Author: sy
 * @CreateDate: 2018/5/3 0003 19:21
 */

@RequestMapping("flickr/")
public class FlickrAction {

    @Autowired
    private FlickrManageService flickrManageService;

    @RequestMapping("flickrBackground")
    public String flickrBackground(HttpSession session, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<FlickrVo> flickrVos = flickrManageService.getStroeFlickrbyStoreId(ps.getLogshop().getShopId());
        if (flickrVos.size() > 0){
            List<PhotoAlbumVo> photoAlbumVoList = new ArrayList<>();
            flickrVos.forEach(flickrVo -> {
                PhotoAlbumVo vo = new PhotoAlbumVo();
                vo.setId(flickrVo.getfId());
                vo.setCateId(flickrVo.getcId());
                vo.setCreated(flickrVo.getCreateTime());
                vo.setImgSrc(flickrVo.getCover());
                vo.setPicCount(flickrVo.getNumber());
                vo.setTitle(flickrVo.getName());
                vo.setReadCount(selFromCache());
            });

        }
        return null;
    }




    /**
     * 创建缓存
     *
     * @param fromCache
     */
    private Object selFromCache(ObjFromCache fromCache) {
        return fromCache.selObj();
    }
}
