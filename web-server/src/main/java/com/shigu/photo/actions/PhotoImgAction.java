package com.shigu.photo.actions;

import com.shigu.main4.photo.process.PhotoImgProcess;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("photo/")
public class PhotoImgAction {
    @Autowired
    PhotoImgProcess photoImgProcess;

    @RequestMapping({"member/getAccessForPhotoWorks","auth/getAccessForPhotoWorks"})
    @ResponseBody
    public JSONObject selPhotoToken(HttpSession session) throws UnsupportedEncodingException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return JSONObject.fromObject(photoImgProcess.selPhotoToken(ps.getUserId())).element("result", "success");
    }
}
