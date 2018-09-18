<#assign $pageid>afterSaleProcess</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>售后处理 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__afterSaleProcess_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__afterSaleProcess_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"orderId","value":""+query.orderId},{"name":"telephone","value":""+query.telephone},{"name":"backPostCode","value":""+query.backPostCode},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime}]}</#assign>
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
<div class="orderSearch orderSearchBox">
    <ul>
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>收货人手机：</label><input type="text" class="fmInput" name="telephone" <#if query.telephone??> value="${query.telephone!}" </#if>></li>
        <li><label>退回快递号：</label><input type="text" class="fmInput" name="backPostCode" <#if query.backPostCode??> value="${query.backPostCode!}" </#if>></li>
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
                    <#if order.oldOrder == true>
                    <i class="fcF40 icon-old oldOrder"></i>
                    </#if>
                </td>
                <td class="buyerInfo"  colspan="3">
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
        <#--<b jbtn="failRefund">退款失败入库</b>-->
            <b jbtn="failRefund">退货失败入库</b>
        <#elseif childOrder.putInStorageType == 2>
        <p class="fcF40">商品未入库</p>
        </#if>
    </td>
    <#if childOrder_index == 0>
    <td class="refundOpe" rowspan="${(afterSale.childOrders?size)!}">
        <#if afterSale.allNotPutInIs == false>
        <b jbtn="storeRefund" data-id="${afterSale.refundId!}">档口已退款</b>
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