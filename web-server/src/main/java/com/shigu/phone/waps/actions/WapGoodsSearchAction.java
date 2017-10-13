package com.shigu.phone.waps.actions;

import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.phone.services.PhoneGoodsSearchService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapGoodsSearchAction {

    @Autowired
    private PhoneGoodsSearchService phoneGoodsSearchService;

    @RequestMapping("itemSearch")
    @ResponseBody
    public JSONObject itemSearch( Long storeId,Long marketId,Long cid,String keyword,String webSite,String orderBy, String startPrice,
                                  String endPrice,String startTime,String endTime,Integer index,Integer size,Integer type) {
        ItemSearchRequest request = new ItemSearchRequest();
        ItemSearchResponse response = new ItemSearchResponse();
        request.setCid(cid);
        request.setEndPrice(endPrice);
        request.setEndTime(endTime);
        request.setIndex(index);
        request.setKeyword(keyword);
        request.setMarketId(marketId);
        request.setOrderBy(orderBy);
        request.setSize(size);
        request.setStartPrice(startPrice);
        request.setStartTime(startTime);
        request.setStoreId(storeId);
        request.setType(type);
        request.setWebSite(webSite);

        List<Integer> types = Arrays.asList(1,2,3);
        if (!types.contains(type)){
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (type == null) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (type == 1 && type ==null) {//1商品库(cid不能为空)
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (type == 2 && StringUtils.isEmpty(keyword)) {//2普通搜索(keywords不为空)
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (type == 3 && StringUtils.isEmpty(storeId)) {//3店铺(storeId不为空)
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (StringUtils.isEmpty(orderBy)) {
            request.setOrderBy(SearchOrderBy.COMMON.getValue());
        }
        if (StringUtils.isEmpty(webSite)) {
            request.setWebSite("hz");
        }
        if (index == null) {
            request.setIndex(1);
        }
        if (size == null) {
            request.setSize(30);
        }
        response=phoneGoodsSearchService.itemSearch(request);
        return JSONObject.fromObject(response);
    }

    @RequestMapping("imgSearch")
    @ResponseBody
    public JSONObject imgSearch(String webSite,String imgurl) {
        ImgSearchRequest request = new ImgSearchRequest();
        request.setImgurl(imgurl);
        request.setWebSite(webSite);
        ImgSearchResponse response = new ImgSearchResponse();
        if (imgurl == null) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (webSite == null) {
            request.setWebSite("hz");
        }
        response=phoneGoodsSearchService.imgSearch(request);
        return JSONObject.fromObject(response);
    }


    @RequestMapping("oneItem")
    @ResponseBody
    public JSONObject oneItem( HttpSession session, long itemId, String webSite) {
        OneItemRequest request = new OneItemRequest();
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        request.setItemId(itemId);
        request.setUserId(ps.getUserId());
        request.setWebSite(webSite);
        if (webSite == null) {
            request.setWebSite("hz");
        }
        return JSONObject.fromObject(phoneGoodsSearchService.oneItem(request));
    }

}
