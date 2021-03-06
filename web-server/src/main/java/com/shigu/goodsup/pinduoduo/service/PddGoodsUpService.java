package com.shigu.goodsup.pinduoduo.service;

import com.openJar.pdd.beans.ShopCat;
import com.openJar.requests.*;
import com.openJar.responses.*;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.goodsup.pinduoduo.bo.AddPropBO;
import com.shigu.goodsup.pinduoduo.bo.PddUploadBO;
import com.shigu.goodsup.pinduoduo.bo.SizeBO;
import com.shigu.goodsup.pinduoduo.bo.SkuBO;
import com.shigu.goodsup.pinduoduo.exceptions.CustomException;
import com.shigu.goodsup.pinduoduo.util.XzPddClient;
import com.shigu.goodsup.pinduoduo.vo.ImgUploadVO;
import com.shigu.goodsup.pinduoduo.vo.ItemColorPropVO;
import com.shigu.goodsup.pinduoduo.vo.PddItemDetailVO;
import com.shigu.goodsup.pinduoduo.vo.UsedCatRecordVO;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.services.ItemCatService;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.SaleProp;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.HtmlImgsLazyLoad;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.XzSdkClient;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pdd.beans.*;
import pdd.goods.add.GoodsAddRequest;
import pdd.goods.add.GoodsAddResponse;
import pdd.goods.fabric.content.get.FabricContentGetRequest;
import pdd.goods.fabric.content.get.FabricContentGetResponse;
import pdd.goods.fabric.get.FabricGetRequest;
import pdd.goods.fabric.get.FabricGetResponse;
import pdd.goods.logistics.template.get.LogisticsTemplateGetRequest;
import pdd.goods.logistics.template.get.LogisticsTemplateGetResponse;
import pdd.goods.spec.get.SpecGetRequest;
import pdd.goods.spec.get.SpecGetResponse;
import pdd.goods.spec.id.get.SpecIdGetRequest;
import pdd.goods.spec.id.get.SpecIdGetResponse;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gtx on 2018/6/18.
 * 一键上传拼多多
 * @author gtx
 * @since
 */
@Service
public class PddGoodsUpService {

    Logger logger = LoggerFactory.getLogger(PddGoodsUpService.class);

    @Resource
    private ShowForCdnService showForCdnService;
    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;
    @Resource(name = "tae_mall_shiguGoodsIdGeneratorMapper")
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Resource(name = "tae_mall_shiguTaobaocatMapper")
    private ShiguTaobaocatMapper shiguTaobaocatMapper;
    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;
    @Resource
    private XzPddClient xzPddClient;
    @Resource
    private XzSdkClient xzSdkClient;
    @Resource
    private CdnService cdnService;
    @Resource
    private ItemCatService itemCatService;
    @Resource
    private UserLicenseService userLicenseService;
    @Resource
    private ItemUpRecordService itemUpRecordService;
    @Resource
    private RedisIO redisIO;
    private static final String GOODS_SPEC_LIST = "goods_spec_list";


