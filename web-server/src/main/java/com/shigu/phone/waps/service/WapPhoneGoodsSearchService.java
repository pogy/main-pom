package com.shigu.phone.waps.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.beans.app.AppItemKv;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.openJar.responses.app.OneItemResponse;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.newcdn.vo.CdnGoodsInfoVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.vo.GoodsInSearch;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneGoodsSearchService
 * 类路径：com.shigu.phone.services.PhoneGoodsSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端商品搜索service
 */
@Service
public class WapPhoneGoodsSearchService {

    @Autowired
    private GoodsSearchService goodsSearchService;

    @Autowired
    private CdnService cdnService;

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private OssIO ossIO;

    /**
     * 移动端商品搜索
     *
     * @param request
     * @return
     */
    public ItemSearchResponse itemSearch(ItemSearchRequest request) {
        ItemSearchResponse resp = new ItemSearchResponse();
        try {
            SearchBO bo = new SearchBO();
            bo.setWebSite(request.getWebSite());
            bo.setKeyword(request.getKeyword());
            bo.setMid(request.getMarketId());
            bo.setCid(request.getCid());
            bo.setPid(request.getCid());
            bo.setShopId(request.getStoreId());
            if (request.getType() != null && request.getType() == 2) {
                //商品库搜索顺序
                bo.setFrom("goods");
            }
            bo.setSort(request.getOrderBy());
            final String dateFormat = "yyyy.MM.dd";
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.patternA);
            Date startTime = null;
            Date endtTime = null;
            if (!StringUtils.isEmpty(request.getStartTime())) {
                startTime  = sdf.parse(request.getStartTime());
            }
            if (!StringUtils.isEmpty(request.getEndTime())) {
                endtTime  = sdf.parse(request.getEndTime());
            }

            bo.setSt(startTime == null? null : DateUtil.dateToString(startTime, dateFormat));
            bo.setEt(endtTime == null ? null : DateUtil.dateToString(endtTime, dateFormat));
            bo.setSp(request.getStartPrice() == null ? null : Double.valueOf(request.getStartPrice()));
            bo.setEp(request.getEndPrice() == null ? null : Double.valueOf(request.getEndPrice()));
            bo.setPage(request.getIndex());
            bo.setRows(request.getSize());
            ShiguPager<GoodsInSearch> result = goodsSearchService.search(bo, SearchOrderBy.valueIs(request.getOrderBy()), false).getSearchData();
            resp.setTotal(result.getTotalCount());
            resp.setHasNext(result.getNumber() < result.getTotalPages());
            resp.setItems(result.getContent().parallelStream().map(o -> {
                AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
                vo.setGoodsId(o.getId());
                return vo;
            }).collect(Collectors.toList()));
            resp.setSuccess(true);
            return resp;
        } catch (ParseException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg(e.getMessage());
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
    }

    /**
     * 移动端图搜
     *
     * @param request
     * @return
     */
    public ImgSearchResponse imgSearch(ImgSearchRequest request) {
        ImgSearchResponse resp = new ImgSearchResponse();
        try {
            resp.setItems(goodsSearchService.searchByPic(request.getImgurl(), request.getWebSite()).parallelStream().map(o -> {
                if (o != null) {
                    AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
                    vo.setGoodsId(o.getId());
                    return vo;
                }
                return null;
            }).collect(Collectors.toList()));
            resp.setSuccess(true);
        } catch (IOException e) {
            resp.setException(new OpenException());
        }
        //搜索完毕，删除临时图片 TODO 删除路径待确认
        String str = request.getImgurl();
        ossIO.deleteFile("mall/file/" + str.substring(str.lastIndexOf("/") + 1));
        return resp;
    }

    /**
     * app单商品信息
     * @param request
     * @return
     */
    public OneItemResponse oneItem(OneItemRequest request) {
        OneItemResponse resp = new OneItemResponse();
        try {
            //商品数据填充
            CdnGoodsInfoVO goods = cdnService.cdnGoodsInfo(request.getItemId());
            resp.setGoodsId(goods.getGoodsId()+"");
            resp.setGoodsNo(goods.getGoodsNo());
            resp.setPrice(goods.getPiPrice());
            resp.setTitle(goods.getTitle());
            resp.setCreateTime(goods.getPostTime());
            resp.setImgSrcs(goods.getImgUrls());
            //获取 商品服务类型, services权限,1(退现金)，2（保换款），可以有的服务都传进来
            List<String> services = goods.getServices();
            List<String> list=new ArrayList<>();
            for (String s:services) {
                if("1".equals(s)){
                    list.add("可退款");
                }else if("2".equals(s)){
                    list.add("可换款");
                }
            }
            resp.setGoodsLicenses(list);
            resp.setColors(JSONArray.parseArray(goods.getColorsMeta()).parallelStream().map(o -> {
                JSONObject color = (JSONObject) o;
                return color.get("text").toString();
            }).collect(Collectors.toList()));
            resp.setSize(JSONArray.parseArray(goods.getSizesMeta()).parallelStream().map(Object::toString).collect(Collectors.toList()));
            resp.setItemKvs(goods.getNormalAttrs().parallelStream().map(o -> {
                AppItemKv itemKv = new AppItemKv();
                itemKv.setKey(o.getName());
                itemKv.setValue(o.getValue());
                return itemKv;
            }).collect(Collectors.toList()));
            //店铺数据填充
            CdnShopInfoVO shop = cdnService.cdnShopInfo(goods.getShopId());
            resp.setStoreId(goods.getShopId());
            resp.setStoreNum(shop.getShopNo());
            resp.setMarket(shop.getMarketName());
            resp.setStarNum(shop.getStarNum().intValue());
            resp.setSuccess(true);
            if (request.getUserId() == null) {
                resp.setType(0);
            }else {
                // 查询商品是否收藏
                ItemCollectInfoVO itemCollectInfoVO = userCollectService.selItemCollectionInfo(request.getUserId(),request.getItemId(),request.getWebSite());
                int type = 1;
                if (itemCollectInfoVO == null || itemCollectInfoVO.getUseStatus() == null){
                   type = 0;
                }else{
                    type = itemCollectInfoVO.getUseStatus();
                }
                resp.setType(type);
            }
        } catch (CdnException | TemplateException | IOException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg(e.getMessage());
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        return resp;
    }


}
