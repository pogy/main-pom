<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>包裹扫码 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">
    <link href="http://style.571xz.com/v2/dfgl/css/parcelSweepCode.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/parcelSweepCode.js"></script>
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
        <div class="scanPost">
    <label>快递单号：</label><input type="text" class="fmInput fmInput-lg fs14 yahei scanPostCode" placeholder="扫描或者输入快递单号">
    <div class="postCon">
        <ul>
            <li><label>快递单号：</label><span class="postCodeCon"><!--1234567890987654--></span></li>
            <li><label>快递名称：</label><span class="postNameCon"><!--申通快递--></span></li>
            <li><label>查询结果：</label><span class="callbackMsg"><!--已查询到此快递单在如下售后订单中，并且已自动标记已收到售后商品--></span></li>
        </ul>
    </div>
    <div class="setWareBox"><b jbtn="setWareBtn" class="setWareBtn">保存包裹信息并入库登记</b></div>
</div>
<div class="orderCon">
    
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

    </div>
</div>
<!--省略end，让浏览器自动添加-->