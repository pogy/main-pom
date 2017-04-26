package com.shigu.main4.data.translate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.enums.FitmentAreaType;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.vo.FitmentArea;
import com.shigu.main4.vo.FitmentModule;
import com.shigu.main4.vo.fitment.CustomModule;
import com.shigu.main4.vo.fitment.ImageInfo;
import com.shigu.main4.vo.fitment.SlideshowModule;
import com.shigu.main4.vo.fitment.ViwepagerModule;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 店铺装修导入
 * Created by Administrator on 2017/4/25 0025.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class ShiguShopFitmentTrans {

    private static final Logger logger = LoggerFactory.getLogger(ShiguShopFitmentTrans.class);

    @Autowired
    private ShiguShopFitmentMapper shiguShopFitmentMapper;

    @Autowired
    private ShopFitmentModuleMapper shopFitmentModuleMapper;

    @Autowired
    private ShopFitmentPageMapper shopFitmentPageMapper;

    @Autowired
    private ShopFitmentAreaMapper shopFitmentAreaMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShopFitmentService shopFitmentService;

    @Test
    public void trans() throws ShopFitmentException {

        int size = 200;
//        int start = 21800;
        int start = 17000;
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.setStartIndex(start);
        shiguShopExample.setEndIndex(size);
        List<ShiguShop> shops;
        while (!(shops = shiguShopMapper.selectByConditionList(shiguShopExample)).isEmpty()) {
            List<Long> shopIds = new ArrayList<>();
            logger.info("正在初始化店铺：" + start + "-" + (start + size));
            for (ShiguShop shop : shops) {
                Long shopId = shop.getShopId();
                ShopFitmentAreaExample exm = new ShopFitmentAreaExample();
                exm.createCriteria().andShopIdEqualTo(shopId);
                int areaSize = shopFitmentAreaMapper.countByExample(exm);
                if (5 == areaSize) {
                    logger.info(shopId + "已导入，跳过");
                    continue;
                }
                if (areaSize < 3)
                    shopFitmentService.initShopFitment(shopId);
                if (shop.getShopStatus() == 0 && shopFitmentAreaMapper.countByExample(exm) == 3) {
                    shopIds.add(shopId);
                }
            }
            if (!shopIds.isEmpty()) {
                ShiguShopFitmentExample fitmentExample = new ShiguShopFitmentExample();
                fitmentExample.createCriteria().andShopIdIn(shopIds);
                List<ShiguShopFitment> shiguShopFitments = shiguShopFitmentMapper.selectByExample(fitmentExample);
                logger.info("初始化完成，正在提取旧装修数据。共有" + shiguShopFitments.size() + "家店铺需要提取");
                for (ShiguShopFitment shiguShopFitment : shiguShopFitments) {
                    Long shopId = shiguShopFitment.getShopId();
//                shopFitmentService.initShopFitment(shopId);
                    Long indexPage = shopFitmentService.selIndexPageIdByShopId(shopId);
                    List<FitmentArea> fitmentAreas = shopFitmentService.selAreaByPageId(indexPage);
                    FitmentArea fitmentArea = fitmentAreas.get(0);
                    Long areaId = fitmentArea.getAreaId();
                    if (shiguShopFitment.getShowSlide() == 1) {
                        Long wadeImage = areaId = shopFitmentService.addArea(indexPage, areaId, FitmentAreaType.CENTER.value(), 1);
                        Long slideModule = shopFitmentService.addModule(wadeImage, null, FitmentModuleType.Slideshow.value, 3, null);
                        List<ImageInfo> images = new ArrayList<>();
                        for (Field field : ShiguShopFitment.class.getDeclaredFields()) {
                            if (field.getModifiers() == Modifier.PRIVATE) {
                                String name = field.getName();
                                if (name.startsWith("shopBanner")) {
                                    field.setAccessible(true);
                                    try {
                                        Object v = field.get(shiguShopFitment);
                                        if (v != null && !"".equals(v)) {
                                            ImageInfo info = new ImageInfo();
                                            info.setPicUrl(v.toString());
                                            info.setTargetUrl("http://www.571xz.com/shop.htm?id=" + shopId);
                                            images.add(info);
                                        }
                                    } catch (Exception ignored) {
                                    }
                                }
                            }
                        }
                        SlideshowModule slideshowModule = new SlideshowModule();
                        slideshowModule.setAreaId(wadeImage);
                        slideshowModule.setModuleId(slideModule);
                        slideshowModule.setAreaId(0L);
                        slideshowModule.setSideType(3);
                        slideshowModule.setImages(images);
                        shopFitmentService.revalueModule(slideModule, slideshowModule);
                    }
                    if (shiguShopFitment.getShowDescription() == 1) {
                        Long customArea = shopFitmentService.addArea(indexPage, areaId, FitmentAreaType.CENTER.value(), 1);
                        Long customModuleId = shopFitmentService.addModule(customArea, null, FitmentModuleType.Custom.value, 3, null);
                        CustomModule customModule = new CustomModule();
                        customModule.setTitleShow(0);
                        customModule.setAreaId(customArea);
                        customModule.setModuleId(customModuleId);
                        customModule.setSideType(3);
                        customModule.setContent(shiguShopFitment.getDescription());
                        shopFitmentService.revalueModule(customModuleId, customModule);
                    }
                }
            }
            shiguShopExample.setStartIndex(start += size);
        }
    }

    @Test
    public void fitmentPublish() {
        int start = 0;
        int size = 200;
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.setStartIndex(start);
        shiguShopExample.setEndIndex(size);
        shiguShopExample.setOrderByClause("shop_id ASC");
        shiguShopExample.createCriteria().andShopStatusEqualTo(0).andWebSiteEqualTo("hz");
        List<ShiguShop> shiguShops;
        boolean ignore = true;
        while (!(shiguShops = shiguShopMapper.selectByConditionList(shiguShopExample)).isEmpty()) {
            logger.info("start:" + start);
            for (ShiguShop shiguShop : shiguShops) {
                if (ignore) {
                    if (shiguShop.getShopId() >= (20211L)) {
                        ignore = false;
                    }
                    continue;
                }
                logger.info("id:" + shiguShop.getShopId());
                publishOne(shiguShop.getShopId());
            }
            shiguShopExample.setStartIndex(start += size);
        }
    }

    public void publishOne(Long shopId ) {
        ShopFitmentAreaExample exm = new ShopFitmentAreaExample();
        exm.createCriteria().andShopIdEqualTo(shopId);
        int areaSize = shopFitmentAreaMapper.countByExample(exm);
        if (areaSize >= 3) {
            shopFitmentService.publishBanner(shopId);
            ShopFitmentPageExample pagerExample = new ShopFitmentPageExample();
            pagerExample.createCriteria().andShopIdEqualTo(shopId);
            for (ShopFitmentPage page : shopFitmentPageMapper.selectByExample(pagerExample)) {
                shopFitmentService.publishPage(page.getPageId(), shopId);
            }
        }
    }

    @Test
    public void publishOne() {
        publishOne(35992L);
    }

    @Test
    public void delArea() {
        shopFitmentService.rmArea(73173L);
    }

    long[] areaIds = new long[]{2787,2797,2800,2804,2806,2807,2809,3413,3415,4017,4019,4021,4023,4027,4629,4631,4633,4635,4637,4639,4641,4643,5246,5248,5252,5255,5257,5859,5861,5863,5865,5867,5868,5872,5874,5876,6478,6480,6482,6484,6486,7090,7092,7094,7698,7700,7702,7704,8307,8312,8314,8316,8318,8320,8322,8324,8927,8929,8931,8933,9535,9537,9541,9547,23356,23360,23362,29364,29366,29369,29371,29373,29379,29381,29383,30585,31187,31189,31191,31193,31195,31803,31805,31807,31809,31811,31813,31815,36019,36021,36023,36025,36627,36629,36633,36635,36645,36647,36654,36656,36664,36666,36671,36673,36675,36681,36683,36687,36689,36693,36695,37298,37304,37307,37309,37319,37321,37324,37327,37329,37331,37333,37335,37338,37342,37344,37346,37348,37350,37353,37957,37959,37968,37970,37972,37976,37979,37981,37985,37987,37989,37991,37993,37995,37997,37999,38002,38604,38609,38616,38619,38623,38625,38627,38629,38631,38633,38635,38637,38639,38641,38643,38645,38647,38649,38651,39253,39257,39259,39262,39266,39268,39270,39272,39274,39277,39279,39281,39283,39285,39291,39893,39895,39899,39901,40505,44110,44112,44114,44116,44118,44120,44122,44124,44126,44128,44733,44735,44742,44744,44746,44748,44750,45352,45354,45356,45358,45360,45364,45366,45368,45370,45372,45374,45376,45980,45986,45989,45991,45993,45995,45997,45999,46001,46004,46006,46008,46010,46012,46014,46618,46620,46624,46627,46629,46631,47233,47235,47237,47240,47242,47245,47247,47249,47251,47253,47861,47863,50265,62044,62046,62048,62054,62056,62058,62060,62737,62739,62741,62743,63346,63348,63350,63352,63354,63356,63358,63360,63362,63368,64176,64178,64180,64182,64184,64186,64189,64193,64393,64395,64397,64399,64401,64603,64609,64612,64614,64616,64621,64826,64828,64830,64840,64844,64846,68238,68240,68247,68249,68254,68256,68259,68261,68263,68265,68267,68269,68271,68273,68275,68284,68288,68290,68294,68296,68299,68303,68306,68308,68310,68312,68914,68920,68923,68925,68927,68929,68931,68933,68937,68940,68942,68946,68949,68952,68954,68960,68962,68964,68966,68968,68970,68972,69574,69576,69578,69582,69584,69586,69589,69591,69593,69596,69598,69600,69602,69604,69606,69608,69610,69612,69614,69616,69618,69620,69622,69624,69626,69628,69630,69634,69637,69639,69641,69647,69649,69651,69653,69655,69657,69659,69666,69668,69670,69674,69676,69680,69682,69688,69689,69691,69697,69699,70301,70303,70305,70307,70312,70315,70319,70321,70323,70325,70327,70329,70334,70336,70340,70342,70344,70346,70350,70353,70356,70358,70362,70364,70366,70368,70370,70372,70374,70376,70378,70380,70382,70386,70388,70390,70392,70394,70398,70400,70411,71016,71018,71020,71022,71026,71028,71030,71033,71038,71040,71044,71046,71048,71050,71052,71054,71056,71058,71060,71062,71066,71068,71070,71074,71076,71079,71081,71085,71087,71089,71092,71094,71096,71098,71100,71102,71104,71110,71112,71116,71118,71120,71122,71126,71128,71133,71141,71748,71750,71755,71759,71762,71766,71768,71770,71772,71774,71776,71779,71784,71786,71788,71790,71792,71794,71796,71798,72398,72400,72402,72406,72408,72410,72412,72416,72418,72424,72428,72434,72436,72443,72445,72447,72449,72453,72457,72461,72463,72465,72467,72469,72471,72473,72475,72477,72479,72481,72483,72485,72487,72489,72491,72493,72495,72497,72499,72501,72505,72508,72510,72512,72520,72523,72526,72528,73130,73132,73134,73136,73138,73142,73144,73146,73148,73150,73152,73154,73156,73161,73164,73166,73169,73175,73179,73181,73183,73185,73187,73189,73191,73195,73197,73199,73203,73205,73207,73209,73214,73216,73219,73221,73223,73225,73227,73230,73232,73234,73236,73238,73240,73242,73244,73246,73250,73252,73254,73256,73258,73260,73262,73264,73866,73868,73870,73872,73876,73878,73880,73882,73884,73886,73888,73890,73895,73897,73899,73902,73904,73908,73910,73912,73914,73916,73918,73920,73922,73924,73926,73928,73930,73932,73934,73941,73943,73947,73949,73951,74555,74559,74561,74563,74567,74569,74571,74573,74577,74579,74581,74583,74585,74589,74591,74593,74597,74599,74601,74603,74606,74610,74612,74614,74616,74618,74621,74623,74625,74627,74629,74631,74633,74635,74639,74641,74643,74645,74647,74649,74651,74653,74655,74657,74659,74661,74663,74665,74667,74669,74673,74676,74678,75281,75283,75285,75287,75289,75291,75293,75303,75310,75312,75314,75318,75320,75322,75324,75326,75328,75330,75332,75334,75336,75338,75340,75342,75344,75348,75352,75958,75962,75965,75967,75969,75974,75976,75978,75984,75986,75988,75992,75994,75996,75998,76000,76002,76008,76010,76012,76014,76016,76018,76020,76022,76024,76026,76028,76030,76032,76040,76047,76049,76054,76655,76658,76660,76662,76664,76668,76670,76672,76674,76676,76678,76680,76683,76685,76687,76689,76691,76693,76695,76697,76699,76701,76703,76705,76707,76709,76712,76714,76716,76718,76720,76728,76732,76734,76740,77342,77344,77349,77353,77361,77363,77365,77367,77373,77377,77383,77387,77389,77391,77395,77399,77403,77405,77408,77410,77412,77418,77421,77425,77427,77429,77431,77435,77437,77439,77441,77445,77447,77450,77452,77454,77456,77458,77462,77466,77468,77472,78078,78080,78082,78088,78092,78094,78096,78098,78100,78102,78106,78110,78112,78114,78116,78118,78120,78122,78124,78126,78130,78132,78134,78136,78140,78142,78144,78148,78150,78155,78163,78165,78167,78171,78173,78179,78181,78183,78187,78189,78791,78793,78795,78802,78804,78806,78808,78813,78820,78824,78826,78829,78833,78835,78837,78839,78841,78843,78845,78849,78851,78853,78856,78858,78862,78864,78866,78868,78980,78982,78984,78986,78988,78990,78992,78994,78996,78998,79003,79010,79014,79022,79027,79029,79033,79037,79039,79043,79045,79047,79049,79058,79060,79062,79064,79066,79071,79073,79076,79078,79080,79085,79089,79091,79095,79097,79100,79102,79103,79105,79107,79109,79113,79117,79119,79121,79123,79125,79127,79129,79131,79133,79134,79136,79138,79140,79143,79145,79147,79149,79153,79155,79157,79159,79161,79163,79165,79167,79171,79173,79175,79177,79179,79183,79186,79188,79190,79196,79198,79203,79205,79207,79209,79211,79220,79226,79230,79238,79240};
    long[] shopIds = new long[]{40638, 40654, 40583, 40659, 40633, 40739, 40720, 40721, 40649, 40634, 40551, 40576, 40655, 40606, 40645, 40594, 40692, 40691, 40690, 40593, 40567, 40615, 40562, 40556, 40625, 40547, 40568, 40610, 40698, 40733, 40777, 40790, 40786, 40764, 40762, 40833, 40773, 40852, 40839, 40848, 40816, 40892, 40897, 40909, 40910, 40915, 40772, 40907, 40919, 40940, 40923, 40911, 40905, 40862, 40904, 40747, 40754, 40795, 40796, 40808, 40793, 40818, 40884, 40805, 40752, 40760, 40900, 40925, 40920, 40746, 40853, 40857, 40866, 40859, 40879, 40751, 40895, 40858, 40929, 40854, 40849, 40830, 40903, 40983, 41008, 40950, 41019, 40979, 40969, 41017, 41060, 41062, 41049, 40948, 41034, 41030, 40993, 40981, 41037, 41006, 40947, 41067, 41026, 40974, 40978, 40971, 40972, 40970, 41003, 40959, 41197, 41207, 41211, 41195, 41230, 41218, 41199, 41244, 41273, 41250, 41280, 41292, 41301, 41290, 41328, 41276, 41344, 41251, 41339, 41266, 41241, 41281, 41286, 41184, 41186, 41264, 41270, 41295, 41303, 41237, 41255, 41265, 41236, 41279, 41352, 41354, 41351, 41370, 41374, 41386, 41444, 41439, 41375, 41511, 41381, 41454, 41377, 41515, 41533, 41528, 41355, 41514, 41435, 41443, 41403, 41445, 41363, 41534, 41472, 41490, 41526, 41521, 41516, 41371, 41364, 41353, 41437, 41446, 41373, 41549, 41557, 41569, 41556, 41610, 41582, 41583, 41625, 41640, 41650, 41632, 41664, 41662, 41669, 41631, 41674, 41670, 41678, 41697, 41702, 41701, 41647, 41711, 41689, 41721, 41744, 41559, 41723, 41713, 41552, 41679, 41722, 41712, 41605, 41616, 41683, 41623, 41634, 41613, 41646, 41558, 41658, 41753, 41754, 41763, 41781, 41789, 41787, 41800, 41803, 41802, 41792, 41832, 41849, 41761, 41784, 41860, 41857, 41863, 41876, 41870, 41837, 41883, 41768, 41877, 41885, 41766, 41858, 41785, 41776, 42413, 41834, 42415, 42411, 42416, 41881, 41801, 41892, 41765, 41798, 41891, 41794, 42449, 42448, 42463, 42493, 42508, 42505, 42531, 42527, 42466, 42535, 42562, 42574, 42575, 42578, 42590, 42577, 42501, 42600, 42594, 42612, 42500, 42500, 42561, 42477, 42637, 42547, 42639, 42630, 40074, 40095, 40028, 39994, 39974, 40136, 40031, 40032, 39936, 40058, 40099, 40116, 39995, 35477, 35589, 35554, 35611, 35607, 35555, 35467, 35562, 35595, 35567, 35635, 35642, 35686, 35664, 35749, 35781, 35698, 35748, 35696, 35651, 35719, 35683, 35706, 35667, 35662, 35892, 35922, 35914, 35923, 35940, 35906, 35973, 35859, 35901, 35896, 35984, 35886, 35978, 35897, 35937, 35969, 35885, 35964, 35920, 35936, 35985, 35874, 36087, 36166, 36177, 36181, 36058, 36171, 36128, 36178, 36162, 36149, 36187, 36089, 36267, 36264, 36292, 36295, 36385, 36375, 36376, 36325, 36303, 36297, 36367, 36260, 36268, 36270, 36259, 36352, 36383, 36337, 36336};

    @Test
    public void rePublish() {
        for (long shopId : shopIds) {
            publishOne(shopId);
        }
    }
    @Test
    public void delSomeArea() {
        for (long areaId : areaIds) {
            shopFitmentService.rmArea(areaId);
        }
    }


    @Test
    public void test() throws ShopFitmentException {
//        List<FitmentArea> fitmentAreas = shopFitmentService.selAreaByPageId(79L);
        shopFitmentService.initShopFitment(35747L);
//        System.out.println(JSON.toJSONString(fitmentAreas, SerializerFeature.PrettyFormat));
    }



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

    @Test
    public void mvSlideshowToViewpager() {
        ShopFitmentModuleExample moduleExam = new ShopFitmentModuleExample();
        moduleExam.createCriteria().andTypeEqualTo(6);
        List<ShopFitmentModule> shopFitmentModules = shopFitmentModuleMapper.selectByExample(moduleExam);
        for (ShopFitmentModule shopFitmentModule : shopFitmentModules) {
            ViwepagerModule module = (ViwepagerModule) JSON.parseObject(shopFitmentModule.getModuleValue(), FitmentModuleType.typeOf(6).moduleType.getClazz());
            module.setModHeight(360);
            shopFitmentModule.setModuleValue(JSON.toJSONString(module));
            shopFitmentModuleMapper.updateByPrimaryKeySelective(shopFitmentModule);
        }
    }
}
