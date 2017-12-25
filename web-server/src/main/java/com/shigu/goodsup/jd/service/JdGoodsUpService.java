package com.shigu.goodsup.jd.service;


import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdGoodsService;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created By admin on 2017/12/22/20:40
 */
@Service
public class JdGoodsUpService {

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private JdGoodsService jdGoodsService;

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    /**
     *查询用户是否已上传过
     * 根据goodsId获取tbCid,然后去jd_tb_bind表查询,如果查不到,则不能上传
     * @return
     */
    public Boolean goodsCanbeUploadedToJd(Long goodsId) throws JdUpException {
        ShiguGoodsIdGenerator generator;
        // 验证参数，并查询分站存在
        if (goodsId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId)) == null) {
            throw new JdUpException("未查询到分站信息");
        }
        String webSite = generator.getWebSite();
        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        if ((tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny)) == null) {
            throw new JdUpException("未查询到商品信息");
        }
        Long tbCid = tiny.getCid();
        return jdGoodsService.goodsCanbeUploadedToJd(tbCid);
    }


    /**
     * 查询用户是否已上传过, true: 已经上传过， false ：未上传过
     * @return
     */
    public Boolean hasBeUploaded(Long userId,Long goodsId) {
        LastUploadedVO lastUploadedVO = itemUpRecordService.selLastUpByIds(userId, goodsId);
        return lastUploadedVO != null;
    }

}
