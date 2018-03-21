package com.shigu.main4.item.processes;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.openJar.requests.imgs.UptoItemImgRequest;
import com.openJar.requests.imgs.UptoPropImgRequest;
import com.openJar.responses.imgs.UptoItemImgResponse;
import com.openJar.responses.imgs.UptoPropImgResponse;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.bo.PropImgBO;
import com.shigu.main4.item.bo.SubmitedPropsBO;
import com.shigu.main4.item.bo.UptoTbBO;
import com.shigu.main4.item.exceptions.TbApiException;
import com.shigu.main4.item.exceptions.TbException;
import com.shigu.main4.item.services.utils.PropsService;
import com.shigu.main4.item.services.utils.TaobaoUtil;
import com.shigu.main4.item.tools.NumberValidationUtils;
import com.shigu.main4.item.tools.TimeUtil;
import com.shigu.main4.item.vo.ItemVO;
import com.shigu.main4.item.vo.PropsVO;
import com.shigu.main4.item.vo.SessionVO;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.PropImg;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.ItemAddRequest;
import com.taobao.api.response.ItemAddResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taobaoAddItemProcess")
public class TaobaoAddItemProcessImpl implements TaobaoAddItemProcess {

    private static final Logger logger = LoggerFactory.getLogger(TaobaoAddItemProcessImpl.class);

    @Value("${xz_appkey}")
    private String OPEN_CLIENT_APPKEY;

    @Value("${xz_secret}")
    private String OPEN_CLIENT_SECRET;

    @Value("${xz_type}")
    private String OPEN_CLIENT_SERVERTYPE;

    @Value("${taobao.app.key}")
    private String APPKEY;

    @Value("${taobao.app.secret}")
    private String SECRET;

    @Value("${taobao.app.server.url}")
    private String TOP_SERVER_URL;

    @Autowired
    private TaobaoUtil taobaoUtil;

    @Autowired
    private PropsService propsService;

