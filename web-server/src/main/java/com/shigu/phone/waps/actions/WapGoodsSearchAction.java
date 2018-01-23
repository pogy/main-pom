package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.phone.basevo.ItemSearchVO;
import com.shigu.phone.basevo.OneItemVO;
import com.shigu.phone.waps.bo.ItemSearchBo;
import com.shigu.phone.waps.bo.OneItemBo;
import com.shigu.phone.waps.service.WapPhoneGoodsSearchService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("datas/")
public class WapGoodsSearchAction {

    @Autowired
    private WapPhoneGoodsSearchService wapPhoneGoodsSearchService;

    /**
     * 商品搜索
     * @return
     */
    @RequestMapping("queryGoodsList")
    @ResponseBody
    public JSONObject queryGoodsList(ItemSearchBo bo) throws ParseException {
        List<Integer> types = Arrays.asList(1,2,3);
        if (!types.contains(bo.getType())){
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        if (bo.getType() == null) {
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        if (bo.getCid() == null) {
            bo.setCid(bo.getPid());//cid为空则取上级类目商品
        }
        if (bo.getScid() != null) {//有店内类目查店内类目下 商品
            bo.setCid(bo.getScid());
        }
        if (bo.getType() == 1 && bo.getCid() ==null) {//1商品库(cid不能为空)
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        if (bo.getType() == 2 && StringUtils.isEmpty(bo.getKeyword())) {//2普通搜索(keywords不为空)
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        if (bo.getType() == 3 && StringUtils.isEmpty(bo.getStoreId())) {//3店铺(storeId不为空)
            return JsonResponseUtil.error("参数错误").element("success",false);
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
        if (bo.getType() != null && bo.getType() == 1){
            bo.setKeyword(null);//type == 1 不需要关键词
        }

        ItemSearchVO itemSearchVo;
        try {
            itemSearchVo = wapPhoneGoodsSearchService.itemSearch(bo);
            //极限词过滤
            itemSearchVo.getItems().forEach(appGoodsBlock -> {
                appGoodsBlock.setTitle(KeyWordsUtil.duleKeyWords(appGoodsBlock.getTitle()));
                appGoodsBlock.setHighLightTitle(KeyWordsUtil.duleKeyWords(appGoodsBlock.getHighLightTitle()));
            });
            return JsonResponseUtil
                        .success()
                        .element("success",true)
                        .element("hasNext",itemSearchVo.getHasNext())
                        .element("total",itemSearchVo.getTotal())
                        .element("items",itemSearchVo.getItems());
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getMessage()).element("success",false);
        }
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
            return WrapperUtil.wrapperOpenException("参数错误",response).element("success",false);
        }
        if (webSite == null) {
            request.setWebSite("hz");
        }
        List<AppGoodsBlock> appGoodsBlocks = wapPhoneGoodsSearchService.imgSearch(imgurl, webSite);
        //极限词过滤
        appGoodsBlocks.forEach(appGoodsBlock -> {
            appGoodsBlock.setTitle(KeyWordsUtil.duleKeyWords(appGoodsBlock.getTitle()));
            appGoodsBlock.setHighLightTitle(KeyWordsUtil.duleKeyWords(appGoodsBlock.getHighLightTitle()));
        });
        return JsonResponseUtil.success().element("success",true).element("imgSearch",appGoodsBlocks);
    }

    /**
     * 单商品信息/查询商品数据
     */
    @RequestMapping("queryGoodsData")
    @ResponseBody
    public JSONObject queryGoodsData(HttpSession session, OneItemBo oneItemBo){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        OneItemVO oneItemVO = null;
        try {
            oneItemVO = wapPhoneGoodsSearchService.oneItem(oneItemBo.getWebSite(), oneItemBo.getItemId(), ps==null?null : ps.getUserId());
            if (oneItemVO == null) {
                return JsonResponseUtil.error("未查询到数据").element("success",false);
            }
            //极限词过滤
            oneItemVO.setTitle(KeyWordsUtil.duleKeyWords(oneItemVO.getTitle()));
            oneItemVO.setDetails(KeyWordsUtil.duleKeyWords(oneItemVO.getDetails()));
            return JsonResponseUtil
                        .success()
                        .element("success",true)
                        .element("title",oneItemVO.getTitle())
                        .element("goodsId",oneItemVO.getGoodsId())
                        .element("imgSrcs",oneItemVO.getImgSrcs())
                        .element("goodsNo",oneItemVO.getGoodsNo())
                        .element("createTime",oneItemVO.getCreateTime())
                        .element("goodsLicenses",oneItemVO.getGoodsLicenses())
                        .element("price",oneItemVO.getLiPrice())
                        .element("storeId",oneItemVO.getStoreId())
                        .element("market",oneItemVO.getMarket())
                        .element("storeNum",oneItemVO.getStoreNum())
                        .element("starNum",oneItemVO.getStarNum())
                        .element("colors",oneItemVO.getColors())
                        .element("size",oneItemVO.getSize())
                        .element("shopHeadUrl",oneItemVO.getShopHeadUrl())
                        .element("itemKvs",oneItemVO.getItemKvs())
                        .element("details",oneItemVO.getDetails());
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }catch (CdnException e){
            e.printStackTrace();
            return JsonResponseUtil.error(e.getMessage()).element("success",false).element("nogoods",true);
        }
    }

}
