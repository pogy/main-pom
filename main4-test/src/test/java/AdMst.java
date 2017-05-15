import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhaohongbo on 17/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:ac.xml")
public class AdMst {

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    MemberLicenseMapper memberLicenseMapper;

    @Test
    public void testMsg(){
        System.out.println(sendSms_quick("18888971970","四季星座网温馨提示：（报名时间为5月12日-5月14日20时）网站广告位报名入口已发布，本期总计首页34个位置，轮转播区2个，首焦下方3个，热卖10个，推荐档口7个，元素馆5个，商品库右侧7个（注意：所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台，“发现好货”栏目 10个位置将在13日20点开始竞拍【四季星座网】"));
//        System.out.println(sendSms_quick("18888971970","温馨提示：（报名时间为4月28日-4月30日20时）网站广告位报名入口已发布，本期总计首页29个位置，轮转播区1个，轮转播下方区1个，首页热卖10个，推荐档口7个，元素馆5个，大家注意（所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台【四季星座网】"));
    }
    @Test
    public void sendMsg(){
        ShiguShopExample example=new ShiguShopExample();
        example.createCriteria().andMarketIdEqualTo(617L).andShopStatusEqualTo(0);
        List<ShiguShop> shopList=shiguShopMapper.selectByExample(example);

        for(ShiguShop s:shopList){
            String telephone=s.getTelephone();
            if(s.getUserId()!=null){
                MemberLicenseExample licenseExample=new MemberLicenseExample();
                licenseExample.createCriteria().andUserIdEqualTo(s.getUserId()).andLicenseTypeEqualTo(4);
                List<MemberLicense> licenses=memberLicenseMapper.selectByExample(licenseExample);
                if(licenses.size()>0){
                    telephone=licenses.get(0).getContext();
                }
            }
            if(telephone!=null){
                System.out.println(telephone);
                System.out.println(sendSms_quick(telephone,"四季星座网温馨提示：（报名时间为5月9日-5月11日12时）网站广告位报名入口已发布，本期总计首页33个位置，轮转播区2个，首页热卖10个，推荐档口8个，元素馆5个，商品库右侧8个（注意：所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台【四季星座网】"));
//                System.out.println(sendSms_quick(telephone,"温馨提示：（报名时间为5月2日-5月4日12时）网站广告位报名入口已发布，本期总计首页32个位置，轮转播区1个，轮转播下方区3个，首页热卖10个，推荐档口8个，元素馆5个，大家注意（所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台【四季星座网】"));
            }

        }
//        System.out.println(sendSms_quick("18857193391","温馨提示：（报名时间为4月25日-4月27日20时）网站广告位报名入口已发布，本期总计首页26个位置，轮转播区2个，轮转播下方区1个，首页热卖10个，推荐档口8个，元素馆5个（注意：所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台。【四季星座网】"));
    }

    String msg="温馨提示：（报名时间为4月28日-4月30日20时）网站广告位报名入口已发布，本期总计首页29个位置，轮转播区1个，轮转播下方区1个，首页热卖10个，推荐档口7个，元素馆5个，大家注意（所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台【四季星座网】";

    private static String account_quick = "sdk_sgwl";
    private static String pwd_quick = "20150630";
    private static String account_ordinary = "3377";
    private static String pwd_ordinary = "D47C126518CE8632397A155F11BDF6C2";


    /**
     * 直接发短信
     * @param mobile
     * @param content
     * @return
     */
    private String sendSms_quick(String mobile, String content) {
        String result = "";
//        String memo = content.length() < 70?content.trim():content.trim().substring(0, 70);
        try {
            Document document = Jsoup.connect("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/http/sendBatchMessage").data("account", account_quick).data("password", pwd_quick).data("destmobile", mobile).data("msgText", content).timeout(1000000).post();
            result = document.text();
        } catch (Exception e) {
        }
        return result;
    }
}
