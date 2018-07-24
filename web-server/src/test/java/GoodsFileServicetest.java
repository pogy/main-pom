import com.shigu.seller.services.GoodsFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Admin on 2017/7/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class GoodsFileServicetest {
    @Autowired
    GoodsFileService goodsFileService;
    @Test
    public void add(){
//        int i = goodsFileService.saveGoodsFile("test", 165843L);
//        System.out.println(i);

    }
    @Test
    public void del(){
//        int i = goodsFileService.delGoodsfile(1L);
//        System.out.println(i);
    }
    @Test
    public void selGoodsFileByGoodsId(){
//        GoodsFile goodsFile = goodsFileService.selGoodsFileByGoodsId(1L);
//        System.out.println(goodsFile.getGoodsId());
    }
    @Test
    public void selGoodsFileByFile(){
//        assert (goodsFileService.selGoodsFileByFile("test").size()>0);
    }

}
