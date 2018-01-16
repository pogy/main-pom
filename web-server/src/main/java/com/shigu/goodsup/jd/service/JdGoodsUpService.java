package com.shigu.goodsup.jd.service;

import com.openJar.requests.api.GoodsCanbeUploadedToJdRequest;
import com.openJar.responses.api.GoodsCanbeUploadedToJdResponse;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.ucenter.services.UserLicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created By admin on 2017/12/22/20:40
 */
@Service
public class JdGoodsUpService {

    private static final Logger logger = LoggerFactory.getLogger(JdGoodsUpService.class);

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private OpenClientService openClientService;

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private UserLicenseService userLicenseService;

    /**
     *查询商品是否可京东上传
     * 根据goodsId获取tbCid,然后去jd_tb_bind表查询,如果查不到,则不能上传
     * @return
     */
    public Boolean goodsCanbeUploadedToJd(Long goodsId)  {
        ShiguGoodsIdGenerator generator;
        // 验证参数，并查询分站存在
        if (goodsId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId)) == null) {
            return false;
        }
        String webSite = generator.getWebSite();
        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        if ((tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny)) == null) {
            return false;
        }
        Long tbCid = tiny.getCid();
        GoodsCanbeUploadedToJdRequest request = new GoodsCanbeUploadedToJdRequest();
        request.setTbCid(tbCid);
        GoodsCanbeUploadedToJdResponse response = openClientService.getOpenClient().execute(request);
        return response.getCan();
    }


    /**
     * 查询用户是否已上传过, true: 已经上传过， false ：未上传过
     * @return
     */
    public Boolean hasBeUploaded(Long userId,Long goodsId) {
        LastUploadedVO lastUploadedVO = itemUpRecordService.selLastUpByIds(userId, goodsId);
        return lastUploadedVO != null;
    }

    /**
     * 添加京东上传记录到ES
     * @return
     */
    public void saveRecord(ItemUpRecordVO vo) {
        try {
            userLicenseService.addScore(vo.getFenUserId(),1);
        } catch (Exception e) {
            logger.error("加积分失败",e);
        }
        ShiguGoodsIdGenerator sgig = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(vo.getSupperGoodsId());
        if(sgig==null){
            return;
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(vo.getSupperGoodsId());
        sgt.setWebSite(sgig.getWebSite());
        sgt = shiguGoodsTinyMapper.selectByPrimaryKey(sgt);
        if(sgt==null){
            return;
        }
        ShiguShop shop=shiguShopMapper.selectByPrimaryKey(sgt.getStoreId());
        if(shop==null){
            return;
        }
        ShopNumAndMarket goodsMarketInfo = shiguShopMapper.selMarketInfo(sgt.getStoreId());
        vo.setSupperGoodsName(sgt.getTitle());
        vo.setWebSite(sgig.getWebSite());
        vo.setSupperImage(sgt.getPicUrl());
        vo.setSupperMarketId(sgt.getMarketId());
        vo.setSupperNumiid(sgt.getNumIid());
        vo.setSupperMarket(goodsMarketInfo.getMarket());

        vo.setSupperPiPrice(sgt.getPiPriceString());
        vo.setSupperPrice(sgt.getPriceString());
        vo.setSupperStoreId(sgt.getStoreId());
        vo.setSupperImww(shop.getImAliww());
        vo.setSupperQq(shop.getImQq());
        vo.setSupperTelephone(shop.getTelephone());
        vo.setSupperTaobaoUrl(shop.getTaobaoUrl());
        itemUpRecordService.addItemUpRecord(vo);
    }

}
