//package com.shigu.test;
//
//import com.opentae.data.daifa.beans.DaifaTrade;
//import com.opentae.data.daifa.beans.DaifaWaitSend;
//import com.opentae.data.daifa.examples.DaifaTradeExample;
//import com.opentae.data.daifa.examples.DaifaWaitSendExample;
//import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
//import com.opentae.data.daifa.interfaces.DaifaWaitSendMapper;
//import com.opentae.data.mall.beans.ItemOrder;
//import com.opentae.data.mall.beans.MemberUserSub;
//import com.opentae.data.mall.beans.TaobaoSessionMap;
//import com.opentae.data.mall.examples.ItemOrderExample;
//import com.opentae.data.mall.examples.MemberUserSubExample;
//import com.opentae.data.mall.examples.TaobaoSessionMapExample;
//import com.opentae.data.mall.interfaces.ItemOrderMapper;
//import com.opentae.data.mall.interfaces.MemberUserSubMapper;
//import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
//import net.sf.json.JSONObject;
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Refund extends BaseSpringTest {
//    @Autowired
//    ItemOrderMapper itemOrderMapper;
//    @Autowired
//    MemberUserSubMapper memberUserSubMapper;
//    @Autowired
//    TaobaoSessionMapMapper taobaoSessionMapMapper;
//    @Autowired
//    DaifaTradeMapper daifaTradeMapper;
//    @Autowired
//    DaifaWaitSendMapper daifaWaitSendMapper;
//
//
//
////    @Autowired
////    RefundBody refundBody;
//
//
////    @Test
////    public void v(){
////        List<Long> oids=new ArrayList<>();
////        oids.add(367500L);
////        refundBody.v(oids,62017090395888L,36558L);
////    }
//
//    @Test
//    public void upadss() throws IOException {
//        String idv="133442,133432,133386,133470,133394,133404,133398,133418,133476,133330,133482,133484,133350,133356,133378,133499,133538,133544,133560,133572,133575,133577,133637,133641,133643,133647,133649,133673,133510,133689,133695,133711,133759,133767,133775,133797,133825,133813,133809,133803,133835,133849,133865,133871,133891,133917,133932,133934,133938,133940,133953,133975,133963,133979,133987,134023,134057,134067,134089,134092,134094,134101,134103,134125,134142,134144,134156,134176,134234,134260,134276,134292,134327,134332,134338,134374,134418,134420,134426,134430,134454,134464,134477,134505,134555,134557,134571,134577,134579,134595,134670,134674,134680,134702,134744,134746,134758,134760,134766,134782,134786,134788,134792,134806,134826,134852,134854,134856,134858,134879,134916,134960,134962,134978,134976,135001,135010,135006,135008,135036,135043,135045,135047,135049,135051,135053,135055,135057,135059,135069,135073,135084,135166,135183,135185,135201,135213,135217,135219,135221,135243,135247,135260,135268,135280,135299,135317,135319,135325,135365,135367,135369,135383,135385,135379,135421,135460,135476,135478,135502,135524,135528";
//        String[] ids=idv.split(",");
//        List<Long> idsss=new ArrayList<>();
//        for(String id:ids){
//            idsss.add(new Long(id));
//        }
//        ItemOrderExample itemOrderExample=new ItemOrderExample();
//        itemOrderExample.createCriteria().andOidIn(idsss);
//        List<ItemOrder> os=itemOrderMapper.selectByExample(itemOrderExample);
//        for(ItemOrder o:os){
//            MemberUserSubExample memberUserSubExample=new MemberUserSubExample();
//            memberUserSubExample.createCriteria().andUserIdEqualTo(o.getUserId()).andAccountTypeEqualTo(3);
//            List<MemberUserSub> mbs=memberUserSubMapper.selectByExample(memberUserSubExample);
//            TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
//            taobaoSessionMapExample.createCriteria().andUserIdEqualTo(new Long(mbs.get(0).getSubUserKey()));
//            List<TaobaoSessionMap> taobaoSessionMaps=taobaoSessionMapMapper.selectByExample(taobaoSessionMapExample);
//            String d=Jsoup.connect("http://xb.571xz.com/inv/ddtest.json?tid="+o.getOuterId()+"&key="+taobaoSessionMaps.get(0).getSession())
//                    .ignoreContentType(true)
//                    .execute().body();
//            JSONObject obj=JSONObject.fromObject(d);
//            JSONObject trade=obj.getJSONObject("trade");
//            Object address=trade.get("receiverAddress");
//            if(address==null){
//                System.out.println(o.getUserId());
//                System.out.println(trade.toString());
//            }
////            address=removeEspecialStr(address.toString().trim());
////            String city=trade.getString("receiverCity");
////            Object towm=trade.get("receiverDistrict");
////            String prov=trade.getString("receiverState");
////
////            DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
////            daifaTradeExample.createCriteria().andTradeCodeEqualTo(o.getOid()+"");
////            List<DaifaTrade> ts=daifaTradeMapper.selectByExample(daifaTradeExample);
////            DaifaTrade t=new DaifaTrade();
////            t.setDfTradeId(ts.get(0).getDfTradeId());
////            t.setReceiverAddress(prov+" "+city+" "+(towm!=null&&!StringUtils.isEmpty(towm.toString())?(towm.toString()+" "):"")+address);
////            daifaTradeMapper.updateByPrimaryKeySelective(t);
////
////            DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
////            daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(t.getDfTradeId());
////            DaifaWaitSend s=new DaifaWaitSend();
////            s.setReceiverAddress(t.getReceiverAddress());
////            daifaWaitSendMapper.updateByExampleSelective(s,daifaWaitSendExample);
//
//        }
//
//
//
//
//    }
//    private static String removeEspecialStr(String str){
//        if(org.springframework.util.StringUtils.isEmpty(str)){
//            return str;
//        }
//        return str.replace("'","")
//                .replace("\"","")
//                .replace("#","")
//                .replace("+","")
//                .replace("&","")
//                .replace("<","")
//                .replace(">","");
//    }
//
//}
