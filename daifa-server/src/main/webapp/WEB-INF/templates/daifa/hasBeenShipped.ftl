<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>已发货订单 - 星帮后台管理 - 四季星座网</title>
    <#include "/common/host_config.ftl">
    <link href="http://style.571xz.com/v2/dfgl/css/hasBeenShipped.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/hasBeenShipped.js"></script>
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
        <div class="statistics yahei fc9">
    <ul>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.beenShippedOrder!}</span>
            <p>今日发货订单（单）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.beenShippedGoods!}</span>
            <p>今日发货商品（件）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.beenShippedGoodsFee!}</span>
            <p>今日发货金额（元）</p>
        </li>
    </ul>
</div>

<div class="orderSearch orderSearchBox">
    <ul>
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>收货人手机：</label><input type="text" class="fmInput" name="telephone" <#if query.telephone??> value="${query.telephone!}" </#if>></li>
        <li><label>发货快递单：</label><input type="text" class="fmInput" name="postCode" <#if query.postCode??> value="${query.postCode!}" </#if>></li>
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

<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"telephone","value":"${query.telephone!}"},{"name":"postCode","value":"${query.postCode!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
                <td class="tradeState">交易状态</td>
            </tr>
        </thead>
        <#list orders as order>
        <tbody class="orderItem">
            <tr class="orderItemHead">
                <td class="leftConBox" colspan="2">
                    <span>订单编号：${order.orderId!}</span>
                    <span>时间：${order.tradeTime!}</span>
                    <#if order.oldOrder == true>
                    <i class="fcF40 icon-old oldOrder"></i>
                    </#if>
                    
                </td>
                <td class="buyerInfo"  colspan="2">
                    <span>下单人：${order.imTel!}<#if order.imWw??><a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${order.imWw!}&siteid=cntaobao&status=1&charset=utf-8"><img border="0" src="http://style.571xz.com/v2/xz/css/img/aliww.png" alt="点击这里给我发消息" /></a></#if><#if order.imQq??><a href="http://wpa.qq.com/msgrd?v=3&uin=${order.imQq!}&site=qq&menu=yes" target="_blank"><img src="http://style.571xz.com/v2/xz/css/img/imqq.png" alt=""></a></#if></span>
                </td>
                <td class="rightConBox" colspan="3">
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
            <#list order.childOrders as childOrder>
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
        <p class="fcG">已分配</p>
        
        <#if childOrder.takeGoodsState == 1>
        <p>已拿到</p>
        <#elseif childOrder.takeGoodsState == 2>
        <p class="fcF40">缺货</p>
        </#if>
        
        <#if childOrder.refundState == 1>
        <p>申请退款</p>
        <#elseif childOrder.refundState == 2>
        <p>已申请退款成功</p>
        <#elseif childOrder.refundState == 3>
        <p>自动退款成功</p>
        </#if>
            
    </td>
    <#if childOrder_index == 0>
    <td class="tradeState" rowspan="${(order.childOrders?size)!}">
        <p>已发货</p>
        <p>${order.sendTime!}</p>
        <p>${order.expressName!}</p>
        <p>(${order.expressCode!})</p>
        <p><b class="againPrint" data-id="${order.sendId!}">重新打印快递单</b></p>
    </td>
    </#if>
</tr>

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