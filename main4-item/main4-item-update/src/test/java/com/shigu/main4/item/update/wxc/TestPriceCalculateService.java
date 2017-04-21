package com.shigu.main4.item.update.wxc;

import com.shigu.main4.item.services.impl.ItemAddOrUpdateServiceImpl;
import com.shigu.main4.item.services.impl.PriceCalculateServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:main4/spring/item-update.xml")
public class TestPriceCalculateService {
    private static final Logger logger = LoggerFactory.getLogger(TestPriceCalculateService.class);

    @Autowired
    PriceCalculateServiceImpl service;

    /**
     * 批发价测试。
     */
    @Test
    public void pickPipriceFromTitle123123() {
        // 正常解title，仅有一个符合
        Long piPrice = service.pickPipriceFromTitle(35874L, 8800L, "17春夏新 纯苎麻宽松褶皱休闲哈伦九分裤 Y127/P58（不低于75）", "Y127", "Y127");
        System.out.println(piPrice);
    }
    @Test
    public void pickPipriceFromTitle() {
        // 正常解title，仅有一个符合
        Long piPrice = service.pickPipriceFromTitle(41844L, 5000L, "新年第一拍 衬衫P39.00Z200", "HZ-F38", "CS-36");
        assertTrue(piPrice == 3900);
        // 正常解huohao，仅有一个符合
        piPrice = service.pickPipriceFromTitle(41844L, 5000L, "新年第一拍 衬衫S39.00Z200", "HZ-F38", "CS-36");
        assertTrue(piPrice == 3800);
        // 正常解outId，仅有一个符合
        piPrice = service.pickPipriceFromTitle(41844L, 5000L, "新年第一拍 衬衫S39.00Z200", "HZ-G38", "CS-f36");
        assertTrue(piPrice == 3600);
        // title 匹配到P\F, 优先取P
        piPrice = service.pickPipriceFromTitle(41844L, 5000L, "新年第一拍 衬衫P39.00f200", "HZ-F38", "CS-36");
        assertTrue(piPrice == 3900);
        // title 匹配到P\p, 多个全部抛弃,取下一项
        piPrice = service.pickPipriceFromTitle(41844L, 5000L, "新年第一拍 衬衫P39.00 p200", "HZ-F38", "CS-36");
        assertTrue(piPrice == 3800);

        // 数字粘连，属于异常情况，解出的批发价将放在一个低优先级队列。如果后续没有正常的批发价，才会返回粘连批发价解析值
        // 第一项 属于粘连，能解析出6000，但不采用，因为第二项第三项能取到正常批发价，按顺序取第一个正常返回
        piPrice = service.pickPipriceFromTitle(41844L, 9800L, "唯一检测P602017新品上市", "HZ-F38", "CS-36");
        assertTrue(piPrice == 3800);
        // title 数字粘连情况2
        piPrice = service.pickPipriceFromTitle(41844L, 13800L, "唯一检测f5515%棉新品上市", "HZ-F38513", "CS-368745");
        assertTrue(piPrice == 5500);
        // title 数字粘连情况3，带小数粘连，优先匹配批发价，取满两位小数
        piPrice = service.pickPipriceFromTitle(41844L, 13800L, "唯一检测f55.215%棉新品上市", "HZ-F3128", "CS-3.6");
        assertTrue(piPrice == 5521);
    }

    @Test
    public void testMatche() {
        String reg = "[^A-Za-z]+[p|P|f|F](\\d+(.[0-9]+)?)";
        Pattern compile = Pattern.compile(reg);
        String target = "新年第一拍60年代 衬衫P39.00F12";
        Matcher matcher = compile.matcher(target);
        System.out.println(target.matches(reg));
        while (matcher.find())
            System.out.println(matcher.group());
    }

    @Test
    public void testOssPattern() {
        ItemAddOrUpdateServiceImpl service = new ItemAddOrUpdateServiceImpl();
        String text = "<img src='http://shigu.oss-cn-hangzhou.aliyuncs.com/OSSimg/7385F47D-AF33-4A80-92C9-F56BE20E55B5.jpg'/>";
        service.proccessDeleteOssImage(text);
    }
}