<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>我的任务 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/orderHasAllocation.css" rel="stylesheet">
    

    

    

    
        
    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
        
            <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
        
    
    <script src="http://style.571xz.com/v2/dfgl/js/orderHasAllocation.js"></script>
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
        <div class="sidebar fl yahei">
            <ul>
            <@shiro.hasAnyPermissions name="df:admin,df:kefu">
                <li>
                    <a  href="orderAll.htm" ><i class="icon-allorders"></i>全部订单</a>
                </li>
            </@shiro.hasAnyPermissions>
            <@shiro.hasAnyPermissions name="df:kefu">
                <li>
                    <a href="orderForServer.htm"><i class="icon-allorders"></i>客服查询</a>
                </li>
            </@shiro.hasAnyPermissions>
            <@shiro.hasAnyPermissions name="df:admin">
                <li>

                    <a  href="javascript:;" ><i class="icon-allocation"></i>订单分配</a>


                    <ul>

                        <li>

                            <a   href="orderAllocation.htm"><i></i>任务分配</a>

                        </li>

                        <li>

                            <a class="current" href="orderHasAllocation.htm"><i></i>我的任务</a>

                        </li>

                        <li>
                            <a href="scanBarCode.htm"><i></i>扫描打印</a>
                        </li>

                    </ul>

                </li>
            </@shiro.hasAnyPermissions>
            </ul>
</div>




    </div>
    <div class="contentBox">
        

<div class="orderSearch">
    <ul class="orderSearchBox">
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>子订单ID：</label><input type="text" class="fmInput" name="childOrderId" <#if query.childOrderId??> value="${query.childOrderId!}" </#if>></li>
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
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










<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"childOrderId","value":"${query.childOrderId!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
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
            <li class="goodsInfo"><b class="printGoodsTab" data-type="1">打印全部商品标签</b><b class="printGoodsTab" data-type="2">打印已选商品标签</b></li>
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
            <#if childOrder.takeGoodsState == 0>
            <p><b class="fcBlue" jbtn="isGetGoods" data-type="1">已拿到</b></p>
            <p><b class="fcBlue" jbtn="isGetGoods" data-type="2">未拿到</b></p>
            <#else>
            <p class="fcBlue">——</p>
            </#if>
        </li>
        
        <li class="remark">
            <#if childOrder.haveGoodsTime??>
                <p>${childOrder.haveGoodsTime!} 有货</p>
            </#if>
            <#if childOrder.noSaleIs == true>
                <p><span class="fcF40">已标记下架</span></p>
            <#else>
                <#if childOrder.takeGoodsState != 1>
                <p><b class="fcBlue" jbtn='setTime'>设置有货时间</b></p>
                <p><b class="fcBlue" jbtn="noSale">标记下架</b></p>
                </#if>
            </#if>
            <div class="childOrderRemark pr">
                <i class="icon-s-message iconfont <#if childOrder.childRemark??>haveRemark</#if>"></i>
                <div class="remarkCon pa">
                    <#if childOrder.childRemark??>
                    ${childOrder.childRemark!}
                    </#if>
                    <p><b class="addChildRemark" jbtn="addChildRemark">添加备注</b></p>
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
<!--省略end，让浏览器自动添加-->




