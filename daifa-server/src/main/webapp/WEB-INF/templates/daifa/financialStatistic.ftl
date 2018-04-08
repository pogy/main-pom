<#assign $pageid>financialStatistic</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>财务统计 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__financialStatistic_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__financialStatistic_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"time","value":""+query.time}]}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="orderSearch orderSearchBox">
    <ul>
        <li><label>日期查询：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="time" placeholder="请选择时间" <#if query.time??> value="${query.time!}" </#if>></li>
        <li>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
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
        搜索
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></li>
    </ul>
</div>
<div class="financialList">
    <h3 class="fs20 fc3">今日所需费用 <span class="fs12 fc6">${query.time!}</span></h3>
    <ul>
        <li>
            <h4 class="fs20"><a href="financialGoodsFeeDetail.htm?time=${query.time!}">商品费用</a></h4>
            <p class="fc6">今日应拿金额${orderStatistics.allotmentFee!}元</p>
            <p class="fc6">今日已拿金额${orderStatistics.haveToTakeFee!}元</p>
        </li>
        <li>
            <h4 class="fs20">服务费</h4>
            <p class="fc6">今日订单产生的服务费${orderStatistics.daifaServerFee!}</p>
        </li>
        <li>
            <h4 class="fs20"><a href="postFeeDetail.htm?time=${query.time!}">快递费</a></h4>
            <p class="fc6">今日快递费用${orderStatistics.shipmentsFee!}</p>
        </li>
    </ul>
    <h3 class="fs20 fc3">售后</h3>
    <ul>
        <li>
            <h4 class="fs20"><a href="afterSaleStockFee.htm?time=${query.time!}">库存中的商品费用</a></h4>
            <p class="fc6">仓库中的商品费用${orderStatistics.inventoryGoodsFee!}元</p>
        </li>
        <li>
            <h4 class="fs20">要退回的商品费用</h4>
            <p class="fc6">今天要退回的商品费用${orderStatistics.inTheBackGoodsFee!}元</p>
        </li>
        <li>
            <h4 class="fs20"><a href="afterSaleRefundedFee.htm?time=${query.time!}">已经退款商品费用</a></h4>
            <p class="fc6">今日已退费用${orderStatistics.refundedGoodsFee!}元</p>
        </li>
    </ul>
</div>
    </div>
</div>