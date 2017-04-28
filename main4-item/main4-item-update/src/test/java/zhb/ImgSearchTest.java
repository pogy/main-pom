package zhb;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.util.Jobs;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by zhaohongbo on 17/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/item-update.xml")
public class ImgSearchTest {
    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Test
    public void test(){
        itemAddOrUpdateService.addImgToSearch(20224369L, "hz", "https://img.alicdn.com/bao/uploaded/i1/1122621970/TB20BQ4hthvOuFjSZFBXXcZgFXa_!!1122621970.jpg",1);
    }

    @Test
    public void picImgTrans() {
        Jobs<List<ShiguGoodsTiny>> jobs = new Jobs<List<ShiguGoodsTiny>>(20) {
            @Override
            public void doWork(List<ShiguGoodsTiny> shiguGoodsTinies) throws Exception {
                for (ShiguGoodsTiny tiny : shiguGoodsTinies) {
                    itemAddOrUpdateService.addImgToSearch(tiny.getGoodsId(), tiny.getWebSite(), tiny.getPicUrl(), 1);
                }
            }
        };


        String[] sites = {
                "hz",
//                "cs",
//                "bb",
//                "bj",
//                "gz",
//                "jf",
//                "jx",
//                "ss",
//                "wa",
//                "xh",
        };

        for (String site : sites) {
            int start = 0;
            int size = 1000;
            ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
            tinyExample.setWebSite(site);
            tinyExample.setStartIndex(start);
            tinyExample.setEndIndex(size);
            tinyExample.createCriteria().andParentMarketIdNotEqualTo(674L);
            List<ShiguGoodsTiny> goodsTinies;
            while (!(goodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id, pic_url, web_site"))).isEmpty()) {
                jobs.addJob(goodsTinies);
                tinyExample.setStartIndex(start += size);
            }
        }

        jobs.join();
    }
}
