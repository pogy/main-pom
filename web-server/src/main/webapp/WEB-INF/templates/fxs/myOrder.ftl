<#assign $pageid="myOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>我的订单 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__myOrder_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__myOrder_js.ftl">
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
<#list [{"fields":[{"name":"status","value":""+query.status},{"name":"goodsNo","value":""+query.goodsNo},{"name":"st","value":query.st,"timeFormat":"yyyy-MM-dd"},{"name":"et","value":query.et,"timeFormat":"yyyy-MM-dd"},{"name":"orderId","value":""+query.orderId},{"name":"receiver","value":""+query.receiver},{"name":"telePhone","value":""+query.telePhone},{"name":"orderType","value":""+query.orderType}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="myOrderTopTips fcF40" id="myOrderTopTips"></div>
<div class="pageTabs clearfix yahei">
    <ul>
        <li <#if !query.status>class="select"</#if>><a href="myOrder.htm">所有订单</a></li>
        <li <#if query.status == "1">class="select"</#if>><a href="myOrder.htm?status=1">待付款</a></li>
        <li <#if query.status == "2">class="select"</#if>><a href="myOrder.htm?status=2">已付款</a></li>
        <li <#if query.status == "3">class="select"</#if>><a href="myOrder.htm?status=3">已发货</a></li>
        <li <#if query.status == "4">class="select"</#if>><a href="myOrder.htm?status=4">交易完成</a></li>
        <li <#if query.status == "5">class="select"</#if>><a href="myOrder.htm?status=5">交易关闭</a></li>
    </ul>
</div>
<div class="searchBox clearfix">
    <ul>
        <li><label>商品货号：</label><input type=text name="goodsNo" <#if query.goodsNo??>value="${query.goodsNo!}"</#if>></li>
        <li>
            <label>时间：</label><input type=text class="jqDatepicker slInput" name="startTime" placeholder="请选择时间范围起始" <#if query.st??>value="${query.st!}"</#if> data-format="%Y-%M-%D"><span class="divideLine">-</span><input type=text class="jqDatepicker slInput" name="endTime" placeholder="请选择时间范围起始" <#if query.et??>value="${query.et!}"</#if> data-format="%Y-%M-%D">
        </li>
        <li>
            <label>订单类型：</label>
            <select name="orderType">
                <option value="">全部</option>
                <option value="1" <#if query.orderType == "1">selected</#if>>淘宝</option>
                <option value="2" <#if query.orderType == "2">selected</#if>>非淘宝</option>
            </select>
        </li>
        <li><label>订单编号：</label><input type=text name="orderId" <#if query.orderId??>value="${query.orderId!}"</#if> maxlength="20"></li>
        <li><label>收货人信息：</label><input type=text name="receiver" placeholder="收货人姓名" class="slInput" <#if query.receiver??>value="${query.receiver!}"</#if>><span class="divideLine"></span><input type=text name="telePhone" placeholder="收货人手机号码" class="slInput" <#if query.telePhone??>value="${query.telePhone!}"</#if>></li>
        <li class="marginLeft">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         searchBtn"
        jbtn="searchBtn"
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
        搜索订单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </li>
    </ul>
</div>
<div id="orderList" class="dataList orderList">
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
<div class="batchOpe">
    <#if session_user_redis__.otherPlatform.__moreOrder__ == true><!--批量操作的权限验证-->
<#list [{}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="orderAllCheckBox"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        全选
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
        <#if query.status == "1" || !query.status>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-white-o
        "
        jbtn="batchPay"
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
        批量付款
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </#if>
        <#if query.status == "3" || !query.status>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-white-o
        "
        jbtn="batchPost"
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
        批量标记淘宝发货
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </#if>
    </#if>
</div>
    <#if (orders?size) gt 0>
        <#list orders as order>
        <div class="orderItem clearfix <#if order.mainState == 4 || order.mainState == 5>finish</#if>" data-id="${order.orderId!}" data-mainstate="${order.mainState!}">
            <div class="orderHead fl">
                <#if session_user_redis__.otherPlatform.__moreOrder__ == true>
                    <#if order.mainState == 2 || order.mainState == 4 || order.mainState == 5>
