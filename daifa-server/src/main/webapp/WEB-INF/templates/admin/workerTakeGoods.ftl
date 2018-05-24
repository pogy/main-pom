<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>分配的商品 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
        <#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/orderHasAllocation.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
        
    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
        
            <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
        
    
    <script src="${daifa_host}js/admin/sys/ggoodsUnComplete/workerTakeGoods.js"></script>
    
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
    </div>
</div>




<div class="mainContent">
    <div class="sideBarBox">
    <#include "/admin/common/menu_admin.ftl">
    </div>
    <div class="contentBox">






<div class="orderSearch">
    <ul class="orderSearchBox">
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择时间" <#if query.startTime??> value="${query.startTime!}" </#if>></li>
        <li>
            <label>拿货人：</label><select class="fmInput" name="searchWorkerId" <#if query.searchWorkerId??> value="${query.searchWorkerId!}" </#if>>
                <option value="">请选择</option>
                <#list workers as worker>
                <option value="${worker.id!}" <#if query.searchWorkerId == worker.id>selected</#if>>${worker.name!}</option>
                </#list>
            </select>
        </li>
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










<#assign text>{"fields":[{"name":"startTime","value":"${query.startTime!}"},{"name":"searchWorkerId","value":"${query.searchWorkerId!}"}]}</#assign>
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







<div class="orderCon">
    <div class="theadCon">
        <ul class="">
            <li class="checkBox">

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
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
            <li class="childOrderId"></li>
            <li class="goodsInfo">
            </li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="dffs">代发方式</li>
            <li class="orderState">订单状态</li>
            <li class="operator">操作</li>
            <li class="remark">备注</li>
        </ul>
    </div>
    <div id="orderContainer">
    <#list childOrders as childOrder>
    <div class="childOrderItem" data-id="${childOrder.childOrderId!}" data-takeGoodsId="${childOrder.takeGoodsId!}">
    <ul class="clearfix">
        <li class="checkBox">

<#assign text>{}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>
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
        <li class="dffs">
            <#if childOrder.dffs == 1>
            <p>普通代发</p>
            </#if>
        </li>
        <li class="orderState">
            <#if childOrder.takeGoodsState == 1>
            <p class="alreadyGet">已拿到</p>
            <#elseif childOrder.takeGoodsState == 2>
            <p class="fcF40">缺货</p>
            <#else>
            <p>拿货中</p>
            </#if>
        </li>
        <li class="operator">
            <p class="fcBlue">——</p>
        </li>
        
        <li class="remark">
            <div class="childOrderRemark pr">
                <i class="icon-s-message iconfont <#if childOrder.childRemark??>haveRemark</#if>"></i>
                <div class="remarkCon pa">
                    <#if childOrder.childRemark??>
                    ${childOrder.childRemark!}
                    </#if>
                </div>
            </div>
        </li>
    </ul>
</div>






    </#list>
    </div>
    

<#assign text>{}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>

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
</body>
</html>




