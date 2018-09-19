<#assign $pageid>afterSaleOrder</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>售后订单 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__afterSaleOrder_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__afterSaleOrder_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"status","value":""+query.status},{"name":"orderId","value":""+query.orderId},{"name":"telephone","value":""+query.telephone},{"name":"backPostCode","value":""+query.backPostCode},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime}]}</#assign>
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
<div class="pageTabs">
    <ul>
        <li <#if !query.status>class="select"</#if> data-type=""><a href="afterSaleOrder.htm">全部订单</a></li>
        <li <#if query.status == 1>class="select"</#if> data-type='1'><a href="afterSaleOrder.htm?status=1">申请订单</a></li>
        <li <#if query.status == 2>class="select"</#if> data-type='2'><a href="afterSaleOrder.htm?status=2">议价订单</a></li>
    </ul>
</div>
<div class="statistics yahei fc9">
    <ul>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.afterOrderNum!}</span>
            <p>售后订单（单）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.refundsNum!}</span>
            <p>退货退款（单）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.exchangeNum!}</span>
            <p>换货（单）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.beenShippedGoodsFee!}</span>
            <p>今日发货金额（元）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.stockoutNum!}</span>
            <p>今日缺货（件）</p>
        </li>
    </ul>
</div>
<div class="orderSearch">
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
    <#if childOrder_index == 0>
    <td class="orderState" rowspan="${(afterSale.childOrders?size)!}">
        <#if afterSale.afterSaleState == 1>
        <p class="fcF40">申请退货退款</p>
        <#elseif afterSale.afterSaleState == 2>
        <p class="fcG">退货退款已同意</p>
        <#elseif afterSale.afterSaleState == 3>
        <p class="fcF40">退货退款已拒绝</p>
        <#elseif afterSale.afterSaleState == 4>
        <p>已发退货商品</p>
        <#elseif afterSale.afterSaleState == 5>
        <p>退货已收到</p>
        <#elseif afterSale.afterSaleState == 21>
        <p class="fcF40">申请换货</p>
        <#elseif afterSale.afterSaleState == 22>
        <p class="fcG">换货已同意</p>
        <#elseif afterSale.afterSaleState == 23>
        <p class="fcF40">换货已拒绝</p>
        <#elseif afterSale.afterSaleState == 24>
        <p>已发换货商品</p>
        <#elseif afterSale.afterSaleState == 25>
        <p>换货已收到</p>
        <#elseif afterSale.afterSaleState == 26>
        <p>换货已完成</p>
        </#if>
        <#if afterSale.afterSalePostName??>
        <p>${afterSale.afterSalePostName!}</p>
        <p>(${afterSale.afterSalePostCode!})</p>
        <#else>
        <p>${afterSale.opeReason!}</p>
        </#if>
    </td>
    </#if>
    <#if childOrder_index == 0>
        <td class="orderOpe" rowspan="${(afterSale.childOrders?size)!}">
        <#if afterSale.afterSaleState == 1 || afterSale.afterSaleState == 21 || afterSale.afterSaleState == 10>
            <b jbtn="agreeBtn" data-id="${afterSale.refundId!}">同意</b>
            <b jbtn="refuseBtn" data-id="${afterSale.refundId!}">拒绝</b>
        <#elseif afterSale.afterSaleState == 26>
            <p>换货已完成</p>
        <#else>
            <#if (afterSale.putInStorageState?size) gt 0>
                <#list afterSale.putInStorageState as sto>
                    <#if sto.type == 1>
                        <#if afterSale.refundState == 1 || afterSale.refundState == 2>
                        <p>商品已退款x${sto.storageNum!}</p>
                        <#else>
                        <p>商品已入库x${sto.storageNum!}</p>
                        </#if>
                    <#elseif sto.type == 2>
                    <p>退货失败入库x${sto.storageNum!}</p>
                    </#if>
                </#list>
            </#if>
            <#if afterSale.refundState == 1>
            <p>档口已退款</p>
            <p class="fcF40">
                <div class="pr moneyBox fcF40">
                    ${afterSale.refundForShop!}
                    <#if afterSale.refundFeeType == 1>
                    <span class="spanIcon editIcon">改</span>
                    <#elseif afterSale.refundFeeType == 2>
                    <span class="spanIcon">拒</span>
                    </#if>
                    <div class="editInfo pa">
                        <#list afterSale.editInfo as info>
                        <p>${info!}</p>
                        </#list>
                    </div>
                </div>
            </p>
            <p><b class="fcBlue editBtn" jbtn="editBtn" data-id="${afterSale.refundId!}">修改</b></p>
            <#elseif afterSale.refundState == 2>
            <p class="fcG">已退款</p>
            <p class="fcF40">${afterSale.refundForShop!}</p>
            <#elseif afterSale.refundState == 3>
            <p class="fcG">系统自动完结订单</p>
            </#if>
        </#if>
        </td>
    </#if>
    <#if childOrder_index == 0 && afterSale_index == 0>
    <td class="tradeState" rowspan="${order.childOrderNum!}">
        <p>已发货</p>
        <p>${order.sendTime!}</p>
        <p>${order.expressName!}</p>
        <p>(${order.expressCode!})</p>
        <div class="remarkCon">
            ${order.allChildRemark}
        </div>
        <p><b class="addRemark" jbtn="addOrderRemark" data-orderid="${order.orderId!}">添加备注</b></p>
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