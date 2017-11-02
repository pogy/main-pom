package com.shigu.main4.daifa.model.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaPostCustomerExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.examples.DaifaWaitSendExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.beans.*;
import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.exception.KdApiException;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ExpressModel;
import com.shigu.main4.daifa.utils.KdConfig;
import com.shigu.main4.daifa.utils.KdHttpUtil;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.daifa.vo.QueryPostCodeVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.*;

/**
 * @类编号
 * @类名称：ExpressModelImpl
 * @文件路径：com.shigu.main4.daifa.model.ExpressModelImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 17:12
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Repository
@Scope("prototype")
public class ExpressModelImpl implements ExpressModel {

    @Resource(name = "tae_daifa_daifaCallExpressMapper")
    DaifaCallExpressMapper daifaCallExpressMapper;

    @Resource(name = "tae_daifa_daifaPostCustomerMapper")
    DaifaPostCustomerMapper daifaPostCustomerMapper;

    @Resource(name = "tae_daifa_daifaSellerMapper")
    DaifaSellerMapper daifaSellerMapper;

    @Resource(name = "tae_daifa_daifaWaitSendMapper")
    DaifaWaitSendMapper daifaWaitSendMapper;

    @Resource(name = "tae_daifa_daifaTradeMapper")
    DaifaTradeMapper daifaTradeMapper;

    @Autowired
    private KdConfig kdConfig;

    private Long expressId;
    private Long sellerId;
    public ExpressModelImpl(Long expressId,Long sellerId){
            this.expressId=expressId;
            this.sellerId=sellerId;
    }
    /**
     * ====================================================================================
     * @方法名： callExpress
     * @user gzy 2017/8/10 15:38
     * @功能：取得快递信息
     * @param: [bo]
     * @return: com.shigu.main4.daifa.vo.ExpressVO
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public ExpressVO callExpress (OrderExpressBO bo) throws DaifaException{

        ExpressVO vo;
        //先查询这个代发交易是否已经有快递鸟的信息了
        DaifaCallExpress dce= daifaCallExpressMapper.selectByPrimaryKey (bo.getTid ());
        if(dce!=null){
            vo=BeanMapper.map (dce,ExpressVO.class);
            vo.setTid (dce.getDfTradeId ());
        }else{
            //先用快递ID查询出快递鸟的账户信息
            DaifaPostCustomerExample example=new DaifaPostCustomerExample();
            example.createCriteria ().andDfSellerIdEqualTo (sellerId).andExpressIdEqualTo (expressId);
            List <DaifaPostCustomer> list_dpc=daifaPostCustomerMapper.selectByExample (example);
            if(list_dpc.size ()==0){
                throw new DaifaException ("系统无此快递鸟账户", DaifaException.DEBUG);
            }
            //再用bo里的信息与快递鸟的账户查询快递
            ExpressBean express=new ExpressBean ();
            if(list_dpc.size ()>0){
               DaifaPostCustomer dpc=list_dpc.get (0);
                express.setKdMonth(dpc.getMonthCode());//电子面单账户秘钥,和customer_pwd至少有一个,具体是哪个,参照文档
                express.setKdName(dpc.getCustomerName());//电子面单账户名
                express.setKdPassword(dpc.getCustomerPwd());//电子面单账户密码
                express.setKdSite(dpc.getSendSite());//快递网点名
                express.setKdType(dpc.getExpressCompanyCode());//快递简称
            }

            DaifaSeller seller= daifaSellerMapper.selectByPrimaryKey (sellerId);
            //发货信息
            SendBean send=new SendBean();
            List<String> goodsInfo=new ArrayList<>();
            for(SubOrderExpressBO sub:bo.getList ()){
                String title = sub.getStoreGoodsCode() + "-" + sub.getPropStr() + "-" + sub.getGoodsNum();
                goodsInfo.add (title);
            }
            send.setTitles (goodsInfo);//要打印的商品信息
            send.setExpressName (bo.getExpressName ());//快递名
            send.setIsNotice (0);//是否通知快递员上门揽件：0-通知；1-不通知；
            send.setOutTradeId (bo.getTid ()+"");//交易ID
            send.setPayType(3);//1-现付，2-到付，3-月结，4-第三方支付
            send.setReceiverName (bo.getReceiverName ());//收货人姓名
            send.setReceiverPhone (bo.getReceiverPhone ());
            //收货人信息
            String[] adds=bo.getReceiverAddress().split(" ");
            send.setReceiverProv (adds[0]);
            send.setReceiverCity (adds[1]);

            if(adds.length==3){
                send.setReceiverAddress (adds[2]);
            }else {
                send.setReceiverArea (adds[2]);
                StringBuilder readd = new StringBuilder();
                for (int i = 3; i < adds.length; i++) {
                    readd.append(adds[i]).append(" ");
                }
                send.setReceiverAddress (readd.toString());
            }

            //发货人信息
            send.setSendName (seller.getName ());
            send.setSendPhone (seller.getTelephone ());
            String[] ses=seller.getAddress ().split(" ");
            send.setSendProv (ses[0]);
            send.setSendCity (ses[1]);
            send.setSendArea (ses[2]);
            send.setSendAddress (ses[3]);

            try {
                QueryPostCodeVO  qvo=getPostCode( send, express);
                if(qvo.getPostCode ()!=null&&!"".equals (qvo.getPostCode ())){
                    //查询出返回的信息保存到数据库中
                    DaifaCallExpress dce1=new DaifaCallExpress();
                    dce1.setCreateTime (new Date());
                    dce1.setDfTradeId (bo.getTid ());
                    dce1.setExpressCode (qvo.getPostCode ());
                    dce1.setExpressId (expressId);
                    dce1.setMarkDestination (qvo.getMarkDestination ());
                    dce1.setPackageName (qvo.getPackageName ());
                    dce1.setSellerId (sellerId);
                    dce1.setJsonData (qvo.getJsonData ());
                    daifaCallExpressMapper.insertSelective (dce1);

                    DaifaWaitSend send1=new DaifaWaitSend ();
                    send1.setDfTradeId (bo.getTid ());
                    send1.setExpressCode (qvo.getPostCode ());
                    DaifaWaitSendExample snedExample=new DaifaWaitSendExample();
                    snedExample.createCriteria ().andDfTradeIdEqualTo (bo.getTid ());
                    daifaWaitSendMapper.updateByExampleSelective (send1,snedExample);

                    DaifaTrade trade=new DaifaTrade ();
                    trade.setDfTradeId (bo.getTid ());
                    trade.setExpressCode (qvo.getPostCode ());
                    DaifaTradeExample tradeExample=new DaifaTradeExample ();
                    tradeExample.createCriteria ().andDfTradeIdEqualTo (bo.getTid ());
                    daifaTradeMapper.updateByExampleSelective (trade,tradeExample);
                    //设置VO
                    vo=new ExpressVO ();
                    vo.setTid (dce1.getDfTradeId ());
                    vo.setPackageName (dce1.getPackageName ());
                    vo.setMarkDestination (dce1.getMarkDestination ());
                    vo.setExpressId (dce1.getExpressId ());
                    vo.setExpressCode (dce1.getExpressCode ());
                }else{
                    JSONObject obj1 = JSONObject.fromObject(qvo.getJsonData ());
                   // Reason
                    Object obj_reasion=obj1.get ("Reason");
                    throw new DaifaException (obj_reasion.toString (),DaifaException.ERROR);
                }

            } catch (KdApiException e) {
                throw new DaifaException (e.getMsg(),DaifaException.ERROR);
            }

        }

        return vo;
    }
    /**
     * ====================================================================================
     * @方法名： getPostCode
     * @user gzy 2017/8/10 15:38
     * @功能：调用快递鸟
     * @param: [send, express]
     * @return: com.shigu.main4.daifa.vo.QueryPostCodeVO
     * @exception:
     * ====================================================================================
     *
     */
    private QueryPostCodeVO getPostCode(SendBean send, ExpressBean express) throws KdApiException {

        EOrderInfo eoinfo = new EOrderInfo();

        eoinfo.setOrderCode(send.getOutTradeId());//订单ID
        eoinfo.setShipperCode(express.getKdType());//快递简称
        eoinfo.setCustomerName(express.getKdName());//电子面单账户名
        eoinfo.setCustomerPwd(express.getKdPassword());//电子面单账户密码
        eoinfo.setMonthCode(express.getKdMonth());//电子面单账户秘钥,和电子面单账户密码至少有一个,具体是哪个,参照文档
        eoinfo.setSendSite(express.getKdSite());//快递网点名
        eoinfo.setPayType(send.getPayType());//结算方式
        eoinfo.setExpType(1);//

        //收货人姓名
        SeReBean receiver = new SeReBean();
        receiver.setName(send.getReceiverName ());//收货人姓名
        receiver.setAddress(send.getReceiverAddress ());//收货人地址
        receiver.setCityName(send.getReceiverCity ());//收货人城市
        receiver.setProvinceName(send.getReceiverProv ());//收货人省份
        receiver.setExpAreaName(send.getReceiverArea ());//收货人区域
        receiver.setTel(send.getReceiverPhone ());//收货人手机号
        eoinfo.setReceiver(receiver);
        //发货人姓名
        SeReBean sender = new SeReBean();
        sender.setName(send.getSendName ());//发货人姓名
        sender.setAddress(send.getSendAddress ());//发货人地址
        sender.setCityName(send.getSendCity ());//发货人城市
        sender.setProvinceName(send.getSendProv ());//发货人省份
        sender.setExpAreaName(send.getSendArea ());//发货人区域名
        sender.setTel(send.getSendPhone ());//发货人电话号
        eoinfo.setSender(sender);
        //商品信息列表
        List<Commodity> cs = new ArrayList<Commodity> ();
        for (String no : send.getTitles()) {
            Commodity c = new Commodity();
            c.setGoodsName(no);
            cs.add(c);
        }
        if (cs.size() > 0) {
            eoinfo.setCommodity(cs);
        }
        eoinfo.setIsReturnPrintTemplate(1);//返回电子面单模板：0-不需要；1-需要
        Gson gson = new Gson();
        String requestData = gson.toJson(eoinfo);


        Map<String, String> params = null;
        try {
            params = new HashMap<String, String> ();
            params.put("RequestData", KdHttpUtil.urlEncoder(requestData, "UTF-8"));//请求内容需进行URL(utf-8)编码。请求内容JSON格式，须和DataType一致。
            params.put("EBusinessID", kdConfig.getEid());//商户ID，请在我的服务页面查看
            params.put("RequestType", "1007");//请求指令类型：1007
            String dataSign = KdHttpUtil.encrypt(requestData, kdConfig.getAppKey(), "UTF-8");//验签
            params.put("DataSign", KdHttpUtil.urlEncoder(dataSign, "UTF-8"));//数据内容签名：把(请求内容(未编码)+AppKey)进行MD5加密，然后Base64编码，最后 进行URL(utf-8)编码
            params.put("DataType", "2");//求、返回数据类型：只支持JSON格式
        } catch (Exception e) {
            throw new KdApiException(KdApiException.KdApiExceptionEnum.SIGN_ERROR);
        }
        String result = KdHttpUtil.sendPost(kdConfig.getEorderserviceReqURL(), params);
//System.out.println("@@@@@@@@@@@@@@"+result);
        JSONObject obj = JSONObject.fromObject(result);

        if (obj.containsKey("Success")) {
            return jsonToPostResult(obj);
        } else {
            if (obj.get("Order") == null || obj.getJSONObject("Order").get("LogisticCode") == null) {
                throw new KdApiException(KdApiException.KdApiExceptionEnum.API_ERROR, obj.getString("Reason"));
            } else {
                return jsonToPostResult(obj);
            }
        }
    }
    /**
     * ====================================================================================
     * @方法名： jsonToPostResult
     * @user gzy 2017/8/10 13:59
     * @功能：处理快递鸟返回结果
     * @param: [obj]
     * @return: com.shigu.main4.daifa.vo.QueryPostCodeVO
     * @exception:
     * ====================================================================================
     *
     */
    private QueryPostCodeVO jsonToPostResult(JSONObject obj) {

        JSONObject order = obj.getJSONObject("Order");//快递鸟返回订单快递信息
        if(order==null||order.size ()==0){
            QueryPostCodeVO pr = new QueryPostCodeVO();
            pr.setJsonData (obj.toString ());
            return pr;
        }
        String postCode = order.getString("LogisticCode");//快递单号
        Object m = order.get("MarkDestination");//大头笔//三段码
        Object oc=order.get("OriginCode");//始发地区域编码
        Object on=order.get("OriginName");//始发地/始发网点
        Object dc=order.get("DestinatioCode");//目的地区域编码
        Object dn=order.get("DestinatioName");//目的地/到达网点
        Object sc=order.get("SortingCode");//分拣编码
        Object pc=order.get("PackageCode");//集包编码
        Object pn=order.get("PackageName");//集包地
        QueryPostCodeVO pr = new QueryPostCodeVO();
        pr.setMarkDestination(m == null ? null : m.toString());
        pr.setOriginCode(oc==null?null:oc.toString());
        pr.setOriginName(on==null?null:on.toString());
        pr.setDestinatioCode(dc==null?null:dc.toString());
        pr.setDestinatioName(dn==null?null:dn.toString());
        pr.setSortingCode(sc==null?null:sc.toString());
        pr.setPackageCode(pc==null?null:pc.toString());
        pr.setPackageName(pn==null?null:pn.toString());
        pr.setPostCode(postCode);
        pr.setJsonData (obj.toString ());
        return pr;
    }
}
