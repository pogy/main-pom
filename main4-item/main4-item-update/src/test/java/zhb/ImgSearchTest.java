package zhb;

import com.shigu.main4.item.services.ItemAddOrUpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by zhaohongbo on 17/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/item-update.xml")
public class ImgSearchTest {
    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Test
    public void test(){
        itemAddOrUpdateService.addImgToSearch(20224369L,"hz","https://img.alicdn.com/bao/uploaded/i1/1122621970/TB20BQ4hthvOuFjSZFBXXcZgFXa_!!1122621970.jpg",1);
    }
}
