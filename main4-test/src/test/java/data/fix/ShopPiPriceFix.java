package data.fix;

import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.tb.finder.exceptions.TbItemSynException;
import com.shigu.tb.finder.services.TaobaoSynService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class ShopPiPriceFix {

    @Autowired
    private TaobaoSynService taobaoSynService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Test
    public void test1() throws TbItemSynException {
        String reg = "[s|S](\\d+(\\.[0-9]*)?)";
        Long shopId = 15884L;

        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        shiguShop.setPriceRule(reg);
        shiguShopMapper.updateByPrimaryKey(shiguShop);

        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(shiguShop.getWebSite());
        tinyExample.createCriteria().andStoreIdEqualTo(shiguShop.getShopId()).andGoodsStatusEqualTo(1).andIsExcelImpEqualTo(0);
        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(tinyExample);
        for (ShiguGoodsTiny tiny : shiguGoodsTinies) {
            ShiguGoodsTiny goodsTiny = new ShiguGoodsTiny();
            goodsTiny.setGoodsId(tiny.getGoodsId());
            goodsTiny.setWebSite(tiny.getWebSite());
            goodsTiny.setModified(DateUtil.stringToDate("2000-01-01 00:00:00"));
            shiguGoodsTinyMapper.updateByPrimaryKeySelective(goodsTiny);
        }
        taobaoSynService.synOneShop(shopId, shiguShop.getTbNick());
    }
}
