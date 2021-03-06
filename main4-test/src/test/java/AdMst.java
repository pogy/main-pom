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

import java.util.ArrayList;
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
        //System.out.println(sendSms_quick("18857193391","四季星座网温馨提示：：\"首页热销\"栏目  共10个位置将在今日20点(星期四）开始竞拍，竞拍所得金额将用于回馈代理，请登录四季星座网商家后台或淘宝搜索店名“杭州石谷网络科技有限公司”参与竞拍。退订回复T【四季星座网】"));
        //System.out.println(sendSms_quick("17605818805","四季星座网温馨提示：：\"首页热销\"栏目  共10个位置将在今日20点(星期四）开始竞拍，竞拍所得金额将用于回馈代理，请登录四季星座网商家后台或淘宝搜索店名“杭州石谷网络科技有限公司”参与竞拍。退订回复T【四季星座网】"));
//        System.out.println(sendSms_quick("18888971970","温馨提示：（报名时间为4月28日-4月30日20时）网站广告位报名入口已发布，本期总计首页29个位置，轮转播区1个，轮转播下方区1个，首页热卖10个，推荐档口7个，元素馆5个，大家注意（所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台【四季星座网】"));
        System.out.println(sendSms_quick("15168224104","四季星座网温馨提示：（报名时间为7月6日-7月8日20时）网站广 告位报名入口已发布，本期总计首页28个位置，轮转播区2个，推荐档口7个，元素馆5个，商品库右侧8个，搜索右侧6个（注意：所有广 告位不同一区域同一时段内，可重复报名）报名入口为四季星座供应商后台。退订回复T【四季星座网】"));
        //System.out.println(sendSms_quick("13588494464","四季星座网温馨提示：“首页热销”栏目+“首页C区风格馆”栏目 共20个位置将在今日20点(星期二）开始竞拍，竞拍所得金额将用于回馈代理，请登录四季星座网商家后台或淘宝搜索店名“杭州石谷网络科技有限公司”参与竞拍。退订回复T【四季星座网】"));
    }
    @Test
    public void sendMsg(){
        ShiguShopExample example=new ShiguShopExample();
        List<Long> marketIds=new ArrayList<>();
        marketIds.add(621L);
        marketIds.add(617L);
        marketIds.add(1087L);
        example.createCriteria().andMarketIdIn(marketIds).andShopStatusEqualTo(0);
        List<ShiguShop> shopList=shiguShopMapper.selectByExample(example);

//        String t="18858286556,13958140264,13675859594,18969115722,13656638853,13656636924,13732242282,13588812431,15157185880,18758888247,15157185881,13735874803,13968063222,13456776938,18658177708,18657135132,18958013731,15267073609,13858052181,13738009872,15957160401,18806810748,17705815759,15068806709,13958033088,15024499222,13906521393,18958026235,13656690690,18367169990,18658886066,15958017886,13587139866,13656640795,18668127852,15158187885,18858286556,13958140264,13675859594,18969115722,13656638853,13656636924,13732242282,13588812431,15157185880,18758888247,15157185881,13735874803,13968063222,13456776938,18658177708,18657135132,18958013731,15267073609,13858052181,13738009872,15957160401,18806810748,17705815759,15068806709,13958033088,15024499222,13906521393,18958026235,13656690690,18367169990,18658886066,15958017886,13587139866,13656640795,18668127852,15158187885,15168425655,15151176283,15059337836,15990004176,13732253806,13989895777,15355031668,18072873811,15267057876,13575482807,13645816803,13732222877,18606533221,13958551494,13282415765,18960232425,13326161655,13306525591,15857115504,15355025233,13646863799,18605880551,13185089689,15858206918,18857865668,13575471184,15158870942,13857055085,15868411550,15824455999,13530332997,13738118294,18626872559,13967157290,15868153789,15988897501,13291821366,15355425000,18358197326,15355011688,13454731785,15105789898,18368892097,18248497989,13666621775,15990154060,18258885518,13868478869,15888452828,13396564052,15888400988,15715758535,18969042702,17767090556,18506815328,13666650228,15926773682,15088770306,15968886190,13738153908,13732242504,15258766336,18655632688,15967994681,18868703635,13567152763,13186995397,15988114447,13989870167,15384058131,13857936388,15817099898,13456735570,18868700520,18868706000,15967142706,18626868666,13868126260,17767168588,13336052955,18758168038,13724015588,13858124906,15658869911,18868788991,13685775804,13777776229,15088606847,18257115286,18606638538,18758028030,15924198858,15857703705,15057145035,13858072178,18668072352,13777818002,13858007054,13616541816,15157152999,13605787096,18758886657,13588058877,13777570378,17681846080,18758251352,13486182799,18072983060,18657216586,13777067596,18368885872,13588215023,13023699911,13515711020,18758235455,18758206638,15757539106,13216708155,13868093689,17706410850,15967119297,18867120015,13858041119,18858181585,13067712628,13957182052,17005686761,15168450018,17767090267,15050904566,15968816345,18611020707,18668030199,17764555122,15268111307,17764568882,15088731800,13868088402,13567196770,15267060830,15005817009,13758890889,18605815176,18267859222,15968803269,15726882271,15867116704,18006782675,18758562317,18072209146,18767124610,13819171057,13868049629,13777376222,13666689391,18858134455,15158829182,18658823011,18668722799,13738191870,15158849841,15068130686,18258881699,13732299529,13064767116,18757555414,15257780065,15757566124,13858107612,13388668170,13656811909,13587758368,15058126971,15990171717,13588227871,13516717215,13588003255,18668615880,18767726868,13738028383,15381130929,13033663198,13616711731,18806718521,13291661618,15267190732,13655819541,13957115738,18668615880,18658781235,15325710328,13666675977,18069828383,15057130817,13958106822,15056392222,13588178857,18668016925,18967190880,13867108255,13116723286,13757154796,13685764611,13588179592,18073608900,13505810057,15990171717,18626869266,18758855559,15669964099,15168302730,18069788585,18368188326,13606818483,18757550203,15968195427,15158113123,18667040868,18767103674,15168237797,15857162886,13758250163,18758173110,15024467009,15267081333,13755591333,13505879185,18626850903,15824401335,13676425500,18958016464,13105811616,17767191337,13685790497,18069838444,15258838388,13957136827,13071822229,13777887577,13516722585,15168701189,15606999961,18679968884,13516808605,13587139951,13958141152,17767175151";
//        String[] ts=t.split(",");
//        List<String> tslist= Arrays.asList(ts);

//        在content内填入短信内容
        String content = "四季星座网温馨提示：（报名时间为7月6日-7月8日20时）网站广 告位报名入口已发布，本期总计首页28个位置，轮转播区2个，推荐档口7个，元素馆5个，商品库右侧8个，搜索右侧6个（注意：所有广 告位不同一区域同一时段内，可重复报名）报名入口为四季星座供应商后台。退订回复T【四季星座网】";
        //遍历档口计数
        int mobileCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder results = new StringBuilder();
        String result = null;
        boolean isNumberFilled = false;
        boolean isLast = false;
        for(ShiguShop s:shopList){
            mobileCount++;
            String telephone=s.getTelephone();
            if(s.getUserId()!=null){
                MemberLicenseExample licenseExample=new MemberLicenseExample();
                licenseExample.createCriteria().andUserIdEqualTo(s.getUserId()).andLicenseTypeEqualTo(4);
                List<MemberLicense> licenses=memberLicenseMapper.selectByExample(licenseExample);
                if(licenses.size()>0){
                    telephone=licenses.get(0).getContext();
                }
            }
            if(s.getShopId()==40413L){
                telephone = "18757597186;15168224104;18736271422";
            }
            if (s.getShopId()==41437L) {
                telephone = "13666678498";
            }
            if(telephone!=null){
                System.out.println(telephone);
                stringBuilder.append(';');
                stringBuilder.append(telephone);
            }
            // 短信平台建议一次最大发送不要超过3000个号码
            isNumberFilled = mobileCount%2000 == 0;
            // 最后一批号码发送信息
            isLast = mobileCount == shopList.size();
            // 发送信息
            if (isNumberFilled || isLast) {
                String destmobile = stringBuilder.substring(1);
                result = sendSms_quick(destmobile,content);
                System.out.println(result);
                results.append(result);
                results.append(';');
                //清空StringBuilder
                stringBuilder.setLength(0);
            }
        }
//        输出短信平台任务号列表，用于短信未发出时向短信平台客服查询
        System.out.println(results.toString());
    }

    String msg="温馨提示：（报名时间为4月28日-4月30日20时）网站广告位报名入口已发布，本期总计首页29个位置，轮转播区1个，轮转播下方区1个，首页热卖10个，推荐档口7个，元素馆5个，大家注意（所有广告位不同一区域同一时段内，可重复报名）报名入口为供应商后台【四季星座网】";

    private static String account_quick = "sdk_xzw";
    private static String pwd_quick = "498876342";
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
