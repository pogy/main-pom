package com.shigu.seller.actions;

import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.GoatLicense;
import com.opentae.data.mall.beans.GoodsFile;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.GoatLicenseExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.GoatLicenseMapper;
import com.opentae.data.mall.interfaces.GoodsFileMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.buyer.vo.MailBindVO;
import com.shigu.buyer.vo.SafeRzVO;
import com.shigu.buyer.vo.UserInfoVO;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.component.shiro.MemberRealm;
import com.shigu.component.shiro.exceptions.ChangeStoreException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.exceptions.ShopDomainException;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.exceptions.ShowCaseException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.ItemCatService;
import com.shigu.main4.item.services.ItemShowCaseService;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.main4.item.vo.*;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.vo.RealNameApplyInfo;
import com.shigu.main4.ucenter.vo.SafeAbout;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserLicense;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.seller.bo.*;
import com.shigu.seller.exceptions.IndexGoatException;
import com.shigu.seller.exceptions.SendGoodsException;
import com.shigu.seller.services.*;
import com.shigu.seller.vo.*;
import com.shigu.services.DubboAllService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.tb.finder.exceptions.TbItemSynException;
import com.shigu.tb.finder.exceptions.TbOnsaleException;
import com.shigu.tb.finder.services.MainTbOnsaleService;
import com.shigu.tb.finder.vo.PropertyItemVO;
import com.shigu.tb.finder.vo.PropertyValueVO;
import com.shigu.tb.finder.vo.PropsVO;
import com.shigu.tb.finder.vo.TbOnsale;
import com.shigu.tools.DateParseUtil;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.XzSdkClient;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 店铺的控制中心
 * Created by zhaohongbo on 17/3/4.
 */
@Controller
public class ShopAction {
    private static final Logger logger = Logger.getLogger(ShopAction.class);

    @Autowired
    PaySdkClientService paySdkClientService;

    @Autowired
    UserLicenseService userLicenseService;

    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    DubboAllService dubboAllService;

    @Autowired
    ShopsItemService shopsItemService;

    @Autowired
    ItemShowCaseService itemShowCaseService;

    @Autowired
    ItemCatService itemCatService;

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    ShopItemModService shopItemModService;

    @Autowired
    ShopFitmentService shopFitmentService;

    @Autowired
    GoodsSendService goodsSendService;

    @Autowired
    MemberRealm memberRealm;

    @Autowired
    MemberFilter memberFilter;

    @Autowired
    StoreRelationService storeRelationService;

    @Autowired
    ShopLicenseService shopLicenseService;

    @Autowired
    XzSdkClient xzSdkClient;

    @Autowired
    ShopBaseSaveService shopBaseSaveService;

    @Autowired
    ShopIndexDataService shopIndexDataService;

    @Autowired
    UserBaseService userBaseService;

    @Autowired
    OssIO ossIO;

    @Autowired
    SpreadService spreadService;

    @Autowired
    GoatShopService goatShopService;

    @Autowired
    GoodsFileService goodsFileService;


    /**
     * 当前登陆的session
     *
     * @param session
     * @return
     */
    private ShopSession getShopSession(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getLogshop();
    }

    /**
     * 商户中心首页
     *
     * @return
     */
    @RequestMapping("seller/index")
    public String index(Model model) {
        // 分销商广告
        List<ImgBannerVO> imageGoat = spreadService.selImgBanners(SpreadEnum.BACK_SHOP).selReal();
        if (!imageGoat.isEmpty()) {
            ImgBannerVO imgBannerVO = imageGoat.get(0);
            model.addAttribute("imgsrc", imgBannerVO.getImgsrc());
            model.addAttribute("tHref", imgBannerVO.getHref());
        }
        return "seller/memberghs";
    }

    /**
     * 供货商中心,暂时访问老的
     * @return
     */
    @RequestMapping("seller/jsonGhLoadInfoNew")
    @ResponseBody
    public JSONObject jsonGhLoadInfoNew(HttpSession session){
        ShopSession shopSession = getShopSession(session);
        return JSONObject.fromObject(shopIndexDataService.selIndexDataFlow(shopSession.getShopId()));
    }

    /**
     * 走线图
     * @param dayType
     * @param session
     * @return
     */
    @RequestMapping("seller/jsonGhTongjiByDay")
    @ResponseBody
    public JSONObject jsonGhTongjiByDay(Integer dayType,HttpSession session){
        ShopSession shopSession = getShopSession(session);
        return JSONObject.fromObject(shopIndexDataService.selGhTongjiByDay(shopSession.getShopId(),dayType));
    }