    /**
     * 获取上传页面商品数据
     */
    public PddItemDetailVO goodsDetail(Long itemId) {
        PddItemDetailVO vo = new PddItemDetailVO();
        //商品数据填充
        CdnItem cdnItem = showForCdnService.selItemById(itemId);
        if(cdnItem==null){//已经下架
            cdnItem=showForCdnService.selItemInstockById(itemId);
        }
        if(cdnItem==null){//商品不存在
            return null;
        }
        vo.setGoodsId(itemId.toString());
        vo.setGoodsNo(cdnItem.getHuohao());
        vo.setPiPrice(cdnItem.getPiPrice());
        vo.setPrice(cdnItem.getPiPrice());
        vo.setTitle(cdnItem.getTitle());
        vo.setTitleLength(cdnItem.getTitle().getBytes(Charset.forName("GBK")).length);
        CdnShopInfoVO shop = null;
        try {
            shop = cdnService.cdnShopInfo(cdnItem.getShopId());
            vo.setMarketName(shop.getMarketName());
            vo.setShopNum(shop.getShopNo());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        //a. 尺寸 等宽高 宽高不低于480px
        //b. 大小1M
        //c. 图片格式仅支持JPG,PNG格式
        vo.setImgSrcs(cdnItem.getImgUrl().stream().filter(item-> StringUtils.isNotBlank(item)).collect(Collectors.toList()));
        vo.setLiPrice(cdnItem.getPrice());

        BigDecimal liPrce = new BigDecimal(cdnItem.getPrice());
        BigDecimal piPrce = new BigDecimal(cdnItem.getPiPrice());
        BigDecimal subtract = liPrce.subtract(piPrce);
        subtract = subtract.setScale(2, BigDecimal.ROUND_HALF_UP);

        if (subtract.doubleValue() < 0) {
            vo.setProfit("0.00");
        }else {
            vo.setProfit(subtract.toString());
        }

        //a. 尺寸要求宽度处于480~1200px之间，高度0-1500px之间
        //b. 大小1M以内
        //c. 图片格式仅支持JPG,PNG格式
        if(cdnItem.getDescription()!=null){
            vo.setDetailsImgs(getDetailImgs(HtmlImgsLazyLoad.replaceLazyLoad(cdnItem.getDescription())));
        }

        vo.setColors(cdnItem.getColors().stream().map(item->{
            ItemColorPropVO itemColorProp = new ItemColorPropVO();
            itemColorProp.setText(item.getValue());
            itemColorProp.setImgSrc(item.getImgUrl());
            return itemColorProp;
        }).collect(Collectors.toList()));

        List<SaleProp> sizes=cdnItem.getSizes();
        if(sizes==null || sizes.isEmpty()){
            vo.setSize(Arrays.asList("均码"));
        }else {
            vo.setSize(sizes.stream().map(item-> item.getValue()).collect(Collectors.toList()));
        }

        return vo;
    }

    /**
     * 过滤HTML只返回内容中的 img 地址<br>直接将真实图片地址赋值到src<br>同时返回内容的img标签只包含 src data-original title 三种属性
     * @param source
     * @return
     */
    public  List<String> getDetailImgs(String source){
        if (StringUtil.isNull(source)){
            return null;
        }
        //只接受图片
        Whitelist whitelist = new Whitelist();
        whitelist.addTags("img").addAttributes("img",  "src","data-original", "title").addProtocols("img", "src", "http", "https");
        String cleanSource = Jsoup.clean(source,whitelist);

        Document cleanOriginnal = Jsoup.parse(cleanSource);

        Elements imgs = cleanOriginnal.select("img");
        List<String> imgUrls = new ArrayList<>();
        for (Element img : imgs){
            String imgUrl = img.attr("data-original");
            if (StringUtils.isBlank(imgUrl)) {
                continue;
            }
//            imgUrls.add(ImgUtils.formatImg(imgUrl, ImgFormatEnum.GOODS_DETAIL));
            imgUrls.add(imgUrl);
        }
        return imgUrls;
    }

    /**
     * 根据userId获取用户拼多多id
     * @param userId
     */
    public Long selPddUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setUserId(userId);
        memberUserSub.setAccountType(LoginFromType.PDD.getAccountType());
        memberUserSub = memberUserSubMapper.selectOne(memberUserSub);
        if (memberUserSub != null) {
            return Long.parseLong(memberUserSub.getSubUserKey());
        }
        return null;
    }

