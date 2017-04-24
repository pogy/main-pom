package com.shigu.main4.cron;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.cron.models.SingleSchedule;
import com.shigu.main4.tools.RedisIO;
import com.shigu.tb.finder.exceptions.TbItemSynException;
import com.shigu.tb.finder.services.TaobaoSynService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 同步店内类目
 * Created by Licca on 17/4/24.
 */
@Component
public class SynStorecat  extends SingleSchedule {

    private static final Logger logger = LoggerFactory.getLogger(SynStorecat.class);

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    TaobaoSynService taobaoSynService;

    @Autowired
    RedisIO redisIO;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    int max=1000;
    String key = "syn_storecat_to_data";

    @Override
    @Scheduled(cron = "0 0 0/1  * * ? ")
//    @Scheduled(cron = "0/1 * *  * * ? ")
    public void execute() {
        super.execute();
    }

    @Override
    public void doContext() {
        //查出最近1个小时的内修改的店铺
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.setDistinct(true);
        Calendar cal=Calendar.getInstance();
        Date now=cal.getTime();
        cal.add(Calendar.HOUR, -1);
        Date before=cal.getTime();
        example.createCriteria().andModifiedGreaterThanOrEqualTo(before)
                .andModifiedLessThan(now).andIsExcelImpEqualTo(0);//淘宝更新来的
        example.setWebSite("hz");
        List<ShiguGoodsTiny> tinys=shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("store_id"));
        if(tinys.size()>0){
            List<Long> shopIds=new ArrayList<>();
            for(ShiguGoodsTiny sgt:tinys){
                shopIds.add(sgt.getStoreId());
            }
            ShiguShopExample shopExample=new ShiguShopExample();
            shopExample.createCriteria().andShopStatusEqualTo(0).andShopIdIn(shopIds);
            List<ShiguShop> shops=shiguShopMapper.selectByExample(shopExample);
            for(ShiguShop s:shops){
                try {
                    taobaoSynService.repairStorecat(s.getShopId(), s.getTbNick());
                    redisIO.rpush(key,s.getShopId());
                    if(redisIO.countList(key)>max){
                        redisIO.lpop(key);
                    }
                } catch (TbItemSynException e) {
                    logger.error("syn taobaocat error",e);
                }
            }
        }
    }
}
