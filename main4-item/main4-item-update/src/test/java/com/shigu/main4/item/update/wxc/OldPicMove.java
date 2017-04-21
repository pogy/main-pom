package com.shigu.main4.item.update.wxc;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsExtends;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsExtendsExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsExtendsMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.tools.OSSUtil;
import org.elasticsearch.action.get.GetResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/3/18.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class OldPicMove extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(OldPicMove.class);

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;

    private LinkedBlockingQueue<List<ShiguGoodsTiny>> queue = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<ExtendsBo> extendsBos = new LinkedBlockingQueue<>();

    @Test
    public void getItem() throws Exception {

        List<Moveing> moveings = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
//            TinyMove tinyMove = new TinyMove("tiny-move" + i);
//            moveings.add(tinyMove);
//            Thread tinyThread = new Thread(tinyMove, tinyMove.name);
//            tinyThread.setPriority(Thread.MAX_PRIORITY);
//            tinyThread.start();

            ExtendsMove extendsMove = new ExtendsMove("extends-move" + i);
            Thread thread = new Thread(extendsMove, extendsMove.name);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            moveings.add(extendsMove);
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
        int jobSize = 1000;
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setEndIndex(jobSize);
        tinyExample.createCriteria().andNumIidIsNull();
        for (String site : sites) {
            tinyExample.setWebSite(site);
            int start;
            tinyExample.setStartIndex(start = 0);
            for (List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id,pic_url,web_site"));
                 !shiguGoodsTinies.isEmpty();
                 tinyExample.setStartIndex(start += jobSize),shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id,pic_url,web_site"))
                    ) {
                logger.info("page-start:" + site + ", " + start);
//                queue.put(shiguGoodsTinies);
//
                List<Long> goodsIds = BeanMapper.getFieldList(shiguGoodsTinies, "goodsId", Long.class);

                ShiguGoodsExtendsExample extendsExample = new ShiguGoodsExtendsExample();
                extendsExample.setWebSite(site);
                extendsExample.createCriteria().andGoodsIdIn(goodsIds);
                List<ShiguGoodsExtends> shiguGoodsExtendses = shiguGoodsExtendsMapper.selectFieldsByExample(extendsExample, FieldUtil.codeFields("goods_id,images,goods_desc"));

                extendsBos.put(new ExtendsBo(site, shiguGoodsExtendses));

            }

        }

        while (true) {
            logger.info("tiny-size:" + queue.size());
            logger.info("ext-size:" + extendsBos.size());
            Thread.sleep(3000L);
            if (queue.isEmpty() && extendsBos.isEmpty()) {
                boolean exit = true;
                for (Moveing moveing : moveings) {
                    if (!moveing.free) {
                        exit = false;
                        break;
                    }
                }
                if (exit)
                    break;
            }
        }
    }

    private void moveTiny(List<ShiguGoodsTiny> tinies) {
        ElasticRepository repository = new ElasticRepository();
        for (ShiguGoodsTiny tiny : tinies) {
            String ossPic = uploadImg(tiny.getPicUrl());
            if (ossPic != null) {
                tiny.setPicUrl(ossPic);
                shiguGoodsTinyMapper.updateByPrimaryKeySelective(tiny);
                logger.info(tiny.getGoodsId() + "主图搬家");
                GetResponse response = ElasticConfiguration.searchClient.prepareGet().setIndex("goods").setType(tiny.getWebSite()).setId(tiny.getGoodsId().toString()).execute().actionGet();
                if (response.isExists()) {
                    Map<String, Object> source = response.getSource();
                    source.put("picUrl", ossPic);
                    SimpleElaBean simpleElaBean = new SimpleElaBean("goods", tiny.getWebSite(), tiny.getGoodsId().toString(), JSON.toJSONStringWithDateFormat(source, "yyyy-MM-dd HH:mm:ss"));
                    repository.updateByKey(simpleElaBean);
                }
            }
        }
    }

    private void moveExtends(List<ShiguGoodsExtends> extendses, String website) {
        for (ShiguGoodsExtends extendse : extendses) {
            extendse.setWebSite(website);
            String ossImages = uploadImg(extendse.getImages());
            boolean changed = false;
            if (ossImages != null) {
                changed = true;
                extendse.setImages(ossImages);
            }
            String ossDesc = uploadImg(extendse.getGoodsDesc());
            if (ossDesc != null) {
                changed = true;
                extendse.setGoodsDesc(ossDesc);
            }
            if (changed) {
                shiguGoodsExtendsMapper.updateByPrimaryKeySelective(extendse);
                logger.info(extendse.getGoodsId() + "详情搬家");
            }
        }
    }

    private static final Pattern pattern = Pattern.compile("http://sgimage.571xz.com/new_image_site/SGimg/[a-z0-9]+\\.(jpg|png|jpeg)");
    private String uploadImg(String url) {
        String oss = null;
        if (url == null || !url.contains("sgimage")) return null;
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            String picUrl = matcher.group();
            String name = picUrl.substring(picUrl.lastIndexOf("/") + 1);
            if (!name.contains("null")) {
                try {
                    URL u = new URL("http://sgimage.571xz.com/" + name.substring(0, 3) + "/" + name);
                    InputStream inputStream = u.openStream();
                    if (oss == null) {
                        oss = url;
                    }
                    String ossImg = OSSUtil.addItemPic(name, inputStream);
                    oss = oss.replace(picUrl, ossImg);
                } catch (IOException e) {
                    logger.error(picUrl);
                }
            } else {
                logger.error(picUrl);
            }
        }
        return url.equals(oss) ? null : oss;
    }

    private abstract class Moveing implements Runnable {
        public volatile Boolean free = true;

        public String name;

        Moveing(String name) {
            this.name = name;
        }
    }

    private class TinyMove extends Moveing {


        TinyMove(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                List<ShiguGoodsTiny> take;
                try {
                    free = true;
                    take = queue.take();
                    free = false;
                } catch (InterruptedException e) {
                    break;
                }
                moveTiny(take);
            }
            logger.info(name + " death.");
        }
    }

    private class ExtendsMove extends Moveing {

        ExtendsMove(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                ExtendsBo take;
                try {
                    free = true;
                    take = extendsBos.take();
                    free = false;
                } catch (InterruptedException e) {
                    break;
                }
                moveExtends(take.extendses, take.webSite);
            }
            logger.info(name + " death.");
        }
    }

    class ExtendsBo{
        String webSite;
        List<ShiguGoodsExtends> extendses;

        public ExtendsBo(String webSite, List<ShiguGoodsExtends> extendses) {
            this.webSite = webSite;
            this.extendses = extendses;
        }
    }

    @Test
    public void testUrlConnection() throws IOException {
        System.out.println(uploadImg("123http://sgimage.571xz.com/new_image_site/SGimg/b0aa774db0c677e7f9a81fcd37d316b1.jpg123"));
    }
}
