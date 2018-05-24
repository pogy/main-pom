
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>售后退款费用 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/afterSaleRefundedFee.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/afterSaleRefundedFee.js"></script>
    
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
        <input id="menus" type="hidden" value="${menu!}"/>
    </div>
</div>




<div class="mainContent">
    <div class="sideBarBox">
        
        <#include "/common/menu_daifa.ftl">
        

    </div>
    <div class="contentBox">
        <div class="allFeeAndShowTime">
    <h3 class="fs20">售后-退款（总费用${allRefundedFee!}元）</h3>
    <p class="fs20">日期：${query.time!}</p>
</div>





<#assign text>{"fields":[{"name":"time","value":"${query.time!}"}]}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
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



<div class="stockFeeList">
    <table>
        <thead>
            <th>入库日期</th>
            <th>订单号</th>
            <th>市场</th>
            <th>档口</th>
            <th>货号</th>
            <th>价格(元)</th>
        </thead>
        <tbody>
            <#list refundedFeeList as item>
            <tr>
                <td>${item.refundedDate!}</td>
                <td>${item.orderId!}</td>
                <td>${item.marketName!}</td>
                <td>${item.shopNum!}</td>
                <td>${item.goodsNo!}</td>
                <td>${item.price!}</td>
            </tr>
            </#list>
        </tbody>
    </table>
    

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

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
</div>
<!--省略end，让浏览器自动添加-->




