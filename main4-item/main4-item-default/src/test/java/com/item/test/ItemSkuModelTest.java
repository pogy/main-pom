package com.item.test;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsSingleSku;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguSite;
import com.opentae.data.mall.examples.ShiguGoodsSingleSkuExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsSingleSkuMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguSiteMapper;
import com.shigu.main4.common.util.Jobs;
import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemSkuModelTest extends BaseSpringTest{
    @Autowired
    ShiguSiteMapper shiguSiteMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;


    @Test
    public void vv(){
        SpringBeanFactory.getBean(ItemSkuModel.class,23000216L);
    }


    @Test
    public void v(){
        List<ShiguSite> sites=shiguSiteMapper.select(new ShiguSite());
        for(ShiguSite site:sites){
            System.out.println(site.getCitySite());
            ShiguGoodsSingleSkuExample shiguGoodsSingleSkuExample=new ShiguGoodsSingleSkuExample();
            shiguGoodsSingleSkuExample.setWebSite(site.getCitySite());
            shiguGoodsSingleSkuExample.setOrderByClause("goods_id desc");
            shiguGoodsSingleSkuExample.setStartIndex(0);
            shiguGoodsSingleSkuExample.setEndIndex(1);
            Long lastGoodsId;
            try {
                List<ShiguGoodsSingleSku> shiguGoodsSingleSkus=shiguGoodsSingleSkuMapper.selectByConditionList(shiguGoodsSingleSkuExample);
                if(shiguGoodsSingleSkus.size()==0){
                    lastGoodsId=-1L;
                }else{
                    lastGoodsId=shiguGoodsSingleSkus.get(0).getGoodsId();
                }
            } catch (Exception e) {
                //过滤掉不存在的站点
                continue;
            }
            while (true) {
                if ((lastGoodsId = skus(site.getCitySite(),lastGoodsId)) == null) break;
            }
        }
    }

    private Long skus(String webSite ,Long lastGoodsId){
        ShiguGoodsTinyExample shiguGoodsTinyExample=new ShiguGoodsTinyExample();
        shiguGoodsTinyExample.createCriteria().andGoodsIdGreaterThan(lastGoodsId).andIsClosedEqualTo(0L).andGoodsStatusEqualTo(0);
        shiguGoodsTinyExample.setWebSite(webSite);
        shiguGoodsTinyExample.setOrderByClause("goods_id asc");
        shiguGoodsTinyExample.setStartIndex(0);
        shiguGoodsTinyExample.setEndIndex(1000);
        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id"));
        Long gid=null;
        Jobs<Long> jobs=new Jobs<Long>(100) {
            @Override
            public void doWork(Long o) throws Exception {
                try {
                    SpringBeanFactory.getBean(ItemSkuModel.class,o);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(o);
                }
            }
        };
        for(ShiguGoodsTiny shiguGoodsTiny:shiguGoodsTinies){
            jobs.addJob(shiguGoodsTiny.getGoodsId());
            gid=shiguGoodsTiny.getGoodsId();
        }
        jobs.join();
        return gid;
    }
}
