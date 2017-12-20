package com.shigu.main4.test.active;

import com.opentae.data.mall.beans.ActiveDrawGoods;
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
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 活动上传统计服务
 * Created by bugzy on 2017/6/6 0006.
 */
@Service
public class ActiveUpGoodsCountService {

    @Autowired
    private ActiveDrawService activeDrawService;

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    @Autowired
    private ActiveDrawPemMapper activeDrawPemMapper;

    @Autowired
    private ActiveDrawGoodsMapper activeDrawGoodsMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private RedisIO redisIO;

    public PemUpData upDateForPem(Long pemId) {
        ActiveDrawPem pem = activeDrawPemMapper.selectByPrimaryKey(pemId);
        if (pem == null) {
            throw new RuntimeException(String.format("期次[%d]不存在。", pemId));
        }
        PemUpData pemData = new PemUpData(pemId, pem.getTerm());

        ActiveDrawGoodsExample goodsExample = new ActiveDrawGoodsExample();
        goodsExample.createCriteria().andPemIdEqualTo(pemId).andTypeEqualTo("DAILYFIND");
        List<ActiveDrawGoods> dailyFind = activeDrawGoodsMapper.selectByExample(goodsExample);

        ActiveDrawGoodsExample faGoodsExample = new ActiveDrawGoodsExample();
        faGoodsExample.createCriteria().andPemIdEqualTo(pemId).andTypeEqualTo("FAGOODS");
        List<ActiveDrawGoods> faGoods = activeDrawGoodsMapper.selectByExample(faGoodsExample);

        List<Long> goodsIds = new ArrayList<>();
        List<Long> dailyIds = BeanMapper.getFieldList(dailyFind, "goodsId", Long.class);
        List<Long> faIds = BeanMapper.getFieldList(faGoods, "goodsId", Long.class);
        goodsIds.addAll(dailyIds);
        goodsIds.addAll(faIds);

        ActiveDrawRecordExample recordExample = new ActiveDrawRecordExample();
        recordExample.createCriteria().andPemIdEqualTo(pemId);
        List<ActiveDrawRecord> records = activeDrawRecordMapper.selectByExample(recordExample);
        List<Long> userIds = new ArrayList<>(BeanMapper.getFieldSet(records, "userId", Long.class));
        MemberUserExample userExample = new MemberUserExample();
        userExample.createCriteria().andUserIdIn(userIds);
        List<MemberUser> memberUsers = memberUserMapper.selectByExample(userExample);
        List<UserUpData> userUpDatas = new ArrayList<>(memberUsers.size());
        pemData.setDatas(userUpDatas);
        for (MemberUser memberUser : memberUsers) {
            UserUpData data = BeanMapper.map(memberUser, UserUpData.class);
            StringBuilder ward = new StringBuilder();
            for (ActiveDrawRecord record : records) {
                if (record.getReceivesYes() && record.getUserId().equals(memberUser.getUserId())) {
                    ward.append(',');
                    ward.append(record.getWard());
                }
            }
            data.setWard(ward.length() > 0 ? ward.substring(1) : "");
            String key = String.format("upsales_%d_%d", memberUser.getUserId(), pemId);
            Map<Integer, Integer> upSales = redisIO.get(key, Map.class);

            if (upSales == null) {
                continue;
//                upSales = new LinkedHashMap<>();
//                Map<Long, Long> goodsIdnumIidsMapper =
//                        activeDrawService.newNumIids(memberUser.getUserNick(), goodsIds, pem.getStartTime(), DateUtil.addDay(pem.getStartTime(), 7));
//                try {
//                    Map<Long, Long> calculate = tbItemTradeService.calculate(
//                            memberUser.getUserNick(),
//                            new ArrayList<>(goodsIdnumIidsMapper.values()),
//                            pem.getStartTime(),
//                            DateUtil.addDay(pem.getStartTime(), 15)
//                    );
//                    for (Map.Entry<Long, Long> entry : goodsIdnumIidsMapper.entrySet()) {
//                        Long sales = calculate.get(entry.getValue());
//                        if (sales != null) {
//                            upSales.put(entry.getKey(), sales);
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                redisIO.put(key, upSales);
            }
            Collection<Goods> dailies = new ArrayList<>();
            for (Long dailyId : dailyIds) {
                Integer idKey = dailyId.intValue();
                if (upSales.containsKey(idKey)) {
                    dailies.add(new Goods(dailyId, upSales.get(idKey).longValue()));
                }
            }
            data.setDaily(dailies);
            Collection<Goods> fas = new ArrayList<>();
            for (Long faId : faIds) {
                Integer idKey = faId.intValue();
                if (upSales.containsKey(idKey)) {
                    fas.add(new Goods(faId, upSales.get(idKey).longValue()));
                }
            }
            data.setFaGoods(fas);
            userUpDatas.add(data);
        }

        Collections.sort(userUpDatas, new Comparator<UserUpData>() {
            @Override
            public int compare(UserUpData o1, UserUpData o2) {
                int total1 = 0;
                for (Goods goods : o1.getDaily()) {
                    total1 += goods.getSales();
                }
                for (Goods goods : o1.getFaGoods()) {
                    total1 += goods.getSales();
                }
                int total2 = 0;
                for (Goods goods : o2.getDaily()) {
                    total2 += goods.getSales();
                }
                for (Goods goods : o2.getFaGoods()) {
                    total2 += goods.getSales();
                }
                return total2 - total1;
            }
        });

        return pemData;
    }
}
