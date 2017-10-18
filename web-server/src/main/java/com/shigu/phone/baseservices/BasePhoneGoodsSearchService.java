package com.shigu.phone.baseservices;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.beans.app.AppItemKv;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.newcdn.vo.CdnGoodsInfoVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.basevo.ItemSearchVO;
import com.shigu.phone.basevo.OneItemVO;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.vo.GoodsInSearch;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneGoodsSearchService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneGoodsSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端商品搜索service
 */
@Service
public class BasePhoneGoodsSearchService {

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
     * @return
     */
    public ItemSearchVO itemSearch(SearchBO bo, String orderBy) {
        ItemSearchVO vo = new ItemSearchVO();
        ShiguPager<GoodsInSearch> result = goodsSearchService.search(bo, SearchOrderBy.valueIs(orderBy), false).getSearchData();
        vo.setTotal(result.getTotalCount());
        vo.setHasNext(result.getNumber() < result.getTotalPages());
        vo.setItems(result.getContent().parallelStream().map(o -> {
            AppGoodsBlock appGoodsBlock = BeanMapper.map(o, AppGoodsBlock.class);
            appGoodsBlock.setGoodsId(o.getId());
            return appGoodsBlock;
        }).collect(Collectors.toList()));
        return vo;
    }

    /**
     * 移动端图搜
     *
     * @return
     */
    public List<AppGoodsBlock>  imgSearch(String imgUrl,String webSite) throws IOException {
        List<AppGoodsBlock> appGoodsBlocks = goodsSearchService.searchByPic(imgUrl,webSite).parallelStream().map(o -> {
            if (o != null) {
                AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
                vo.setGoodsId(o.getId());
                return vo;
            }
            return null;
        }).collect(Collectors.toList());

        //搜索完毕，删除临时图片 TODO 删除路径待确认
        ossIO.deleteFile("mall/file/" + imgUrl.substring(imgUrl.lastIndexOf("/") + 1));
        return appGoodsBlocks;
    }

    /**
     * app单商品信息
     * @return
     */
    public OneItemVO oneItem(String webSite,Long itemId,Long userId) throws IOException, TemplateException, CdnException {
        OneItemVO vo = new OneItemVO();
        //商品数据填充
        CdnGoodsInfoVO goods = cdnService.cdnGoodsInfo(itemId);
        vo.setGoodsId(goods.getGoodsId()+"");
        vo.setGoodsNo(goods.getGoodsNo());
        vo.setPrice(goods.getPiPrice());
        vo.setTitle(goods.getTitle());
        vo.setCreateTime(goods.getPostTime());
        vo.setImgSrcs(goods.getImgUrls());
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
        vo.setGoodsLicenses(list);
        vo.setColors(JSONArray.parseArray(goods.getColorsMeta()).parallelStream().map(o -> {
            JSONObject color = (JSONObject) o;
            return color.get("text").toString();
        }).collect(Collectors.toList()));
        vo.setSize(JSONArray.parseArray(goods.getSizesMeta()).parallelStream().map(Object::toString).collect(Collectors.toList()));
        vo.setItemKvs(goods.getNormalAttrs().parallelStream().map(o -> {
            AppItemKv itemKv = new AppItemKv();
            itemKv.setKey(o.getName());
            itemKv.setValue(o.getValue());
            return itemKv;
        }).collect(Collectors.toList()));
        //店铺数据填充
        CdnShopInfoVO shop = cdnService.cdnShopInfo(goods.getShopId());
        vo.setStoreId(goods.getShopId());
        vo.setStoreNum(shop.getShopNo());
        vo.setMarket(shop.getMarketName());
        vo.setStarNum(shop.getStarNum().intValue());
        vo.setShopHeadUrl(ImgUtils.headUrl(shop.getImWw()));
        if (userId == null) {
            vo.setType(0);
        }else {
            // 查询商品是否收藏
            ItemCollectInfoVO itemCollectInfoVO = userCollectService.selItemCollectionInfo(userId,itemId,webSite);
            int type = 1;
            if (itemCollectInfoVO == null || itemCollectInfoVO.getUseStatus() == null){
               type = 0;
            }else{
                type = itemCollectInfoVO.getUseStatus();
            }
            vo.setType(type);
        }

        return vo;
    }


}
