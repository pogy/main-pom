package com.shigu.daifa.services;

import com.opentae.data.daifa.beans.DaifaCallExpress;
import com.opentae.data.daifa.interfaces.DaifaCallExpressMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类编号
 * @类名称：DaifaScanService
 * @文件路径：com.shigu.daifa.services.DaifaScanService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/27 10:57
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class DaifaScanService {

    @Autowired
    private DaifaCallExpressMapper daifaCallExpressMapper;

    public String queryPackageCode(String dfTradeId){

        DaifaCallExpress press=  daifaCallExpressMapper.selectByPrimaryKey (dfTradeId);
        if(press!=null){
            if(press.getPackageCode ()!=null&&"".equals(press.getPackageCode ())){
                return press.getPackageCode ();
            }else{
                JSONObject obj=JSONObject.fromObject  (press.getJsonData ());

                JSONObject order = obj.getJSONObject("Order");//快递鸟返回订单快递信息
                if(order==null||order.size ()==0){
                    return "";
                }

                Object pc=order.get("PackageCode");//集包编码
                if(pc==null){
                    return "";
                }
                return pc.toString ();
            }
        }else{
            return "";
        }
    }
}
