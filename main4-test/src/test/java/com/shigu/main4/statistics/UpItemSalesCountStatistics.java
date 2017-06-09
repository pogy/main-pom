package com.shigu.main4.statistics;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ActiveDrawPem;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.ActiveDrawRecordExample;
import com.opentae.data.mall.examples.MemberUserExample;
import com.opentae.data.mall.interfaces.ActiveDrawGoodsMapper;
import com.opentae.data.mall.interfaces.ActiveDrawPemMapper;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.Jobs;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.test.active.ActiveUpGoodsCountService;
import com.shigu.main4.test.active.TemplateUtil;
import com.shigu.main4.test.active.UserUpData;
import com.shigu.main4.tools.RedisIO;
import com.shigu.tb.finder.services.TbItemTradeService;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by bugzy on 2017/6/6 0006.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ac.xml")
public class UpItemSalesCountStatistics {

    @Autowired
    private ActiveUpGoodsCountService activeUpGoodsCountService;

    @Autowired
    private TemplateUtil templateUtil;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private ActiveDrawPemMapper activeDrawPemMapper;

    @Autowired
    private ActiveDrawGoodsMapper activeDrawGoodsMapper;

    @Autowired
    private ActiveDrawService activeDrawService;

    @Autowired
    private TbItemTradeService tbItemTradeService;

    @Test
    public void count() {
        System.out.println(JSON.toJSONString(activeUpGoodsCountService.upDateForPem(8L)));
    }

    @Test
    public void testWrite() throws IOException, TemplateException {
        Map<String, Object> params = new HashMap<>();
        params.put("pems", Arrays.asList(activeUpGoodsCountService.upDateForPem(8L)));
        templateUtil.write("template.ftl", params, new PrintWriter("D:\\Administrator\\Desktop\\test1.xls"));
    }

    @Test
    public void initUpSalesDataForRedis() {
        final Long pemId = 8L;
        final ActiveDrawPem pem = activeDrawPemMapper.selectByPrimaryKey(pemId);

        ActiveDrawGoodsExample goodsExample = new ActiveDrawGoodsExample();
        goodsExample.createCriteria().andTypeEqualTo("DAILYFIND").andPemIdEqualTo(pemId);
        goodsExample.or().andTypeEqualTo("FAGOODS").andPemIdEqualTo(pemId);
        final List<Long> goodsIds = BeanMapper.getFieldList(activeDrawGoodsMapper.selectByExample(goodsExample), "goodsId", Long.class);

        ActiveDrawRecordExample recordExample = new ActiveDrawRecordExample();
        recordExample.createCriteria().andPemIdEqualTo(pemId);
        List<ActiveDrawRecord> records = activeDrawRecordMapper.selectByExample(recordExample);

        List<Long> userIds = new ArrayList<>(BeanMapper.getFieldSet(records, "userId", Long.class));

        Jobs<MemberUser> jobs = new Jobs<MemberUser>(40) {
            @Override
            public void doWork(MemberUser memberUser) throws Exception {
                String key = String.format("upsales_%d_%d", memberUser.getUserId(), pemId);
                Map<Long, Long> upSales = redisIO.get(key, Map.class);
                if (upSales == null) {
                    upSales = new LinkedHashMap<>();
                    Map<Long, Long> goodsIdnumIidsMapper =
                            activeDrawService.newNumIids(memberUser.getUserNick(), goodsIds, pem.getStartTime(), DateUtil.addDay(pem.getStartTime(), 7));
                    try {
                        Map<Long, Long> calculate = tbItemTradeService.calculate(
                                memberUser.getUserNick(),
                                new ArrayList<>(goodsIdnumIidsMapper.values()),
                                pem.getStartTime(),
                                DateUtil.addDay(pem.getStartTime(), 15)
                        );
                        for (Map.Entry<Long, Long> entry : goodsIdnumIidsMapper.entrySet()) {
                            Long sales = calculate.get(entry.getValue());
                            if (sales != null) {
                                upSales.put(entry.getKey(), sales);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    redisIO.put(key, upSales);
                }
            }
        };

        MemberUserExample userExample = new MemberUserExample();
        userExample.createCriteria().andUserIdIn(userIds);
        for (MemberUser memberUser : memberUserMapper.selectByExample(userExample)) {
            jobs.addJob(memberUser);
        }
        jobs.join();
    }

}
