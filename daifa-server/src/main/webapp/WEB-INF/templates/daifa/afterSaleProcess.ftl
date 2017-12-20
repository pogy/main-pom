<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>售后处理 - 星帮后台管理 - 四季星座网</title>
    
<#include "/common/host_config.ftl">
    <link href="http://style.571xz.com/v2/dfgl/css/afterSaleProcess.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/afterSaleProcess.js"></script>
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
        <div class="orderSearch orderSearchBox">
    <ul>
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>收货人手机：</label><input type="text" class="fmInput" name="telephone" <#if query.telephone??> value="${query.telephone!}" </#if>></li>
        <li><label>退回快递号：</label><input type="text" class="fmInput" name="backPostCode" <#if query.backPostCode??> value="${query.backPostCode!}" </#if>></li>
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
 <#if $it.href??><a href="${$it.href!}" <#else> <b </#if> class="fmButton fmButton-blue searchBtn" jbtn="searchBtn" <#if $it.title??> title="" </#if><#if $it.id??> id="" </#if>>
搜索<#if $it.href??></a><#else></b></#if>

</#list>
</li>
    </ul>
</div>

<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"telephone","value":"${query.telephone!}"},{"name":"backPostCode","value":"${query.backPostCode!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
    <table>
        <thead class="theadCon">
            <tr class="">
                <td class="childOrderId">子订单ID</td>
                <td class="goodsInfo">商品信息</td>
                <td class="price">价格（元）</td>
                <td class="goodsNum">数量</td>
                <td class="otherFee">其他费用</td>
                <td class="orderState">订单状态</td>
                <td class="orderOpe">操作</td>
                <td class="refundOpe">退款操作</td>
                <td class="tradeState">交易状态</td>
            </tr>
        </thead>
        <#list orders as order>
        <tbody class="orderItem" data-id="${order.orderId!}">
            <tr class="orderItemHead">
                <td class="leftConBox" colspan="2">
                    <span>订单编号：${order.orderId!}</span>
                    <span>时间：${order.afterSaleTime!}</span>
                </td>
                <td class="buyerInfo"  colspan="3">
                    <span>下单人：${order.imTel!}<#if order.imWw??><a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${order.imWw!}&siteid=cntaobao&status=1&charset=utf-8"><img border="0" src="http://style.571xz.com/v2/xz/css/img/aliww.png" alt="点击这里给我发消息" /></a></#if><#if order.imQq??><a href="http://wpa.qq.com/msgrd?v=3&uin=${order.imQq!}&site=qq&menu=yes" target="_blank"><img src="http://style.571xz.com/v2/xz/css/img/imqq.png" alt=""></a></#if></span>
                </td>
                <td class="rightConBox" colspan="4">
                    <span class="fr">总费用：${order.totalFee!}（含快递：${order.expressFee!}，服务费：${order.serversFee!}，减免：${order.discountFee!}）</span>
                    <#if order.buyerRemark??>
                    <div class="pr fr buyerRemark">
                        <i class="icon-s-message iconfont haveRemark"></i>
                        <div class="remarkCon">
                            ${order.buyerRemark!}
                        </div>
                    </div>
                    </#if>
                    <div class="fr pr receiverAddress">
                        <span class="">${order.receiverName!}（${order.receiverPhone!}）</span>
                        <div class="pa addressCon">${order.receiverName!},${order.receiverPhone!},${order.receiverAddress!}</div>
                    </div>
                </td>
            </tr>
            <#list order.afterSales as afterSale>
            <#list afterSale.childOrders as childOrder>
            <tr class="childOrderItem" data-id="${childOrder.childOrderId!}" valign="top">
    <td class="childOrderId">${childOrder.childOrderId!}</td>
    <td class="goodsInfo">
        <div class="fl imgBox">
            <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="54" height="54">
        </div>
        <p class="title">${childOrder.title!}</p>
        <p>商品属性：${childOrder.goodsProperty!}</p>
        <p>商家编码：${childOrder.storeGoodsCode!}</p>
    </td>
    <td class="price">
        <p>批价：${childOrder.piPrice!}</p>
        <#if childOrder.payPrice??>
        <p>实价：${childOrder.payPrice!}</p>
        <#else>
        <p>实价：——</p>
        </#if>
    </td>
    <td class="goodsNum">${childOrder.num!}</td>
    <td class="otherFee">
        <p>服务费：${childOrder.childServersFee!}</p>
    </td>
    <td class="orderState">
        <#if childOrder.afterSaleState == 1>
        <p class="fcF40">申请退货退款</p>
        </#if>
        
        <p>${childOrder.afterSalePostName!}</p>
        <p>(${childOrder.afterSalePostCode!})</p>
    </td>
    <#if afterSale.refundId??>
    <td class="orderOpe">
        <#if childOrder.putInStorageType == 1>
        <p>商品已入库</p>
        <!--<b jbtn="storeRefund" data-id="${afterSale.refundId!}">档口已退款</b>-->
            <#if childOrder.afterSaleState == 5>
            <b jbtn="failRefund">退款失败入库</b>
            <#elseif childOrder.afterSaleState == 25>
            <p>换货处理中</p>
            <#elseif childOrder.afterSaleState == 26>
            <p>换货已完成</p>
            </#if>
        <#elseif childOrder.putInStorageType == 2>
        <p class="fcF40">商品未入库</p>
        <#elseif childOrder.putInStorageType == 3>
        <p class="fcF40">退款失败入库</p>
        <#elseif childOrder.putInStorageType == 4>
        <p>商品已退款</p>
        </#if>
    </td>
    <#if childOrder_index == 0>
    <td class="refundOpe" rowspan="${(afterSale.childOrders?size)!}">
        <#if childOrder.afterSaleState == 5>
            <#if afterSale.allNotPutInIs == false>
                <#if afterSale.refundIs == false>
                <b jbtn="storeRefund" data-id="${afterSale.refundId!}">档口已退款</b>
                <#else>
                <p>售后已处理</p>
                </#if>
            </#if>
        <#elseif childOrder.afterSaleState == 25>
        <p>换货已收到</p>
        <#elseif childOrder.afterSaleState == 26>
        <p>换货已完成</p>
        </#if>
    </td>
    </#if>
    <#else>
    <td class="orderOpe">
        
    </td>
    <td class="refundOpe">
        
    </td>
    </#if>
    
    <#if childOrder_index == 0 && afterSale_index == 0>
    <td class="tradeState" rowspan="${order.childOrderNum!}">
        <div class="remarkCon">
            ${order.allChildRemark}
        </div>
        <p><b class="addRemark" jbtn="addOrderRemark" data-id="${order.orderId!}">添加备注</b></p>
    </td>
    </#if>
</tr>
            </#list>
            </#list>
        </tbody>
        </#list>
    </table>
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