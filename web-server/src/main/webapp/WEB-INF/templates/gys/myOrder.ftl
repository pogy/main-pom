<#assign $pageid="myOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>我的订单 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__myOrder_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__myOrder_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<#list [{"fields":[{"name":"goodsNo","value":""+query.goodsNo},{"name":"orderId","value":""+query.orderId}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a>星座网代发订单</a></li>
</ul>
<div class="gysOrderSearchBox clearfix">
    <ul>
        <li><label>商品货号：</label><input type=text name="goodsNo" <#if query.goodsNo??>value="${query.goodsNo!}"</#if>></li>
        <li><label>订单编号：</label><input type=text name="orderId" <#if query.orderId??>value="${query.orderId!}"</#if> maxlength="20"></li>
        <li class="marginLeft">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
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
            <li class="sku">属性</li>
            <li class="num">数量</li>
            <li class="takeNum">拿货件数</li>
            <li class="payMoney">总价(元)</li>
        </ul>
    </div>
    <#if (orders?size) gt 0>
        <#list orders as order>
        <div class="orderItem clearfix">
            <div class="orderHead fl">
                <span class="fc6 mr">订单编号：${order.orderId!}</span>
                <span class="fc6 mr">时间：${order.tradeTime!}</span>
            </div>
            <div class="childOrderList fl clearfix">
                <div class="childOrderBox fl clearfix">
                    <#list order.childOrders as childOrder>
<div class="childOrderItem fl">
    <div class="goods goodsDetail fl clearfix">
        <a class="imgBox fl" href="//www.571xz.com/item.htm?id=${childOrder.goodsId!}">
            <img src="${childOrder.imgsrc!}_80x80.jpg" width="80" height="80">
        </a>
        <div class="goodsCon">
            <p class="fc3">货号：${childOrder.goodsNo!}</p>
            <a href="//www.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank" class="goodsTitle fc9" title="${childOrder.title!}">${childOrder.title!}</a>
            <p class="fcF40">&yen;${childOrder.price!}</p>
        </div>
    </div>
    <div class="childOrderInfoBox fl">
        <#list childOrder.skus as sku>
        <div class="childOrderInfo clearfix">
            <div class="sku fl">
                <span class="ellip color" title="${sku.color!}">${sku.color!}</span><span>${sku.size!}</span>
            </div>
            <div class="num fl">x${sku.num!}</div>
            <div class="takeNum fl">已拿<em class="fcF40"> x${sku.haveTakeGoodsNum!}</em></div>
        </div>
        </#list>
    </div>
</div>
                    </#list>
                </div>
                <div class="payMoney fr fcF40">${order.tradePay!}</div>
            </div>
        </div>
        </#list>
    <#else>
        <p class="fs20 fc6 tac noOrder">暂无订单！</p>
    </#if>
<#list [{}] as $it>
<div class="jqPagination blue" id="jqPagination0"
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