package com.shigu.seller.actions;

import com.shigu.main4.storeservices.FlickrManageService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.FlickrVo;
import com.shigu.seller.services.FlickrService;
import com.shigu.seller.vo.PhotoAlbumVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.services.ObjFormFlickrRedis;
import com.shigu.spread.services.ObjFromCache;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
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
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private OssIO ossIO;

    @RequestMapping("flickrBackground")
    public String flickrBackground(HttpSession session, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<FlickrVo> flickrVos = flickrManageService.getStroeFlickrbyStoreId(ps.getLogshop().getShopId());
        List<PhotoAlbumVo> photoAlbumVoList = new ArrayList<>();
        if (flickrVos.size() > 0){
            flickrVos.forEach(flickrVo -> {
                PhotoAlbumVo vo = new PhotoAlbumVo();
                vo.setId(flickrVo.getfId());
                vo.setCateId(flickrVo.getcId());
                vo.setCreated(flickrVo.getCreateTime());
                vo.setImgSrc(flickrVo.getCover());
                vo.setPicCount(flickrVo.getNumber());
                vo.setTitle(flickrVo.getName());
                vo.setReadCount(Long.valueOf(selFromCache(flickrService.selreadCount(flickrVo.getfId().toString(),flickrVo.getClicks())).toString())+flickrService.temporaryClicks(flickrVo.getfId().toString()));
                photoAlbumVoList.add(vo);
            });
        }
        model.addAttribute("photoAlbums",photoAlbumVoList);
        return null;
    }

    public JSONObject getAccessForGoodsPic(HttpSession session) throws UnsupportedEncodingException {
        ShopSession shopSession = getShopSession(session);
        return JSONObject.fromObject(ossIO.createPostSignInfo("flickrImgs/temp/"+ shopSession.getShopId() + "/")).element("result", "success");
    }




    /**
     * 创建缓存
     *
     * @param flickrRedis
     */
    private Object selFromCache(ObjFormFlickrRedis flickrRedis) {
        return flickrRedis.selObj();
    }

    /**
     * 当前登陆的session
     *
     * @param session
     * @return
     */
    private ShopSession getShopSession(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getLogshop();
    }

    /**
     * 移动图片
     */
}