    @Override
    public ItemVO addItemBase(UptoTbBO bo, SubmitedPropsBO spv, String[] sellerCids, SessionVO session) throws TbApiException {
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL, APPKEY, SECRET);
        ItemAddRequest req = new ItemAddRequest();
        req.setInputStr(spv.getInputStr());
        req.setInputPids(spv.getInputPids());
        req.setNum(bo.getNum());
        req.setPrice(bo.getPrice());
        req.setType("fixed");
        req.setStuffStatus(bo.getStuffStatus());
        req.setTitle(bo.getTitle());
        req.setDesc(cleanPcContent(bo.getPcContent()));
        req.setLocationState(bo.getProv());
        req.setLocationCity(bo.getCity());
//        if("onsale_clock".equals(bo.getApprove_status())){//定时上架,弄成仓库
//            req.setApproveStatus("instock");
//        }else{
//            req.setApproveStatus(bo.getApprove_status());
//        }
        req.setApproveStatus(bo.getApprove_status());
        req.setCid(bo.getCid());
        req.setProps(spv.getProps());
        req.setHasInvoice(bo.getHas_invoice());
        req.setHasWarranty(bo.getHas_warranty());
        if(sellerCids!=null){
            String sellerCidStr="";
            for(String s:sellerCids){
                sellerCidStr+=s+",";
            }
            if(sellerCidStr.endsWith(",")){
                sellerCidStr=sellerCidStr.substring(0,sellerCidStr.length()-1);
            }
            req.setSellerCids(sellerCidStr);
        }
        //如果没有postageId作为包邮处理
        if(bo.getPostage_id()==null){
            req.setFreightPayer("seller");
        }else{
            req.setFreightPayer("buyer");
            req.setPostageId(bo.getPostage_id());
        }
        //如果有设定时间
        if("onsale_clock".equals(bo.getApprove_status())){
            //如果_date为空,取现在
            if(bo.getDate()==null){
                bo.setDate(TimeUtil.getNowTime("yyyy-MM-dd"));
            }
            //如果_hour为空,取现在
            if(bo.getHour()==null){
                bo.setHour(TimeUtil.getNowTime("HH"));
            }
            //如果_date为空,取现在
            if(bo.getMinute()==null){
                bo.setMinute(TimeUtil.getNowTime("mm"));
            }
            req.setListTime(StringUtils.parseDateTime(bo.getDate()+" "+bo.getHour()+":"+bo.getMinute()+":00"));
        }
        req.setValidThru(7L);
        req.setPropertyAlias(spv.getPropertyAlias());
        req.setSkuProperties(spv.getSkuProperties());
        req.setSkuQuantities(spv.getSkuQuantities());
        req.setSkuPrices(spv.getSkuPrices());
        req.setSkuOuterIds(spv.getSkuOuterIds());
        req.setLang("zh_CN");
        req.setOuterId(bo.getOuterId());
        req.setIsTaobao(true);
        req.setIsEx(true);
        req.setIs3D(true);
        req.setSellPromise(bo.getSell_promise());
//        req.setIsXinpin(true);
        req.setSubStock(bo.getSub_stock());
        if(bo.getItem_size()!=null&& NumberValidationUtils.isRealNumber(bo.getItem_size())){
            req.setItemSize("bulk:"+bo.getItem_size());
        }else{
            req.setItemSize(bo.getItem_size());
        }
        req.setItemWeight(bo.getItem_weight());
        req.setSellPoint(bo.getSellPoint());
        req.setInputCustomCpv(spv.getInputCustomCpv());
        ItemAddResponse rsp = null;
        try {
            rsp = client.execute(req, session.getSession());
        } catch (ApiException e) {
            throw new TbApiException(e.getMessage());
        }
        if(!rsp.isSuccess()){
            logger.error("addItemError!!!!!"+rsp.getBody());
            throw new TbApiException(rsp.getSubMsg());
        }
        return BeanMapper.map(rsp.getItem(),ItemVO.class);
    }

    private String cleanPcContent(String content){
        if (StringUtils.isEmpty(content)) {
            return content;
        }
        Document dom= Jsoup.parse(content);
        Elements tds=dom.select("td");
        for(Element td:tds){
            if(td.hasAttr("background")){
                td.removeAttr("background");
            }
        }
        return dom.html();
    }

    @Override
    public String addOneImg(Long numIid, String url, Long position, boolean major, SessionVO session) {
        OpenClient c=new PcOpenClient(OPEN_CLIENT_APPKEY, OPEN_CLIENT_SECRET,
                OPEN_CLIENT_SERVERTYPE);
        if(org.apache.commons.lang3.StringUtils.isEmpty(url)){
            return null;
        }
        UptoItemImgRequest req=new UptoItemImgRequest();
        req.setMajor(major?1:0);
        req.setUrl(url);
        req.setNumIid(numIid);
        req.setPosition(position);
        req.setSession(session.getSession());
        UptoItemImgResponse res= (UptoItemImgResponse) c.execute(req);
        if(!res.isSuccess()&&res.getTbMsg()!=null){
            return "第"+position+"张详述图上传失败=>"+res.getTbMsg();
        }
        return null;
    }

    @Override
    public String addOnePropImg(Long numIid, String url, String properties, SessionVO session) {
        OpenClient c=new PcOpenClient(OPEN_CLIENT_APPKEY, OPEN_CLIENT_SECRET,
                OPEN_CLIENT_SERVERTYPE);
        if(org.apache.commons.lang3.StringUtils.isEmpty(url)){
            return null;
        }
        UptoPropImgRequest req=new UptoPropImgRequest();
        req.setSession(session.getSession());
        req.setNumIid(numIid);
        req.setUrl(url);
        req.setProperties(properties);
        UptoPropImgResponse res= (UptoPropImgResponse) c.execute(req);
        if(!res.isSuccess()){
            return res.getTbmsg();
        }
        return null;
    }

    @Override
    public PropsVO importValue(PropsVO propsVO, String prop, List<PropImgBO> propImgs, String alias, String inputStr, String inputIds) throws TbException {
        try {
            return propsService.importValue(propsVO,prop, BeanMapper.mapList(propImgs,PropImg.class),alias,inputStr,inputIds);
        } catch (Exception e) {
            throw new TbException("填充值失败"+e.getMessage());
        }
    }

    @Override
    public String updateWldesc(String desc, Long numIid, String session, String title, Long userId, String nick) throws TbException {
        try {
            return taobaoUtil.updateWldesc0803(desc, numIid, session,
                    title, userId, nick);
        } catch (ApiException e) {
            throw new TbException(e.getMessage());
        }
    }

}
