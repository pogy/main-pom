package com.shigu.phone.apps.actions;


import com.openJar.requests.app.ShopSearchRequest;
import com.openJar.responses.app.ShopSearchResponse;
import com.shigu.phone.services.PhoneSearchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：AppSearchAction
 * 类路径：com.shigu.phone.apps.actions.AppSearchAction
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:24
 * 项目：main-pom
 * 描述：app搜索
 */
@Controller
@RequestMapping("/app/")
public class AppSearchAction {

    @Autowired
    private PhoneSearchService phoneSearchService;

    @RequestMapping("")
    @ResponseBody
    public JSONObject shopSearch(ShopSearchRequest request) {
        ShopSearchResponse response = phoneSearchService.shopSearch(request);
        return JSONObject.fromObject(response);
    }
}
