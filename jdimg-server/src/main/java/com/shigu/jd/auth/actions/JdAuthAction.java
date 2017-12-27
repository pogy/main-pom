package com.shigu.jd.auth.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

/**
 * Created By admin on 2017/12/25/10:46
 */
@Controller
@RequestMapping("zs")
public class JdAuthAction {

    /**
     * 京东CODE回调
     * @param state
     * @param code
     * @return
     * @throws IOException
     */
    @RequestMapping("callback")
    public String jdCallback(String code, String state) {
//        return "redirect:http://www.571xz.com/jd/callback.htm?code="+code+"&state="+state;
        return "redirect:http://www.571xz.com/jd/callback.htm?code="+code+"&state="+state;
    }


}
