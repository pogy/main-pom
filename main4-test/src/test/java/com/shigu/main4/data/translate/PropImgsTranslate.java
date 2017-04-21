package com.shigu.main4.data.translate;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguPropImgs;
import com.opentae.data.mall.beans.TaobaoPropimg;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.TaobaoPropimgExample;
import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguPropImgsMapper;
import com.opentae.data.mall.interfaces.TaobaoPropimgMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wxc on 2017/2/28.
 * 用于将 taobao_prop_imgs 数据传输至  shigu_prop_imgs
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/ac.xml")
public class PropImgsTranslate {
    private static final Logger logger = Logger.getLogger(PropImgsTranslate.class);

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private TaobaoPropimgMapper taobaoPropimgMapper;

    @Autowired
    private ShiguPropImgsMapper shiguPropImgsMapper;

    private LinkedBlockingQueue<Collection<ShiguPropImgs>> queue = new LinkedBlockingQueue<>();

    class MakerInsert implements Runnable {
        int i;
        @Override
        public void run() {
            while (true) {
                try {
                    for (ShiguPropImgs entry : queue.take()) {
                        try {
                            shiguPropImgsMapper.insertSelective(entry);
                        } catch (Exception ignore) {
                            logger.warn(entry.getItemId() + " 已经存在");
                            ShiguPropImgs img = new ShiguPropImgs();
                            img.setItemId(entry.getItemId());
                            ShiguPropImgs propImgs = shiguPropImgsMapper.selectOne(img);
                            if (propImgs != null && !propImgs.getPropimgs().equals(entry.getPropimgs())) {
                                List<String> imgs = Arrays.asList(propImgs.getPropimgs().split(";"));
                                imgs.addAll(Arrays.asList(entry.getPropimgs().split(";")));
                                Set<String> set = new HashSet<>(imgs);
                                String join = StringUtils.join(set, ";");
                                propImgs.setPropimgs(join);
                                shiguPropImgsMapper.updateByPrimaryKeySelective(propImgs);
                            }
                        }
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    class TinysRunner implements Runnable {

        String site;

        String status;
        int start;
        int count;

        private TinysRunner(String site) {
            this.site = site;
            status = "出售";
            start = 0;
        }

        @Override
        public void run() {
            logger.warn(site + "区块数据。。。");
            // 架上商品
            ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
            tinyExample.setWebSite(site);
            tinyExample.setEndIndex(20000);
            tinyExample.createCriteria()
                    .andCreatedGreaterThanOrEqualTo(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH))
                    .andCreatedLessThan(DateUtils.truncate(DateUtils.addDays(new Date(), 1), Calendar.DAY_OF_MONTH));
            count = shiguGoodsTinyMapper.countByExample(tinyExample);
//            if (!site.equals("hz"))
            while (start < count) {
                info();
                tinyExample.setStartIndex(start);
                rollPropImg(shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id, num_iid")));
                start += 20000;
            }

            start = 0;
            status = "仓库";

            ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
            soldoutExample.setWebSite(site);
            soldoutExample.setEndIndex(20000);
            soldoutExample.createCriteria()
                    .andCreatedGreaterThanOrEqualTo(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH))
                    .andCreatedLessThan(DateUtils.truncate(DateUtils.addDays(new Date(), 1), Calendar.DAY_OF_MONTH));
            count = shiguGoodsSoldoutMapper.countByExample(soldoutExample);
            while (start < count) {
                info();
                soldoutExample.setStartIndex(start);
                List<ShiguGoodsSoldout> shiguGoodsSoldouts
                        = shiguGoodsSoldoutMapper.selectFieldsByConditionList(soldoutExample, FieldUtil.codeFields("goods_id, num_iid"));
                rollPropImg(BeanMapper.mapList(shiguGoodsSoldouts, ShiguGoodsTiny.class));
                start += 20000;
            }
        }

        public void info() {
            logger.warn(site + ": " + status + "， 第" + start + ", 剩余" + (count - start));
        }
    }

    private void rollPropImg(List<ShiguGoodsTiny> tinies)  {
        if (tinies.isEmpty()) return;
        Map<Long, ShiguPropImgs> taobaoPropMap = new HashMap<>();
        Map<Long, Long> map = new HashMap<>(tinies.size(), 1);
        for (ShiguGoodsTiny tiny : tinies)
            map.put(tiny.getNumIid(), tiny.getGoodsId());
        TaobaoPropimgExample propimgExample = new TaobaoPropimgExample();
        propimgExample.createCriteria().andNumIidIn(new ArrayList<>(map.keySet()));
        for (TaobaoPropimg taobaoPropimg : taobaoPropimgMapper.selectByExample(propimgExample)) {
            Long goodsId = map.get(taobaoPropimg.getNumIid());
            if (goodsId != null) {
                String text = taobaoPropimg.getProperties() + "##" + taobaoPropimg.getUrl();
                ShiguPropImgs s = taobaoPropMap.get(goodsId);
                if (s == null) {
                    s = new ShiguPropImgs();
                    s.setItemId(goodsId);
                    s.setPropimgs(text);
                    taobaoPropMap.put(goodsId, s);
                } else {
                    s.setPropimgs(s.getPropimgs() + ";" + text);
                }
            }
        }
        try {
            queue.put(taobaoPropMap.values());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 上次更新到 2017/3/1（不包含） 日前的数据
     * @throws InterruptedException
     */
    @Test
    public void menu() throws InterruptedException {
        String tip = "1. 队列大小\n2.各个插入线程\n0.exit\n";
        Scanner scanner = new Scanner(System.in);
        List<MakerInsert> inserts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MakerInsert makerInsert = new MakerInsert();
            inserts.add(makerInsert);
            Thread thread = new Thread(makerInsert);
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
        List<TinysRunner> tinysRunners = new ArrayList<>();
        for (String site : sites) {
            TinysRunner tinysRunner = new TinysRunner(site);
            tinysRunners.add(tinysRunner);
            new Thread(tinysRunner).start();
        }
        while (true) {
            System.out.println(tip);
            String s = scanner.nextLine();
            Thread.sleep(2000);
            if (s.equals("xxx")) {
                break;
            } else if (s.equals("info")) {
            }
        }
    }
}