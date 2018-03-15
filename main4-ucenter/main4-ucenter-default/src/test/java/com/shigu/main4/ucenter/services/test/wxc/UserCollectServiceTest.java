package com.shigu.main4.ucenter.services.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.beans.ShiguStoreCollect;
import com.opentae.data.mall.examples.ShiguStoreCollectExample;
import com.opentae.data.mall.interfaces.ShiguGoodsCollectMapper;
import com.opentae.data.mall.interfaces.ShiguStoreCollectMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import static org.junit.Assert.*;

import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.session.main4.tool.BeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/spring.xml" )
@Transactional(rollbackFor = Exception.class)
public class UserCollectServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(UserCollectServiceTest.class);

    @Resource
    private UserCollectService userCollectService;

    @Autowired
    private ShiguGoodsCollectMapper shiguGoodsCollectMapper;

    @Autowired
    private ShiguStoreCollectMapper shiguStoreCollectMapper;

    @Test
    public void testSelByType(){
        userCollectService.selItemCollectionsByType(1000067987L,null,"hz",1,12,2);
    }
    /**
     * 查询本店收藏的宝贝
     */
    @Test
    public void testSelItemCollections() {
        ShiguPager<ItemCollectVO> pager = userCollectService.selItemCollections(1000064147L, "2017","hz", 1, 10);
        logger.info("\n" + JSON.toJSONString(pager, SerializerFeature.PrettyFormat));
        assertTrue(pager != null && pager.getContent() != null);
    }

    /**
     * 查询本店收藏的店铺
     * shop表数据较少，所以返回数据有点少
     */
    @Test
    public void testSelShopCollections() {
        ShiguPager<ShopCollectVO> pager = userCollectService.selShopCollections(9968L, "hz", 1, 4);
        logger.info("\n" + JSON.toJSONString(pager, SerializerFeature.PrettyFormat));
        assertTrue(pager != null && pager.getContent() != null);
    }

    /**
     * 批量删除用户收藏的宝贝
     * Tip: 测试请连本地数据库。
     *  修改/test/resources/mall_config.properties ,只要所连库存在shigu_goods_collect一张表就成
     */
    @Test
    public void testDelItemCollection() {
        List<Long> list = new ArrayList<>();
        list.add(1418L);
        userCollectService.delItemCollection(9968L, list);
    }
    /**
     * 测试添加收藏服务
     *      测试数据自动回滚
     */
    @Test
    public void addItemCollection() {
        // 添加新收藏
        ItemCollect collect = new ItemCollect();
        collect.setItemId(88088L);
        collect.setStoreId(18311L);
        collect.setUserId(9968L);
        collect.setWebsite("hz");
        try {
            userCollectService.addItemCollection(collect);
            ShiguGoodsCollect col = BeanMapper.map(collect, ShiguGoodsCollect.class);
            col.setGoodsId(collect.getItemId());
            assertFalse("插入失败", shiguGoodsCollectMapper.select(col).isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());
        }

        // 测试参数错误
        collect.setItemId(88088L);
        collect.setStoreId(18311L);
        collect.setUserId(null);
        collect.setWebsite("hz");
        try {
            userCollectService.addItemCollection(collect);
            fail("userID为null不应该添加成功");
        } catch (ItemCollectionException e) {
            assertTrue(e.getCode().equals(ItemCollectionException.ItemCollecExcpEnum.IllegalArgumentException.getCode()));
        }

        // 测试已收藏错误
        collect.setItemId(512892L);
        collect.setStoreId(16589L);
        collect.setUserId(9968L);
        collect.setWebsite("hz");
        try {
            userCollectService.addItemCollection(collect);
            fail("512892L商品应该是已收藏的");
        } catch (ItemCollectionException e) {
            assertTrue(e.getCode().equals(ItemCollectionException.ItemCollecExcpEnum.CollectionAlreadyExist.getCode()));
        }
    }

    /**
     *  测试店铺收藏删除
     */
    @Test
    public void delShopCollection() {
        List<Long> collectIds = new ArrayList<>();
        collectIds.add(18538L);
        collectIds.add(24816L);
        Long userId = 9968L;

        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andStoreIdIn(collectIds);
        List<ShiguStoreCollect> shiguStoreCollects = shiguStoreCollectMapper.selectByExample(collectExample);

        // 验证测试数据存在
        assertFalse(shiguStoreCollects.isEmpty());

        userCollectService.delShopCollection(userId, collectIds);
        // 验证测试数据正确删除
        assertTrue(shiguStoreCollectMapper.selectByExample(collectExample).isEmpty());
        // 自动回滚
    }

    /**
     *  添加店铺收藏测试
     */
    @Test
    public void addShopCollection()  {
// 添加新收藏
        ShopCollect collect = new ShopCollect();
        collect.setUserId(9968L);
        collect.setShopId(88088L);
        collect.setWebsite("hz");

        // 验证测试数据不存在
        ShiguStoreCollect col = new ShiguStoreCollect();
        col.setUserId(collect.getUserId());
        col.setWebSite(collect.getWebsite());
        col.setStoreId(collect.getShopId());
        assertTrue("测试数据已存在，请更换测试数据", shiguStoreCollectMapper.select(col).isEmpty());
        try {
            userCollectService.addShopCollection(collect);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertFalse("插入失败", shiguStoreCollectMapper.select(col).isEmpty());


        // 测试已收藏错误(刚刚插入的测试数据)
        try {
            userCollectService.addShopCollection(collect);
            fail();
        } catch (ShopCollectionException e) {
            assertTrue(e.getCode().equals(ShopCollectionException.ShopCollecExcpEnum.CollectionAlreadyExist.getCode()));
        }

        // 测试参数错误
        collect.setShopId(null);
        try {
            userCollectService.addShopCollection(collect);
            fail("ShopId为null不应该添加成功");
        } catch (ShopCollectionException e) {
            assertTrue(e.getCode().equals(ShopCollectionException.ShopCollecExcpEnum.IllegalArgumentException.getCode()));
        }
    }
}
