package com.shigu.sysman.goods.service;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.sysman.goods.actions.ShiguGoodsWhController;
import com.shigu.sysman.goods.bo.ShiguGoodsTinyBo;
import com.shigu.sysman.goods.vo.ShiguGoodsTinyVo;
import com.shigu.zhb.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/02 12:27
 *
 */
@Service("back_shiguGoodsTinyService")
public class ShiguGoodsTinyService {

    private static final Logger logger = LoggerFactory.getLogger(ShiguGoodsTinyService.class);

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ItemAddOrUpdateService itemAddOrUpdateService;

    /**
     * 商品列表
     * @param shiguGoodsTinyBo
     * @return
     */
    public List<ShiguGoodsTinyVo> findListByBo(ShiguGoodsTinyBo shiguGoodsTinyBo){
        if(shiguGoodsTinyBo == null){
            shiguGoodsTinyBo = new ShiguGoodsTinyBo();
        }
        List<ShiguGoodsTiny> shiguGoodsTinyList = shiguGoodsTinyMapper.selectGoodsTinyListByBo(shiguGoodsTinyBo.getWebsite(),
                shiguGoodsTinyBo.getGoodsId(), shiguGoodsTinyBo.getGtSortOrder(), shiguGoodsTinyBo.getStartRow(),
                shiguGoodsTinyBo.getPageSize());
        List<ShiguGoodsTinyVo> goodsTinyVoList = BeanMapper.mapList(shiguGoodsTinyList, ShiguGoodsTinyVo.class);
        return goodsTinyVoList;
    }

    /**
     * 商品记录数
     * @param shiguGoodsTinyBo
     * @return
     */
    public int countByBo(ShiguGoodsTinyBo shiguGoodsTinyBo){
        if(shiguGoodsTinyBo == null){
            shiguGoodsTinyBo = new ShiguGoodsTinyBo();
        }
        int count = shiguGoodsTinyMapper.selectGoodsTinyCountByBo(shiguGoodsTinyBo.getWebsite(),shiguGoodsTinyBo.getGoodsId(),
                shiguGoodsTinyBo.getGtSortOrder());
        return count;
    }

    /**
     * 分页查询商品
     * @param shiguGoodsTinyBo
     * @return
     */
    public ShiguPager<ShiguGoodsTinyVo> findPagerByBo(ShiguGoodsTinyBo shiguGoodsTinyBo){
        if(shiguGoodsTinyBo == null){
            shiguGoodsTinyBo = new ShiguGoodsTinyBo();
        }
        List<ShiguGoodsTinyVo> goodsTinyVoList = findListByBo(shiguGoodsTinyBo);
        int count = countByBo(shiguGoodsTinyBo);
        ShiguPager<ShiguGoodsTinyVo> pager = new ShiguPager<ShiguGoodsTinyVo>();
        pager.setContent(goodsTinyVoList);
        pager.setNumber(shiguGoodsTinyBo.getCurrentPage());
        pager.calPages(count,shiguGoodsTinyBo.getPageSize());
        return pager;
    }

    /**
     * 商品更新
     * @param
     */
    public void updateGoodsTiny(ShiguGoodsTiny shiguGoodsTiny) throws ItemModifyException {
        if(shiguGoodsTiny == null || shiguGoodsTiny.getGoodsId() == null){
            return;
        }
        SynItem synItem = new SynItem();
        synItem.setGoodsId(shiguGoodsTiny.getGoodsId());
        synItem.setNumIid(shiguGoodsTiny.getNumIid());
        synItem.setShopId(shiguGoodsTiny.getStoreId());
        synItem.setSortOrder(shiguGoodsTiny.getSortOrder());
        itemAddOrUpdateService.systemUpdateItem(synItem);
    }

    /**
     * 商品查询 BY ID
     * @param goodsId
     * @return
     */
    public ShiguGoodsTinyVo findGoodsTinyById(Long goodsId, String webSite){
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setWebSite(webSite);
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny = shiguGoodsTinyMapper.selectOne(shiguGoodsTiny);
        ShiguGoodsTinyVo shiguGoodsTinyVo = BeanMapper.map(shiguGoodsTiny, ShiguGoodsTinyVo.class);
        return shiguGoodsTinyVo;
    }

}
