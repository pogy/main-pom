<#assign $pageid="orderDetail">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>订单详情 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__orderDetail_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/order__orderDetail_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/order__common__header.ftl">
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="/">首页</a> &gt;
    <a href="/member/index.htm">我的星座网</a> &gt;
    <span class="fcF40">我的订单</span>
</div>
<div class="orderStatus layout fs3 clearfix">
    <#if orderStateNum == 5>
    <ul class="title cancel">
        <li>提交订单</li>
        <li class="fc9">交易取消</li>
    </ul>
    <ul class="status cancel">
        <li class="current"><i></i><span>1</span></li>
        <li class="current"><i></i><span>2</span></li>
    </ul>
    <#else>
    <ul class="title">
        <li <#if 0 lt orderStateNum> class="current" </#if>>${title!}</li>
        <li <#if 1 lt orderStateNum> class="current" </#if>>${title!}</li>
        <li <#if 2 lt orderStateNum> class="current" </#if>>${title!}</li>
        <li <#if 3 lt orderStateNum> class="current" </#if>>${title!}</li>
    </ul>
    <ul class="status">
        <li <#if 0 lt orderStateNum> class="current"</#if>><i></i><span>1</span></li>
        <li <#if 1 lt orderStateNum> class="current"</#if>><i></i><span>2</span></li>
        <li <#if 2 lt orderStateNum> class="current"</#if>><i></i><span>3</span></li>
        <li <#if 3 lt orderStateNum> class="current"</#if>><i></i><span>4</span></li>
    </ul>
    </#if>
    <ul class="time fs14 arail <#if orderStateNum == 5> cancel </#if>">
        <#list orderStateTime as time>
        <li>${time!}</li>
        </#list>
    </ul>
</div>
<div class="orderInfo layout">
    <div class="infoBox fl fc6">
        <ul>
            <li>
                <label>订单编号：</label>
                <p class="fs14 arail">${orderId!}</p>
            </li>
            <#if orderDealTime??>
            <li>
                <label>成交时间：</label>
                <p class="fs14 arail">${orderDealTime!}</p>
            </li>
            </#if>
            <li>
                <label>收货人信息：</label>
                <p>${orderAddrInfo.name!},${orderAddrInfo.phone!},${orderAddrInfo.address!}</p>
            </li>
        </ul>
    </div>
    <#if orderStateNum == 1>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：订单已提交，等待买家付款！</div>
        <p><i></i>您还有
        <span class="fcF40">
<#list [{"endTime":orderCreateTime+72*60*60*1000}] as $it>
<span id="countdown1" class="xzCountdown" data-format="%dd天%hh小时%mm分%ss秒" data-nowTime="${$it.nowTime!}" data-endTime="${$it.endTime!}"></span>
</#list>
        </span>
        未支付，72小时候自动取消订单</p>
        <div class="goto">
            您可以
<#list [{"href":"payMode.htm?orderId="+orderId}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-orange
         payBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        立即支付
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <b class="cancel" id="cancelOrderBtn">取消订单</b>
        </div>
    </div>
    <#elseif orderStateNum == 2>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：等待配货</div>
    </div>
    <#elseif orderStateNum == 3>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：订单已发货</div>
        <p><i></i><span class="fc6">${express.name!}</span> <span class="fc3 fs14 arail vm">${express.id!}</span></p>
        <div class="expressInfo">
        <#list express.detail as express>
            <#if express_index lt 2>
            <p class="nodot"><span class="fc3 fs14 arail vm">${express.date!}  ${express.time!}</span> ${express.desc!}</p>
            </#if>
        </#list>
        </div>
        <p class="nodot"><a href="expressDetail.htm?orderId=${orderId!}" target="_blank">查看详情</a></p>
    </div>
    <#elseif orderStateNum == 4>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：交易完成</div>
    </div>
    <#elseif orderStateNum == 5>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：订单已取消</div>
    </div>
    </#if>
