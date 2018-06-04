package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguGysCategoryGoods;
import com.opentae.data.mall.beans.ShiguGysCustomCategory;
import com.opentae.data.mall.examples.ShiguGysCategoryGoodsExample;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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



    @Override
    public TabDatasVo getShopTabDatas(Long shopId,String webSite) {
        TabDatasVo tabDatasVo = new TabDatasVo();
        Integer nonum = shiguGysCategoryGoodsMapper.selectGoodsCountByDiyCate(shopId,webSite,null);
        ShiguGysCustomCategory shiguGysCustomCategory = new ShiguGysCustomCategory();
        shiguGysCustomCategory.setSId(shopId);
        shiguGysCustomCategory.setGcStatus(1);
        List<ShiguGysCustomCategory> shiguGysCustomCategoryList = shiguGysCustomCategoryMapper.select(shiguGysCustomCategory);
        if (shiguGysCustomCategoryList == null || shiguGysCustomCategoryList.size()<=0){
            tabDatasVo.setNoSetCateGoodsNum(nonum);
            tabDatasVo.setCates(new ArrayList<>());
            return tabDatasVo;
        }
        List<CatesVo> catesVoList = new ArrayList<>();
        ShiguGysCustomCategory customCategory = null;
        for (int i = 0; i <shiguGysCustomCategoryList.size() ; i++) {
            CatesVo catesVo = new CatesVo();
            customCategory = shiguGysCustomCategoryList.get(i);
            catesVo.setCnameId(customCategory.getGcId());
            catesVo.setCname(customCategory.getGcName());
            Integer goodsCateNum = shiguGysCategoryGoodsMapper.getCateInfo(customCategory.getGcId(),webSite);
            catesVo.setCnameNum(goodsCateNum==null?0:goodsCateNum);
            catesVoList.add(catesVo);
        }
        tabDatasVo.setNoSetCateGoodsNum(nonum);
        tabDatasVo.setCates(catesVoList);
        return tabDatasVo;
    }

    @Override
    public ShiguPager<GoodsVo> getShopShowGoods(Long shopId, Long cnameId,Integer page,Integer size,String webSite) {
        ShiguPager<GoodsVo> pager = new ShiguPager<>();
        if (page==null || page < 1)
            page = 1;
        if (size==null ||size < 1)
            size = 10;
        pager.setNumber(page);
        int pageno = (page-1)*size;
        int count = shiguGysCategoryGoodsMapper.selectGoodsCountByDiyCate(shopId,webSite,cnameId);
        pager.calPages(count, size);
        if (count > 0){
            List<GoodsVo> goodsVoList=null;
            try {
                goodsVoList = shiguGysCategoryGoodsMapper.selectGoodsByDiyCate(shopId, webSite, cnameId, pageno, size);
            }catch (Exception e){
                e.printStackTrace();
            }
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
    public Integer setCategoryForGoods(String ids, Long cnameId,Integer zt,Long shopId) {
        if (ids==null||ids.length()<=0)
            return -2;
        if (zt==2) {
            ShiguGysCategoryGoodsExample shiguGysCategoryGoodsExample = new ShiguGysCategoryGoodsExample();
            shiguGysCategoryGoodsExample.createCriteria().andGoodsIdIn(Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList()));
            ShiguGysCategoryGoods g = new ShiguGysCategoryGoods();
            g.setGcId(cnameId);
            return shiguGysCategoryGoodsMapper.updateByExampleSelective(g, shiguGysCategoryGoodsExample);
        }
        List<ShiguGysCategoryGoods> gysCategoryGoods = new ArrayList<>();
        String[] idstrs = ids.split(",");
        for (int i = 0; i <idstrs.length ; i++) {
            ShiguGysCategoryGoods shiguGysCategoryGoods = new ShiguGysCategoryGoods();
            shiguGysCategoryGoods.setSId(shopId);
            shiguGysCategoryGoods.setGcId(cnameId);
            shiguGysCategoryGoods.setGcgStatus(1);
            shiguGysCategoryGoods.setGoodsId(Long.valueOf(idstrs[i]));
            gysCategoryGoods.add(shiguGysCategoryGoods);
        }
        return shiguGysCategoryGoodsMapper.insertListNoId(gysCategoryGoods);
    }

    @Override
    @Transactional
    public Integer deleCate(Long cateId) {
        ShiguGysCategoryGoodsExample shiguGysCategoryGoodsExample = new ShiguGysCategoryGoodsExample();
        shiguGysCategoryGoodsExample.createCriteria().andGcIdEqualTo(cateId).andGcgStatusEqualTo(1);
        ShiguGysCategoryGoods g = new ShiguGysCategoryGoods();
        g.setGcgStatus(-1);
        shiguGysCategoryGoodsMapper.updateByExampleSelective(g, shiguGysCategoryGoodsExample);
        ShiguGysCustomCategory shiguGysCustomCategory = new ShiguGysCustomCategory();
        shiguGysCustomCategory.setGcId(cateId);
        shiguGysCustomCategory.setGcStatus(-1);
        return shiguGysCustomCategoryMapper.updateByPrimaryKey(shiguGysCustomCategory);
    }

}