    /**
     * 发布宝贝——按淘宝
     *
     * @return
     */
    @RequestMapping("seller/createGoods21init")
    public String createGoods21init(SendTbItemBO get, HttpSession session, Model model) throws UnsupportedEncodingException {
        ShopSession shopSession = getShopSession(session);
        int authstatu = shopBaseService.shopAuthState(shopSession.getShopId());
        try {
            if (authstatu == 0) {//没有授权
                get.setFeedback(1);
            } else if (authstatu == 1) {//授权正常的情况
                get.setFeedback(-1);
                MainTbOnsaleService tbOnsaleService=dubboAllService.getMaintbOnsaleService();
                if(tbOnsaleService==null){
                    throw new TbOnsaleException("dubbo 注入失败");
                }
                if(get.getKeyword()!=null){
                    get.setKeyword(URLDecoder.decode(get.getKeyword(),"utf-8"));
                }
                ShiguPager<TbOnsale> pager = tbOnsaleService.selTbOnsale(shopSession.getShopId(),
                        get.getKeyword(), get.getPageNo(), get.getPageSize());
                if (pager == null) {
                    throw new SendGoodsException("实际调用时授权过期");
                }
                model.addAttribute("pageOption",pager.selPageOption(get.getPageSize()));
                if(pager.getContent()!=null){
                    List<ItemSendVO2> list=new ArrayList<>();
                    for(TbOnsale to:pager.getContent()){
                        list.add(new ItemSendVO2(to));
                    }
                    model.addAttribute("goodslist",list);
                }
            } else if (authstatu == 2) {
                get.setFeedback(2);
                throw new SendGoodsException("授权过期");
            }
        } catch (SendGoodsException e1) {
            get.setFeedback(2);
        } catch (TbOnsaleException e) {
            logger.error("调用淘宝接口异常",e);
            get.setFeedback(2);
        }
        model.addAttribute("get",get);
        return "seller/createGoods21init";
    }

