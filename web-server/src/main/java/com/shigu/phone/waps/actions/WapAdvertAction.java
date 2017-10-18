package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppItemSpread;
import com.openJar.requests.app.ImgSpreadRequest;
import com.openJar.requests.app.ItemSpreadRequest;
import com.openJar.responses.app.ImgSpreadResponse;
import com.openJar.responses.app.ItemSpreadResponse;
import com.shigu.phone.apps.services.AppAdvertService;
import com.shigu.phone.waps.service.WapAdvertService;
import com.shigu.phone.waps.vo.ImgSpreadVO;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapAdvertAction {
    @Autowired
    WapAdvertService wapAdvertService;

    /**
     * 图片式广告数据
     * @param spreadCode
     * @param webSite
     * @return
     */
    @RequestMapping("queryPicGoatList")
    @ResponseBody
    public JSONObject queryPicGoatList(String spreadCode, String webSite){
        if(spreadCode == null || StringUtils.isEmpty(webSite)){
            return JsonResponseUtil.error("缺少参数");
        }
        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(spreadCode)){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            return JsonResponseUtil.error("缺少错误:spreadCode="+spreadCode);
        }
        List<ImgSpreadVO> imgSpreadVOS = wapAdvertService.imgSpread(spread);

        return  JsonResponseUtil.success().element("spreads",imgSpreadVOS);
    }

    /**
     * 商品广告数据
     * @param spreadCode
     * @param webSite
     * @return
     */
    @RequestMapping("queryGoodsGoatList")
    @ResponseBody
    public JSONObject queryGoodsGoatList(String spreadCode, String webSite) {
        if(spreadCode == null || StringUtils.isEmpty(webSite)){
            return  JsonResponseUtil.error("缺少参数");
        }
        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(spreadCode)){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            return  JsonResponseUtil.error("缺少错误:spreadCode="+spreadCode);
        }
        List<AppItemSpread> appItemSpreads = wapAdvertService.itemSpread(webSite, spread);
        return JsonResponseUtil.success().element("spreads",appItemSpreads);
    }
}
