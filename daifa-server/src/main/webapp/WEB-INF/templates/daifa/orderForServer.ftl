<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>客服查询 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/orderForServer.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/orderForServer.js"></script>
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
        
            <li>
                
                <a  href="orderAll.htm" ><i class="icon-allorders"></i>全部订单</a>
                
                
            </li>
        
            <li>
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>订单分配</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="orderAllocation.htm"><i></i>任务分配</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="orderHasAllocation.htm"><i></i>我的任务</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="scanBarCode.htm"><i></i>扫描打印</a>
                        
                    </li>
                    
                    <li>
                        
                        <a class="current" href="orderForServer.htm"><i></i>客服查询</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
    </ul>
</div>




    </div>
    <div class="contentBox">
        

<div class="orderSearch">
    <ul class="orderSearchBox">
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>下单人ID：</label><input type="text" class="fmInput" name="buyerId" <#if query.buyerId??> value="${query.buyerId!}" </#if>></li>
        <li><label>收件人姓名：</label><input type="text" class="fmInput" name="recevier" <#if query.recevier??> value="${query.recevier!}" </#if>></li>
        <li><label>收件人手机号码：</label><input type="text" class="fmInput" name="telphone" <#if query.telphone??> value="${query.telphone!}" </#if>></li>
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










<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"buyerId","value":"${query.buyerId!}"},{"name":"recevier","value":"${query.recevier!}"},{"name":"telphone","value":"${query.telphone!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
            <li class="childOrderId">子订单ID</li>
            <li class="goodsInfo">商品信息</li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="otherFee">其他费用</li>
            <li class="tradeState">交易状态</li>
            <li class="remark">备注</li>
        </ul>
    </div>
    <#list orders as order>
    <div class="orderItem" data-id="${order.orderId!}">
        <div class="orderItemHead">
            <div class="leftConBox fl">
                <span>订单编号：${order.orderId!}</span>
                <span>时间：${order.tradeTime!}</span>
                
            </div>
            <div class="rightConBox fr">
                <span class="fl">${order.receiverName!}（${order.receiverPhone!}）</span>
                <#if order.buyerRemark??>
                <div class="pr fl buyerRemark">
                    <i class="icon-s-message iconfont haveRemark"></i>
                    <div class="remarkCon">
                        ${order.buyerRemark!}
                    </div>
                </div>
                </#if>
                <span class="fl">总费用：${order.totalFee!}（含快递：${order.expressFee!}，服务费：${order.serversFee!}，减免：${order.discountFee!}）</span>
            </div>
        </div>
        <#list order.childOrders as childOrder>
        <div class="childOrderItem" data-id="${childOrder.childOrderId!}">
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
        <li class="otherFee">
            <p>服务费：${childOrder.childServersFee!}</p>
        </li>
        <li class="tradeState">
            <#if childOrder_index == 0>
                <#if order.tradeState == 1>
                <p>未发货</p>
                <#elseif order.tradeState == 2>
                <p>已发货</p>
                <p>${order.sendTime!}</p>
                </#if>
                <p>${order.expressName!}</p>
                <#if order.tradeState == 2>
                    <p>（${order.expressCode!}）</p>
                </#if>
            </#if>
        </li>
        <li class="remark">
            <#if childOrder_index == 0>
            <div class="childOrderRemark pr">
                <#if order.childRemark??>
                <#list order.childRemark as remark>
                    <p>${remark!}</p>
                </#list>
                </#if>
                <!--<i class="icon-s-message iconfont <#if childOrder.childRemark??>haveRemark</#if>"></i>-->
                <p><b class="addChildRemark" jbtn="addChildRemark">添加备注</b></p>
            </div>
            </#if>
        </li>
    </ul>
</div>


        </#list>
    </div>
    </#list>
</div>
    

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

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