<#list [{}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        disabled
">
    <input
        type="checkbox"
        autocomplete="off"
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
            </#if>
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
            disabled
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                    <#else>
<#list [{}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
            </#if>
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="orderAllCheckBox"
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                    </#if>
                </#if>
                <span class="fc6 mr">订单编号：${order.orderId!}</span>
                <span class="fc6 mr">时间：${order.tradeTime!}</span>
                <b class="fr delete" jbtn="deleteBtn" data-id="${order.orderId!}"></b>
            </div>
            <div class="childOrderList fl">
                <#list order.childOrders as childOrder>
<ul class="childOrderItem <#if childOrder_index == (order.childOrders?size) - 1>lastChildOrder</#if> clearfix">
    <li class="goods goodsDetail">
        <a class="imgBox fl" href="//www.571xz.com/item.htm?id=${childOrder.goodsId!}">
            <img src="${childOrder.imgsrc!}_80x80.jpg" width="80" height="80">
        </a>
        <div class="goodsCon">
            <a href="//www.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank" class="goodsTitle" title="${childOrder.title!}">${childOrder.title!}</a>
            <p class="goodsSku fc9">颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </div>
    </li>
    <li class="price yahei fs14">&yen;${childOrder.price!}</li>
    <li class="num">
        <p class="fs14">${childOrder.num!}</p>
        <#if childOrder.stockoutNum??>
        <div class="pr stockoutNum">
            <p class="fcF40">
                <#if childOrder.haveGoodsTime??><i class="icon-time"></i></#if>缺货 x${childOrder.stockoutNum!}
            </p>
            <#if childOrder.haveGoodsTime??>
            <div class="pa haveGoodsTime">
                ${childOrder.haveGoodsTime!} 有货
            </div>
            </#if>
        </div>
        </#if>
        <#if order.mainState == 2 && childOrder.haveTakeGoodsNum??>
            <p class="fc6">已拿货 x${childOrder.haveTakeGoodsNum!}</p>
        </#if>
    </li>
    <li class="opera">
        <#if order.mainState == 1 || order.mainState == 5>
        ——
        <#elseif order.mainState == 2 || order.mainState == 3 || order.mainState == 4>
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
                <#if order.mainState == 2>
                <p><a href="javascript:;" onclick="applyRefund(${childOrder.childOrderId!})">申请退款</a></p>
                <#elseif order.mainState == 3>
                <p><a href="refund.htm?childOrderId=${childOrder.childOrderId!}" target="_blank" class="fc9">申请售后</a></p>
                <#elseif order.mainState == 4>
                    <#if childOrder.restoreSaleAfterServiceIs == true>
                    <p><a href="refund.htm?childOrderId=${childOrder.childOrderId!}" target="_blank" class="fc9">申请售后</a></p>
                    <#else>
                    ——
                    </#if>
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
            <#if order.mainState == 1>
<#list [{"href":"/order/payMode.htm?orderId="+order.orderId}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         toPay"
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
        立即付款
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <#elseif order.mainState == 2>
            <p>配货中</p>
            <#elseif order.mainState == 3>
            <p>已发货</p>
            <#elseif order.mainState == 4>
            <p>交易完成</p>
            <#elseif order.mainState == 5>
            <p>交易取消</p>
            </#if>
            <p><a href="orderDetail.htm?orderId=${order.orderId!}" target="_blank" class="fc9">订单详情</a></p>
            <#if order.mainState == 1>
            <p><a href="javascript:;" onclick="cancelOrder(${order.orderId!})" class="fc9">取消订单</a></p>
            <#elseif order.mainState == 3>
            <p><a href="expressDetail.htm?orderId=${order.orderId!}" target="_blank" class="fc9">查看物流</a></p>
            </#if>
            <#if order.mainState == 3>
                <#if order.isTbOrder == true>
                    <#if order.isTbShipments == true>
                    <p>淘宝已发货</p>
                    <#else>
                    <p><b class="markingTb" jbtn="markingTb" data-id="${order.orderId!}">标记淘宝发货</b></p>
                    </#if>
                </#if>
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
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>