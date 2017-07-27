package com.test.productAi;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.productAi.beans.AiImageInfo;
import com.shigu.productAi.beans.ProductAiAddBo;
import com.shigu.productAi.beans.ProductAiVo;
import com.shigu.productAi.services.ProductAiInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
public class GoodsUPAi {
    @Autowired
    ProductAiInterface productAiInterface;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Test
    public void selGoodsToUp() {
        Long endId = 20928882L;

        int row = 10000;//一次选一万条
        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite("wa");
        example.createCriteria().andIsClosedEqualTo(0l).andPicUrlIsNotNull();
        int totalSize = 0 ;

        ProductAiAddBo bo = new ProductAiAddBo();

        fun:for(int i =1;;i++){
            List<AiImageInfo> infolist= new ArrayList<>();
            example.setStartIndex((i-1)*row);
            example.setEndIndex(row);

            List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(example
                    , FieldUtil.codeFields("goods_id,pic_url,web_site"));

            if(shiguGoodsTinies.size()==0){
                break ;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int j = 0; j<shiguGoodsTinies.size();j++){
                ShiguGoodsTiny tiny = shiguGoodsTinies.get(j);
                if(tiny.getGoodsId().longValue()> endId.longValue()){
                    break fun;
                }
                if(tiny.getPicUrl()==null||tiny.getPicUrl().trim().equals("")){
                    continue ;
                }
                AiImageInfo info = new AiImageInfo();
                info.setTags(tiny.getWebSite());
                info.setMeta(tiny.getGoodsId().toString());
                info.setImageUrl(tiny.getPicUrl());
                infolist.add(info);
            }
            System.out.println(infolist.size());
            totalSize+=infolist.size();
            bo.setImages(infolist);
            if(infolist.size()>0) {
                ProductAiVo productAiVo = productAiInterface.addAi(bo);
                System.out.println(productAiVo.getRequestId());
            }


        }

        System.out.println(totalSize);


    }

    public static void main(String[] args) {

        int max =100;
        int index= 0;

        fun:for(int i=0;;i++){
            for(int j=0;j<10;j++){

                if(index>100){
                    break ;
                }
                System.out.println(index);
                index++;

            }
        }
    }

}
