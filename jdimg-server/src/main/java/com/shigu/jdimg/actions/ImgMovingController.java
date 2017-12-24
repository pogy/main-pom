package com.shigu.jdimg.actions;


import com.openJar.requests.imgs.JdUpImgRequest;
import com.shigu.jdimg.services.ImgMovingService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




/**
 * Created By admin on 2017/12/22/13:30
 */
@Controller
@RequestMapping("jdImgApi/")
public class ImgMovingController {

    @Autowired
    private ImgMovingService imgMovingService;

    /**
     * 取得手机详情
     * @param
     * @return
     */
    @RequestMapping("wapdesc")
    @ResponseBody
    public JSONObject wapdesc(){

        return null;
    }

    /**
     * 上传属性图

     */
    @RequestMapping("uptopropimg")
    @ResponseBody
    public JSONObject uptopropimg()  {

        return new JSONObject().element("success",true);
    }

    /**
     * 上传一张商品图
     * @return
     */
    @RequestMapping("uptoitemimg")
    @ResponseBody
    public JSONObject uptoitemimg(JdUpImgRequest request){
        imgMovingService.imgUpload(request.getUserId(),request.getImgUrls());
        return null;
    }

    /**
     * 通过接口请求一键搬家的
     * @param
     * @return
     */
    @RequestMapping("uptoimgs")
    @ResponseBody
    public JSONObject uptoImgs() {

        return null;
    }

}
