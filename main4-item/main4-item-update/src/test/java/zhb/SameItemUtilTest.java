package zhb;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.item.exceptions.SameItemException;
import com.shigu.main4.item.services.impl.SameItemUtil;
import com.shigu.main4.item.vo.NowItemInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by zhaohongbo on 17/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/item-update.xml")
public class SameItemUtilTest {
    @Autowired
    SameItemUtil sameItemUtil;

    @Test
    public void addItemTest() throws SameItemException, ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NowItemInfo nii=new NowItemInfo();
        nii.setItemId(9975781L);
        nii.setWebSite("hz");
        nii.setCid(3035L);
        nii.setCreated(sdf.parse("2017-02-21 19:58:47"));
        nii.setPiPrice("40.00");
        nii.setTitle("2017春装新款男士休闲裤 英伦小脚裤九分裤店主风街拍港风K01-P40");
        nii.setStoreId(32090L);
        sameItemUtil.addItem(nii);
    }

    @Test
    public void changeMoreEsRelationIdTest(){
        List<String> ids=new ArrayList<String>();
        ids.add("9975793");
        ids.add("9975791");
        ids.add("9975787");
        ids.add("9975781");
        sameItemUtil.changeMoreEsRelationId("hz",ids,9975780L);
    }

    /**
     *
     */
    @Test
    public void updateSoldOutTime(){
        System.out.println(ElasticConfiguration.client);

    }
}
