package com.test.productAi;

import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.vo.GoodsInSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created by pc on 2017-07-21.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/test.xml")
public class GoodsSearchServiceTest {

    @Autowired
    GoodsSearchService goodsSearchService;


    @Test
    public void test_searchByPic(){


        try {
            List<GoodsInSearch> hz = goodsSearchService.searchByPic("https://img.alicdn.com/bao/uploaded/i2/424259443/TB2t5tkXlEOyuJjy0FdXXbzApXa_!!424259443.jpg", "hz");
            System.out.println("条数"+hz.size());
            System.out.println(hz.get(0).getImgsrc());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
