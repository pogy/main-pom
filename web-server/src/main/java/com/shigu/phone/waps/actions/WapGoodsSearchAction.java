package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.phone.basevo.ItemSearchVO;
import com.shigu.phone.basevo.OneItemVO;
import com.shigu.phone.waps.bo.ItemSearchBo;
import com.shigu.phone.waps.bo.OneItemBo;
import com.shigu.phone.waps.service.WapPhoneGoodsSearchService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.search.bo.SearchBO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapGoodsSearchAction {

    @Autowired
    private WapPhoneGoodsSearchService wapPhoneGoodsSearchService;

    /**
     * 商品搜索
     * @return
     */
    @RequestMapping("queryGoodsList")
    @ResponseBody
    public JSONObject queryGoodsList(ItemSearchBo bo) {

        ItemSearchResponse response = new ItemSearchResponse();
        List<Integer> types = Arrays.asList(1,2,3);
        if (!types.contains(bo.getType())){
            return JsonResponseUtil.error("参数错误");
        }
        if (bo.getType() == null) {
            return JsonResponseUtil.error("参数错误");
        }
        if (bo.getType() == 1 && bo.getType() ==null) {//1商品库(cid不能为空)
            return JsonResponseUtil.error("参数错误");
        }
        if (bo.getType() == 2 && StringUtils.isEmpty(bo.getKeyword())) {//2普通搜索(keywords不为空)
            return JsonResponseUtil.error("参数错误");
        }
        if (bo.getType() == 3 && StringUtils.isEmpty(bo.getStoreId())) {//3店铺(storeId不为空)
            return JsonResponseUtil.error("参数错误");
        }
        if (StringUtils.isEmpty(bo.getOrderBy())) {
            bo.setOrderBy(SearchOrderBy.COMMON.getValue());
        }
        if (StringUtils.isEmpty(bo.getWebSite())) {
            bo.setWebSite("hz");
        }
        if (bo.getIndex() == null) {
            bo.setIndex(1);
        }
        if (bo.getSize() == null) {
            bo.setSize(30);
        }

        SearchBO searchBO=new SearchBO();
        searchBO.setD(bo.getD());
//        searchBO.getBpic(bo.);
        searchBO.setCid(bo.getCid());
        searchBO.setEp(Double.parseDouble(bo.getEndPrice()));
        searchBO.setEt(bo.getEndTime());
//        searchBO.getFrom(bo.);
        searchBO.setKeyword(bo.getKeyword());
        searchBO.setMid(bo.getMarketId());
        searchBO.setPid(bo.getPid());
        searchBO.setShopId(bo.getStoreId());
        searchBO.setSort(bo.getOrderBy());
        searchBO.setSp(Double.parseDouble(bo.getStartPrice()));
        searchBO.setSt(bo.getStartTime());
        searchBO.setWebSite(bo.getWebSite());
        searchBO.setPage(bo.getIndex());
        searchBO.setRows(bo.getSize());
//        searchBO.setTotalPage();




        ItemSearchVO ItemSearchVo = wapPhoneGoodsSearchService.itemSearch(searchBO,bo.getOrderBy());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hasNext",ItemSearchVo.getHasNext());
        jsonObject.put("total",ItemSearchVo.getTotal());
        jsonObject.put("tems",ItemSearchVo.getItems());
        return jsonObject;
    }

    /**
     * 图搜
     */
    @RequestMapping("imgSearch")
    @ResponseBody
    public JSONObject imgSearch(String webSite,String imgurl) throws IOException {
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
        List<AppGoodsBlock> appGoodsBlocks = null;
            appGoodsBlocks = wapPhoneGoodsSearchService.imgSearch(imgurl, webSite);
        return JsonResponseUtil.success().element("imgSearch",appGoodsBlocks);
    }

    /**
     * 单商品信息/查询商品数据
     */
    @RequestMapping("queryGoodsData")
    @ResponseBody
    public JSONObject queryGoodsData(HttpSession session, OneItemBo oneItemBo) throws CdnException, IOException, TemplateException {
        if (oneItemBo.getWebSite() == null) {
            oneItemBo.setWebSite("hz");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        OneItemVO oneItemVO = wapPhoneGoodsSearchService.oneItem(oneItemBo.getWebSite(), oneItemBo.getItemId(), ps.getUserId());
        return JsonResponseUtil.success().element("spreads",oneItemVO);
    }

}
