package com.whx;

import com.item.test.BaseSpringTest;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.utils.JsoupUtil;
import com.shigu.main4.item.services.utils.OuterSynUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类名：TbUnauthSynTest
 * 类路径：com.whx.TbUnauthSynTest
 * 创建者：王浩翔
 * 创建时间：2017-11-05 12:12
 * 项目：main-pom
 * 描述：
 */
public class TbUnauthSynTest extends BaseSpringTest {
    @Autowired
    OuterSynUtil taobaoUnauthorizedSynService;

    @Test
    public void testSynShop(){
        taobaoUnauthorizedSynService.synOneShop(43429L);
    }

    @Autowired
    OuterSynUtil wsyUnauthorizedSynService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;
    @Test
    public void t() throws IOException {
        long l=new Date().getTime();
//        wsyUnauthorizedSynService.synOneShop(43476L,1032352L);
//        wsyUnauthorizedSynService.synOneGoods(43476L,1032352L,4716530L);

//        wsyUnauthorizedSynService.synOneShop(40072L,982561L);//217
////        wsyUnauthorizedSynService.synOneShop(41424L,532410L);//226
//        wsyUnauthorizedSynService.synOneShop(16346L,23389L);//228
//        wsyUnauthorizedSynService.synOneShop(43350L,115111L);//301D-2
//        wsyUnauthorizedSynService.synOneShop(40270L,476257L,"2017-01-01");//401
//        wsyUnauthorizedSynService.synOneShop(15898L,10513L);//1314
//        wsyUnauthorizedSynService.synOneShop(39988L,10488L);//1601
//        wsyUnauthorizedSynService.synOneShop(43551L,1139401L);//1712
//        wsyUnauthorizedSynService.synOneShop(43553L,1112935L);//1713
//        wsyUnauthorizedSynService.synOneShop(42641L,1090076L);//618A
        wsyUnauthorizedSynService.synOneShop(41033L,1032352L);//1101


//        wsyUnauthorizedSynService.synOneGoods(41033L,1032352L,3360524L);

        System.out.println(new Date().getTime()-l);
    }



}