    /**
     * 同步一件宝贝
     * @return
     */
    @RequestMapping("seller/jsonsyntbgoods")
    @ResponseBody
    public JSONObject jsonsyntbgoods(Long numIid,HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        if(numIid==null){
            throw new JsonErrException("参数异常");
        }
        try {
            dubboAllService.getTaobaoSynService().synOneItem(shopSession.getShopId(),numIid,shopSession.getTbNick());
        } catch (TbItemSynException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 选择类目
     * @return
     */
    @RequestMapping("seller/releaseGoodsinit")
    public String releaseGoodsinit(){
        return "seller/releaseGoodsinit";
    }

    /**
     * 手工发布类目,编辑页面
     * @return
     */
    @RequestMapping("seller/releaseGoodsSend")
    public String releaseGoodsSend(@Valid GoodsSendBO bo,BindingResult result,Model model) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        model.addAttribute("category_text",goodsSendService.selCatPath(bo.getCid()));
        PropsVO propsVO=dubboAllService.getTbPropsService().selProps(bo.getCid());
        //转化成老的pageProps
        List<FormAttrVO> formAttribute=new ArrayList<>();
        List<SKUVO> skuAttribute=new ArrayList<>();
        if(propsVO!=null){
            List<PropertyItemVO> saleProps=propsVO.getSaleProps();
            PropertyItemVO colorProps=propsVO.getColor();
            if(colorProps!=null){
                skuAttribute.add(goodsSendService.parseTaobaoSaleVO(colorProps,1));
            }
            if(saleProps!=null){
                for(PropertyItemVO piv:saleProps){
                    skuAttribute.add(goodsSendService.parseTaobaoSaleVO(piv,0));
                }
            }
            List<PropertyItemVO> simpleProps=propsVO.getProperties();

            if(propsVO.getPingpai()!=null){
                PropertyValueVO pvv=new PropertyValueVO();
                pvv.setVid(-2L);
                pvv.setName("其它/other");
                propsVO.getPingpai().getValues().add(0,pvv);
                simpleProps.add(0,propsVO.getPingpai());
            }
            if(propsVO.getHuohao()!=null){
                simpleProps.add(0,propsVO.getHuohao());
            }
            if(simpleProps!=null){
                for(PropertyItemVO piv:simpleProps){
                    formAttribute.add(goodsSendService.parseTaobaoItemPropVO(piv));
                }
            }
        }
        //店内类目暂时不要
        model.addAttribute("formAttribute",formAttribute);
        model.addAttribute("skuAttribute",skuAttribute);
        model.addAttribute("get",bo);
        return "seller/releaseGoodsSend";
    }

    /**
     * 上传单张图片到淘宝
     * @param file
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("seller/jsontaobao_fileUpload")
    @ResponseBody
    public JSONObject jsontaobao_fileUpload(@RequestParam(value = "multimagefile", required = false) MultipartFile file,HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        String url="";
        try {
            url=ossIO.uploadFile(file.getBytes(),"mall/file/item/"+shopSession.getShopId()+"/"+System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload("item/"+shopSession.getShopId()+"/"+System.currentTimeMillis() + ".jpg",file.getBytes());
        } catch (IOException e) {
            throw new JsonErrException("").addErrMap("err","图片数据读取失败");
        }
        return JsonResponseUtil.success().element("status",1).element("type","ajax").element("url",url);
    }

    /**
     * 编辑页,详情上传图片
     * @return
     */
    @RequestMapping("seller/jsonuoloadImgFitment")
    public void jsonuoloadImgFitment(@RequestParam(value = "Filedata", required = false) MultipartFile file, HttpServletResponse response, HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        JSONObject result=new JSONObject();
        String url="";
        try {
            url=ossIO.uploadFile(file.getBytes(),"mall/file/item/"+shopSession.getShopId()+"/"+System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload("item/"+shopSession.getShopId()+"/"+System.currentTimeMillis() + ".jpg",file.getBytes());
            result.element("imgUrl",url);
        } catch (IOException e) {
//            throw new JsonErrException("").addErrMap("err","图片数据读取失败");
            result.element("error","图片数据读取失败");
        }
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().print(result);
        } catch (IOException var3) {
            logger.error("response打印json异常");
        }
    }

    /**
     * 查询子类目
     * @param cid
     * @return
     */
    @RequestMapping("seller/jsonSelSubCat")
    @ResponseBody
    public JSONObject jsonSelSubCat(Long cid){
        List<TbCat> cats=itemCatService.subCats(cid);
        return JsonResponseUtil.success().element("rows", JSONArray.fromObject(cats));
    }
    /**
     * 发页商品
     * @return
     */
    @RequestMapping("seller/jsongoods_send")
    @ResponseBody
    public JSONObject jsongoods_send(@Valid GoodsInfoBO bo,BindingResult result, HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        Long itemId;
        //包装bo
        try {
            SynItem synItem=bo.getOffer().parseToSynItem();
            synItem.setShopId(shopSession.getShopId());
            synItem.setPropsName(goodsSendService.parsePropName(synItem.getCid(),synItem.getProps(),synItem.getInputStr(),
                    synItem.getInputPids(),synItem.getPropertyAlias()));
            synItem.setMarketId(shopSession.getMarketId());
            synItem.setFloorId(shopSession.getFloorId());
            synItem.setWebSite(shopSession.getWebSite());
            synItem.setItemFrom(ItemFrom.MEMBER);
            itemId=itemAddOrUpdateService.userAddItem(synItem);
            //保存上传记录
            EverUsedCatForAdd usedCat=new EverUsedCatForAdd();
            usedCat.setCid(synItem.getCid());
            try {
                usedCat.setShowName(goodsSendService.selCatPath(synItem.getCid()));
                usedCat.setAllcids(goodsSendService.selCatIds(synItem.getCid()));
                usedCat.setCname(goodsSendService.selCnameById(synItem.getCid()));
                itemCatService.saveEverUsedCat(shopSession.getShopId(),usedCat);
            } catch (Main4Exception e) {
                logger.error("得到类目串失败",e);
            }
        } catch (ItemModifyException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success().element("goodsId",itemId).element("webSite",shopSession.getWebSite());
    }
    /**
     * 出售中的宝贝
     *
     * @return
     */
    @RequestMapping("seller/storeGoodsList21init")
    public String storeGoodsList21init(OnsaleItemBO bo, HttpSession session,Model model) throws UnsupportedEncodingException {
        ShopSession shopSession = getShopSession(session);

        model.addAttribute("goods_counts",selOnsaleCountByShopId(shopSession.getShopId()));
        if(bo.getKeyword()!=null){
            bo.setKeyword(URLDecoder.decode(bo.getKeyword(),"utf-8"));
        }
        //商品列表数据  String keyword,String goodsNo,Long numIid, Long shopId, int pageNo, int pageSize
        try {
            ShiguPager<OnsaleItem> pager=shopsItemService.selOnsaleItems(bo.getKeyword(),bo.getGoodsNo(),bo.getGoodsNumIid()
                    ,shopSession.getShopId(),bo.getPage(),bo.getPageSize());
            model.addAttribute("pageOption",pager.selPageOption(bo.getPageSize()));
            List<OnsaleItem> list=pager.getContent();
            List<Long> goodIds = BeanMapper.getFieldList(list, "itemId", Long.class);
            Map<Long, GoodsFile> goodsIdFileMap = BeanMapper.list2Map(goodsFileService.selGoodsFileInfo(goodIds), "goodsId", Long.class);
            List<OnsaleItemVO> goodsList=new ArrayList<>();
            for(OnsaleItem oi:list){
                OnsaleItemVO vo = new OnsaleItemVO(oi);
                GoodsFile fileInfo = goodsIdFileMap.get(vo.getId());
                vo.setSetCorrelateType(fileInfo==null?1:2);
                vo.setBigPicType(fileInfo==null?2:fileInfo.getNeedPwd()?2:1);
                if (fileInfo != null) {
                    vo.setLinkHref(fileInfo.getFileKey());
                    vo.setLinkHrefPassword(fileInfo.getPasswd());
                }
                goodsList.add(vo);
            }
            model.addAttribute("goodslist",goodsList);
        } catch (ItemException e) {
            logger.error("拉取店铺出售中失败,shopId="+shopSession.getShopId(),e);
        }
        model.addAttribute("get",bo);
        return "seller/storeGoodsList21init";
    }

    /**
     * 查出售中的商品上面的统计数据
     * @param shopId
     * @return
     */
    private OnsaleCountsVO selOnsaleCountByShopId(Long shopId){
        OnsaleCountsVO onsaleCountsVO=new OnsaleCountsVO();
        //统计数据
        try {
            ItemCount itemCount=shopsItemService.selItemCount(shopId);
            onsaleCountsVO.setSale(itemCount.getOnsale());
            onsaleCountsVO.setStore(itemCount.getInstock());
            onsaleCountsVO.setTj(itemCount.getShowcase());
        } catch (ItemException e) {
//            e.printStackTrace();
            onsaleCountsVO.setSale(0);
            onsaleCountsVO.setTj(0);
            onsaleCountsVO.setStore(0);
        }
        return onsaleCountsVO;
    }
    /**
     * 修改商品标题与货号
     * @param bo
     * @return
     */
    @RequestMapping("seller/jsonupdategoodsinfo")
    @ResponseBody
    public JSONObject jsonupdategoodsinfo(@Valid ModifyGoodsinfoBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        SynItem synItem=new SynItem();
        synItem.setGoodsId(bo.getGoodsId());
        synItem.setTitle(bo.getTitle());
        synItem.setShopId(shopSession.getShopId());
        synItem.setWebSite(shopSession.getWebSite());

//        synItem.setNumIid(40566999083L);
        synItem.setGoodsNo(bo.getGoodsNo());
        try {
            itemAddOrUpdateService.userUpdateItem(synItem);
        } catch (ItemModifyException e) {
            logger.error("更新商品失败",e);
            throw new JsonErrException("更新商品失败");
        }
        return JsonResponseUtil.success();
    }

    /**
     * 商品推荐
     * @return
     */
    @RequestMapping("seller/jsonshowcaseRecommends")
    @ResponseBody
    public JSONObject jsonshowcaseRecommends(@Valid RecommendsBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        List<Long> goodsIds=new ArrayList<>();
        String[] idsarr=bo.getGoodsIds().split(",");
        for(String id:idsarr){
            goodsIds.add(Long.valueOf(id));
        }
        try {
            itemShowCaseService.modifyShowcase(shopSession.getShopId(),shopSession.getWebSite(),goodsIds,bo.getIsShowcase());
        } catch (ShowCaseException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 修改商品价格
     * @return
     */
    @RequestMapping("seller/jsonupdategoodsprice")
    @ResponseBody
    public JSONObject jsonupdategoodsprice(@Valid ModifyPriceBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        SynItem synItem=new SynItem();
        synItem.setGoodsId(bo.getGoodsId());
        synItem.setShopId(shopSession.getShopId());
        if(bo.getType() == 1){
            synItem.setPriceString(bo.getPrice());
        }else{
            synItem.setPiPriceString(bo.getPrice());
        }
        synItem.setWebSite(shopSession.getWebSite());
        try {
            itemAddOrUpdateService.userUpdateItem(synItem);
        } catch (ItemModifyException e) {
            logger.error("更新商品失败",e);
            throw new JsonErrException("更新商品失败");
        }
        return JsonResponseUtil.success();
    }

    /**
     * 商品下架
     * @param goodsIds
     * @return
     */
    @RequestMapping("seller/jsonGoodsDown")
    @ResponseBody
    public JSONObject jsonGoodsDown(String goodsIds,HttpSession session){
        ShopSession shopSession = getShopSession(session);
        shopItemModService.downItems(shopSession.getShopId(),goodsIds,shopSession.getWebSite());
        return JsonResponseUtil.success().element("ok","下架成功").element("success",true);
    }

    /**
     * 推荐的宝贝
     * @return
     */
    @RequestMapping("seller/storeRecommendListinit")
    public String storeRecommendListinit(OnsaleItemBO bo, HttpSession session,Model model){
        ShopSession shopSession = getShopSession(session);
        //统计数据
        model.addAttribute("goods_counts",selOnsaleCountByShopId(shopSession.getShopId()));
        try {
            ShiguPager<ShowCaseItem> pager=itemShowCaseService.selShowCases(bo.getKeyword(),bo.getGoodsNo(),bo.getGoodsNumIid()
                    ,shopSession.getShopId(),bo.getPage(),bo.getPageSize());
            model.addAttribute("pageOption",pager.selPageOption(bo.getPageSize()));
            List<ShowCaseItem> list=pager.getContent();
            List<OnsaleItemVO> goodsList=new ArrayList<>();
            for(ShowCaseItem oi:list){
                goodsList.add(new OnsaleItemVO(oi));
            }
            model.addAttribute("goodslist",goodsList);
        } catch (ItemException e) {
            logger.error("拉取店铺出售中失败,shopId="+shopSession.getShopId(),e);
        }
        model.addAttribute("get",bo);
        return "seller/storeRecommendListinit";
    }
    /**
     * 仓库中的宝贝
     *
     * @return
     */
    @RequestMapping("seller/storeGoodsListinit")
    public String storeGoodsListinit(InstockItemBO bo, HttpSession session, Model model) throws ItemException {
        ShopSession shopSession = getShopSession(session);
        ShiguPager<InstockItem> pager=shopsItemService.selInstockItems(bo.getKeyword(),bo.getGoodsNo(),
                bo.getGoodsNumIid(),shopSession.getShopId(),bo.getPage(),bo.getPageSize());
        List<InstockItem> list=pager.getContent();
        List<InstockItemVO> goodslist=new ArrayList<>();
        if(list!=null){
            for(InstockItem instockItem:list){
                goodslist.add(new InstockItemVO(instockItem));
            }
        }
        model.addAttribute("goodslist",goodslist);
        model.addAttribute("pageOption",pager.selPageOption(bo.getPageSize()));
        model.addAttribute("get",bo);
        return "seller/storeGoodsListinit";
    }

    /**
     * 商品上架
     * @return
     */
    @RequestMapping("seller/jsonGoodsUp")
    @ResponseBody
    public JSONObject jsonGoodsUp(@Valid GoodsUpBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        shopItemModService.upItems(shopSession.getShopId(),bo.getGoodsIds(),shopSession.getWebSite());
        return JsonResponseUtil.success().element("ok","上架成功").element("success",true);
    }

    /**
     * 删除商品
     * @param bo
     * @param result
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("seller/jsonSoldoutGoodsDelete")
    @ResponseBody
    public JSONObject jsonSoldoutGoodsDelete(@Valid DeleteItemBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        shopItemModService.delInstockItems(shopSession.getShopId(),bo.getIds(),shopSession.getWebSite());
        return JsonResponseUtil.success().element("ok","删除成功").element("success",true);
    }
    /**
     * 修复宝贝
     *
     * @return
     */
    @RequestMapping("seller/xiufuGoods21init")
    public String xiufuGoods21init(XiufuGoodsBO bo,HttpSession session,Model model) throws ItemException {
        ShopSession shopSession = getShopSession(session);
        ShiguPager<XiufuItem> pager=shopsItemService.selXiufuItem(bo.getKeyword(),bo.getGoodsId()
                ,shopSession.getShopId(),bo.getPage(),bo.getPageSize());

        List<XiufuItem> list=pager.getContent();
        List<XiufuItemVO> goodsList=new ArrayList<>();
        for(XiufuItem oi:list){
            goodsList.add(new XiufuItemVO(oi));
        }
        model.addAttribute("goodslist",goodsList);
        model.addAttribute("pageOption",pager.selPageOption(bo.getPageSize()));
        model.addAttribute("get",bo);
        return "seller/xiufuGoods21init";
    }

    /**
     * 修复-同步一件商品
     * @return
     */
    @RequestMapping("seller/jsonsyngoodsupdate")
    @ResponseBody
    public JSONObject jsonsyngoodsupdate(String goodsId,HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        if(StringUtils.isEmpty(goodsId)){
            throw new JsonErrException("请求数据有误");
        }
        String [] goodIds = goodsId.split(",");
        for (int i = 0; i < goodIds.length; i++) {
            Long numIid = shopItemModService.selNumiidByGoodsId(Long.valueOf(goodIds[i]), shopSession.getWebSite());
            if (numIid == null) {
                throw new JsonErrException("商品不存在numIid,可能不是淘宝商品");
            }
            try {
                dubboAllService.getTaobaoSynService().synOneItem(shopSession.getShopId(), numIid, shopSession.getTbNick());
            } catch (TbItemSynException e) {
                throw new JsonErrException(e.getMessage());
            }
        }
        return JsonResponseUtil.success();
    }
    /**
     * 修复店内类目
     *
     * @return
     */
    @RequestMapping("seller/xiufuStorecat21init")
    public String xiufuStorecat21init() {
        return "seller/xiufuStorecat21init";
    }

    /**
     * 同步店内类目
     * @return
     */
    @RequestMapping("seller/jsonsynstorecat")
    @ResponseBody
    public JSONObject jsonsynstorecat(HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        try {
            dubboAllService.getTaobaoSynService().repairStorecat(shopSession.getShopId(),shopSession.getTbNick());
        } catch (Exception e) {// TODO: 17/3/15 等开发完,把真正的exception放进去
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 修复宝贝类目
     * @return
     */
    @RequestMapping("seller/xiufuGoodscat21init")
    public String xiufuGoodscat21init(){
        return "seller/xiufuGoodscat21init";
    }

    /**
     * 修复宝贝类目
     * @return
     */
    @RequestMapping("seller/jsonsyngoodscat")
    @ResponseBody
    public JSONObject jsonsyngoodscat(HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        try {
            dubboAllService.getTaobaoSynService().repairGoodscat(shopSession.getShopId(),shopSession.getTbNick());
        } catch (Exception e) {// TODO: 17/3/15 等开发完,把真正的exception放进去
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 同步店内类目
     * @return
     */
    @RequestMapping("seller/jsonsynAlltbgoods")
    @ResponseBody
    public JSONObject jsonsynAlltbgoods(HttpSession session) throws JsonErrException {
        ShopSession shopSession = getShopSession(session);
        try {
            dubboAllService.getTaobaoSynService().repairStorecat(shopSession.getShopId(),shopSession.getTbNick());
            dubboAllService.getTaobaoSynService().repairGoodscat(shopSession.getShopId(),shopSession.getTbNick());
        } catch (Exception e) {// TODO: 17/3/15 等开发完,把真正的exception放进去
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 批量修改货号
     *
     * @return
     */
    @RequestMapping("seller/storeGoodsNoListinit")
    public String storeGoodsNoListinit(MoreModifyBO bo,HttpSession session,Model model) throws ItemException {
        ShopSession shopSession = getShopSession(session);
        //查总量
        model.addAttribute("inSaleCount",selOnsaleCountByShopId(shopSession.getShopId()).getSale());
        //查单页
        ShiguPager<OnsaleItem> pager=shopsItemService.selOnsaleItems(null,null,null
                ,shopSession.getShopId(),bo.getPageNo(),bo.getPageSize());
        model.addAttribute("pageOption",pager.selPageOption(bo.getPageSize()));
        List<OnsaleItem> list=pager.getContent();
        List<MoreModifyItemVO> volist=new ArrayList<>();
        for(OnsaleItem oi:list){
            MoreModifyItemVO mmi=BeanMapper.map(oi,MoreModifyItemVO.class);
            mmi.setCreated(oi.getCreated());
            volist.add(mmi);
        }
        model.addAttribute("dataList", volist);
        model.addAttribute("webSite",shopSession.getWebSite());
        return "seller/storeGoodsNoListinit";
    }

    /**
     * 批量修改货号提交
     * @return
     */
    @RequestMapping("seller/jsonupdateGoodsNoPrice")
    @ResponseBody
    public JSONObject jsonupdateGoodsNoPrice(@Valid MoreModifyUpdateBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        try {
            shopItemModService.moreModify(bo.parseSynItems(shopSession.getShopId(),shopSession.getWebSite()));
        } catch (ItemModifyException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success().element("OK","OK");
    }

    /**
     * 店铺装修
     *
     * @return
     */
    @RequestMapping("seller/fitmentStorefitmentStore")
    public String fitmentStorefitmentStore() {
        return "seller/fitmentStorefitmentStore";
    }

    /**
     * 切换档口号
     * @return
     */
    @RequestMapping("seller/changeStoreNum")
    public String changeStoreNum(Long storeNumId) throws ChangeStoreException {
        memberRealm.changeShop(storeNumId);
        return "redirect:"+memberFilter.getSuccessUrl();
    }

    /**
     * 二级域名设置
     *
     * @return
     */
    @RequestMapping("seller/shiguStoreerjiyuming")
    public String shiguStoreerjiyuming(String domain,HttpSession session,Model model) {
        ShopSession shopSession = getShopSession(session);
        if(domain==null){
            model.addAttribute("domain",shopBaseService.selDomain(shopSession.getShopId()));
        }else{
            try {
                shopBaseService.updateDomain(shopSession.getShopId(),domain);
            } catch (ShopDomainException e) {
                model.addAttribute("msg",e.getMsg());
            }
            model.addAttribute("domain",domain);
        }
        return "seller/shiguStoreerjiyuming";
    }

    /**
     * 授权管理
     *
     * @return
     */
    @RequestMapping("seller/ghTongbu")
    public String ghTongbu() {
        return "seller/ghTongbu";
    }

    /**
     * 店铺基本信息修改
     *
     * @return
     */
    @RequestMapping("seller/shiguStorebasicStore")
    public String shiguStorebasicStore(@Valid ShopBaseBO bo,BindingResult result, HttpSession session, Model model) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        ShopSession shopSession = getShopSession(session);
        if(bo!=null){
            shopBaseSaveService.saveShopBase(shopSession.getShopId(),bo);
        }
        ShopBase base=shopBaseService.shopBaseForUpdate(shopSession.getShopId());
        StoreRelation relation=storeRelationService.selRelationById(shopSession.getShopId());
        List<ShopBaseVO> shopinfo=new ArrayList<>();
        shopinfo.add(new ShopBaseVO("档口号","storeNum",true,relation.getStoreNum()));
        shopinfo.add(new ShopBaseVO("店铺名","storeName",true,base.getShopName()));
        shopinfo.add(new ShopBaseVO("小标题","smallTitle",false,base.getSystemRecommon()));
        shopinfo.add(new ShopBaseVO("联系手机号","telephone",false,relation.getTelephone()));
        shopinfo.add(new ShopBaseVO("旺旺号","imWw",false,relation.getImWw()));
        shopinfo.add(new ShopBaseVO("QQ号码","imQq",false,relation.getImQq()));
        shopinfo.add(new ShopBaseVO("微信号","imWx",false,relation.getImWx()));
        shopinfo.add(new ShopBaseVO("数据包地址","packetUrl",false,base.getDataPackageUrl()));

        model.addAttribute("shopinfo",shopinfo);

        ShopTypeSetVO shopTypeSetVO=new ShopTypeSetVO();
        shopTypeSetVO.setMainBus(base.getMainBus());
        List<ShiguTags> sgtags=shopLicenseService.selTagLicenseByShopId(shopSession.getShopId());
        List<ShopTagVO> tags=new ArrayList<>();
        tags.add(new ShopTagVO("可退","1"));
        tags.add(new ShopTagVO("可换","2"));
//      tags.add(new ShopTagVO("可退可换","1,2"));
        List<String> servers=new ArrayList<>();
        for(ShiguTags st:sgtags){
            servers.add(st.getValue());
        }
        shopTypeSetVO.setServer_level(tags);
        shopTypeSetVO.setServers(servers);
        shopTypeSetVO.setBusiness_type(xzSdkClient.getXzMainBus().split(","));
        model.addAttribute("typeset",shopTypeSetVO);
        return "seller/shiguStorebasicStore";
    }

    /**
     * 全店同步
     * @param shopId
     * @return
     */
    @RequestMapping(value = "/seller/jsonSynAllGoods" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject synWholeShop(Long shopId, HttpSession session){
        ShopSession shopSession = getShopSession(session);
        try{
            dubboAllService.getTaobaoSynService().synOneShop(shopId,shopSession.getTbNick());
            dubboAllService.getTaobaoTmcService().addToTmc(shopSession.getTbNick());
            return JSONObject.fromObject(JsonResponseUtil.success());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSONObject.fromObject("{'result':'error','msg':'系统错误'}");
    }

    /**
     * 充值
     * @return
     */
    @RequestMapping("seller/iwantToRechargein5")
    public String iwantToRechargein5(HttpSession session,Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempcode = paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode", tempcode);
        return "seller/iwantToRechargein5";
    }

    /**
     * 提现
     * @return
     */
    @RequestMapping("seller/withdraw5Apply")
    public String withdraw5Apply(HttpSession session,Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempcode = paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode", tempcode);
        return "seller/withdraw5Apply";
    }

    /**
     * 安全设置首页
     * @return
     */
    @RequestMapping("seller/safeindex")
    public String safeindex(HttpSession session,Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SafeAbout safeAbout = userLicenseService.selUserLicenses(ps.getUserId());
        if (safeAbout != null) {
            model.addAttribute("safe_level", safeAbout.getScore());
            List<UserLicense> licenses = safeAbout.getLicenses();
            if (licenses != null) {
                for (UserLicense ul : licenses) {
                    if (ul.getType().equals(MemberLicenseType.PHONE_BIND)) {
                        model.addAttribute("info_mobile", true);
                        model.addAttribute("text_mobile", ul.getContext());
                    } else if (ul.getType().equals(MemberLicenseType.PASSWORD_SAFE)) {
                        Integer pwdScore = Integer.valueOf(ul.getContext());
                        model.addAttribute("info_pwd", pwdScore >= 75 ? "high" : pwdScore >= 50 ? "middle" : "low");
                    } else if (ul.getType().equals(MemberLicenseType.EMAIL)) {
                        model.addAttribute("info_email", true);
                    } else if (ul.getType().equals(MemberLicenseType.REAL_NAME)) {
                        model.addAttribute("info_card", true);
                    }
                }
            }
        } else {
            model.addAttribute("safe_level", 0);
        }
        return "seller/safeindex";
    }

    /**
     * 个人设置
     * @return
     */
    @RequestMapping("seller/sysSetsindex")
    public String sysSetsindex(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        UserInfo userInfo = userBaseService.selUserInfo(ps.getUserId());
        UserInfoVO userInfoVO= com.shigu.session.main4.tool.BeanMapper.map(userInfo, UserInfoVO.class);
        userInfoVO.setUserId(ps.getUserId());
        model.addAttribute("userInfo", userInfoVO);
        return "seller/sysSetsindex";
    }

    /**
     * 上传实名认证
     * @return
     */
    @RequestMapping("seller/saferz")
    public String saferz(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //查出权益
        SafeRzVO safeRzVO=new SafeRzVO();
        SafeAbout safeAbout=userLicenseService.selUserLicenses(ps.getUserId());
        if(safeAbout!=null){
            List<UserLicense> licenses=safeAbout.getLicenses();
            if(licenses!=null){
                for(UserLicense ul:licenses){
                    if(ul.getType().equals(MemberLicenseType.REAL_NAME)){
                        String context=ul.getContext();
                        String[] contextarr=context.split(";");
                        if(contextarr.length<2){
                            break;
                        }
                        safeRzVO.setCardnum(contextarr[0]);
                        safeRzVO.setImgurl1(contextarr[1]);
                    }
                }
            }
        }
        //查一下最后一次实名认证的情况
        RealNameApplyInfo info=userLicenseService.lastRealNameApply(ps.getUserId());
        if(info!=null){
            String msg="您在"+ DateParseUtil.parseDate("yyyy-MM-dd",info.getApplyTime())+"的申请 ";
            if(info.getApplyStatus()==0){
                msg+="还在审核中";
            }else if(info.getApplyStatus()==-1){
                msg+="不通过 原因:"+info.getReason();
            }else{
                msg+="已通过";
            }
            safeRzVO.setMsg(msg);
        }
        model.addAttribute("identity",safeRzVO);
        return "seller/saferz";
    }


    /**
     * 修改密码
     * @return
     */
    @RequestMapping("seller/safexgmm")
    public String safexgmm(String code,HttpSession session,Model model){
        //如果code和手机忘记密码验证码一样,则不需要原密码
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        PhoneVerify phoneCode= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
        if(checkFromForget(ps.getUserId(),code,phoneCode)){
            model.addAttribute("fromForget",phoneCode);
        }
        return "seller/safexgmm";
    }
    /**
     * 验证是否忘记密码来的
     * @param code
     * @param phoneVerify
     * @return
     */
    private boolean checkFromForget(Long userId,String code,PhoneVerify phoneVerify){
        if(code!=null){
            //手机验证码一样,用户ID一样
            if(phoneVerify!=null&&phoneVerify.getVerify().equals(code)&&userId.equals(phoneVerify.getUserId())){
                return true;
            }
        }
        return false;
    }

    /**
     * 邮箱绑定
     * @return
     */
    @RequestMapping("seller/safeszyx")
    public String safeszyx(HttpSession session,Model model){
        //查出旧的邮箱
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SafeAbout safeAbout=userLicenseService.selUserLicenses(ps.getUserId());
        if(safeAbout!=null){
            List<UserLicense> licenses=safeAbout.getLicenses();
            if(licenses!=null){
                for(UserLicense ul:licenses){
                    if(ul.getType().equals(MemberLicenseType.EMAIL)){
                        MailBindVO mail=new MailBindVO();
                        String context=ul.getContext();
                        mail.setEmail(context);
                        mail.setMsg("认证成功");
                        model.addAttribute("mail",mail);
                    }
                }
            }
        }
        return "seller/safeszyx";
    }

    /**
     * 邮箱认证回调
     * @return
     */
    @RequestMapping("seller/safeemail")
    public String safeemail(String p,HttpSession session,Model model) throws UnsupportedEncodingException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (p.contains("%"))
            p= URLDecoder.decode(p,"utf-8");
        p=Opt3Des.decryptPlainData(p);
        JSONObject json = JSONObject.fromObject(p);
        Long userId = json.getLong("userId");
        MailBindVO mail=new MailBindVO();
        mail.setEmail(json.getString("email"));
        if(ps.getUserId().equals(userId)){
            try {
                userLicenseService.bindEmail(ps.getUserId(),json.getString("email"));
                mail.setMsg("认证成功");
            } catch (Main4Exception e) {
                mail.setMsg(e.getMessage());
            }
        }else{
            mail.setMsg("当前登陆账号与认证发起账号不符合,请切换账号,重新激活");
        }
        model.addAttribute("mail",mail);
        return "seller/safeszyx";
    }

    /**
     * 首页广告管理
     * @return
     */
    @RequestMapping("seller/promotion")
    public String indexGgChange(HttpSession session, Model model) throws IndexGoatException, GoatException {
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shopSession = personalSession.getLogshop();
        Long shopId = shopSession.getShopId();
        String webSite = shopSession.getWebSite();
        List<IndexGoatVO> myIndexTerms = goatShopService.selGoatByShopId(webSite, shopId, GoatType.ItemGoat);
        //分为开始与没开始两种
        List<GoatListVO> inForceList=new ArrayList<>();
        List<GoatListVO> willInForceList=new ArrayList<>();
        Map<String,GoatListVO> map=new HashMap<>();
        for(IndexGoatVO igv:myIndexTerms){
            String key;
            if(igv.getHadStart()){
                key=igv.getCode()+"_ol";
            }else{
                key=igv.getCode()+"_unol";
            }
            GoatListVO glv=map.get(key);
            if(glv == null){
                glv=new GoatListVO();
                glv.setCode(igv.getCode());
                glv.setPosList(new ArrayList<IndexGoatVO>());
                map.put(key,glv);
                if(igv.getHadStart()){
                    inForceList.add(glv);
                }else{
                    willInForceList.add(glv);
                }
            }
            glv.getPosList().add(igv);
        }
        model.addAttribute("inForceList", inForceList);
        model.addAttribute("willInForceList",willInForceList);
        return "seller/promotion";
    }

    /**
     * 首页广告管理，更换广告接口
     * @return
     */
    @RequestMapping("seller/setNewIndexGoodsData")
    @ResponseBody
    public JSONObject setNewIndexGoodsData(String id, Long goodsId, HttpSession session) throws JsonErrException {
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shopSession = personalSession.getLogshop();
        String webSite = shopSession.getWebSite();
        Long shopId = shopSession.getShopId();
        GoatLicense license=goatShopService.getGoatLicenseByCodeId(id,shopId);
        GoatShopService.GoatLicenseStatu statu = goatShopService.getGoatLicenseStatu(license);
        ShiguGoodsTiny good = goatShopService.getShopGoodsInfo(webSite, goodsId, shopId);
        switch (statu) {
            case PUBLISH: {
                goatShopService.publishGoatUpdate(license,personalSession.getUserId(), good);
                break;
            }
            case PREPUBLISH: {
                goatShopService.prepublishGoatUpdate(license,personalSession.getUserId(), good);
                break;
            }
        }
        return JsonResponseUtil.success().element("good", good);

    }

}
