package com.item.test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemSellerGetRequest;
import com.taobao.api.response.ItemSellerGetResponse;
import org.junit.Test;

public class TbItemDetail {


    @Test
    public void itemDetail() throws ApiException {
        String url="http://gw.api.taobao.com/router/rest";
        String appkey="21720662";
        String secret="dc0130db87142f81cb85374baeb2f285";
        String sessionKey="62001305e8609f7c567c917726118660db9fc3ZZce6fh62106794041";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        ItemSellerGetRequest req = new ItemSellerGetRequest();
        req.setFields("num_iid,title,nick,price,approve_status,sku,created");
        req.setNumIid(556570136980L);
        ItemSellerGetResponse rsp = client.execute(req, sessionKey);
        System.out.println(rsp.getBody());
    }
}
