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
    public List<IndexGoatVO> selGoatByShopId(String webSite, Long shopId, GoatType type) throws GoatException {
        Date now=new Date();
        GoatLicenseExample goatLicenseExample = new GoatLicenseExample();
        //查询本店,当前有效期内的授权
        goatLicenseExample.createCriteria().andShopIdEqualTo(shopId).andLicenseFromTimeLessThan(now)
            .andLicenseToTimeGreaterThan(now);

        List<GoatLicense> licenses=goatLicenseMapper.selectByExample(goatLicenseExample);
        List<IndexGoatVO> shopGoats = Lists.newArrayList();
        for (GoatLicense license: licenses) {
            //判断是预发布还是线上
            shopGoats.add(mapItemGoatVOToIndexGoatVO(webSite,license.getGoatId(),type,license.getSpreadFromTime(),license.getSpreadToTime()));
        }
        return shopGoats;
    }

    /**
     * 将ItemGoatVO对象数据转化为IndexGoatVO对象数据
     * @param webSite
     * @return 首页广告信息VO
     */
    private IndexGoatVO mapItemGoatVOToIndexGoatVO(String webSite,Long goatId,GoatType type,Date spreadStart,Date spreadEnd) throws GoatException {
        Date now=new Date();
        ItemGoatVO itemGoatVO;
        int isonline;
        if(spreadStart.getTime()<now.getTime()
                &&spreadEnd.getTime()>now.getTime()){
            //线上
            itemGoatVO = goatDubboService.selGoatById(goatId, type);
            isonline=1;
        }else{
            //预发布
            itemGoatVO = goatDubboService.selGoatPrepareById(goatId, type);
            isonline=0;
        }
        IndexGoatVO indexGoatVO = BeanMapper.map(itemGoatVO, IndexGoatVO.class);
        //有一种可能性是,同一个人,对同一个广告连续买了2期,那么权限里应该有2个,一个在线的,一个预发布的
        indexGoatVO.setCodeId(itemGoatVO.getGoatId()+"_"+isonline);
        indexGoatVO.setWebSite(webSite);
        indexGoatVO.setCode(itemGoatVO.getDescription());
        indexGoatVO.setType(itemGoatVO.getTitle());
        if(itemGoatVO.getItemId()!=null){
            ShiguGoodsTiny tiny=new ShiguGoodsTiny();
            tiny.setGoodsId(itemGoatVO.getItemId());
            tiny.setWebSite(webSite);
            tiny=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny,FieldUtil.codeFields("goods_id,pic_url"));
            if(tiny!=null){
                indexGoatVO.setGoodsId(tiny.getGoodsId());
                indexGoatVO.setPicUrl(tiny.getPicUrl());
            }
        }
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        indexGoatVO.setStartOnline(format.format(spreadStart));
        indexGoatVO.setEndOnline(format.format(spreadEnd));
        return indexGoatVO;
    }

    /**
     * 按code查询授权情况
     * @param codeId
     * @param shopId
     * @return
     * @throws JsonErrException
     */
    public GoatLicense getGoatLicenseByCodeId(String codeId,Long shopId) throws JsonErrException {
        String[] strarr=codeId.split("_");
        Long goatId=Long.valueOf(strarr[0]);
        Integer online=Integer.valueOf(strarr[1]);
        GoatLicenseExample goatLicenseExample = new GoatLicenseExample();
        GoatLicenseExample.Criteria cri=goatLicenseExample.createCriteria();
        cri.andGoatIdEqualTo(goatId).andShopIdEqualTo(shopId);
        Date now=new Date();
        if(online==1){
            cri.andSpreadFromTimeLessThan(now).andSpreadToTimeGreaterThan(now);
        }else{
            cri.andSpreadFromTimeGreaterThan(now);
        }
        List<GoatLicense> goatLicenses = goatLicenseMapper.selectByExample(goatLicenseExample);
        if(goatLicenses.size()<=0){
            throw new JsonErrException("没有找到对应的广告授权记录");
        }
        return goatLicenses.get(0);
    }
    /**
     * 根据goatId和shopId获取广告授权信息
     * @param license
     * @return 广告授权状态
     * @throws JsonErrException 没有对应授权时抛出
     */
    public GoatLicenseStatu getGoatLicenseStatu(GoatLicense license) throws JsonErrException {
        Date now = new Date();
        if (now.before(license.getLicenseFromTime())||now.after(license.getLicenseToTime())) {
            throw new JsonErrException("不在广告授权时间内");
        }
        if (now.before(license.getSpreadFromTime())) {
            return GoatLicenseStatu.PREPUBLISH;
        } else if (now.before(license.getSpreadToTime())) {
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
     * @param good 更新用的广告信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void publishGoatUpdate(GoatLicense license,Long userId, ShiguGoodsTiny good) throws JsonErrException {
        try {
            ItemGoatVO goatVO = new ItemGoatVO();
            goatVO.setItemId(good.getGoodsId());
            goatVO.setGoatId(license.getGoatId());
            goatVO.setFromTime(license.getSpreadFromTime());
            goatVO.setToTime(license.getSpreadToTime());
            goatVO.setUserId(userId);
            goatDubboService.publish(goatVO);
        } catch (GoatException e) {
            throw new JsonErrException(e.getMessage());
        }

    }

    /**
     * 更新预发布广告信息
     * @param good 更新用的广告信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void prepublishGoatUpdate(GoatLicense license,Long userId, ShiguGoodsTiny good) throws JsonErrException {
            ItemGoatVO goatVO = new ItemGoatVO();
            goatVO.setItemId(good.getGoodsId());
            goatVO.setGoatId(license.getGoatId());
            goatVO.setFromTime(license.getSpreadFromTime());
            goatVO.setToTime(license.getSpreadToTime());
            goatVO.setUserId(userId);
            goatDubboService.preparePublish(goatVO, (license.getSpreadFromTime().getTime() - new Date().getTime())/1000);
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
