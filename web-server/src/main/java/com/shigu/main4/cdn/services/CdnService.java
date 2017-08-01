package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.cdn.bo.ScGoodsBO;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.vo.CatPolyFormatVO;
import com.shigu.main4.cdn.vo.ShopShowVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.vo.CatPolymerization;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.services.ShopDesignService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class CdnService {

    @Autowired
    UserCollectService userCollectService;

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    StoreRelationService storeRelationService;

    @Autowired
    ShopLicenseService shopLicenseService;

    @Autowired
    ShopDesignService shopDesignService;

    /**
     * banner部分的html
     * @param shopId
     * @return
     */
    public String bannerHtml(Long shopId,String webSite) throws IOException, TemplateException {
        return shopDesignService.selHeadModuleWithData(shopId,webSite,false).getHtml();
    }

    /**
     * 重组聚合数据
     * @param shopId
     * @return
     */
    public List<CatPolymerization> formatCatPoly(Long shopId){
        List<CatPolymerization> cats=shopForCdnService.selCatRolymerizations(shopId);
        List<CatPolyFormatVO> polys=new ArrayList<>();
        for(CatPolymerization c:cats){
            polys.add(new CatPolyFormatVO(c));
        }
        Collections.sort(polys);
        List<CatPolymerization> result=new ArrayList<>();
        CatPolymerization other=new CatPolymerization();
        other.setCid(404L);
        other.setName("其它");
        other.setSubPolymerizations(new ArrayList<CatPolymerization>());
        for(int i=0;i<polys.size();i++){
            if(i>1){
                List<CatPolymerization> sub=other.getSubPolymerizations();
                if(sub.size()<10){
                    CatPolymerization me=polys.get(i).getCatpoly();
                    if(me.getSubPolymerizations()==null){
                        sub.add(me);
                    }else{
                        List<CatPolymerization> mesub=me.getSubPolymerizations();
                        sub.addAll(mesub);
                    }
                }
            }else{
                result.add(polys.get(i).getCatpoly());
            }
        }
        if(polys.size()>2){
            result.add(other);
        }
        return result;
    }


    /**
     * 收藏商品
     * @param userId
     * @param bo
     * @return
     */
    public boolean addItemCollect(Long userId,ScGoodsBO bo){
        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        //查出店、webSite
        ShiguGoodsIdGenerator sgig=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(bo.getGoodsId());
        if(sgig==null){
            return false;
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(bo.getGoodsId());
        sgt.setWebSite(sgig.getWebSite());
        sgt=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt, FieldUtil.codeFields("goods_id,store_id"));
        if(sgt==null){
            return false;
        }
        itemCollect.setItemId(bo.getGoodsId());
        itemCollect.setStoreId(sgt.getStoreId());
        itemCollect.setWebsite(sgig.getWebSite());
        try {
            userCollectService.addItemCollection(itemCollect);
        } catch (ItemCollectionException e) {
            return false;
        }
        return true;
    }

    /**
     * 收藏店铺
     * @param userId
     * @param bo
     * @return
     */
    public boolean addShopCollect(Long userId, ScStoreBO bo){
        ShopCollect shopCollect=new ShopCollect();
        ShiguShop shop=shiguShopMapper.selectFieldsByPrimaryKey(bo.getStore_id(),
                FieldUtil.codeFields("shop_id,web_site"));
        if(shop==null){
            return false;
        }
        shopCollect.setWebsite(shop.getWebSite());
        shopCollect.setUserId(userId);
        shopCollect.setShopId(shop.getShopId());
        try {
            userCollectService.addShopCollection(shopCollect);
        } catch (ShopCollectionException e) {
            return false;
        }
        return true;
    }

    /**
     * 店铺页面基本信息
     * @param shopId
     * @return
     */
    public ShopShowVO shopSimpleVo(Long shopId){
        ShopShowVO shopShowVO=new ShopShowVO();
        shopShowVO.setOther(shopForCdnService.selShopBase(shopId));
        shopShowVO.setDomain(shopBaseService.selDomain(shopId));
        shopShowVO.setHasAuth(shopBaseService.shopAuthState(shopId));
        shopShowVO.setStoreRelation(storeRelationService.selRelationById(shopId));
//        shopShowVO.setShopCats(shopForCdnService.selShopCatsById(bo.getId()));
        //查商品
        shopShowVO.setShopLicenses(shopLicenseService.selShopLicenses(shopId));
        //得到商品ID
        shopShowVO.setGoodsNum(shopForCdnService.selItemNumberById(shopId,shopShowVO.getStoreRelation().getWebSite()));

        Long starNum=shopForCdnService.selShopStarById(shopId);
        starNum=starNum==null?0:starNum;
        shopShowVO.setStarNum(starNum);
        return shopShowVO;
    }

    /**
     * 查询店内最新几件商品
     * @param shopId
     * @param number
     * @return
     */
    public List<ItemShowBlock> selShopNew(Long shopId,String webSite,Integer number){
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.createCriteria().andStoreIdEqualTo(shopId).andIsClosedEqualTo(0L);
        example.setStartIndex(0);
        example.setEndIndex(number);
        example.setWebSite(webSite);
        example.setOrderByClause("created desc");
        List<ShiguGoodsTiny> tinyList=shiguGoodsTinyMapper.selectFieldsByConditionList(example,
                FieldUtil.codeFields("pic_url,title,goods_id,pi_price,web_site,goods_no"));
        List<ItemShowBlock> blocks=new ArrayList<>();
        for(ShiguGoodsTiny tiny:tinyList){
            ItemShowBlock isb=new ItemShowBlock();
            isb.setWebSite(tiny.getWebSite());
            isb.setShopId(tiny.getStoreId());
            isb.setGoodsNo(tiny.getGoodsNo());
            isb.setItemId(tiny.getGoodsId());
            isb.setImgUrl(tiny.getPicUrl());
            isb.setPrice(isb.parsePrice(tiny.getPiPrice()==null?null:tiny.getPiPrice()));
            isb.setTitle(tiny.getTitle());
            blocks.add(isb);
        }
        return blocks;
    }
}
