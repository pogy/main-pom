<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>无货号订单 - 星帮后台管理 - 四季星座网</title>
    <#include "/common/host_config.ftl">
    <link href="http://style.571xz.com/v2/dfgl/css/noGoodsnoOrder.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/noGoodsnoOrder.js"></script>
    <script src="${daifa_host!}js/daifa/menudeal/menu.js"></script>
</head>
<body>
<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if userIcon??>
        <img src="${userIcon!}">
        <#else>
        <img src="http://style.571xz.com/v2/dfgl/css/img/headImg.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="${daifa_host!}init/logout.htm" class="fcF40 fs16">退出</a>
            <input id="menus" type="hidden" value="${menu}"/>
    </div>
</div>

<div class="mainContent">
    <div class="sideBarBox">
    <#include "/common/menu_daifa.ftl">
    </div>
    <div class="contentBox">
        <div class="printTypeTabs">
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
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

<div class="jqPagination " id="jqPagination0" 
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}" 
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>

</#list>
<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
        <#if field.timeFormat??>
            <#if field.value??>
            <input type=hidden name="${field.name!}" value="${field.value?string(field.timeFormat)}">
            <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
            </#if>
        <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
        </#if>
    </#list>
</form>
</#if>

</#list>

    </div>
</div>
