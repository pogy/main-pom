package com.test.webservertest;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.vo.fitment.ItemPromoteModule;
import com.shigu.seller.services.ShopDesignService;
import com.shigu.seller.vo.ContainerVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * 类名：ShopFitmentServiceImplTest
 * 类路径：com.test.webservertest.ShopFitmentServiceImplTest
 * 创建者：王浩翔
 * 创建时间：2017-08-21 18:17
 * 项目：main-pom
 * 描述：
 */

/**
 * 测试类{@link com.shigu.main4.storeservices.impl.ShopFitmentServiceImpl}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/test.xml" )
public class ShopFitmentServiceImplTest {

    /**
     * 不进行装修初始化的档口id
     */
    Long[] ignoredShopIds = {};
    /**
     * 要进行装修初始化的市场
     */
    Long[] marketIds = {};
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    private ShopFitmentService shopFitmentService;
    /**
     * 初始化店铺装修工具
     */
    @Test
    public void InitShopFitment() throws Exception {
        //给定市场
        ShiguShopExample example = new ShiguShopExample();
        example.createCriteria().andMarketIdIn(Arrays.asList(marketIds)).andShopIdNotIn(Arrays.asList(ignoredShopIds)).andShopStatusEqualTo(0);
        shiguShopMapper.selectFieldsByExample(example,FieldUtil.codeFields("shop_id")).stream().map(ShiguShop::getShopId)
                .forEach(o->{
                    try {
                        shopFitmentService.initShopFitment(o);
                    } catch (ShopFitmentException e) {
                        e.printStackTrace();
                    }
                });
        //其他市场
        example = new ShiguShopExample();
        example.createCriteria().andMarketIdNotIn(Arrays.asList(marketIds)).andShopStatusEqualTo(0);
        shiguShopMapper.selectByExample(example).forEach(o->{
            try {
                if (noFitment(shopDesignService.selPagePublishedById(shopDesignService.selPageIdByShopId(o.getShopId()),shopDesignService.selShopForModule(o.getShopId(),
                        o.getWebSite())))) {
                    shopFitmentService.initShopFitment(o.getShopId());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ShopFitmentException e) {
                e.printStackTrace();
            }
        });
    }

    @Autowired
    private ShopDesignService shopDesignService;

    //原noFitment逻辑
    private boolean noFitment(ContainerVO vo){
        if(vo.getFitmentAreas()==null||vo.getFitmentAreas().size()!=1
                ||vo.getFitmentAreas().get(0).getLeftarea()==null||vo.getFitmentAreas().get(0).getLeftarea().size()!=1
                ||vo.getFitmentAreas().get(0).getLeftarea().get(0).getModuleType()!= FitmentModuleType.Category.value
                ||vo.getFitmentAreas().get(0).getRightarea()==null||vo.getFitmentAreas().get(0).getRightarea().size()!=1
                ||vo.getFitmentAreas().get(0).getRightarea().get(0).getModuleType()!=FitmentModuleType.Promote.value){
            return false;
        }
        ItemPromoteModule promote= (ItemPromoteModule) vo.getFitmentAreas().get(0).getRightarea().get(0);
        if(promote.getPromoteType()==1&&promote.getSort()==1&&promote.getItemNum()==16&&promote.getShowPage()==0
                &&promote.getShowTitle()==1&&promote.getShowGoodsNo()==0&&promote.getShowPrice()==1
                &&promote.getTitle().equals("推荐宝贝")&&promote.getRadio()==4&&promote.getFilter()==0){
            return true;
        }else{
            return false;
        }
    }
}