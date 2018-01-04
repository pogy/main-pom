<#assign $pageid="shManaOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>售后管理 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__shManaOrder_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__shManaOrder_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<#list [{"fields":[{"name":"shStatus","value":""+query.shStatus}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="pageTabs clearfix yahei">
    <ul>
        <li class="select"><a>售后订单</a></li>
    </ul>
</div>
<div id="orderList" class="orderList orderDetail">
    <div class="listHead clearfix">
        <ul>
            <li class="goods goodsHead">商品</li>
            <li class="price">单价</li>
            <li class="num">数量</li>
            <li class="opera">商品操作</li>
            <li class="payMoney">实付款(元)</li>
            <li class="orderState">交易状态</li>
        </ul>
    </div>
    <#if (orders?size) gt 0>
        <#list orders as order>
        <div class="orderItem clearfix <#if order.mainState == 4>finish</#if>">
            <div class="orderHead fl">
                <span class="fc6">订单编号：${order.orderId!}</span>
                <span class="fc6">成交时间：${order.tradeTime!}</span>
                <b class="fr delete" jbtn="deleteBtn" data-id="${order.orderId!}"></b>
            </div>
            <div class="childOrderList fl">
                <#list order.childOrders as childOrder>
<ul class="childOrderItem <#if childOrder_index == (order.childOrders?size) - 1>lastChildOrder</#if> clearfix">
    <li class="goods goodsDetail">
        <div class="imgBox fl">
            <img src="${childOrder.imgsrc!}_80x80.jpg" width="80" height="80">
        </div>
        <div class="goodsCon">
            <a href="http://www.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank" class="goodsTitle" title="${childOrder.title!}">${childOrder.title!}</a>
            <p class="goodsSku fc9">颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </div>
    </li>
    <li class="price yahei">&yen;${childOrder.price!}</li>
    <li class="num">
        ${childOrder.num!}
        <#if childOrder.stockoutNum??>
        <div class="pr stockoutNum">
            <p class="fcF40"><i class="icon-c-warn"></i>缺货 x${childOrder.stockoutNum!}</p>
            <#if childOrder.haveGoodsTime??>
            <div class="pa haveGoodsTime">
                ${childOrder.haveGoodsTime!} 有货
            </div>
            </#if>
        </div>
        </#if>
    </li>
    <li class="opera">
        <#if order.mainState == 3 || order.mainState == 4>
            <#if childOrder.afterSales?? && (childOrder.afterSales?size) gt 0>
                <#if childOrder.refundCount != childOrder.num && childOrder.hasAfter == false && order.mainState == 3>
                <p><a href="refund.htm?childOrderId=${childOrder.childOrderId!}" target="_blank" class="fc9">申请售后</a></p>
                </#if>
                <#list childOrder.afterSales as afterSale>
                    <#if afterSale.type == 1>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="onlyRefund.htm?refundId=${afterSale.refundId!}" target="_blank">申请退款成功 x${afterSale.afterSaleNum!}</a></p>
                        </#if>
                    </#if>
                    <#if afterSale.type == 2>
                        <#if afterSale.state == 2>
                        <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" target="_blank">退货退款完成x${afterSale.afterSaleNum!}</a></p>
                        <#elseif afterSale.state == 1>
                        <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" data-id="${afterSale.refundId!}" jbtn="afterSaleBtn" target="_blank">售后处理中<#if afterSale.newAfterSaleInfoIs == true><i class="afterSaleDot"></i></#if></a></p>
                            <#list afterSale.afterSaling as after>
                                <#if after.type == 1>
                                <p class="fc6">售后已同意</p>
                                <#elseif after.type == 2>
                                <p class="fc6">售后已发货</p>
                                <#elseif after.type == 3>
                                <p class="fc6">档口退款失败 x${after.opeAfterSaleNum!}</p>
                                <#elseif after.type == 4>
                                <p class="fc6">档口已退款 x${after.opeAfterSaleNum!}</p>
                                <#elseif after.type == 5>
                                <p class="fc6">退款金额已更改</p>
                                </#if>
                            </#list>
                        <#elseif afterSale.state == 3>
                        <div class="refuseAfterSale pr">
                            <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" target="_blank"><i class="icon-c-warn"></i>退货申请已拒绝</a></p>
                            <div class="pa refuseReason fc6">
                                ${afterSale.refuseReason!}
                            </div>
                        </div>
                        <#elseif afterSale.state == 4>
                        <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" target="_blank">档口退货失败</a></p>
                        </#if>
                    </#if>
                    <#if afterSale.type == 3>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="exchange.htm?refundId=${afterSale.refundId!}" target="_blank">换货完成</a></p>
                        <#elseif afterSale.state == 1>
                        <p><a class="fcF40" href="exchange.htm?refundId=${afterSale.refundId!}" data-id="${afterSale.refundId!}" jbtn="afterSaleBtn" target="_blank">售后处理中<#if afterSale.newAfterSaleInfoIs == true><i class="afterSaleDot"></i></#if></a></p>
                            <#list afterSale.afterSaling as after>
                                <#if after.type == 1>
                                <p class="fc6">售后已同意</p>
                                <#elseif after.type == 2>
                                <p class="fc6">售后已发货</p>
                                </#if>
                            </#list>
                        <#elseif afterSale.state == 3>
                        <div class="refuseAfterSale pr">
                            <p><a class="fcF40" href="exchange.htm?refundId=${afterSale.refundId!}" target="_blank"><i class="icon-c-warn"></i>换货申请已拒绝</a></p>
                            <div class="pa refuseReason fc6">
                                ${afterSale.refuseReason!}
                            </div>
                        </div>
                        </#if>
                    </#if>
                    <#if afterSale.type == 4>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="onlyRefund.htm?refundId=${afterSale.refundId!}" target="_blank">自动退款 x${afterSale.afterSaleNum!}</a></p>
                        </#if>
                    </#if>
                    <#if afterSale.type == 5>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="onlyRefund.htm?refundId=${afterSale.refundId!}" target="_blank">自动退款 x${afterSale.afterSaleNum!}</a></p>
                        </#if>
                    </#if>
                </#list>
            <#else>
                <#if order.mainState == 3>
                <p><a href="refund.htm?childOrderId=${childOrder.childOrderId!}" target="_blank" class="fc9">申请售后</a></p>
                <#elseif order.mainState == 4>
                ——
                </#if>
            </#if>
        </#if>
    </li>
    <li class="payMoney">
        <#if childOrder_index == 0>
        <p class="totalPay fs16">${order.tradePay!}</p>
        <p class="fc9">含快递费：${order.postPay!}</p>
        <p class="fc9">含服务费：${order.serverPay!}</p>
            <#if order.isTbOrder == true>
            <i class="tbOrderIcon"></i>
            </#if>
        </#if>
    </li>
    <li class="orderState">
        <#if childOrder_index == 0>
            <#if order.mainState == 3>
            <p>已发货</p>
            <#elseif order.mainState == 4>
            <p>交易完成</p>
            </#if>
            <p><a href="orderDetail.htm?orderId=${order.orderId!}" target="_blank" class="fc9">订单详情</a></p>
            <#if order.mainState == 3>
            <p><a href="expressDetail.htm?orderId=${order.orderId!}" target="_blank" class="fc9">查看物流</a></p>
            </#if>
        </#if>
    </li>
</ul>
                </#list>
            </div>
        </div>
        </#list>
    <#else>
        <p class="fs20 fc6 tac noOrder">暂无订单！</p>
    </#if>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">