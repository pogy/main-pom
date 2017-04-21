package com.shigu.main4.item.update.wxc.datafix;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.PriceCalculateService;
import com.shigu.main4.item.services.impl.EsGoodsService;
import com.shigu.main4.item.tools.ItemHelper;
import com.shigu.main4.item.update.wxc.BaseSpringTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wxc on 2017/4/4.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class PiPriceFix extends BaseSpringTest {

    private static final Logger logger = getLogger(PiPriceFix.class);
    @Autowired
    private ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private PriceCalculateService priceCalculateService;

    @Autowired
    private EsGoodsService esGoodsService;

    String idstr = "20129234,9813854,9686078,9079896,8916635,9923173,9497066,9497077,9875320,9875749,9922972,9479804,9051595,9051591,9545691,8276737,9534210,9602099,9534243,9534259,9534278,9853320,9853047,9844216,9844217,9844218,9844219,9844221,9847505,9587944,9587952,9853051,9853166,9853063,9851302,10010232,10010233,10010235,9922963,9922028,9922029,9922030,9922031,9922033,9621779,1659521,9990640,9534260,9990642,9932821,10030109,9999466,10008102,9534264,9853104,9920839,9829442,9774300,9853153,2576296,8479028,2235190,8479052,8373467,8373468,8204300,2817699,8373470,8373471,8373469,8373464,8373465,8373466,867967,8204464,8204299,8204466,2297539,2123259,8374181,8374182,8374183,8374184,8374185,2297536,9853098,9853170,9884386,9526405,8735578,9534137,9534175,9534177,9534178,9534143,8735577,9534153,9534156,9765275,8302310";
    String idstr2 = "9621779,1659521,9758224,8988708,8677478,9965739,10014196,9965740,10014198,9965741,10014199,9853250,9853278,9918152,9949014,9949015,9949017,20133399,20133408,8980286,9834959,4289550,9310686,9889279,10016093,10016106,20147202,2244474,583259,2798137,9830969,9765566,9427735,9427835,9830987,9427805,9427834,9830972,9427803,9427808,9427833,9461781,9427734,9668415,9427804,9427807,9427836,9910412,9765567,9765262,9765263,9994067,10003154,9994042,10002874,9849955,9850052,9850060,9853461,10028239,284352,9236729,20133398,9765272,9840455,9866971,9427771,9427820,9861383,9427770,9427823,9427768,9427821,9755553,9863955,9988424,9607916,8871840,9724678,9552702,9435090,8286002,8882966,8764581,1650664,9080241,8810190,9960829,9273965,9489252,8854834,284297,9863956,9988400,2263169,8854833,879505,879510,2317204,9686142";
    String idstr3 = "9621779,1659521,9918152,2244474,583259,284352,1650664,284297,2263169,879505,2317204,2240034,8854764,1441850,9846644,536452,8203225,9618180,2060902,20129285,20129286,20129287,20129289,20129290,20129292,20129293,20129294,20129296,20129298,20129300,20129301,20129233,20129249,20129250,20129264,20129266,20129267,20129268,20129269,20129270,20129271,20129272,20129273,20129274,9915004,20133555,20133560,20133561,20133549,20133554,20133559,20133551,20133552,9681987,8041481,9165108,1670231,4233171,1698528,9664496,4187182,9668215,9779003,9778911,8956425,8373730,9668220,8352259,9631748,9522469,2041152,4204352,9565506,9409396,4185323,9458459,9560382,10008339,9903394,10008355,9903413,9903426,10008153,9945178,9903195,9903456,9945191,9903510,9945776,9945808,10003436,9945838,9945340,4258473,9600706,9628111,9366874,9600705,4234697,4213244";

    @Test
    public void fixPiPrice() throws ItemModifyException {
        List<Long> longs = new ArrayList<>();
        for (String s : idstr3.split(",")) {
            longs.add(Long.valueOf(s));
        }
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.createCriteria().andGoodsIdIn(longs);
        for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectFieldsByExample(tinyExample, FieldUtil.codeFields("goods_id, price_string, num_iid, store_id"))) {
//            itemAddOrUpdateService.systemUpdateItem(ItemHelper.toSynItem(tiny, null, null));
        }

    }

    LinkedBlockingQueue<List<ShiguGoodsTiny>> queue = new LinkedBlockingQueue<>();

    @Test
    public void get() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new HHH());
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }

        String[] sites = {
                "hz",
                "cs",
                "bb",
                "bj",
                "gz",
                "jf",
                "jx",
                "ss",
                "wa",
                "xh",
        };
        Integer size = 500;
        for (String site : sites) {
            ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
            shiguGoodsTinyExample.setWebSite(site);
            shiguGoodsTinyExample.setEndIndex(size);
            int start;
            shiguGoodsTinyExample.setStartIndex(start = 0);
            shiguGoodsTinyExample.createCriteria().andIsExcelImpEqualTo(0).andPiPriceGreaterThan(2000L);
            int i = shiguGoodsTinyMapper.countByExample(shiguGoodsTinyExample);
            logger.info(site + "有" + i);
            while (start < i) {
                queue.put(shiguGoodsTinyMapper.selectByConditionList(shiguGoodsTinyExample));
                shiguGoodsTinyExample.setStartIndex(start += size);
            }
        }

        while (true) {
            logger.info("queue-size:" + queue.size());
            Thread.sleep(5000);
        }
    }

    class HHH implements Runnable {

        @Override
        public void run() {
            ElasticRepository repository = new ElasticRepository();
            while (true) {
                try {
                    for (ShiguGoodsTiny tiny : queue.take()) {
                        Long aLong = priceCalculateService.pickPipriceFromTitle(tiny.getStoreId(), tiny.getPrice(), tiny.getTitle(), tiny.getOuterId(), tiny.getGoodsNo());
                        if (!Objects.equals(aLong, tiny.getPiPrice())) {
                            tiny.setPiPrice(aLong);
                            tiny.setPiPriceString(String.format("%.2f", aLong * .01));
                            try {
                                shiguGoodsTinyMapper.updateByPrimaryKeySelective(tiny);
                                ESGoods esGoods = esGoodsService.createEsGoods(tiny);
                                repository.insert(new SimpleElaBean("goods", tiny.getWebSite(), tiny.getGoodsId().toString(), JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss")));
                            } catch (Exception ignore) {
                                ignore.printStackTrace();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
