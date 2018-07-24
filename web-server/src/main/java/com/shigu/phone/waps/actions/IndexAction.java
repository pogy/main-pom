package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
