package com.shigu.main4.item.services.utils;

import com.opentae.data.mall.beans.ShiguShop;
import com.shigu.main4.item.exceptions.TbItemSynException;
import com.shigu.main4.item.processes.TaobaoAuthProcess;
import com.shigu.main4.item.vo.SessionVO;
import com.shigu.main4.item.vo.SynItem;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemsSellerListGetRequest;
import com.taobao.api.response.ItemsSellerListGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.shigu.main4.item.exceptions.TbItemSynException.TbItemSynExceptionEnum.*;

/**
 * Created by wxc on 2017/3/10.
 *
 *  淘宝接口调用密集服务。淘宝商品拉取服务
 *
 * @author wxc
 * @version tb_site4.0 4.0.0
 * @since tb_site4.0 4.0.0
 */
@Service
public class TaobaoItemFetchService {

    private static final Logger logger = LoggerFactory.getLogger(TaobaoItemFetchService.class);

    @Autowired
    private TaobaoAuthProcess taobaoAuthProcess;

    @Value("${taobao.app.key}")
    private String APPKEY;

    @Value("${taobao.app.secret}")
    private String SECRET;

    @Value("${taobao.app.server.url}")
    private String TOP_SERVER_URL;

    /**
     * 拉取用户淘宝店内的商品
     * @param shop 星座店铺
     * @param numIid 淘宝商品ID
     * @param nick 用户昵称
     * @return 商品传输对象
     * @throws TbItemSynException 淘宝商品同步异常
     */
    public SynItem fetchItem(ShiguShop shop, Long numIid, String nick) throws TbItemSynException {
        SessionVO session = taobaoAuthProcess.getSession(APPKEY, nick);
        if (session == null)
            throw new TbItemSynException(SESSION_OVERDUE);
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL, APPKEY, SECRET);
        ItemsSellerListGetRequest request = new ItemsSellerListGetRequest();
        request.setFields("detail_url,num_iid,title,nick,type,desc,sku,props_name,created,is_lightning_consignment,is_fenxiao,auction_point,property_alias,template_id,after_sale_id,is_xinpin,sub_stock,inner_shop_auction_template_id,outer_shop_auction_template_id,features,item_weight,item_size,with_hold_quantity,valid_thru,outer_id,auto_fill,custom_made_type_id,wireless_desc,barcode,cid,seller_cids,props,input_pids,input_str,pic_url,num,list_time,delist_time,stuff_status,location,price,post_fee,express_fee,ems_fee,has_discount,freight_payer,has_invoice,has_warranty,has_showcase,modified,increment,approve_status,postage_id,product_id,item_img,prop_img,is_virtual,is_taobao,is_ex,is_timing,video,is_3D,one_station,second_kill,violation,wap_desc,wap_detail_url,cod_postage_id,sell_promise");
        request.setNumIids(numIid.toString());
        try {
            ItemsSellerListGetResponse response = client.execute(request, session.getSession());
            if (response.isSuccess()) {
                List<Item> items = response.getItems();
                Item item;
                if (items!=null && (item = items.get(0)) != null) {
                    if (shop == null) {
                        throw new TbItemSynException(SHOP_DOES_NOT_EXIST);
                    }
                    ///////////////////////////////////////////////////
                    return TbItemSynMapper.toSynItem(item, shop, null);
                } else {
                    throw new TbItemSynException(TB_ITEM_DOES_NOT_EXIST);
                }
            } else {
                throw new TbItemSynException("淘宝接口调用失败:" + response.getMsg() + ", " + response.getSubMsg());
            }
        } catch (ApiException e) {
            throw new TbItemSynException(TAOBAO_CLIENT_ERROR);
        }
    }
}
