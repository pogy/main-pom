package com.shigu.seller.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.seller.services.GoodsFileService;
import com.shigu.seller.services.VideoService;
import com.shigu.seller.vo.VideoFileVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("seller/")
public class VideoSpaceAction {

    @Autowired
    VideoService videoService;

    @RequestMapping("videoSpace")
    public String videoSpace(Map<String,Object> map,HttpSession session){
        List<VideoFileVo> list=videoService.selFilesByVid(logshop(session).getShopId(),null);
//        List<VideoFileVo> list=new ArrayList<>();
        map.put("videoList",list);
        return "gys/videoSpace";
    }

    @RequestMapping("setNewVideoTitle")
    @ResponseBody
    public JSONObject renameFile(String vid, String newTitle, HttpSession session) throws JsonErrException {
        if (!videoService.checkFileId(vid) || !videoService.checkFileId(newTitle)) {
            throw new JsonErrException("key信息异常");
        }
        videoService.rename(logshop(session).getShopId(),vid, "other", newTitle);

        return JsonResponseUtil.success();
    }

    /**
     * 得到当前登陆的店铺
     * @param session
     * @return
     */
    private ShopSession logshop(HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getLogshop();
    }


    /**
     * 删除文件
     * @param vid
     * @return
     */
    @RequestMapping("deleteVideo")
    @ResponseBody
    public JSONObject deleteFile(String vid,HttpSession session) throws JsonErrException {
        if (!videoService.checkFileId(vid)) {
            throw new JsonErrException("key信息异常");
        }
        if(videoService.deleteFile(logshop(session).getShopId(),vid, "other")){
            return JsonResponseUtil.success();
        }
        throw new JsonErrException("删除文件失败");
    }

    /**
     * 通知服务器创建文件成功并返回文件信息
     * @return
     */
    @RequestMapping("setVideoFile")
    @ResponseBody
    public JSONObject noticeUploadFile(String fileName,HttpSession session) throws JsonErrException {
        if (!videoService.checkFileId(fileName)) {
            throw new JsonErrException("key信息异常");
        }
        VideoFileVo vo=videoService.upload(logshop(session).getShopId(),fileName);
        return JSONObject.fromObject(vo).element("result","success");
    }

}
