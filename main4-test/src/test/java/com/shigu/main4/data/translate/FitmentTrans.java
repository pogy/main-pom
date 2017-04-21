package com.shigu.main4.data.translate;

import com.opentae.data.mall.beans.ShiguShopFitment;
import com.opentae.data.mall.beans.ShiguStoreFitment;
import com.opentae.data.mall.examples.ShiguShopFitmentExample;
import com.opentae.data.mall.examples.ShiguStoreFitmentExample;
import com.opentae.data.mall.interfaces.ShiguShopFitmentMapper;
import com.opentae.data.mall.interfaces.ShiguStoreFitmentMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.test.oss.OSSUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/3/19.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:ac.xml")
public class FitmentTrans {

    private static final Logger logger = LoggerFactory.getLogger(FitmentTrans.class);

    @Autowired
    private ShiguStoreFitmentMapper shiguStoreFitmentMapper;

    @Autowired
    private ShiguShopFitmentMapper shiguShopFitmentMapper;

    @Test
    public void doTrans() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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

        for (String site : sites) {
            ShiguStoreFitmentExample fExam = new ShiguStoreFitmentExample();
            fExam.setWebSite(site);
            List<ShiguStoreFitment> shiguStoreFitments = shiguStoreFitmentMapper.selectByExample(fExam);
            Map<Long, ShiguStoreFitment> fitmentMap = BeanMapper.list2Map(shiguStoreFitments, "fitmentId", Long.class);
            if (!shiguStoreFitments.isEmpty()) {
                List<ShiguShopFitment> shiguShopFitments = BeanMapper.mapList(shiguStoreFitments, ShiguShopFitment.class);
                for (ShiguShopFitment fitment : shiguShopFitments) {
                    ShiguStoreFitment storeFitment = fitmentMap.get(fitment.getFitmentId());
                    fitment.setFitmentId(null);
                    fitment.setShowDescription(1);
                    fitment.setShowLogo(1);
                    fitment.setShowSlide(1);
                    fitment.setShopId(storeFitment.getStoreId());
                    fitment.setShopName(storeFitment.getStoreName());
                    fitment.setShopBanner(storeFitment.getStoreBanner());
                    fitment.setShopBanner2(storeFitment.getStoreBanner2());
                    fitment.setShopBanner3(storeFitment.getStoreBanner3());
                    fitment.setShopBanner4(storeFitment.getStoreBanner4());
                    fitment.setShopBanner5(storeFitment.getStoreBanner5());
                    fitment.setShopLogo(storeFitment.getStoreLogo());
                    if (StringUtils.isNotEmpty(storeFitment.getRemark4())) {
                        try {
                            fitment.setShowLogo(Integer.valueOf(storeFitment.getRemark4()));
                        } catch (Exception e){}
                    }
                    if (StringUtils.isNotEmpty(storeFitment.getRemark5())) {
                        try {
                            fitment.setShowSlide(Integer.valueOf(storeFitment.getRemark5()));
                        } catch (Exception e){}
                    }
                    if (StringUtils.isNotEmpty(storeFitment.getRemark6())) {
                        try {
                            fitment.setShowDescription(Integer.valueOf(storeFitment.getRemark6()));
                        } catch (Exception e){}
                    }
                    shiguShopFitmentMapper.insertSelective(fitment);
                }
            }
        }
    }

    @Test
    public void picMove() {
        List<ShiguShopFitment> selectByExample = shiguShopFitmentMapper.selectByExample(new ShiguShopFitmentExample());
        for (int i = 0; i < selectByExample.size(); i++) {
            logger.info("move" + i);
            ShiguShopFitment fitment = selectByExample.get(i);
            fitment.setShopBanner(uploadImg(fitment.getShopBanner()));
            fitment.setShopBanner2(uploadImg(fitment.getShopBanner2()));
            fitment.setShopBanner3(uploadImg(fitment.getShopBanner3()));
            fitment.setShopBanner4(uploadImg(fitment.getShopBanner4()));
            fitment.setShopBanner5(uploadImg(fitment.getShopBanner5()));
            fitment.setShopLogo(uploadImg(fitment.getShopLogo()));
            fitment.setDescription(uploadImg(fitment.getDescription()));
            shiguShopFitmentMapper.updateByPrimaryKeySelective(fitment);
        }
    }

    private static final Pattern pattern = Pattern.compile("http://sgimage.571xz.com/new_image_site/SGimg/[a-z0-9]+\\.[.]?(jpg|png|jpeg)");
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
}
