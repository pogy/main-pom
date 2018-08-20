<#assign $pageid="myTbOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>淘宝订单 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__myTbOrder_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__myTbOrder_js.ftl">
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
<#list [{"fields":[{"name":"st","value":""+query.st},{"name":"et","value":""+query.et},{"name":"orderId","value":""+query.orderId}]}] as $it>
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
        <li class="select"><a>淘宝已卖出商品</a></li>
    </ul>
</div>
<div class="searchBox clearfix">
    <ul>
        <li><label>订单编号：</label><input type="text" name="orderId" <#if query.orderId??>value="${query.orderId!}"</#if>></li>
        <li>
            <label>成交时间：</label><input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择时间范围起始" <#if query.st??>value="${query.st!}"</#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择时间范围起始" <#if query.et??>value="${query.et!}"</#if>>
        </li>
        <li>
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
<div id="orderList" class="orderList orderDetail">
<div class="listHead clearfix">
    <ul>
        <li class="goods">商品</li>
        <li class="tbPrice">淘宝价格</li>
        <li class="xzPrice">星座网价格</li>
        <li class="num">数量</li>
        <li class="profits">利润(元)</li>
        <li class="opera">操作</li>
    </ul>
</div>
<div class="tbOrderTip tac fcF40">
    温馨提示：只有淘宝中出售中的商品与四季星座网商品库中的商品互相关联，才能准确无误下单哦！
</div>
    <div class="orderBox">
        <#if (orders?size) gt 0>
            <#list orders as order>
<div class="orderItem" data-id="${order.tbId!}">
    <div class="orderHead">
        <span class="fc6">订单编号：<em class="fs14">${order.tbId!}</em></span>
        <span class="fc6">成交时间：<em class="fs14">${order.time!}</em></span>
        <#if order.lastTime??>
        <em class="fr fcBlue">最近下单时间：${order.lastTime!}</em>
        </#if>
    </div>
    <div class="orderInfo">
        <#list order.childOrders as childOrder>
<div class="childOrderItem" name="${childOrder.numiid!}" data-webSite="${childOrder.webSite!}">
    <ul class="clearfix">
        <li class="goods clearfix borderBot" data-imgSrc="${childOrder.imgSrc!}" data-title="${childOrder.title!}" data-goodsNo="${childOrder.goodsNo!}" data-price="<#if childOrder.newTbPrice??>${childOrder.newTbPrice!}<#else>${childOrder.oldTbPrice!}</#if>" data-tbId="${childOrder.numiid!}">
            <span class="imgBox fl">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="80" height="80">
            </span>
            <div class="goodsInfo fl">
                <span title="${childOrder.title!}">${childOrder.title!}</span>
                <p class="fc9" title="颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}">颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}</p>
                <#if childOrder.goodsNo??>
                <p class="goodsNoShow" title="已关联货号：${childOrder.goodsNo!}">已关联货号：${childOrder.goodsNo!}</p>
                <p class="goodsGlBtn">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-white-o
         glBtn"
        jhand="openGlWindow"
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
        重新关联
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
                <#else>
                <p class="goodsNoShow" title="">已关联货号：<em class="fcF40">暂未关联</em></p>
                <p class="goodsGlBtn">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange-o
         toGlBtn"
        jhand="openGlWindow"
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
        立即关联
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
                </#if>
            </div>
        </li>
        <li class="tbPrice yahei borderBot">
            <p class="<#if childOrder.newTbPrice??>oldTbPrice</#if>">&yen;${childOrder.oldTbPrice!}</p>
            <#if childOrder.newTbPrice??>
            <p class="fs14">&yen; ${childOrder.newTbPrice!}<i class="editIcon"></i></p>
            </#if>
        </li>
        <li class="xzPrice yahei borderBot">
            <#if childOrder.goodsType == 1>
            <p class="fs12 fcF40">商品已下架</p>
            <#elseif childOrder.goodsType == 2>
            <p class="fs12 fcF40">该颜色尺码已失效</p>
            <#else>
                <#if childOrder.xzPrice??>
                <p class="fs14">&yen; ${childOrder.xzPrice!}</p>
                <#else>
                <p class="fs12 fcF40">暂未关联</p>
                </#if>
            </#if>
        </li>
        <li class="num fs14 borderBot">${childOrder.num!}</li>
        <li class="profits fcF40 fs16 borderLe">
            <#if childOrder_index == 0>
            ${order.profits!}
            </#if>
        </li>
        <li class="opera borderLe">
            <#if childOrder_index == 0>
                <#if order.canOrder == true>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         toOrder"
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
        立即下单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                <#else>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         notOrder"
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
        立即下单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                </#if>
            </#if>
        </li>
    </ul>
</div>
        </#list>
    </div>
    <div class="receAddress">
        ${order.address!}
    </div>
</div>
            </#list>
        <#else>
<#list [{}] as $it>
<div class="dataEmpty tac">
    <i class="errorPng"></i>
    <#if $it.errorCon??>
        <p class="tac fs14 fc6 yahei">${$it.errorCon!}</p>
    <#else>
        <p class="tac fs14 fc6 yahei">暂无数据！</p>
    </#if>
</div>
</#list>
        </#if>
    </div>
</div>
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
<#include "/common/xz__fixedBox.ftl">
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>