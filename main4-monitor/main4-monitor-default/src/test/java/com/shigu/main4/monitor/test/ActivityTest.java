package com.shigu.main4.monitor.test;

import com.opentae.data.mall.beans.ShiguNewActiveParticipants;
import com.opentae.data.mall.beans.ShiguNewActivity;
import com.opentae.data.mall.beans.ShiguNewActivityUpRecord;
import com.opentae.data.mall.examples.ShiguNewActivityExample;
import com.opentae.data.mall.interfaces.ShiguNewActiveParticipantsMapper;
import com.opentae.data.mall.interfaces.ShiguNewActivityMapper;
import com.opentae.data.mall.interfaces.ShiguNewActivityUpRecordMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.monitor.service.impl.ItemUpRecordServiceImpl;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author www 2018-01-25 21:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/store_test.xml" )
public class ActivityTest {

    @Autowired
    private ItemUpRecordServiceImpl itemUpRecordService;

    @Test
    public void test() {

        ItemUpRecordVO itemUpRecordVO = new ItemUpRecordVO();
        itemUpRecordVO.setFlag("tb");
        itemUpRecordVO.setApproveStatus("instock");
        //    itemUpRecordVO.setApproveStatus("onsale");
        itemUpRecordVO.setFenUserId(300L);
        itemUpRecordVO.setSupperGoodsId(300L);
        itemUpRecordVO.setCid(30L);

        itemUpRecordService.countUploadForCash(itemUpRecordVO);


    }
}
