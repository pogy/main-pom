<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>任务分配 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">
    <link href="http://style.571xz.com/v2/dfgl/css/orderAllocation.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/orderAllocation.js"></script>
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
        <div class="byMarketAllocation yahei">
    <h2 class="fs14">按市场分配</h2>
    <div class="marketList">
        <ul>
            <li id="markets">
                <span>请选择市场：</span>
                <div class="selectBox"></div>
                

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-sm
         fmButton-lighter-b
        "
    
        jbtn="marketAllocation"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="marketAllocationBtn"
    
>

    
        分配当前市场
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>

</#list>

            </li>
            <li id="floors" class="none">
                <span>请选择楼层：</span>
                <div class="selectBox">
                </div>

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-sm
         fmButton-lighter-b
        "
    
        jbtn="floorAllocation"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="floorAllocationBtn"
    
>

    
        分配当前楼层
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>

</#list>

            </li>
            <li id="shops" class="none">
                <span>请选择档口：</span>
                <div class="selectBox"></div>
                

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-sm
         fmButton-lighter-b
        "
    
        jbtn="shopAllocation"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="shopAllocationBtn"
    
>

    
        分配当前档口
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>

</#list>

            </li>
        </ul>
    </div>
</div>

<div class="byOrderAllocation yahei">
    <h2><span class="fs14">按订单分配</span> 

<#assign text>{}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-sm
         fmButton-lighter-b
         fr"
    
        jbtn="orderAllocation"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="orderAllocationBtn"
    
>

    
        分配已选订单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>

</#list>
</h2>
    <div class="orderSearchBox">
        <ul>
            <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
            <li><label>子订单ID：</label><input type="text" class="fmInput" name="childOrderId" <#if query.childOrderId??> value="${query.childOrderId!}" </#if>></li>
            <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
            <li>

<#assign text>{}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>

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
</div>

<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"childOrderId","value":"${query.childOrderId!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>
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
            <li class="checkBox">

<#assign text>{}</#assign>
<#assign moduledata6=text?eval />
<#list [moduledata6] as $it>
<label class="fmCheckbox
    
        <#if $it.checked??>
            checked
        </#if>
    
">
    <input 
        type="checkbox"
        autocomplete="off"
        
            name="selectAll"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i> 
    <span>
    
        全选
    
    
        <#if $it.html??>
            ${$it.html}
        </#if>
    
    </span>
</label>
</#list>
</li>
            <li class="childOrderId">子订单ID</li>
            <li class="goodsInfo">商品信息</li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="dffs">代发方式</li>
        </ul>
    </div>
    <div id="orderContainer">
    <#list childOrders as childOrder>
    <div class="childOrderItem" data-id="${childOrder.childOrderId!}">
    <ul class="clearfix">
        <li class="checkBox">

<#assign text>{}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>
<label class="fmCheckbox
    
        <#if $it.checked??>
            checked
        </#if>
    
">
    <input 
        type="checkbox"
        autocomplete="off"
        
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="selectAll"
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i> 
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    
        <#if $it.html??>
            ${$it.html}
        </#if>
    
    </span>
</label>
</#list>
</li>
        <li class="childOrderId">${childOrder.childOrderId!}</li>
        <li class="goodsInfo">
            <div class="fl imgBox">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width=54 height=54>
            </div>
            <p class="title">${childOrder.title!}</p>
            <p>商品属性：${childOrder.goodsProperty!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </li>
        <li class="price">
            <p>批价：${childOrder.piPrice!}</p>
        </li>
        <li class="goodsNum">${childOrder.num!}</li>
        <li class="dffs">
            <#if childOrder.dffs == 1>
            <p>普通代发</p>
            </#if>
        </li>
    </ul>
</div>


    </#list>
    </div>

<#assign text>{}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>

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