    /**
     * 查询运费模板
     * @param userId
     */
    public List<LogisticsTemplate> selPostTemplate(Long userId) {
        String token = selAccessToken(userId);
        if (token == null) {
            return null;
        }
        LogisticsTemplateGetRequest request = new LogisticsTemplateGetRequest();
        request.setPage(1);
        request.setPage_size(20);
        LogisticsTemplateGetResponse response = xzPddClient.openClient(token).excute(request);
        if (!response.getSuccess()) {
            return null;
        }
        return response.getLogisticsTemplates();
    }

//    /**
//     * 查询用户授权类目信息
//     * cid为空则查最顶级
//     */
//    public  List<GoodsCats> selAuthorizationCats(Long userId,Long cid) {
//        String token = selAccessToken(userId);
//        if (token == null) {
//            return null;
//        }
//
//        AuthorizationCatsRequest request = new AuthorizationCatsRequest();
//        request.setParent_cat_id(cid);
//        AuthorizationCatsResponse response = xzPddClient.openClient(token).excute(request);
//        if (!response.getSuccess()) {
//            return null;
//        }
//        return response.getGoodsCatsList();
//
//    }
//
    /**
     * 查询用户授权类目信息
     * cid为空则查最顶级
     */
    public  List<ShopCat> selAuthorizationCats(Long userId, Long cid) {
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setUserId(userId);
        memberUserSub.setAccountType(LoginFromType.PDD.getAccountType());

        memberUserSub = memberUserSubMapper.selectOne(memberUserSub);
        if (memberUserSub == null) {
            return null;
        }

        SelAuthorizationCatsRequest request = new SelAuthorizationCatsRequest();
        request.setPddUid(new Long(memberUserSub.getSubUserKey()));
        request.setParentCid(cid);
        SelAuthorizationCatsResponse response = xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
            return null;
        }
        return response.getShopCats();

    }

    /**
     * 根据拼多多cid查询拼多多类目层级信息
     */
    public String selPddCatsNamesByPddCid(Long cid) {
        PddCatsNamesRequest request = new PddCatsNamesRequest();
        request.setCatId(cid);

        PddCatsNamesResponse response = xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
            return null;
        }
        return response.getCatNames();
    }


    /**
     * 根据拼多多cid查询拼多多类目层级cid信息
     */
    public String selPddCatsIdsByPddCid(Long cid) {
        PddCatsNamesResponse response = selPddCatsInfoByPddCid(cid);
        if (!response.isSuccess()) {
            return null;
        }
        return response.getAllCids();
    }

    /**
     * 根据拼多多cid查询拼多多类目层级信息
     */
    public PddCatsNamesResponse selPddCatsInfoByPddCid(Long cid) {
        PddCatsNamesRequest request = new PddCatsNamesRequest();
        request.setCatId(cid);

        return xzSdkClient.getPcOpenClient().execute(request);
    }

    /**
     * 根据星座网cid查询拼多多cid
     */
    public Long selPddCidByXzCid(Long cid) {
        boolean instanOfWoman = itemCatService.instanOfWoman(cid);

        SelPddCidByXzCidRequest request = new SelPddCidByXzCidRequest();
        request.setXzCid(cid);
        request.setSex(instanOfWoman ? 0 : 1);

        SelPddCidByXzCidResponse response = xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
            return null;
        }
        return response.getPddCid();
    }


    /**
     *  根据goodsId查询星座网类目层级信息
     * @param goodsId
     */
    public String selXzCatsName(Long goodsId) {

        Long cid = selCidByGoodsId(goodsId);
        if (cid == null) {
            return null;
        }
        ShiguTaobaocat st = shiguTaobaocatMapper.selectByPrimaryKey(cid);
        if(st != null){
            if(st.getParentCname() != null){
                return st.getParentCname()+" > "+st.getCname();
            }else{
                return st.getCname();
            }
        }
        return null;
    }

    /**
     *  根据商品id 查询类目id
     * @param goodsId 商品id
     * @return 类目id
     */
    public Long selCidByGoodsId(Long goodsId){
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            return null;
        }
        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        if (tiny == null) {
            return null;
        }
        return tiny.getCid();
    }

    /**
     * 根据userId获取与accesstoken
     * @param userId
     * @return
     */
    public String selAccessToken(Long userId){
        PddAuthInfoRequest pddAuthInfoRequest = new PddAuthInfoRequest();
        pddAuthInfoRequest.setThirdUid(selPddUserId(userId));
        PddAuthInfoResponse pddAuthInfoResponse = xzSdkClient.getPcOpenClient().execute(pddAuthInfoRequest);
        if (pddAuthInfoResponse.isSuccess()) {
            return pddAuthInfoResponse.getAccessToken();
        }
        return null;
    }

    /**
     * 生成商家自定义的规格
     * 1 颜色 0 尺码
     * @return
     */
    public Long addProp(Long userId,AddPropBO bo) {
        SelThirdLevelCidRequest request = new SelThirdLevelCidRequest();
        request.setPddCid(bo.getPddCid());
        SelThirdLevelCidResponse response = xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
           return null;
        }

        String token = selAccessToken(userId);
        if (token == null) {
            return null;
        }

        List<GoodsSpec> goodsSpecList = redisIO.getList(GOODS_SPEC_LIST,GoodsSpec.class);
        if (goodsSpecList == null) {
            SpecGetRequest specGetRequest = new SpecGetRequest();
            specGetRequest.setCat_id(response.getThirdLevelCid());
            SpecGetResponse specGetResponse = xzPddClient.openClient(token).excute(specGetRequest);
            if (!specGetResponse.getSuccess()) {
                return null;
            }
            goodsSpecList = specGetResponse.getGoodsSpecList();
            redisIO.putTemp(GOODS_SPEC_LIST,goodsSpecList,1800);//缓存半小时
        }


        Long parentSpecId = null;
        if (bo.getType() == 1) {//1 颜色
            for (GoodsSpec goodsSpec : goodsSpecList){
                if ("颜色".equals(goodsSpec.getParentSpecName())) {
                    parentSpecId = goodsSpec.getParentSpecId();
                    break;
                }
            }
        }else {//0 尺码
            for (GoodsSpec goodsSpec : goodsSpecList){
                if ("尺码".equals(goodsSpec.getParentSpecName())) {
                    parentSpecId = goodsSpec.getParentSpecId();
                    break;
                }
            }
        }

        SpecIdGetRequest specIdGetRequest = new SpecIdGetRequest();
        specIdGetRequest.setParent_spec_id(parentSpecId);
        specIdGetRequest.setSpec_name(bo.getPropName());
        SpecIdGetResponse specIdGetResponse = xzPddClient.openClient(token).excute(specIdGetRequest);
        if (!specIdGetResponse.getSuccess()) {
            return null;
        }
        return specIdGetResponse.getSpecId();
    }

    /**
     * 记录上传使用过的类目信息
     * @param userId
     * @param pddCid
     */
    public void addUsedCatRecord(Long userId, Long pddCid) {
        try {
            AddUsedCatRecordRequest recordRequest = new AddUsedCatRecordRequest();
            recordRequest.setXzUserId(userId);
            recordRequest.setPddCid(pddCid);

            xzSdkClient.getPcOpenClient().execute(recordRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询用户上传使用过的类目信息
     * @return
     */
    public List<UsedCatRecordVO> selUsedCatRecord(Long userId, String catName) {
        SelUsedCatRecordRequest recordRequest = new SelUsedCatRecordRequest();
        recordRequest.setXzUserId(userId);
        recordRequest.setCatName(catName);
        recordRequest.setStartIndex(0);
        recordRequest.setSize(5);

        SelUsedCatRecordResponse recordResponse = xzSdkClient.getPcOpenClient().execute(recordRequest);
        if (!recordResponse.isSuccess() || recordResponse.getUsedCatRecords() == null
                || recordResponse.getUsedCatRecords().isEmpty()) {
            return null;
        }
        List<UsedCatRecordVO> usedCatRecordVOS = recordResponse.getUsedCatRecords().stream().map(item -> {
            UsedCatRecordVO usedCatRecordVO = new UsedCatRecordVO();
            usedCatRecordVO.setCid(item.getCid() + "");
            usedCatRecordVO.setText(item.getShowName());
            usedCatRecordVO.setValue(item.getAllcids());
            return usedCatRecordVO;
        }).collect(Collectors.toList());

        return usedCatRecordVOS;
    }

    /**
     * 商品上传
     * @param
     */
    public GoodsAddResponse upload(PddUploadBO bo, String[] picUrl, String[] descPicUrl, List<SkuBO> skuBOS ,Long userId) throws CustomException {
        GoodsAddRequest request = new GoodsAddRequest();
        //skuList
        List<Sku> skus = new ArrayList<>();
        for (SkuBO skuBO :skuBOS){
            if (skuBO == null || StringUtils.isBlank(skuBO.getName())
                    || StringUtils.isBlank(skuBO.getImgSrc())
                    || skuBO.getVid() == null) {
                continue;
            }
            Long colorId = skuBO.getVid();

            List<SizeBO> sizes = skuBO.getSizes();
            if (sizes != null && sizes.size() > 0) {
                for (SizeBO sizeBO : sizes){
                    if (sizeBO == null || sizeBO.getVid() == null
                        || StringUtils.isBlank(sizeBO.getName())) {
                        continue;
                    }
                    Sku sku = new Sku();

                    sku.setSpec_id_list(com.alibaba.fastjson.JSONObject.toJSONString(Arrays.asList(colorId,sizeBO.getVid())));
                    sku.setWeight(1000L);
                    sku.setQuantity(Integer.parseInt(sizeBO.getNum()));
                    sku.setOut_sku_sn(sizeBO.getCode());
                    sku.setThumb_url(skuBO.getImgSrc());
                    sku.setMulti_price(MoneyUtil.StringToLong(sizeBO.getGprice()));
                    sku.setPrice(MoneyUtil.StringToLong(sizeBO.getPrice()));
                    sku.setLimit_quantity(999);
                    sku.setIs_onsale(1);

                    skus.add(sku);
                }
            }
        }

        request.setSku_list(com.alibaba.fastjson.JSONObject.toJSONString(skus));

        request.setGoods_name(bo.getTitle());
        //1-国内普通商品，2-进口，3-直供（保税），4-直邮 ,5-流量 ,6-话费 ,7-优惠券 ,8-QQ充值 ,9-加油卡
        request.setGoods_type(1);
        request.setGoods_desc(bo.getSellPoint());
        request.setCat_id(bo.getCid());
        request.setTiny_name(bo.getSmallTitle());
        request.setCountry_id(0L);//中国CountryGetRequest获取 仅在goods_type为2、3时（海淘商品）入参生效，其余goods_type传0
        request.setMarket_price(MoneyUtil.StringToLong(bo.getMarketPrice()));
        request.setIs_pre_sale(false);

        long shipment_limit_second = 0L;
        if (bo.getDelivery() == 1) {
            shipment_limit_second = 48 * 60 * 60;
        }else {
            shipment_limit_second = 24 * 60 * 60;
        }
        request.setShipment_limit_second(""+shipment_limit_second);
        request.setCost_template_id(bo.getPostage_id());
        request.setCustomer_num(bo.getGrouponer());
        request.setBuy_limit(bo.getSingleLimit());
        request.setOrder_limit(bo.getPurchaseLimit());
        request.setIs_refundable(bo.getReturns() == 1 ? true : false );
        request.setSecond_hand(false);
        request.setIs_folt(bo.getArtificial() == 1 ? true : false);
        request.setOut_goods_id(bo.getOuterId());
        request.setHd_thumb_url(bo.getHdThumbUrl());
        request.setThumb_url(bo.getThumbUrl());

        List<String> picUrlList = Arrays.stream(picUrl).filter(item -> StringUtils.isNotBlank(item)).collect(Collectors.toList());
        List<String> descPicUrlList = Arrays.stream(descPicUrl).filter(item -> StringUtils.isNotBlank(item)).collect(Collectors.toList());

        request.setCarousel_gallery(com.alibaba.fastjson.JSONObject.toJSONString(picUrlList));
        request.setDetail_gallery(com.alibaba.fastjson.JSONObject.toJSONString(descPicUrlList));
        request.setImage_url(bo.getMainImg());

        if (StringUtils.isNotBlank(bo.getGoodsFabricCode())) {
            request.setFabric(Long.valueOf(bo.getGoodsFabricCode()));
        }
        if (StringUtils.isNotBlank(bo.getFabricContentCode())) {
            request.setFabric_content(Long.valueOf(bo.getFabricContentCode()));
        }

        String token = selAccessToken(userId);
        if (token == null) {
            throw new CustomException("未查询到授权信息");
        }
        GoodsAddResponse response = xzPddClient.openClient(token).excute(request);

        if (!response.getSuccess()) {
            if (logger.isInfoEnabled()) {
                logger.info(userId + "request -> "+ com.alibaba.fastjson.JSONObject.toJSONString(request)+
                        "response -> " + com.alibaba.fastjson.JSONObject.toJSONString(response));
            }
            System.err.println(userId + "request -> "+ com.alibaba.fastjson.JSONObject.toJSONString(request)+
                    "response -> " + com.alibaba.fastjson.JSONObject.toJSONString(response));
            throw new CustomException(response.getException().getErrMsg());
        }

        return response;
    }

    /**
     * 图片上传
     * @param imgUrl
     * @param tempCode
     * @return
     */
    public ImgUploadVO uploadImg(String imgUrl, String tempCode, Integer type, Long userId) throws CustomException {
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setUserId(userId);
        memberUserSub.setAccountType(LoginFromType.PDD.getAccountType());

        memberUserSub = memberUserSubMapper.selectOne(memberUserSub);
        if (memberUserSub == null) {
            throw new CustomException("该账号尚未绑定拼多多");
        }

        PddUploadImgRequest request = new PddUploadImgRequest();
        request.setImgUrl(imgUrl);
        request.setPddUid(new Long(memberUserSub.getSubUserKey()));
        request.setType(type);
        request.setTempCode(tempCode);

        PddUploadImgResponse response = xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
            throw new CustomException(response.getException().getErrMsg());
        }
        ImgUploadVO vo = new ImgUploadVO();
        vo.setTempCode(response.getTempCode());
        vo.setPddImgUrls(response.getPddImgUrls());
        vo.setNum(response.getNum());
        return vo;

    }

    /**
     * 强制更新pdd店内类目信息
     * @return
     */
    public JSONObject updateShopCats(Long userId) {
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setUserId(userId);
        memberUserSub.setAccountType(LoginFromType.PDD.getAccountType());

        memberUserSub = memberUserSubMapper.selectOne(memberUserSub);
        if (memberUserSub == null) {
            return JsonResponseUtil.error("该账号尚未绑定拼多多");
        }

        UpdateShopCatsRequest request = new UpdateShopCatsRequest();
        request.setPddUid(new Long(memberUserSub.getSubUserKey()));
        request.setXzUserId(userId);

        UpdateShopCatsResponse response = xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
            return JsonResponseUtil.error("更新失败");
        }
        return JsonResponseUtil.success();

    }

    /**
     * 添加上传记录
     * @param userId
     * @param cid
     * @param mid
     */
    public void saveRecord(Long userId, Long cid, Long mid,PddUploadBO bo,Long pddGoodsId) {

        PddAuthInfoRequest pddAuthInfoRequest = new PddAuthInfoRequest();
        pddAuthInfoRequest.setThirdUid(selPddUserId(userId));
        PddAuthInfoResponse pddAuthInfoResponse = xzSdkClient.getPcOpenClient().execute(pddAuthInfoRequest);
        if (!pddAuthInfoResponse.isSuccess()) {
            return;
        }

        ItemUpRecordVO vo=new ItemUpRecordVO();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        vo.setDaiTime(sdf.format(new Date()));
        vo.setFenGoodsName(bo.getTitle());
        vo.setFenImage(bo.getMainImg());
        vo.setFenPrice(bo.getMarketPrice());
        vo.setFenNumiid(pddGoodsId);
        vo.setFenUserId(userId);
        vo.setFenUserNick(pddAuthInfoResponse.getThirdUserNick());
        vo.setFlag(GoodsUploadFlagEnum.PDD.getFlag());
        vo.setSupperGoodsId(mid);
        vo.setCid(cid);



        try {
            userLicenseService.addScore(vo.getFenUserId(),1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShiguGoodsIdGenerator sgig = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(vo.getSupperGoodsId());
        if(sgig==null){
            return;
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(vo.getSupperGoodsId());
        sgt.setWebSite(sgig.getWebSite());
        sgt = shiguGoodsTinyMapper.selectByPrimaryKey(sgt);
        if(sgt==null){
            return;
        }
        ShiguShop shop = shiguShopMapper.selectByPrimaryKey(sgt.getStoreId());
        if(shop==null){
            return;
        }
        ShopNumAndMarket goodsMarketInfo = shiguShopMapper.selMarketInfo(sgt.getStoreId());
        vo.setSupperGoodsName(sgt.getTitle());
        vo.setWebSite(sgig.getWebSite());
        vo.setSupperImage(sgt.getPicUrl());
        vo.setSupperMarketId(sgt.getMarketId());
        vo.setSupperNumiid(sgt.getNumIid());
        vo.setSupperMarket(goodsMarketInfo.getMarket());

        vo.setSupperPiPrice(sgt.getPiPriceString());
        vo.setSupperPrice(sgt.getPriceString());
        vo.setSupperStoreId(sgt.getStoreId());
        vo.setSupperImww(shop.getImAliww());
        vo.setSupperQq(shop.getImQq());
        vo.setSupperTelephone(shop.getTelephone());
        vo.setSupperTaobaoUrl(shop.getTaobaoUrl());
        itemUpRecordService.addItemUpRecord(vo);

    }

    /**
     * 查询服饰面料含量信息
     */
    public List<FabricContent> selFabricContent(Long userId) {
        String token = selAccessToken(userId);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        FabricContentGetRequest request = new FabricContentGetRequest();
        FabricContentGetResponse response = xzPddClient.openClient(token).excute(request);
        if (!response.getSuccess()) {
            return null;
        }
        return response.getFabricContentList();
    }

    /**
     * 查询服饰面料信息
     */
    public List<GoodsFabric> selGoodsFabric(Long userId) {
        String token = selAccessToken(userId);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        FabricGetRequest request = new FabricGetRequest();
        FabricGetResponse response = xzPddClient.openClient(token).excute(request);
        if (!response.getSuccess()) {
            return null;
        }
        return response.getGoodsFabricList();
    }
}
