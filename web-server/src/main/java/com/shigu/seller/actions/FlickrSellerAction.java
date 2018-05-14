package com.shigu.seller.actions;

import com.shigu.main4.storeservices.FlickrManageService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.FlickrPicInfoVo;
import com.shigu.main4.vo.FlickrVo;
import com.shigu.seller.services.FlickrService;
import com.shigu.seller.vo.CategoryVo;
import com.shigu.seller.vo.PhotoAlbumVo;
import com.shigu.seller.vo.QueryVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.services.ObjFormFlickrRedis;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.actions
 * @ClassName: FlickrSellerAction
 * @Author: sy
 * @CreateDate: 2018/5/11 0011 14:26
 */
@Controller
@RequestMapping
public class FlickrSellerAction {
    @Autowired
    private FlickrManageService flickrManageService;
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private OssIO ossIO;

    /**
     * 相册后台首页
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("seller/photoAlbumManagement")
    public String photoAlbumManagement(HttpSession session, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<FlickrVo> flickrVos = flickrManageService.getStroeFlickrbyStoreId(ps.getLogshop().getShopId());
        List<PhotoAlbumVo> photoAlbumVoList = new ArrayList<>();
        if (flickrVos != null && flickrVos.size() > 0){
            flickrVos.forEach(flickrVo -> {
                PhotoAlbumVo vo = new PhotoAlbumVo();
                vo.setId(flickrVo.getfId());
                vo.setCateId(flickrVo.getcId());
                vo.setCreated(flickrVo.getCreateTime());
                vo.setImgSrc(flickrVo.getCover());
                vo.setPicCount(flickrVo.getNumber());
                vo.setTitle(flickrVo.getName());
                vo.setDesc(flickrVo.getDesc());
                vo.setReadCount(Long.valueOf(selFromCache(flickrService.selreadCount(flickrVo.getfId().toString(),flickrVo.getClicks())).toString())+flickrService.temporaryClicks(flickrVo.getfId().toString()));
                photoAlbumVoList.add(vo);
            });
        }
        List<CategoryVo> categroyVos = flickrService.getCategroy();
        JSONArray jsonArray = JSONArray.fromObject(categroyVos);
        model.addAttribute("cates",jsonArray.toString());
        model.addAttribute("photoAlbums",photoAlbumVoList);
        model.addAttribute("disabledGoodsAblumSpaceSize",true);
        return "gys/photoAlbumManagement";
    }

    /**
     * 商家后台相册详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("seller/photoAlbumItem")
    public String photoAlbumItem(Long id ,Model model){
        FlickrPicInfoVo flickrPicInfoVo = flickrManageService.getFlickrPictureList(id);
        QueryVo queryVo = new QueryVo();
        queryVo.setId(id);
        model.addAttribute("photoAlbumInfo", flickrPicInfoVo);
        model.addAttribute("query",queryVo);
        model.addAttribute("disabledGoodsAblumSpaceSize",true);
        return "gys/photoAlbumItem";
    }

    /**
     * 获取图片上传密钥
     * @param session
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("seller/getAccessForGoodsPic")
    @ResponseBody
    public JSONObject getAccessForGoodsPic(HttpSession session) throws UnsupportedEncodingException {
        ShopSession shopSession = getShopSession(session);
        return JSONObject.fromObject(ossIO.createPostSignInfo("flickrImgs/temp/"+ shopSession.getShopId() + "/")).element("result", "success");
    }

    /**
     * 上传图片
     */
    @RequestMapping("seller/submitUploadPic")
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
    @RequestMapping("seller/createPhotoAlbum")
    @ResponseBody
    public JSONObject createPhotoAlbum(HttpSession session,String title,String desc,Long cateId){
        if (StringUtils.isBlank(title)){
            return JsonResponseUtil.error("相册标题不能为空");
        }
        if (StringUtils.isBlank(desc)){
            return JsonResponseUtil.error("相册说明不能为空");
        }
        if (cateId==null){
            return JsonResponseUtil.error("相册类别不能为空");
        }
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
    @RequestMapping("seller/savePhotoAlbumInfo")
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
    @RequestMapping("seller/removePhotAlbum")
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
    @RequestMapping("seller/deleteGoodsPic")
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
    @RequestMapping("seller/getPicSizeInfo")
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
