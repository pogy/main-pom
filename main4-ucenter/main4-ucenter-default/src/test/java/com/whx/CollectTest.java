package com.whx;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.NewGoodsCollectVO;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类名：CollectTest
 * 类路径：com.whx.CollectTest
 * 创建者：王浩翔
 * 创建时间：2017-10-17 16:25
 * 项目：main-pom
 * 描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/main4/spring/spring.xml")
public class CollectTest {

    @Autowired
    UserCollectService userCollectService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;


    @Test
    public void selShopCollectionsTest(){
        ShiguPager<ShopCollectVO> hz = userCollectService.selShopCollections(1000083680L, "hz", 1, 12);
        System.out.println(JSON.toJSONString(hz));
    }

    @Test
    public void selItemCollectionsByTypeTest(){
        ShiguPager<NewGoodsCollectVO> dataPackage = userCollectService.selItemCollectionsByType(1000083680L, null, "hz", 1, 5, 1);
        ShiguPager<NewGoodsCollectVO> goodsCollect = userCollectService.selItemCollectionsByType(1000083680L, null, "hz", 1, 5, 2);
        System.out.println(JSON.toJSONString(dataPackage));
        System.out.println(JSON.toJSONString(goodsCollect));
    }

    @Test
    public void delShopCollectionTest(){
        userCollectService.delShopCollection(1000083680L, Lists.newArrayList(106559L));
    }

    @Test
    public void delItemCollectionTest() {
        try {
            userCollectService.delItemCollection(1000083680L,Lists.newArrayList(851820L,851821L));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void addShopCollectionTest() throws ShopCollectionException {
        ShopCollect shopCollect = new ShopCollect();
        shopCollect.setWebsite("hz");
        shopCollect.setUserId(1000083680L);
        shopCollect.setShopId(42669L);
        userCollectService.addShopCollection(shopCollect);
    }

    @Test
    public void addItemCollectionTest(){
        addItem(1000083680L,21470025L,2);
        addItem(1000083680L,21470035L,2);
        addItem(1000083680L,21470041L,1);
    }

    public boolean addItem(Long userId,Long goodsId,int type){
        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        //查出店、webSite
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(goodsId);
        sgt.setWebSite("hz");
        sgt=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt, FieldUtil.codeFields("goods_id,store_id,title,type"));
        itemCollect.setItemId(goodsId);
        itemCollect.setStoreId(sgt.getStoreId());
        itemCollect.setWebsite("hz");
        itemCollect.setTitle(sgt.getTitle());
        itemCollect.setType(type);
        try {
            userCollectService.addItemCollection(itemCollect);
        } catch (ItemCollectionException e) {
            return false;
        }
        return true;
    }
}
