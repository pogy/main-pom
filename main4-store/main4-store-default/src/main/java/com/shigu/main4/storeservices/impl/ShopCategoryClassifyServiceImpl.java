package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguGysCustomCategory;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguGysCategoryGoodsMapper;
import com.opentae.data.mall.interfaces.ShiguGysCustomCategoryMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.ShopCategoryClassifyService;
import com.shigu.main4.vo.CatesVo;
import com.shigu.main4.vo.GoodsVo;
import com.shigu.main4.vo.TabDatasVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.storeservices.impl
 * @ClassName: ShopCategoryClassifyServiceImpl
 * @Author: sy
 * @CreateDate: 2018/5/31 0031 13:22
 */
@Service("ShopCategoryClassifyService")
public class ShopCategoryClassifyServiceImpl implements ShopCategoryClassifyService {

    @Autowired
    private ShiguGysCategoryGoodsMapper shiguGysCategoryGoodsMapper;
    @Autowired
    private ShiguGysCustomCategoryMapper shiguGysCustomCategoryMapper;
    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;



    @Override
    public TabDatasVo getShopTabDatas(Long shopId) {
        TabDatasVo tabDatasVo = new TabDatasVo();
        Integer nonum = shiguGoodsTinyMapper.selectGoodsCountByShopId(shopId,"qz");
        List<CatesVo> catesVoList = shiguGysCategoryGoodsMapper.getCateInfo(shopId,"qz");
        if (catesVoList == null ||catesVoList.size() <= 0) {
            tabDatasVo.setNoSetCateGoodsNum(nonum);
            tabDatasVo.setCates(new ArrayList<>());
            return tabDatasVo;
        }
        Integer num = 0;
        for (int i = 0; i <catesVoList.size() ; i++) {
            num +=catesVoList.get(i).getCnameNum();
        }
        tabDatasVo.setNoSetCateGoodsNum(nonum-num);
        tabDatasVo.setCates(catesVoList);
        return tabDatasVo;
    }

    @Override
    public ShiguPager<GoodsVo> getShopShowGoods(Long shopId, Long cnameId,Integer page,Integer size) {
        ShiguPager<GoodsVo> pager = new ShiguPager<>();
        if (page==null || page < 1)
            page = 1;
        if (size==null ||size < 1)
            size = 10;
        pager.setNumber(page);
        int pageno = (page-1)*size;
        int count = shiguGysCategoryGoodsMapper.selectGoodsCountByDiyCate(shopId,"qz",cnameId);
        pager.calPages(count, size);
        if (count > 0){
            List<GoodsVo> goodsVoList = shiguGysCategoryGoodsMapper.selectGoodsByDiyCate(shopId,"qz",cnameId,pageno,size);
            if (goodsVoList == null || goodsVoList.size() <= 0){
                pager.setContent(new ArrayList<>());
                return pager;
            }
            pager.setContent(BeanMapper.mapList(goodsVoList, GoodsVo.class));
        }
        return pager;
    }

    @Override
    public Integer addCustomCategory(String cname, Long shopId) {
        ShiguGysCustomCategory shiguGysCustomCategory = new ShiguGysCustomCategory();
        shiguGysCustomCategory.setGcName(cname);
        shiguGysCustomCategory.setGcStatus(1);
        shiguGysCustomCategory.setSId(shopId);
        return shiguGysCustomCategoryMapper.insertSelective(shiguGysCustomCategory);
    }

    @Override
    public Integer setCategoryForGoods(String ids, String cnameId,Integer zt) {
        return null;
    }
}
