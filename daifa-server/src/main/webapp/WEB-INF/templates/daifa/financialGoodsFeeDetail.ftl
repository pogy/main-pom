
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>商品费详情 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/financialGoodsFeeDetail.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/financialGoodsFeeDetail.js"></script>
    
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
        <div class="showTime fs20">
    日期：${query.time!}
</div>




<div class="goodsFeeList">
    <ul>
        <#list goodsFeeList as item>
        <li data-id="${item.userId!}">
            <h4 class="fs20"><a href="userTakeGoodsDetail.htm?userId=${item.userId!}&time=${query.time!}">${item.userName!}商品费用</a></h4>
            <p class="fc6">今日应拿金额${item.allotmentFee!}元</p>
            <p class="fc6">今日已拿金额${item.haveToTakeFee!}元</p>
            <#if item.userRefundedFee??>
            <div class="showRefundedFee">
                <p class="fs20 <#if item.userRefundedIsWrong == true>fcF40</#if>">退回的费用：${item.userRefundedFee!}</p>
                <p>

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
        "
    
        jbtn="modifyRefundedFee"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        修改
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</p>
            </div>
            <div class="editRefundedFee">
                <p><span class="fs14">退回的费用：</span><input type="text" class="userRefundedFee" value="${item.userRefundedFee!}"></p>
                <p>

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
        "
    
        jbtn="sbmitRefundedFee"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        提交
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</p>
            </div>
            <#else>
            <p><span class="fs14">退回的费用：</span><input type="text" class="userRefundedFee"></p>
            <p>

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
        "
    
        jbtn="sbmitRefundedFee"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        提交
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</p>
            </#if>
        </li>
        </#list>
    </ul>
    <input type=hidden id="time" value="${query.time!}">
</div>
































    </div>
</div>
<!--省略end，让浏览器自动添加-->




