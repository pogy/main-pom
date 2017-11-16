package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.shigu.api.exceptions.SystemException;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.spread.bo.TrademarkApplyBO;
import com.shigu.main4.spread.service.TrademarkService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.basebo.TrademarkRegistBO;
import com.shigu.phone.basevo.UserWinningInfo;
import com.shigu.phone.waps.service.WapPhoneUserService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("waps/")
public class IndexAction {

    @RequestMapping("index")
    public String getUserWinningInfoList() throws OpenException {
        return "waps/index";
    }

}
