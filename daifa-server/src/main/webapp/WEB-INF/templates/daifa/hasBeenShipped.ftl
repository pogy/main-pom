<#assign $pageid>hasBeenShipped</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>已发货订单 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__hasBeenShipped_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__hasBeenShipped_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"orderId","value":""+query.orderId},{"name":"telephone","value":""+query.telephone},{"name":"postCode","value":""+query.postCode},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime}]}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
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
        <li><label>手机：</label><input type="text" class="fmInput" name="telephone" <#if query.telephone??> value="${query.telephone!}" </#if>></li>
        <li><label>发货快递单：</label><input type="text" class="fmInput" name="postCode" <#if query.postCode??> value="${query.postCode!}" </#if>></li>
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
        <li>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         searchBtn"
        jbtn="searchBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
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
    </button>
    </#if>
</#list></li>
    </ul>
</div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
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
                    <span>下单人：${order.imTel!}
<#assign text>{"id":order.imWw}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
<#assign text>{"id":order.imQq}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.id != ''>
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>
</#list></span>
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
        <p><b class="againPrint" data-sendid="${order.sendId!}" jbtn="priceExpressList">重新打印快递单</b></p>
    </td>
    </#if>
</tr>
            </#list>
        </tbody>
        </#list>
    </table>
</div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
    </div>
</div>