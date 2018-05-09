package com.shigu.seller.actions;

import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.storeservices.FlickrManageService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.FlickrDetailsVo;
import com.shigu.main4.vo.FlickrHomeVo;
import com.shigu.main4.vo.FlickrVo;
import com.shigu.main4.vo.ShopFlickrsVo;
import com.shigu.seller.bo.ShopFlickrBo;
import com.shigu.seller.services.FlickrService;
import com.shigu.seller.vo.*;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.services.ObjFormFlickrRedis;
import com.shigu.tools.JsonResponseUtil;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    @Autowired
    private CdnService cdnService;

    /**
     * 相册后台首页
     * @param session
     * @param model
     * @return
     */
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

    /**
     * 获取图片上传密钥
     * @param session
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("getAccessForGoodsPic")
    @ResponseBody
    public JSONObject getAccessForGoodsPic(HttpSession session) throws UnsupportedEncodingException {
        ShopSession shopSession = getShopSession(session);
        return JSONObject.fromObject(ossIO.createPostSignInfo("flickrImgs/temp/"+ shopSession.getShopId() + "/")).element("result", "success");
    }

    /**
     * 上传图片
     */
    @RequestMapping("submitUploadPic")
    @ResponseBody
    public JSONObject submitUploadPic (Long id,String imgs,HttpSession session){
        if (flickrService.isUpload(getShopSession(session).getShopId()) == false){
            return JsonResponseUtil.error("内存空间不足！");
        }
        List<String> imgList = new ArrayList<>();
        String[] imgStrs = imgs.split(",");
        String str = null;
        for (int i = 0; i <imgStrs.length ; i++) {
            str = flickrService.banjia(imgStrs[i]);
            imgList.add(str);
        }
        Integer b = flickrManageService.addFlickrPicture(id,imgList);
        if (b ==null || b <=0){
            return JsonResponseUtil.error("添加图片失败");
        }
        return JsonResponseUtil.success();
    }

    /**
     *添加相册
     */
    @RequestMapping("createPhotoAlbum")
    @ResponseBody
    public JSONObject createPhotoAlbum(HttpSession session,String title,String desc,Long cateId){
        ShopSession shopSession = getShopSession(session);
        Integer b = flickrManageService.addFlickr(title,cateId,desc,shopSession.getShopId(),"cs");
        if (b ==null || b <=0){
            return JsonResponseUtil.error("添加相册失败");
        }
        return JsonResponseUtil.success();
    }

    /**
     *保存相册信息
     */
    @RequestMapping("savePhotoAlbumInfo")
    @ResponseBody
    public JSONObject savePhotoAlbumInfo(Long id,String title,String desc,Long cateId){
        Integer b = flickrManageService.updateFlickr(id,title,cateId,desc);
        if (b ==null || b <=0){
            return JsonResponseUtil.error("保存相册失败");
        }
        return JsonResponseUtil.success();
    }


    /**
     *删除相册
     */
    @RequestMapping("removePhotAlbum")
    @ResponseBody
    public JSONObject removePhotAlbum(Long id){
        Integer b = flickrManageService.deleteFlickr(id);
        if (b ==null || b <=0){
            return JsonResponseUtil.error("删除相册失败");
        }
        return JsonResponseUtil.success();
    }

    /**
     *删除图片
     */
    @RequestMapping("deleteGoodsPic")
    @ResponseBody
    public JSONObject deleteGoodsPic(Long goodsPicId){
        Integer b = flickrManageService.deleteFlickrPicture(goodsPicId);
        if (b ==null || b <=0){
            return JsonResponseUtil.error("删除图片失败");
        }
        return JsonResponseUtil.success();
    }

    /**
     * 空间容量
     */
    @RequestMapping("getSizeInfo")
    @ResponseBody
    public JSONObject getSizeInfo( HttpSession session) {
        JSONObject obj= JsonResponseUtil.success();
        Long shopId = getShopSession(session).getShopId();
        String path = "/flickrImgs/"+shopId+"/";
        Double useSize = null;
        if (ossIO.fileExist(path)){
            useSize = ossIO.getFileAllSizeInfo(path).doubleValue();//b为单位
            useSize = useSize/1048576;
        }else{
            useSize = 0.0;
        }
        obj.element("totalSize", 1048576);
        obj.element("useSize", useSize);
        return obj;
    }

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
        return "";
    }

    /**
     * 店铺相册页面
     * @param bo
     * @param model
     * @return
     */
    public String photoShop(ShopFlickrBo bo ,Model model) throws IOException, TemplateException {
        ShiguPager<ShopFlickrsVo> shiguPager = flickrManageService.getFlickrbyShop(bo.getId(),bo.getCid(),bo.getPage(),bo.getRows());
        if (shiguPager.getContent() != null){
            List<ShopFlickrsVo> svoList = shiguPager.getContent();
            for (int i = 0; i < svoList.size(); i++) {
                ShopFlickrsVo shopFlickrsVo = svoList.get(i);
                shopFlickrsVo.setReadCount(Long.valueOf(selFromCache(flickrService.selreadCount(shopFlickrsVo.getId().toString(),shopFlickrsVo.getReadCount())).toString())+flickrService.temporaryClicks(shopFlickrsVo.getId().toString()));
            }
            model.addAttribute("photoAlbums",svoList);
        }
        List<CategoryVo> categroyVos = flickrService.getCategroy();
        CdnShopInfoVO shop = cdnService.cdnShopInfo(bo.getId());
        model.addAttribute("shopInfo",shop);
        model.addAttribute("cates",categroyVos);
        model.addAttribute("pageOption", shiguPager.selPageOption(bo.getRows()));
        return "";
    }

    /**
     * 图片库
     * @param bo
     * @param model
     * @return
     */
    public String photoPics(ShopFlickrBo bo,Model model){
        ShiguPager<FlickrHomeVo> pager = flickrManageService.getFlickrByCategory(bo.getCid(),bo.getPage(),bo.getRows());
        if (pager.getContent() != null){
            List<FlickrHomeVo> flickrHomeVos = pager.getContent();
            for (int i = 0; i <flickrHomeVos.size() ; i++) {
                FlickrHomeVo flickrHomeVo = flickrHomeVos.get(i);
                flickrHomeVo.setReadCount(Long.valueOf(selFromCache(flickrService.selreadCount(flickrHomeVo.getId().toString(),flickrHomeVo.getReadCount())).toString())+flickrService.temporaryClicks(flickrHomeVo.getId().toString()));
            }
            model.addAttribute("photoAlbums",flickrHomeVos);
        }
        List<CategoryVo> categroyVos = flickrService.getCategroy();
        model.addAttribute("cates",categroyVos);
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        return "";
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
