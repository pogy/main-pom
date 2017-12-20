package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @类编号
 * @类名称：OrderDetailExpressVO
 * @文件路径：com.shigu.main4.order.vo.OrderDetailExpressVO
 * @内容摘要：订单详情中的--快递信息
 * @编码作者：gzy
 * @创建日期：2017/7/21 11:01
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderDetailExpressVO implements Serializable{

    private String name;//快递名

    private String id;//快递单号

    private List<OrderDetailExpressDetailVO> detail;//快递详情

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public List<OrderDetailExpressDetailVO> getDetail () {
        return detail;
    }

    public void setDetail (List<OrderDetailExpressDetailVO> detail) {
        this.detail = detail;
    }
}