</div>
<script modulepath="order/orderDetail#orderInfo">
var orderId = '${orderId!}'
</script>
<div class="orderGoodsInfo layout">
    <div class="goodsInfoHead">
        <ul>
            <li class="goodsDesc">商品</li>
            <li class="goodsAttrs">属性</li>
            <li class="goodsCount">数量</li>
            <li class="goodsPrice">价格</li>
            <li class="goodsStatus">订单状态</li>
        </ul>
    </div>
    <div class="goodsList clearfix">
        <#list childOrders as childOrder>
        <ul>
            <li class="goodsDesc">
                <a href="http://www.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank" class="fl"><img src="${childOrder.imgsrc!}"></a>
                <div class="goodsTitle pr fl">
                    <h4><a href="http://www.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank">${childOrder.title!}</a></h4>
                    <p class="marketCode fwb pa">商品货号：${childOrder.goodsNo!}</p>
                </div>
            </li>
            <li class="goodsAttrs fwb fc3">${childOrder.color!} ${childOrder.size!}</li>
            <li class="goodsCount fs14"><span class="yahei fwb">${childOrder.num!}</span></li>
            <li class="goodsPrice fs14 yahei">&yen; <span class="fwb">${childOrder.price!}</span></li>
            <li class="goodsStatus">
                <#if orderStateNum == 1>
                    <span class="fcF40">待付款</span>
                <#elseif orderStateNum == 2 || orderStateNum == 3 || orderStateNum == 4>
                    <#if childOrder.afterSales?? && (childOrder.afterSales?size) gt 0>
                        <#list childOrder.afterSales as afterSale>
                            <#if afterSale.type == 1>
                                <#if afterSale.state == 2>
                                <span class="fcBlue">申请退款成功 x${afterSale.afterSaleNum!}</span>
                                </#if>
                            </#if>
                            <#if afterSale.type == 2>
                                <#if afterSale.state == 2>
                                <p class="fcF40">退货退款完成x${afterSale.afterSaleNum!}</p>
                                <#elseif afterSale.state == 1>
                                <p class="fcF40">售后处理中</p>
                                <#elseif afterSale.state == 3>
                                <p class="fcF40">退货申请已拒绝</p>
                                <#elseif afterSale.state == 4>
                                <p class="fcF40">档口退货失败</p>
                                </#if>
                            </#if>
                            <#if afterSale.type == 3>
                                <#if afterSale.state == 2>
                                <p class="fcF40">换货完成</p>
                                <#elseif afterSale.state == 1>
                                <p class="fcF40">售后处理中</p>
                                <#elseif afterSale.state == 3>
                                <p class="fcF40">换货申请已拒绝</p>
                                </#if>
                            </#if>
                            <#if afterSale.type == 4>
                                <#if afterSale.state == 2>
                                <p class="fcBlue">自动退款 x${afterSale.afterSaleNum!}</p>
                                </#if>
                            </#if>
                            <#if afterSale.type == 5>
                                <#if afterSale.state == 2>
                                <p class="fcBlue">自动退款 x${afterSale.afterSaleNum!}</p>
                                </#if>
                            </#if>
                        </#list>
                    <#else>
                        <#if orderStateNum == 2>
                        <span>待配货</span>
                        <#elseif orderStateNum == 3>
                        <span>已发货</span>
                        <#elseif orderStateNum == 4>
                        <span>交易完成</span>
                        </#if>
                    </#if>
                <#elseif orderStateNum == 5>
                    <span>交易已取消</span>
                </#if>
            </li>
        </ul>
        </#list>
    </div>
    <div class="goodsTotal clearfix">
        <label>运费总计：</label><span class="yahei fs14">&yen;<em class="fwb">${total.expressPrice!}</em></span><br>
        <label>服务费总计：</label><span class="yahei fs14">&yen;<em class="fwb">${total.servicePrice!}</em></span><br>
        <label>商品总金额：</label><span class="yahei fs14">&yen;<em class="fwb">${total.childOrdersPrice!}</em></span>
        <p>
            <#if orderStateNum == 0>
                <label>待付款总金额：</label>
            <#else>
                <label>已付款总金额：</label>
            </#if>
            <span class="yahei fs14 fcF40">&yen;<em class="fwb">${total.orderTotalPrice!}</em></span>
        </p>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">