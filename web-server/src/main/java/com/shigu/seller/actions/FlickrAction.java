package com.shigu.seller.actions;

import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.storeservices.FlickrManageService;
import com.shigu.main4.vo.FlickrDetailsVo;
import com.shigu.main4.vo.FlickrHomeVo;
import com.shigu.main4.vo.ShopFlickrsVo;
import com.shigu.seller.bo.CateFlickrBo;
import com.shigu.seller.bo.ShopFlickrBo;
import com.shigu.seller.services.FlickrService;
import com.shigu.seller.vo.CategoryVo;
import com.shigu.seller.vo.PhotoAlbumInfoVo;
import com.shigu.seller.vo.PicVo;
import com.shigu.seller.vo.QueryVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.services.ObjFormFlickrRedis;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.actions
 * @ClassName: FlickrAction
 * @Author: sy
 * @CreateDate: 2018/5/3 0003 19:21
 */
@Controller
public class FlickrAction {

    @Autowired
    private FlickrManageService flickrManageService;
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private CdnService cdnService;


    /**
     * 图片详情页面
     * @param id
     * @param model
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    @RequestMapping("photoItem")
    public String photoItem(Long id,Model model) throws IOException, TemplateException {
        FlickrDetailsVo fVo = flickrManageService.getFlickrShow(id);
        PhotoAlbumInfoVo vo = new PhotoAlbumInfoVo();
        List<PicVo> picVos = new ArrayList<>();
        vo.setDesc(fVo.getDesc());
        vo.setPicCount(fVo.getNumber());
        vo.setTitle(fVo.getName());
        if (fVo.getPictures() != null && fVo.getPictures().size() > 0){
            for (int i = 0; i <fVo.getPictures().size() ; i++) {
                PicVo picVo = new PicVo();
                picVo.setImgSrc(fVo.getPictures().get(i).getPicUrl());
                picVo.setUploadTime(fVo.getPictures().get(i).getCreateTime());
                picVos.add(picVo);
            }
        }
        vo.setPics(picVos);
        CdnShopInfoVO shop = cdnService.cdnShopInfo(fVo.getStoreId());
        model.addAttribute("shopInfo",shop);
        model.addAttribute("photoAlbumInfo",vo);
        return "goodsDetail/photoItem";
    }

    /**
     * 店铺相册页面
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("photoShop")
    public String photoShop(ShopFlickrBo bo ,Model model) throws IOException, TemplateException {
        ShiguPager<ShopFlickrsVo> shiguPager = flickrManageService.getFlickrbyShop(bo.getId(),bo.getCid(),bo.getPage(),bo.getRows());
        if (shiguPager.getContent() != null && shiguPager.getContent().size()>0){
            List<ShopFlickrsVo> svoList = shiguPager.getContent();
            for (int i = 0; i < svoList.size(); i++) {
                ShopFlickrsVo shopFlickrsVo = svoList.get(i);
                shopFlickrsVo.setReadCount(Long.valueOf(selFromCache(flickrService.selreadCount(shopFlickrsVo.getId().toString(),shopFlickrsVo.getReadCount())).toString())+flickrService.temporaryClicks(shopFlickrsVo.getId().toString()));
            }
            model.addAttribute("photoAlbums",svoList);
        }
        if (bo.getCid() != null) {
            QueryVo q = new QueryVo();
            q.setCid(bo.getCid());
            model.addAttribute("query", q);
        }
        List<CategoryVo> categroyVos = flickrService.getCategroy();
        CdnShopInfoVO shop = cdnService.cdnShopInfo(bo.getId());
        model.addAttribute("shopInfo",shop);
        model.addAttribute("cates",categroyVos);
        model.addAttribute("pageOption", shiguPager.selPageOption(bo.getRows()));
        model.addAttribute("webSite","cs");
        return "goodsDetail/photoShop";
    }

    /**
     * 图片库
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("photoPics")
    public String photoPics(CateFlickrBo bo, Model model){
        ShiguPager<FlickrHomeVo> pager = flickrManageService.getFlickrByCategory(bo.getCid(),bo.getPage(),bo.getRows());
        if (pager.getContent() != null && pager.getContent().size()>0){
            List<FlickrHomeVo> flickrHomeVos = pager.getContent();
            for (int i = 0; i <flickrHomeVos.size() ; i++) {
                FlickrHomeVo flickrHomeVo = flickrHomeVos.get(i);
                flickrHomeVo.setReadCount(Long.valueOf(selFromCache(flickrService.selreadCount(flickrHomeVo.getId().toString(),flickrHomeVo.getReadCount())).toString())+flickrService.temporaryClicks(flickrHomeVo.getId().toString()));
            }
            model.addAttribute("photoAlbums",flickrHomeVos);
        }else {
            model.addAttribute("photoAlbums",new ArrayList<>());
        }
        if (bo.getCid() != null) {
            QueryVo q = new QueryVo();
            q.setCid(bo.getCid());
            model.addAttribute("query", q);
        }
        List<CategoryVo> categroyVos = flickrService.getCategroy();
        model.addAttribute("cates",categroyVos);
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        model.addAttribute("webSite","cs");
        return "search/photoPics";
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

}
