package com.shigu.jd.img.actions;


import com.openJar.requests.imgs.JdUpImgRequest;
import com.shigu.exceptions.JdAuthFailureException;
import com.shigu.jd.img.services.ImgMovingService;
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
     * 上传属性图
     * @return
     */
    @RequestMapping("uptoitemimg")
    @ResponseBody
    public JSONObject uptoitemimg(JdUpImgRequest request) throws JdAuthFailureException {

        return JSONObject.fromObject(imgMovingService.imgUpload(request));
    }

}
