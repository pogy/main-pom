package com.shigu.main4.ucenter.util;

import au.com.bytecode.opencsv.CSVReader;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguSiteExample;
import com.opentae.data.mall.examples.ShiguTaobaocatExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShiguSiteMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.vo.PriceDataGrid;
import com.shigu.main4.ucenter.vo.ShiguGoodsExtendsVO;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import com.shigu.main4.ucenter.vo.ShiguPropImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @类编号
 * @类名称：ImportCsvFile
 * @文件路径：com.shigu.main4.ucenter.util.ImportCsvFile
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/2 18:16
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class ImportCsvFileService {

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    private ShiguSiteMapper shiguSiteMapper;
    @Autowired
    private ShiguTaobaocatMapper shiguTaobaocatMapper;
    @Autowired
    private TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    PriceErrorService priceErrorService;
    @Autowired
    OssIO oss;

    public  List<ShiguGoodsTinyVO> importCsvFileString(Long storeId, String importCSVFile, String image_save_path) throws Main4Exception {
    //Date t1=new Date();
        //查询店铺
        ShiguShop shop= shiguShopMapper.selectByPrimaryKey (storeId);

        ShiguSiteExample ssExample=new ShiguSiteExample();
        ssExample.createCriteria ().andCitySiteEqualTo (shop.getWebSite ());
        List<ShiguSite> list_site= shiguSiteMapper.selectByExample (ssExample);
        ShiguSite ss=null;
        if(list_site.size ()>0){
            ss=list_site.get (0);
        }

        Map<String, String> map=new HashMap<String, String> ();//key为图片存储地址  //value为转化后的图片访问地址



        ShiguGoodsTinyVO record=null;
        ShiguGoodsExtendsVO sge=null;
        CSVReader csvReader = null;
        List<ShiguGoodsTinyVO> goodsList=new ArrayList<>();
        Vector vector=null;

        Vector<Vector> vector_h=new Vector<Vector>();
        try {
            //csvReader = new CSVReader(new FileReader(myFile), '\r', '\n', 3);
            //csvReader = new CSVReader(new FileReader(myFile),'\t');//importFile为要导入的文本格式逗号分隔的csv文件，提供getXX/setXX方法
            DataInputStream in = new DataInputStream(new FileInputStream (importCSVFile));
            csvReader = new CSVReader(new InputStreamReader (in, "Unicode"), '\t');
           // Date tcsv=new Date();
            if(csvReader != null){

                //first row is title, so past
                csvReader.readNext();
                String[] csvRow = null;//row
                int kpi=0;
                while ((csvRow = csvReader.readNext()) != null){
                    kpi++;
                    //System.out.println("第"+kpi+"行");
                    vector=new Vector();
                    for (int i =0; i<csvRow.length; i++){
                        String temp = csvRow[i];
                        vector.add(temp);
                    }
                    vector_h.add(vector);
                    //System.out.println("下一行");
                    //保存linkman到数据库
                }
            }


            List<Long> cidList=new ArrayList<> ();

            for(int i=2;i<vector_h.size();i++){
                if(i==11){
                   // System.out.println(i);
                }
                Vector v_title=vector_h.get(0);
                Vector v11=vector_h.get(i);
                record=new ShiguGoodsTinyVO();
                sge=new ShiguGoodsExtendsVO();

                String input_custom_cpv="";//扩展属性
                String propAlias="";

                for(int k=0;k<v_title.size();k++){
                    //if(v_title.get(k).equals("q1")){

                    //System.out.println("第"+i+"行第"+k+"列"+v_title.get(k)+"="+v11.get(k));
                    //}
                    String tt=(String)v_title.get(k);

                    switch (tt) {//tt.hashCode()
                        case "title":record.setTitle((String)v11.get(k));break;//title//标题
                        case "cid"://宝贝类目
                            if(v11.get(k)!=null&&!"".equals(v11.get(k))){
                                //System.out.println(((String)v11.get(k)).trim());
                                //System.out.println(k);
                                Long cid=new Long(((String)v11.get(k)).trim());

                                cidList.add (cid);
                                record.setCid(cid);
                            }
                            break;
                        case "seller_cids"://店铺类目//seller_cids
                            if(v11.get(k)!=null){
                                record.setCidAll((String)v11.get(k));
                                sge.setSellerCids((String)v11.get(k));
                            }else{
                                record.setCidAll("");
                                sge.setSellerCids("");
                            }
                            break;
                        case "stuff_status"://新旧程度//stuff_status
                            if(v11.get(k)!=null&&"1".equals (v11.get (k))){
                                record.setStuffStatus("new");
                            }
                            break;
                        case "location_state"://省//location_state
                            record.setProv(ss.getProvinceName ());
                            break;
                        case "location_city"://城市//location_city
                                record.setCity(ss.getCityName ());
                            break;
                        case "item_type"://出售方式//item_type
                            break;
                        case "price"://宝贝价格//price
                            if(v11.get(k)!=null&&!"".equals(v11.get(k))){
                                record.setPriceString(TypeConvert.StringToString((String)v11.get(k)));
                                Double dp=new Double(record.getPriceString())*100;
                                record.setPrice(dp.longValue());
                                record.setPiPrice (dp.longValue());
                                record.setPiPriceString (record.getPriceString ());
                                record.setIsStandard(1);//然后跳转到页面让他设置批发价
                            }else{
                                record.setError ("没有批发价");
                            }
                            break;
                        case "auction_increment"://加价幅度//auction_increment
                            if(v11.get(k)!=null){
                                sge.setIncrement((String)v11.get(k));
                            }
                            break;
                        case "num"://宝贝数量//num
                            if(v11.get(k)!=null&&!"".equals(v11.get(k))){
                                Long num=new Long(((String)v11.get(k)).trim());
                                record.setNum(num);
                            }else{
                                record.setNum (9999L);
                            }
                            break;
                        case "valid_thru"://有效期//valid_thru
                            break;
                        case "freight_payer"://运费承担//freight_payer
                            if(v11.get(k)!=null){
                                if("1".equals(v11.get(k))){
                                    record.setFreightPayer("seller");
                                }else{
                                    record.setFreightPayer("buyer");
                                }
                            }else{
                                record.setFreightPayer("buyer");
                            }
                            break;
                        case "post_fee"://平邮//post_fee
                                record.setPostFee("0.00");
                            break;
                        case "ems_fee"://ems//ems_fee
                                record.setEmsFee("0.00");
                            break;
                        case "express_fee"://快递//express_fee
                                record.setExpressFee("0.00");
                            break;
                        case "has_invoice"://发票//has_invoice
                            if(v11.get(k)!=null){
                                if("0".equals(v11.get(k))){
                                    sge.setHasInvoice("false");
                                }else{
                                    if("1".equals(v11.get(k))){
                                        sge.setHasInvoice("true");
                                    }
                                }
                            }else{
                                sge.setHasInvoice("true");
                            }
                            break;
                        case "has_warranty"://保修//has_warranty
                            if(v11.get(k)!=null){
                                if("0".equals(v11.get(k))){
                                    sge.setHasWarranty("false");
                                }else{
                                    if("1".equals(v11.get(k))){
                                        sge.setHasWarranty("true");
                                    }
                                }
                            }else{
                                sge.setHasWarranty("true");
                            }
                            break;
                        case "approve_status"://放入仓库//approve_status
                            if(v11.get(k)!=null){
                                if("0".equals(v11.get(k))){
                                    sge.setApproveStatus("instock");
                                }else{
                                    if("1".equals(v11.get(k))){
                                        sge.setApproveStatus("onsale");
                                    }
                                }
                            }else{
                                sge.setApproveStatus("onsale");
                            }
                            break;
                        case "has_showcase"://橱窗推荐//has_showcase
                            if(v11.get(k)!=null){
                                if("0".equals(v11.get(k))){
                                    record.setHasShowcase("false");
                                }else{
                                    if("1".equals(v11.get(k))){
                                        record.setHasShowcase("true");
                                    }
                                }
                            }else{
                                record.setHasShowcase("true");
                            }
                            break;
                        case "list_time"://开始时间//list_time
                            if(v11.get(k)!=null){
                                String time=(String)v11.get(k);
                                Date dd=TypeConvert.parseStringToDate(time,"yyyy-MM-dd HH:mm:ss");
                                record.setListTime(dd);
                            }else{
                                record.setListTime (new Date());
                            }
                            break;
                        case "description"://宝贝描述//description
                            if(v11.get(k)!=null){
                                String desc=(String)v11.get(k);
                                /*if(desc.indexOf("hznzcn")!=-1||desc.indexOf("freep.cn")!=-1){
                                    desc=uploadImages(desc, storeId);
                                }*/
                                sge.setGoodsDesc(desc);
                            }else{
                                record.setError ("宝贝描述为空");
                            }
                            break;
                        case "cateProps"://宝贝属性//cateProps
                            if(v11.get(k)!=null){//
                                sge.setProps((String)v11.get(k));
                            }else{
                                record.setError ("宝贝属性为空");
                            }
                            break;
                        case "postage_id"://邮费模版ID//postage_id
                            if(v11.get(k)!=null&&!"".equals(v11.get(k))){

                                Long codPostageId=new Long(((String)v11.get(k)).trim());
                                sge.setPostageId(codPostageId);
                                sge.setCodPostageId(codPostageId);
                            }
                            break;
                        case "has_discount"://会员打折//has_discount
                            if(v11.get(k)!=null){
                                if("0".equals(v11.get(k))){
                                    record.setHasDiscount("false");
                                }else{
                                    if("1".equals(v11.get(k))){
                                        record.setHasDiscount("true");
                                    }
                                }
                            }else{
                                record.setHasDiscount("false");
                            }
                            break;
                        case "modified"://修改时间//modified
                            if(v11.get(k)!=null){
                                String time=(String)v11.get(k);
                                Date dd=TypeConvert.parseStringToDate(time,"yyyy-MM-dd HH:mm:ss");
                                record.setModified(dd);
                            }else{
                                record.setModified (new Date());
                            }
                            break;
                        case "upload_fail_msg"://上传状态//upload_fail_msg
                            break;
                        case "picture_status"://图片状态//picture_status
                            break;

                        case "auction_point"://返点比例//auction_point
                            break;
                        case "picture"://新图片//picture
                            if(v11.get(k)!=null&&!"".equals(v11.get(k))){
                                //有图片空间是淘宝助理导入的
                                record.setStoreId(storeId);
                               // Date tpic=new Date();

                                getImgs((String)v11.get(k), record,sge,image_save_path,map);
                               // Date tpicend=new Date();
                               // long timepic=tpicend.getTime()-tpic.getTime();
                               // System.out.println(i+"执行图片处理"+timepic);
                            }else{
                                record.setError ("没有主图");
                            }
                            break;
                        case "video"://视频//video
                            break;
                        case "skuProps"://销售属性组合//skuProps
                            if(v11.get(k)!=null){
                                //sge.setProps ((String)v11.get(k));//原来没有
                            }
                            break;
                        case "inputPids"://用户输入ID串//inputPids
                            if(v11.get(k)!=null){
                                sge.setInputPids((String)v11.get(k));
                            }
                            break;
                        case "inputValues"://用户输入名-值对//inputValues
                            if(v11.get(k)!=null){
                                sge.setInputStr((String)v11.get(k));
                            }
                            break;
                        case "outer_id"://商家编码 ,货号//outer_id
                            if(v11.get(k)!=null){
                                record.setOuterId((String)v11.get(k));
                            }
                            break;
                        case "propAlias"://销售属性别名//propAlias
                            if(v11.get(k)!=null){
                                propAlias=(String)v11.get(k);//=====================================================
                            }
                            break;
                        case "auto_fill"://代充类型//auto_fill
                            break;
                        case "num_id"://数字ID//num_id
                            break;

                        case "local_cid"://本地ID//local_cid
                            break;
                        case "navigation_type"://宝贝分类//navigation_type
                            break;
                        case "user_name"://用户名称//user_name
                            break;
                        case "syncStatus"://宝贝状态//syncStatus
                            break;
                        case "is_lighting_consigment"://闪电发货//is_lighting_consigment
                            record.setIsLightningConsignment("0");break;
                        case "is_xinpin"://新品//is_xinpin
                            if(v11.get(k)!=null){
                                record.setIsXinpin("true");
                            }
                            break;
                        case "foodparame"://食品专项//foodparame
                            break;

                        case "features"://尺码库 //宝贝特征值//features
                            if(v11.get(k)!=null){
                                sge.setFeatures((String)v11.get(k));
                            }
                            break;
                        case "buyareatype"://采购地//buyareatype
                            break;

                        case "global_stock_type"://库存类型//global_stock_type
                            break;
                        case "global_stock_country"://国家地区//global_stock_country
                            break;
                        case "sub_stock_type"://库存计数//sub_stock_type
                            if(v11.get(k)!=null&&!"".equals(v11.get(k))){

                                Long subStock=new Long(((String)v11.get(k)).trim());
                                sge.setSubStock(subStock);
                            }
                            break;
                        case "item_size"://物流体积//item_size
                            sge.setItemSize((String)v11.get(k));
                            break;
                        case "item_weight"://物流重量//item_weight
                            if(v11.get(k)!=null){
                                sge.setItemWeight((String)v11.get(k));
                            }
                            break;
                        case "sell_promise"://退换货承诺//sell_promise
                            if(v11.get(k)!=null){
                                if("0".equals(v11.get(k))){
                                    sge.setSellPromise("false");
                                }else{
                                    if("1".equals(v11.get(k))){
                                        sge.setSellPromise("true");
                                    }
                                }
                            }else{
                                sge.setSellPromise("false");
                            }
                            break;
                        case "custom_design_flag"://定制工具//custom_design_flag
                            break;
				            	/*if(v11.get(k)!=null){
				            		sge.setCustomMadeTypeId((String)v11.get(k));break;
				            	}*/
                        case "wireless_desc"://无线详情//wireless_desc
                            if(v11.get(k)!=null){
                                sge.setWirelessDesc((String)v11.get(k));
                            }
                            break;
                        case "barcode"://商品条形码//barcode
                            if(v11.get(k)!=null){
                                sge.setBarcode((String)v11.get(k));
                            }
                            break;
                        case "sku_barcode"://sku 条形码//sku_barcode
                            break;

                        case "newprepay"://7天退货/newprepay
                            break;

                        case "subtitle"://宝贝卖点//subtitle
                            if(v11.get(k)!=null){
                                sge.setSubtitle((String)v11.get(k));
                            }
                            break;

                        case "cpv_memo"://属性值备注//cpv_memo
                            break;
                        case "input_custom_cpv"://自定义属性值//input_custom_cpv
                            if(v11.get(k)!=null){
                                input_custom_cpv=(String)v11.get(k);
                                sge.setInputCustomCpv (input_custom_cpv);
                            }
                            break;
                        case "qualification"://商品资质//qualification
                            break;
                        case "add_qualification"://增加商品资质//add_qualification
                            break;
                        case "o2o_bind_service"://关联线下服务//o2o_bind_service
                            break;
                        case "tmall_extend"://tmall扩展字段//tmall_extend
                            break;
                        case "product_combine"://产品组合//product_combine
                            break;
                        case "tmall_item_prop_combine"://tmall属性组合//tmall_item_prop_combine
                            break;
                        case "taoschema_extend"://taoschema扩展字段//taoschema_extend
                            break;
                    }

                }

               String sgoodsId= getgoodsId(storeId,i);
               Long goodsId=new Long(sgoodsId);
                record.setGoodsId(goodsId);
                record.setStoreId(storeId);
                record.setCreated(new Date());
                record.setGoodsStatus(1);//上传完成后设置成1，等图片上传后就转为0或不转换
                //////////=====================以下可能要去掉================
                record.setInStoreSortOrder(999L);
                record.setIsClosed(0L);
                record.setLoadDate(new Date());
                record.setMarketId(shop.getFloorId ());
                record.setNick(shop.getTbNick ());
                record.setParentMarketId(shop.getMarketId());
                record.setStoreNum(shop.getShopNum ());
                record.setType("fixed");
                record.setValidThru(7L);
                record.setWebSite(shop.getWebSite());
                record.setClicks(0L);
                record.setSortOrder(999L);
                record.setDelistTime(new Date());
                record.setListTime(new Date());
                record.setModified(new Date());
                if(record.getPiPrice()==null){
                    if(record.getPrice()!=null){
                        record.setPiPrice(record.getPrice());
                    }
                }
                if(record.getPiPriceString()==null){
                    if(record.getPriceString()!=null){
                        record.setPiPriceString(record.getPriceString());
                    }
                }
                sge.setGoodsId(goodsId);
                sge.setAuctionPoint("0");
                sge.setIs3d("false");
                sge.setIsEx("false");
                sge.setIsTiming("false");
                sge.setIsVirtual("false");
                sge.setOneStation("false");

                //CatStr  cs=  getCatStrAndGoodsNo(sge.getProps(),input_custom_cpv,record.getCid(),sge.getInputPids(),sge.getInputStr(),record.getGoodsNo(),propAlias);

               // sge.setPropsName(cs.getPn());

               // //sge.setPropertyAlias(cs.getPnc());
                if(propAlias!=null&&!"".equals (propAlias))
                sge.setPropertyAlias (propAlias);
                /*if(cs.getGoodsNo()!=null&&!"".equals(cs.getGoodsNo())){
                    record.setGoodsNo(cs.getGoodsNo());
                }*/
               String goodsNo= getgoodsNo(sge.getInputPids(),sge.getInputStr(),record.getGoodsNo());
               record.setGoodsNo (goodsNo);
               /* if((record.getGoodsNo()==null||"".equals(record.getGoodsNo()))&&record.getOuterId ()!=null&&!"".equals (record.getOuterId ())){
                    record.setGoodsNo(record.getOuterId());
                }*/

                sge.setUpdateTime(new Date());
                sge.setViolation("false");
                sge.setWapDesc("");
                sge.setWapDetailUrl("");

                sge.setWithHoldQuantity(1L);
                sge.setLoadDate(new Date());

                String prices=record.getPriceString();
                Double priced=new Double(prices);

                //Date datepprice1=new Date();
                PriceDataGrid data = priceErrorService.piPriceMatcher(shop, record, 10.00, 0.2, 4, "p,f", 1);
                //Date datepprice2=new Date();
                //long time_piprice=datepprice2.getTime ()-datepprice1.getTime ();
                //System.out.println(i+"执行piPriceMatcher的时间="+time_piprice);
                //System.out.println(data.getpPriceString());
               /* System.out.println("-------------------@@@@@@@@@@@@@-----------------");
                System.out.println("msg===="+data.getMsg());
                System.out.println("isStandard==="+data.getGoods().getIsStandard());
                System.out.println("PiPrice==="+data.getGoods().getPiPrice());
                System.out.println("PiPriceString===="+data.getGoods().getPiPriceString());
                System.out.println("-------------------@@@@@@@@@@@@@-----------------");*/
                record.setPiPriceString(data.getGoods().getPiPriceString());
                record.setPiPrice(data.getGoods().getPiPrice());
                record.setIsStandard(data.getGoods().getIsStandard());
                record.setIsExcelImp(1);

                //加入前判断哪些字段不能为空有为空的就返回报错到页面=====================================================================
                String checkres=checkRecord(record,sge);
                record.setError (checkres);
                record.setExtendsGoods (sge);
                /*System.out.println("-------------------@@@@@@@@@@@@@-----------------");
                System.out.println("PropertyAlias"+i+"===="+sge.getPropertyAlias ());
                System.out.println("-------------------@@@@@@@@@@@@@-----------------");*/
                goodsList.add (record);
            }

            //=================================================================================================
            //cidList 查询cid然后最后循环放到goods的cid里//如果cid查询里没有类目名的话那么cid就是有问题的，有就是没有问题的
            //Date dcid1=new Date();

            Map<Long,String> mapcid=queryCid(cidList);
            if(goodsList.size ()>0){
                for(ShiguGoodsTinyVO goodsvo:goodsList){
                    if(goodsvo.getCid ()!=null){
                      String cname=  mapcid.get (goodsvo.getCid ());
                      if(cname!=null){
                          goodsvo.setCname (cname);
                      }else{
                          goodsvo.setError ("类目不存在");
                      }
                    }else{
                        goodsvo.setError ("类目不存在");
                    }

                }
            }
            //Date dcid2=new Date();
            //Long dr1=dcid2.getTime()-dcid1.getTime();
           // System.out.println ("类目执行时间：" + dr1);
            //=================================================================================================

        } catch (Exception e) {

            throw new Main4Exception (e.getMessage ());
        }
        //Date t2=new Date();
        //Long dr1=t2.getTime()-t1.getTime();
       // System.out.println ("全部执行时间为：" + dr1);

        return goodsList;
    }


    /**
     * ====================================================================================
     * @方法名： getImgs
     * @user gzy 2017/11/3 17:17
     * @功能：
     * @param: [imgString, record, sge, image_save_path, map]
     * @return: void
     * @exception:
     * ====================================================================================
     *
     */
    private void getImgs(String imgString, ShiguGoodsTinyVO record, ShiguGoodsExtendsVO sge, String image_save_path, Map<String, String> map){

        String imgs[]=imgString.split (";");
        String imgse="";
        String picUrl="";
        if(imgs.length>0){
            for(int i=0;i<imgs.length;i++){
                String img=imgs[i];
                String img_w[]=img.split("\\|");
                //System.out.println(img_w.length);
                if(img_w.length>1){
                    String mainpics[]= img_w[0].split(":");
                    if(mainpics.length>2){
                        if("1".equals(mainpics[1])){
                            String imgpic=img_w[1];
                            if(imgpic.endsWith("-")){
                                imgpic+="item_pic.jpg";
                            }
                            if(i==0){
                                imgse=imgpic;
                                picUrl=imgpic;
                            }else{
                                imgse+=","+imgpic;
                            }
                        }/*else{
                            if("2".equals(mainpics[1])){
                                //是颜色尺码图片
                            }
                        }*/
                    }

                }else{
                    //没有直接的图片
                    String pics[]=img_w[0].split(":");
                    if("1".equals (pics[1])) {
                        //System.out.println(pics[0]);
                        if (i == 0) {

                            imgse = imageurl (record.getStoreId (), image_save_path + "/" + pics[0] + ".tbi");
                           // picUrl = imageurl (record.getStoreId (), image_save_path + "/" + pics[0] + ".tbi");
                            picUrl=imgse;
                            //map.put(image_save_path+"/"+pics[0]+".tbi", imgse);
                            map.put (imgse, image_save_path + "/" + pics[0] + ".tbi");

                        } else {
                            //imgse+=","+DConfig.BAIDU_YUN_BASE_URL+record.getStoreId()+"/"+pics[0]+".jpg";
                            String imurlString = imageurl (record.getStoreId (), image_save_path + "/" + pics[0] + ".tbi");

                            imgse += "," + imurlString;
                            //map.put(image_save_path+"/"+pics[0]+".tbi", imurlString);
                            map.put (imurlString, image_save_path + "/" + pics[0] + ".tbi");
                        }
                    }else{/////2
                        if("2".equals (pics[1])) {
                          String  propPicUrl = imageurl (record.getStoreId (), image_save_path + "/" + pics[0] + ".tbi");
                            String spid=pics[3];
                            String svid=pics[4];
                            ShiguPropImg spi=new ShiguPropImg();
                            spi.setPid (new Long(spid));
                            spi.setVid (new Long(svid));
                            spi.setUrl (propPicUrl);

                           List<ShiguPropImg> list_spi= sge.getList_spi ();
                            list_spi.add (spi);

                        }
                    }


                }
            }
        }
       // imgse=cutimage(imgse);
        sge.setImages (imgse);
        record.setPicUrl (picUrl);
    }

    /**
     *
     *=========================================================
     *@方法名：imageurl
     *@功能： 取得图片访问地址
     *@param image_save_path
     *@return:String
     *=========================================================
     */
    public String imageurl(Long storeId,String image_save_path){

        byte[] data=readYjImgBypath (image_save_path);
        String md5= Byte2MD5.getMD5(data);

        //OssIO oss=new OssIO ();

        String imgPath="itemImgs/temp/"+storeId+"/"+md5+".jpg";

        String picUrl= null;
        try {
            picUrl = oss.uploadFile(data, imgPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }

        //System.out.println("picUrl="+picUrl);
        return picUrl;

    }
    /**
     * ====================================================================================
     * @方法名： readYjImgBypath
     * @user gzy 2017/11/3 17:15
     * @功能：读取文件成字节
     * @param: [path]
     * @return: byte[]
     * @exception:
     * ====================================================================================
     *
     */
    public static byte[] readYjImgBypath(String path){

        byte[] arg0;
        File f=new File(path);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(f);
            arg0=new byte[fis.available()];
            bis=new BufferedInputStream(fis);
            bis.read(arg0);
            return arg0;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ====================================================================================
     * @方法名： cutimage
     * @user gzy 2017/11/3 17:16
     * @功能：
     * @param: [imgse]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    public String cutimage(String imgse){

        String[] imgs1= imgse.split(",");
        HashMap<String,String> map_img=new HashMap<String, String> ();
        if(imgs1.length>0){
            for(int i=0;i<imgs1.length;i++){
                map_img.put (imgs1[i],imgs1[i]);
            }
        }

        String imggs="";
        String[] imgs= null;

        if(map_img.size ()>0){
            imgs= new String[map_img.size ()];
            int k=0;
            for (java.util.Map.Entry<String, String> entry : map_img.entrySet()) {
                imgs[k]=entry.getKey ();
                if(k==0){
                    imggs=entry.getKey ();
                }else{
                    imggs+=","+entry.getKey ();
                }

                k++;
            }
        }
        imgse=imggs;

        if(imgs!=null&&imgs.length>=20){
            for(int i=imgs.length-1;i>=20;i--){
                imgse=imgse.replace(","+imgs[i], "");
            }
        }
        return imgse;
    }
    /**
     *
     *=========================================================
     *@方法名：queryCid
     *@功能： 查询类目
     *@param list_cid
     *@return:boolean
     *=========================================================
     */
    private Map<Long,String> queryCid(List<Long> list_cid){
        ShiguTaobaocatExample example=new ShiguTaobaocatExample();
        example.createCriteria ().andCidIn (list_cid);
        List<ShiguTaobaocat> cidlist= shiguTaobaocatMapper.selectFieldsByExample (example, FieldUtil.codeFields("cid,cname"));
        //转成map
        Map<Long,String> map=new HashMap<> ();
        if(cidlist.size ()>0){
            for(ShiguTaobaocat cat:cidlist){
                map.put (cat.getCid (),cat.getCname ());
            }
        }
        return map;

    }

    private String checkRecord(ShiguGoodsTinyVO record,  ShiguGoodsExtendsVO sge){

        //确认不能为空的字段city  prov这两个字段要处理一下要修改成他所城城市

        String result="";
        if(record.getTitle()==null||"".equals(record.getTitle())){
            result="有商品标题为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }

        if(record.getCid()==null||record.getCid()<=0){
            result="有商品"+record.getTitle()+"的宝贝类目（cid）为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }
        if(record.getPicUrl()==null||"".equals(record.getPicUrl())){
            result="有商品"+record.getTitle()+"商品主图为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }
        if(record.getPriceString()==null||"".equals(record.getPriceString())){
            result="有商品"+record.getTitle()+"宝贝价格(price)为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }
        if(sge.getGoodsDesc()==null||"".equals(sge.getGoodsDesc())){
            result="有商品"+record.getTitle()+"宝贝描述(description)为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }

        if(sge.getPropsName()==null||"".equals(sge.getPropsName())){
            result="有商品"+record.getTitle()+"宝贝属性为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }

        if(sge.getProps()==null||"".equals(sge.getProps())){
            result="有商品"+record.getTitle()+"宝贝属性为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }
        if(sge.getImages ()==null||"".equals(sge.getImages())){
            result="有商品"+record.getTitle()+"宝贝图片(picture)为空的商品在CSV中进行请补全后再进行上传";
            return result;
        }


        return result;

    }

    /**
     * ====================================================================================
     * @方法名： getgoodsNo
     * @user gzy 2017/11/6 17:06
     * @功能：取得货号
     * @param: [inputPids, inputValues, outer_id]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    public String getgoodsNo(String inputPids,String inputValues,String outer_id){

        //货号
        String goodsNo = "";

        if (inputPids != null && inputPids.length() > 0) {
            if (inputPids.contains("13021751")) {//商品编码
                //开始处理
                String goodsnoids[] = inputPids.split(",");

                String goodsnos[] = inputValues.split(",");
                for (int i = 0; i < goodsnoids.length; i++) {
                    if (goodsnoids[i].equals("13021751")||goodsnoids[i].equals("1647377840")||goodsnoids[i].equals("637078838")) {
                        goodsNo = goodsnos[i];
                    }
                }
            }

        }

        if("".equals(goodsNo)){
            goodsNo=outer_id;
        }
        return goodsNo;
    }

    /**
     * ====================================================================================
     * @方法名： getCatStrAndGoodsNo
     * @user gzy 2017/11/3 18:53
     * @功能：
     * @param: [props, input_custom_cpv, cid, inputPids, inputValues, outer_id, propAlias]
     * @return: com.shigu.main4.ucenter.util.CatStr
     * @exception:
     * ====================================================================================
     *
     */
    public CatStr getCatStrAndGoodsNo(String props,String input_custom_cpv,Long cid,String inputPids,String inputValues,String outer_id,String propAlias) {

        //自定义的尺码
        CatStr cs = new CatStr();
        String pn = "";
        String pnc ="";
        String colorString = "";
        String sizeString = "";
        Map<String, String> map_size = new HashMap<String, String>();
        map_size.put("20509", "尺码");
        map_size.put("20518", "尺码");
        map_size.put("20549", "尺码");

        //自定义的颜色
        Map<String, String> map_color = new HashMap<String, String>();
        map_color.put("1627207", "颜色");

        //自定义属性的map
        List<String> list_p = new ArrayList<String>();
        LinkedHashMap<String, String> map_prop_myself = new LinkedHashMap<String, String>();
        if (input_custom_cpv != null && input_custom_cpv.trim().length() > 0) {
            String cpvs[] = input_custom_cpv.split(";");
            if (cpvs.length > 0) {
                for (int i = 0; i < cpvs.length; i++) {
                    String ses = cpvs[i];
                    String seeStrings[] = ses.split(":");
                    if (seeStrings.length == 3) {
                        String keyString = map_size.get(seeStrings[0]);
                        if (keyString == null || keyString.length() <= 0) {
                            keyString = map_color.get(seeStrings[0]);
                        }
                        map_prop_myself.put(seeStrings[0] + ":" + seeStrings[1] + ":" + seeStrings[2], seeStrings[0] + ":" + seeStrings[1] + ":" + keyString + ":" + seeStrings[2]);
                        list_p.add(seeStrings[0] + ":" + seeStrings[1]);
                    }

                }
            }

        }

        if (list_p.size() > 0) {
            for (int i = 0; i < list_p.size(); i++) {
                //props=props.replaceAll(list_p.get(i)+";", "");
                props = props.replaceAll(list_p.get(i), "");
            }
        }

        String props_new = "";
        if(props!=null){
            String[] propss = props.split(";");
            if (propss.length > 0) {
                for (int ki = 0; ki < propss.length; ki++) {
                    String ss[] = propss[ki].split(":");
                    if (ss.length > 1) {
                        int p = ss[1].indexOf("-");
                        //System.out.println(p);
                        if (p == -1) {
                            if (ki == 0) {
                                props_new += ss[0] + ":" + ss[1];
                            } else {
                                props_new += ";" + ss[0] + ":" + ss[1];
                            }
                        }
                    }
                }
            }
            props = props_new;
            pnc = propAlias;
            if (pnc.length() >= 1) {
                pnc += ";";
            }

            List<Long> list_pid=new ArrayList<> ();
            List<Long> list_vid=new ArrayList<> ();
            if(props!=null){

            String prss[]=props.split (";");
                if (propss.length > 0) {
                    for(int i=0;i<prss.length;i++){
                        String prs=prss[i];
                        if(!"".equals (prs)) {
                            String pidvids[] = prs.split (":");
                            if(pidvids.length>0) {
                                list_pid.add (new Long (pidvids[0]));
                                list_vid.add (new Long (pidvids[1]));
                            }
                        }
                    }
                }

            }
            TaobaoPropValueExample example=new TaobaoPropValueExample ();
            example.createCriteria ().andCidEqualTo (cid).andPidIn (list_pid).andVidIn (list_vid);
            List<PropBean> list=new ArrayList<> ();
            List<TaobaoPropValue> list_tpv= taobaoPropValueMapper.selectFieldsByExample (example,FieldUtil.codeFields ("pid,prop_name,vid,name,name_alias,status,sort_order"));
            if(list_tpv.size ()>0){
                for(TaobaoPropValue tpv:list_tpv){
                    PropBean pb=new PropBean ();
                    pb.setName (tpv.getName ());
                    pb.setNameAlias (tpv.getNameAlias ());
                    pb.setPid (tpv.getPid ());
                    pb.setPropName (tpv.getPropName ());
                    pb.setSortOrder (tpv.getSortOrder ());
                    pb.setStatus (tpv.getStatus ());
                    pb.setVid (tpv.getVid ());
                    list.add (pb);
                }
            }

            LinkedHashMap<String, PropBean> map_prop_order = new LinkedHashMap<String, PropBean>();//过滤重复
            String keyString = "";
            for (int i = 0; i < list.size(); i++) {
                keyString = list.get(i).getPid() + ":" + list.get(i).getVid() + ":" + list.get(i).getPropName() + ":" + list.get(i).getName();
                map_prop_order.put(keyString, list.get(i));
            }

            int map_s = map_prop_order.size() - 1;
            int ik = 0;

            for (java.util.Map.Entry<String, PropBean> entry : map_prop_order.entrySet()) {
                PropBean pBean = entry.getValue();
                if (ik == map_s) {
                    pn += pBean.getPid() + ":" + pBean.getVid() + ":" + pBean.getPropName() + ":" + pBean.getName();
                    if (pBean.getNameAlias()!=null&&!pBean.getName().equals(pBean.getNameAlias())) {
                        pnc += pBean.getPid() + ":" + pBean.getVid() + ":" + pBean.getNameAlias();
                    }

                } else {
                    pn += pBean.getPid() + ":" + pBean.getVid() + ":" + pBean.getPropName() + ":" + pBean.getName() + ";";
                    if (pBean.getNameAlias()!=null&&!pBean.getName().equals(pBean.getNameAlias())) {
                        pnc += pBean.getPid() + ":" + pBean.getVid() + ":" + pBean.getNameAlias() + ";";
                    }
                }
                CatStr cStr = dealSizeColor(pBean, colorString, sizeString);
                colorString = cStr.getColorString();
                sizeString = cStr.getSizeString();
                ik++;

            }
            //再加上map里的值

            //Map<String, String> map = new HashMap<String, String>();
            for (java.util.Map.Entry<String, String> entry : map_prop_myself.entrySet()) {
                // entry.getKey();
                //entry.getValue();
                pn += ";" + entry.getValue();
                pnc += entry.getKey() + ";";
            }
        }
        //货号
        String goodsNo = "";

        if (inputPids != null && inputPids.length() > 0) {
            if (inputPids.contains("13021751")) {//商品编码
                //开始处理
                String goodsnoids[] = inputPids.split(",");

                String goodsnos[] = inputValues.split(",");
                for (int i = 0; i < goodsnoids.length; i++) {
                    if (goodsnoids[i].equals("13021751")) {
                        goodsNo = goodsnos[i];
                    }
                }
            }

        }

        if("".equals(goodsNo)){
            goodsNo=outer_id;
        }
        cs.setGoodsNo(goodsNo);
        if(goodsNo!=null&&!"".equals(goodsNo))
            pn+=";13021751:"+goodsNo.hashCode()+":货号:"+goodsNo;

        cs.setPn(pn);
        cs.setPnc(pnc);
        cs.setColorString(colorString);
        cs.setSizeString(sizeString);
        //System.out.println(pn);
        return cs;

    }

    public CatStr dealSizeColor(PropBean pBean,String colorString,String sizeString){
        CatStr csCatStr=new CatStr();
        if(checkColor(pBean)){//颜色
            colorString+=" "+pBean.getName();
        }
        if(checkSize(pBean)){//尺码
            sizeString+=" "+pBean.getName();
        }
        csCatStr.setColorString(colorString);
        csCatStr.setSizeString(sizeString);
        return csCatStr;
    }
    /**
     *
     *=========================================================
     *@方法名：checkColor
     *@功能： 校验颜色分类
     *@param pb
     *@return:boolean
     *=========================================================
     */
    public static boolean checkColor(PropBean pb){
        if(pb.getPid().equals ("1627207")){
            return true;
        }
        if(pb.getPropName().equals ("颜色")){
            return true;
        }
        if(pb.getPropName().equals("颜色分类")){
            return true;
        }
        return false;
    }


    /**
     *
     *=========================================================
     *@方法名：checkSize
     *@功能： 校验尺码分类
     *@param pb
     *@return:boolean
     *=========================================================
     */
    public static boolean checkSize(PropBean pb){
        if(pb.getPid().equals("20509")){
            return true;
        }
        if(pb.getPid().equals("20518")){
            return true;
        }
        if(pb.getPid().equals("20549")){
            return true;
        }
        if(pb.getPropName().equals("尺寸")){
            return true;
        }
        if(pb.getPropName ().equals ("尺码")){
            return true;
        }
        if(pb.getPropName().equals ("鞋码")){
            return true;
        }
        if(pb.getPid ().equals("122216343")){
            return true;
        }

        return false;
    }

    public static  String getgoodsId(Long storeId,Integer pki){
        String orderNo = "" ;
        UUID uuid = UUID.randomUUID();
        //String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat ("yyyyMMddHHMMSS").format(new Date ());
        sdf="";
        orderNo = uuid.toString().substring(0, 5);
        orderNo = orderNo + sdf ;
        String sorderNo="";
        if(orderNo.length ()>0){
            for(int i=0;i<orderNo.length ();i++){
                char se= orderNo.charAt (i);
                String sse=se+"";
                int ise=se;
                if(isNumeric(sse)){
                    int pse=Integer.parseInt (sse);
                    ise=pse;
                }

                sorderNo+=ise;
            }
        }
        sorderNo=storeId+"00"+pki+"0"+sorderNo;
        if(sorderNo.length ()>=19){
            sorderNo=sorderNo.substring (0,19);
        }
        return sorderNo ;
    }


    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            //System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
