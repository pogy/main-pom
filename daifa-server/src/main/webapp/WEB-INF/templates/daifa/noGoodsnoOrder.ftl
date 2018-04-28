<#assign $pageid>noGoodsnoOrder</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>无货号订单 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__noGoodsnoOrder_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__noGoodsnoOrder_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{}</#assign>
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
<div class="pageTabs">
    <ul>
        <li ><a href="orderAll.htm">全部订单</a></li>
        <li class="select"><a href="noGoodsnoOrder.htm">无货号订单</a></li>
    </ul>
</div>
<div class="noGoodsnoOrderCon">
    <div class="theadCon">
        <ul class="">
            <li class="childOrderId">子订单ID</li>
            <li class="goodsInfo">商品信息</li>
            <li class="marketCode">市场编码</li>
            <li class="ope">操作</li>
        </ul>
    </div>
    <#list childOrders as childOrder>
    <div class="orderItemCon">
<div class="childOrderItem" data-id="${childOrder.childOrderId!}">
    <ul class="clearfix">
        <li class="childOrderId">${childOrder.childOrderId!}</li>
        <li class="goodsInfo">
            <div class="fl imgBox">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="54" height="54">
            </div>
            <p class="title"><a href="http://www.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank">${childOrder.title!}</a></p>
            <p>商品属性：${childOrder.goodsProperty!}</p>
        </li>
        <li class="marketCode">
            <p class="fcF40">暂无</p>
        </li>
        <li class="ope">
            <b class="bindGoodsno" jbtn="bindGoodsno" data-id="${childOrder.goodsId!}">绑定货号</b>
        </li>
    </ul>
</div>
    </div>
    </#list>
</div>
<#assign text>{}</#assign>
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
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#assign text>{}</#assign>
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
</#list>
    </div>
</div>