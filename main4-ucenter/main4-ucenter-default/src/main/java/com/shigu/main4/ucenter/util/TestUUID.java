package com.shigu.main4.ucenter.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @类编号
 * @类名称：TestUUID
 * @文件路径：com.shigu.main4.ucenter.util.TestUUID
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/4 13:47
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TestUUID {
    public static void main(String args[]){

        String se="24806002002100101102";
        Long goodsId=Long.parseLong (se);
        System.out.println (goodsId);

        //System.out.println(getgoodsId(24806L,12));
    }

    public static  String getgoodsId(Long storeId,Integer pki){
        String orderNo = "" ;
        UUID uuid = UUID.randomUUID();
        String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat ("yyyyMMddHHMMSS").format(new Date ());
        orderNo = uuid.toString().substring(0, 8);
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

              // System.out.println(se+"="+ise);
                sorderNo+=ise;
            }
        }
        sorderNo=storeId+"00"+pki+"000"+sorderNo;

       // System.out.println("orderNo="+orderNo+"@@@sorderNo="+sorderNo);

        return sorderNo ;
    }


    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
