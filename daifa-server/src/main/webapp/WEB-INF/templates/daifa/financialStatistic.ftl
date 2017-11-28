
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>财务统计 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/financialStatistic.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/financialStatistic.js"></script>
    
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
        <div class="orderSearch orderSearchBox">
    <ul>
        <li><label>日期查询：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="time" placeholder="请选择时间" <#if query.time??> value="${query.time!}" </#if> readonly></li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-blue
         searchBtn"
    
        jbtn="searchBtn"
    
    
        
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
    </b>
    </#if>





</#list>
</li>
    </ul>
</div>













<#assign text>{"fields":[{"name":"time","value":"${query.time!}"}]}</#assign>
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
<!--省略end，让浏览器自动添加-->




