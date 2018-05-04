<#assign $pageid="distributionOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>配货订单 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__distributionOrder_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__distributionOrder_js.ftl">
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
<#list [{"fields":[{"name":"goodsNo","value":""+query.goodsNo}]}] as $it>
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
            <li class="xzPrice">星座网代发(元)</li>
            <li class="payMoney">总价(元)</li>
        </ul>
    </div>
    <#if (orderGoods?size) gt 0>
        <#list orderGoods as order>
        <div class="orderItem clearfix">
            <div class="childOrderList fl clearfix">
<div class="childOrderItem fl">
    <div class="goods goodsDetail fl clearfix">
        <a class="imgBox fl" href="http://www.571xz.com/item.htm?id=${order.goodsId!}">
            <img src="${order.imgsrc!}_80x80.jpg" width="80" height="80">
        </a>
        <div class="goodsCon">
            <p>货号：${order.goodsNo!}</p>
            <a href="http://www.571xz.com/item.htm?id=${order.goodsId!}" target="_blank" class="goodsTitle" title="${order.title!}">${order.title!}</a>
            <p class="fcF40">&yen;${order.price!}</p>
        </div>
    </div>
    <div class="childOrderInfoBox fl">
        <#list order.skus as sku>
        <div class="childOrderInfo clearfix">
            <div class="sku fl">
                <span class="ellip color" title="${sku.color!}">${sku.color!}</span><span>${sku.size!}</span>
            </div>
            <div class="num fl">x${sku.num!}</div>
        </div>
        </#list>
    </div>
    <div class="xzPriceBox fcF40 fl">${order.xzPrice!}</div>
    <div class="payMoney fr">
        <p class="fcF40">${order.tradePay!}</p>
        <p>共${order.totalCount!}件</p>
    </div>
</div>
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