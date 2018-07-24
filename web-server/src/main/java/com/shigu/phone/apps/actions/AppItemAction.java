package com.shigu.phone.apps.actions;

import com.openJar.requests.app.DelItemCollectRequest;
import com.openJar.requests.app.GoodsCollectRequest;
import com.openJar.requests.app.ItemCollectRequest;
import com.openJar.responses.app.DelItemCollectResponse;
import com.openJar.responses.app.GoodsCollectResponse;
import com.openJar.responses.app.ItemCollectResponse;
import com.shigu.phone.apps.services.AppItemService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


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

    @Autowired
    private AppItemService appItemService;

    @RequestMapping("itemCollect")
    @ResponseBody
    public JSONObject itemCollectRequest( @Valid ItemCollectRequest request, ItemCollectResponse response, BindingResult bindingResult){
        if (request.getUserId() == null) {
            return WrapperUtil.wrapperOpenException("userId si null",response);
        }
        if (request.getIndex() == null)request.setIndex(1);
        if (request.getSize() == null)request.setSize(30);
        ItemCollectResponse itemCollectResponse = appItemService.collectItem(request);
        //极限词过滤
        if (itemCollectResponse.getItems() != null) {
            itemCollectResponse.getItems().forEach(appGoodsBlock -> {
                appGoodsBlock.setTitle(KeyWordsUtil.duleKeyWords(appGoodsBlock.getTitle()));
                appGoodsBlock.setHighLightTitle(KeyWordsUtil.duleKeyWords(appGoodsBlock.getHighLightTitle()));
            });
        }
        return JSONObject.fromObject(itemCollectResponse);
    }

    @RequestMapping("delItemCollect")
    @ResponseBody
    public JSONObject delItemCollectRequest (@Valid DelItemCollectRequest request, DelItemCollectResponse response, BindingResult bindingResult){
        if (request.getUserId() == null || StringUtils.isEmpty(request.getCollectIds())
                || StringUtils.isEmpty(request.getToken())) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }

        return JSONObject.fromObject(appItemService.delItemCollect(request));
    }

    /**
     * 商品收藏/取消收藏
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("goodsCollect")
    @ResponseBody
    public JSONObject goodsCollectRequest(@Valid GoodsCollectRequest request, GoodsCollectResponse response, BindingResult bindingResult){
        if (request.getGoodsId() == null || request.getStoreId() == null || request.getUserId() == null) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (StringUtils.isEmpty(request.getWebSite())) {
            request.setWebSite("hz");
        }
        return JSONObject.fromObject(appItemService.collectGoods(request));
    }

}
