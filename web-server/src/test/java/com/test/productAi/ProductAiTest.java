package com.test.productAi;

import com.shigu.productAi.beans.*;
import com.shigu.productAi.services.ProductAiInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by pc on 2017-07-13.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="/main4/spring/test.xml")
public class ProductAiTest {
    @Autowired
    ProductAiInterface productAiInterface;
    @Test
    public void search_Test(){


        ProductAiSearchBo bo =new ProductAiSearchBo();
        bo.setUrl("https://img.alicdn.com/bao/uploaded/i3/324975222/TB2ejyNqS0jpuFjy0FlXXc0bpXa_!!324975222.jpg");
        bo.setCount(5);
        bo.setTags("cs");

        List<AiImageInfo> search = productAiInterface.search(bo);
        for (AiImageInfo info:search
             ) {
            System.out.println("url:"+info.getImageUrl()+"meta:"+info.getMeta());

            Assert.notNull(info.getImageUrl(),"url不可能为空");
        }
    }
    @Test
    public void add_Test(){
        ProductAiAddBo bo = new ProductAiAddBo();
        List<AiImageInfo> infolist= new ArrayList<>();
        bo.setImages(infolist);
        AiImageInfo info =new AiImageInfo();
        info.setImageUrl("https://img.alicdn.com/bao/uploaded/i3/324975222/TB2ejyNqS0jpuFjy0FlXXc0bpXa_!!324975222.jpg");
        info.setMeta("20570324-男装");
        infolist.add(info);
        AiImageInfo info2 = new AiImageInfo();
        info2.setImageUrl("https://img.alicdn.com/bao/uploaded/i4/TB1It.1PXXXXXaBXFXXXXXXXXXX_!!0-item_pic.jpg");
        info2.setMeta("9928088-男装");
        infolist.add(info2);
        ProductAiVo productAiAddVo = productAiInterface.addAi(bo);

        System.out.println(productAiAddVo.getRequestId()+"\r\n"+productAiAddVo.getImageSetId());

    }

    @Test
    public void addOne_Test(){
        ProductAiAddBo bo = new ProductAiAddBo();
        List<AiImageInfo> infolist= new ArrayList<>();
        bo.setImages(infolist);
        AiImageInfo info =new AiImageInfo();
        info.setImageUrl("https://img.alicdn.com/bao/uploaded/i2/424259443/TB2t5tkXlEOyuJjy0FdXXbzApXa_!!424259443.jpg");
        info.setMeta("20886293-男装");
        info.setTags("hz");
        infolist.add(info);

        ProductAiVo productAiAddVo = productAiInterface.addAi(bo);
        System.out.println(productAiAddVo.getRequestId());
    }


    @Test
    public void delete_Test(){
        ProductAiDelBo bo =new ProductAiDelBo();
        List<AiImageInfo> infolist= new ArrayList<>();
        bo.setImages(infolist);
        AiImageInfo info =new AiImageInfo();
        //info.setImageUrl("https://img.alicdn.com/bao/uploaded/i3/324975222/TB2ejyNqS0jpuFjy0FlXXc0bpXa_!!324975222.jpg");
        //info.setMeta("20570324-男装");
        info.setImageUrl("https://img.alicdn.com/bao/uploaded/i4/TB1It.1PXXXXXaBXFXXXXXXXXXX_!!0-item_pic.jpg");
        info.setMeta("9928088-男装");
        infolist.add(info);
        ProductAiVo delete = productAiInterface.delete(bo);
        System.out.println(delete.getRequestId());
    }

}
