package com.shigu.phone.apps.actions;

import com.openJar.requests.app.ImgSpreadRequest;
import com.openJar.requests.app.ItemCollectRequest;
import com.openJar.requests.app.ItemSpreadRequest;
import com.openJar.responses.app.ImgSpreadResponse;
import com.openJar.responses.app.ItemCollectResponse;
import com.shigu.phone.apps.services.AppAdvertService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.spread.enums.SpreadEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by pc on 2017-08-29.
 *app 商品收藏夹
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
@RequestMapping("app")
public class AppItemAction {

    @RequestMapping("itemCollect")
    @ResponseBody
    public JSONObject itemCollectRequest(ItemCollectRequest request, ItemCollectResponse response){
        if (request.getUserId() == null) {
            return WrapperUtil.wrapperOpenException("userId si null",response);
        }
        if (request.getIndex() == null)request.setIndex(1);
        if (request.getSize() == null)request.setSize(15);
//        return JSONObject.fromObject();
        return null;
    }
}
