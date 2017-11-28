
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>拿货详情 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/userTakeGoodsDetail.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/userTakeGoodsDetail.js"></script>
    
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
        <div class="userTimeShow fs20">
    日期：${query.time!} ${takeGoodsUserName!}的拿货商品列表
</div>





<#assign text>{"fields":[{"name":"time","value":"${query.time!}"},{"name":"userId","value":"${query.userId!}"}]}</#assign>
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


<div class="orderCon">
    <div class="theadCon">
        <ul class="">
            <li class="childOrderId">子单id</li>
            <li class="goodsInfo">商品</li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="orderState">订单状态</li>
        </ul>
    </div>
    <div id="orderContainer">
    <#list childOrders as childOrder>
    <div class="childOrderItem">
    <ul class="clearfix">
        <li class="childOrderId">${childOrder.childOrderId!}</li>
        <li class="goodsInfo">
            <div class="fl imgBox">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="54" height="54">
            </div>
            <p class="title">${childOrder.title!}</p>
            <p>商品属性：${childOrder.goodsProperty!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </li>
        <li class="price">
            <p>批价：${childOrder.piPrice!}</p>
            <#if childOrder.payPrice??>
            <p>实价：${childOrder.payPrice!}</p>
            <#else>
            <p>实价：——</p>
            </#if>
        </li>
        <li class="goodsNum">${childOrder.num!}</li>
        <li class="orderState">
            <#if childOrder.takeGoodsState == 1>
            <p class="alreadyGet">已拿到</p>
            <#elseif childOrder.takeGoodsState == 2>
            <p class="fcF40">缺货</p>
            <#else>
            <p>拿货中</p>
            </#if>
        </li>
    </ul>
</div>


    </#list>
    </div>
    

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




