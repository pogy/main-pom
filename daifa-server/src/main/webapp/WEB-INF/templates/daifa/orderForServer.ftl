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
        

<div class="orderSearch">
    <ul class="orderSearchBox">
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>下单人ID：</label><input type="text" class="fmInput" name="buyerId" <#if query.buyerId??> value="${query.buyerId!}" </#if>></li>
        <li><label>收件人姓名：</label><input type="text" class="fmInput" name="receiver" <#if query.receiver??> value="${query.receiver!}" </#if>></li>
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

<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"buyerId","value":"${query.buyerId!}"},{"name":"receiver","value":"${query.receiver!}"},{"name":"telphone","value":"${query.telphone!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
                <span>交易编号：${order.tradeCode!}</span>
                <span>时间：${order.tradeTime!}</span>
                <#if order.oldOrder == true>
                <i class="fcF40 icon-old oldOrder"></i>
                </#if>
                
            </div>
            <div class="buyerInfo fl">
                <span>下单人：${order.imTel!}<#if order.imWw??><a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${order.imWw!}&siteid=cntaobao&status=1&charset=utf-8"><img border="0" src="http://style.571xz.com/v2/xz/css/img/aliww.png" alt="点击这里给我发消息" /></a></#if><#if order.imQq??><a href="http://wpa.qq.com/msgrd?v=3&uin=${order.imQq!}&site=qq&menu=yes" target="_blank"><img src="http://style.571xz.com/v2/xz/css/img/imqq.png" alt=""></a></#if></span>
            </div>
            <div class="rightConBox fr">
                <div class="fl pr receiverAddress">
                    <span class="">${order.receiverName!}（${order.receiverPhone!}）</span>
                    <div class="pa addressCon">${order.receiverName!},${order.receiverPhone!},${order.receiverAddress!}</div>
                </div>
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
            <p>商家编码：${childOrder.storeGoodsCode!}</p>
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
                <#if order.sendStatus == 1>
                <p>未发货</p>
                <#elseif order.sendStatus == 2>
                <p>已发货</p>
                </#if>
                <p>${order.sendTime!}</p>
                <p>${order.expressName!}</p>
                <p>（${order.expressCode!}）</p>
            </#if>
        </li>
        <li class="remark">
            <#if childOrder_index == 0>
            <div class="childOrderRemark pr">
                <p class="childRemark">${order.childRemark!}</p>
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