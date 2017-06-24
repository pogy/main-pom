package com.shigu.seller.services;

import com.google.common.collect.Lists;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.GoatLicense;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.GoatLicenseExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.GoatLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.seller.vo.IndexGoatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by whx on 2017/6/24 0024.
 */
@Service
public class GoatShopService {

    @Autowired
    private GoatLicenseMapper goatLicenseMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private GoatDubboService goatDubboService;

    /**
     * 获取店铺首页广告数据列表
     * @param webSite 分站
     * @param shopId 店铺id
     * @param type GoatType,首页广告为GoatType.ItemGoat
     * @return
     */
    public List<IndexGoatVO> selGoatByShopId(String webSite, Long shopId, GoatType type) {
        GoatLicenseExample goatLicenseExample = new GoatLicenseExample();
        goatLicenseExample.createCriteria().andShopIdEqualTo(shopId);
        List<Long> goatIds = BeanMapper.getFieldList(
                goatLicenseMapper.selectFieldsByExample(goatLicenseExample, "goat_id"),"goatId",Long.class);
        List<IndexGoatVO> shopGoats = Lists.newArrayList();
        for (Long goatId: goatIds) {
            ItemGoatVO itemGoatVO = null;
            try {
                itemGoatVO = goatDubboService.selGoatById(goatId, type);
                if (itemGoatVO == null) {
                    itemGoatVO = goatDubboService.selGoatPrepareById(goatId, type);
                }
                if (itemGoatVO != null) {
                    IndexGoatVO indexGoatVO = mapItemGoatVOToIndexGoatVO(webSite, itemGoatVO);
                    shopGoats.add(indexGoatVO);
                }
            } catch (GoatException e) {
            }
        }
        return shopGoats;
    }

    /**
     * 将ItemGoatVO对象数据转化为IndexGoatVO对象数据
     * @param webSite
     * @param itemGoatVO
     * @return 首页广告信息VO
     */
    private IndexGoatVO mapItemGoatVOToIndexGoatVO(String webSite, ItemGoatVO itemGoatVO) {
        IndexGoatVO indexGoatVO = BeanMapper.map(itemGoatVO, IndexGoatVO.class);
        indexGoatVO.setCodeId(itemGoatVO.getGoatId());
        indexGoatVO.setWebSite(webSite);
        indexGoatVO.setCode(itemGoatVO.getDescription());
        indexGoatVO.setType(itemGoatVO.getTitle());
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        indexGoatVO.setStartOnline(format.format(itemGoatVO.getFromTime()));
        indexGoatVO.setEndOnline(format.format(itemGoatVO.getToTime()));
        indexGoatVO.setGoatTime(indexGoatVO.getStartOnline() + ',' + indexGoatVO.getEndOnline());
        return indexGoatVO;
    }

    /**
     * 根据goatId和shopId获取广告授权信息
     * @param goatId
     * @param shopId
     * @return 广告授权状态
     * @throws JsonErrException 没有对应授权时抛出
     */
    public GoatLicenseStatu getGoatLicenseStatu(Long goatId, Long shopId) throws JsonErrException {
        GoatLicenseExample goatLicenseExample = new GoatLicenseExample();
        goatLicenseExample.createCriteria().andGoatIdEqualTo(goatId).andShopIdEqualTo(shopId);
        List<GoatLicense> goatLicenses = goatLicenseMapper.selectByExample(goatLicenseExample);
        if(goatLicenses.size()<=0){
            throw new JsonErrException("没有找到对应的广告授权记录");
        }
        GoatLicense goatLicense = goatLicenses.get(0);
        Date now = new Date();
        if (now.before(goatLicense.getLicenseFromTime())||now.after(goatLicense.getLicenseToTime())) {
            throw new JsonErrException("不在广告授权时间内");
        }
        if (now.before(goatLicense.getSpreadFromTime())) {
            return GoatLicenseStatu.PREPUBLISH;
        } else if (now.before(goatLicense.getSpreadToTime())) {
            return GoatLicenseStatu.PUBLISH;
        } else {
            throw new JsonErrException("广告已过期");
        }
    }

    /**
     * 获取根据goodsId获取店铺中的商品信息
     * @param webSite
     * @param goodsId
     * @param storeId
     * @return 商品信息，包括goodsId,picUrl,webSite
     */
    public ShiguGoodsTiny getShopGoodsInfo(String webSite, Long goodsId, Long storeId) throws JsonErrException {
        ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
        shiguGoodsTinyExample.setWebSite(webSite);
        shiguGoodsTinyExample.createCriteria().andGoodsIdEqualTo(goodsId).andStoreIdEqualTo(storeId);
        List<ShiguGoodsTiny> result = shiguGoodsTinyMapper.selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id,pic_url,web_site"));
        if (result.size() > 0) {
            return result.get(0);
        }
        throw new JsonErrException("商品不存在");
    }

    /**
     * 更新已发布广告信息
     * @param goatId 广告id
     * @param good 更新用的广告信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void publishGoatUpdate(Long goatId, ShiguGoodsTiny good) throws JsonErrException {
        try {
            ItemGoatVO goatVO = goatDubboService.selGoatById(goatId, GoatType.ItemGoat);
            goatVO.setItemId(good.getGoodsId());
            goatVO.setPicUrl(good.getPicUrl());
            goatDubboService.publish(goatVO);
        } catch (GoatException e) {
            throw new JsonErrException(e.getMessage());
        }

    }

    /**
     * 更新预发布广告信息
     * @param goatId 广告id
     * @param good 更新用的广告信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void prepublishGoatUpdate(Long goatId, ShiguGoodsTiny good) throws JsonErrException {
        try {
            ItemGoatVO goatVO = goatDubboService.selGoatPrepareById(goatId, GoatType.ItemGoat);
            goatVO.setItemId(good.getGoodsId());
            goatVO.setPicUrl(good.getPicUrl());
            goatDubboService.preparePublish(goatVO, (goatVO.getFromTime().getTime() - new Date().getTime())/1000);
        } catch (GoatException e) {
            throw new JsonErrException(e.getMessage());
        }
    }

    /**
     * 广告授权状态
     */
    public enum GoatLicenseStatu {
        PUBLISH("广告发布授权"),
        PREPUBLISH("广告预发布授权"),
        NOLICENSE("没有授权"),
        ;

        public String statu;

        GoatLicenseStatu(String statu) {
            this.statu = statu;
        }
    }
}
