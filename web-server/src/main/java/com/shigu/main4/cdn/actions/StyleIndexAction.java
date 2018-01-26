package com.shigu.main4.cdn.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路径:com.shigu.main4.cdn.actions.StyleIndexAction
 * 工程:main-pom
 * 时间:18-1-26上午10:34
 * 创建人:wanghaoxiang
 * 描述：首页风格馆(目前只有杭州男装）
 */
@Controller
public class StyleIndexAction {


    /**
     * 风格商品推荐
     * @return
     */
    @RequestMapping("styleRecommd")
    public String styleRecommd(Long spid) {

        return "styleChannel/styleRecommd";
    }
}
