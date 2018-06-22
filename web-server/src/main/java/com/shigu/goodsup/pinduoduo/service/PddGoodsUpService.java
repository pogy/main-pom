package com.shigu.goodsup.pinduoduo.service;

import com.openJar.requests.PddAuthInfoRequest;
import com.openJar.requests.PddCatsNamesRequest;
import com.openJar.requests.SelPddCidByXzCidRequest;
import com.openJar.requests.SelThirdLevelCidRequest;
import com.openJar.responses.PddAuthInfoResponse;
import com.openJar.responses.PddCatsNamesResponse;
import com.openJar.responses.SelPddCidByXzCidResponse;
import com.openJar.responses.SelThirdLevelCidResponse;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.goodsup.pinduoduo.bo.AddPropBO;
import com.shigu.goodsup.pinduoduo.util.XzPddClient;
import com.shigu.goodsup.pinduoduo.vo.ItemColorPropVO;
import com.shigu.goodsup.pinduoduo.vo.PddItemDetailVO;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.SaleProp;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.HtmlImgsLazyLoad;
import com.shigu.tools.XzSdkClient;
import freemarker.template.TemplateException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pdd.beans.GoodsCats;
import pdd.beans.GoodsSpec;
import pdd.beans.LogisticsTemplate;
import pdd.goods.authorization.cats.AuthorizationCatsRequest;
import pdd.goods.authorization.cats.AuthorizationCatsResponse;
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
    @Resource
    private XzPddClient xzPddClient;
    @Resource
    private XzSdkClient xzSdkClient;
    @Resource
    private CdnService cdnService;

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
//        vo.setImgSrcs(cdnItem.getImgUrl().stream().map(s -> ImgUtils.formatImg(s, ImgFormatEnum.GOODS_HEAD_IMAGES)).collect(Collectors.toList()));
        vo.setImgSrcs(cdnItem.getImgUrl());
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

    /**
     * 查询用户授权类目信息
     * cid为空则查最顶级
     */
    public  List<GoodsCats> selAuthorizationCats(Long userId,Long cid) {
        String token = selAccessToken(userId);
        if (token == null) {
            return null;
        }

        AuthorizationCatsRequest request = new AuthorizationCatsRequest();
        request.setParent_cat_id(cid);
        AuthorizationCatsResponse response = xzPddClient.openClient(token).excute(request);
        if (!response.getSuccess()) {
            return null;
        }
        return response.getGoodsCatsList();

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
        SelPddCidByXzCidRequest request = new SelPddCidByXzCidRequest();
        request.setXzCid(cid);

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
     * 0 颜色 1 尺码
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

        SpecGetRequest specGetRequest = new SpecGetRequest();
        specGetRequest.setCat_id(response.getThirdLevelCid());
        SpecGetResponse specGetResponse = xzPddClient.openClient(token).excute(specGetRequest);
        if (!specGetResponse.getSuccess()) {
            return null;
        }

        List<GoodsSpec> goodsSpecList = specGetResponse.getGoodsSpecList();
        Long parentSpecId = null;
        if (bo.getType() == 0) {//0 颜色
            for (GoodsSpec goodsSpec : goodsSpecList){
                if ("颜色".equals(goodsSpec.getParentSpecName())) {
                    parentSpecId = goodsSpec.getParentSpecId();
                    break;
                }
            }
        }else {//1 尺码
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


    }
}
