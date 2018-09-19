<#assign $pageid="notYetSipped">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>未发货订单 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__notYetSipped_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__notYetSipped_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#list [{"fields":[{"name":"orderId","value":""+query.orderId},{"name":"telephone","value":""+query.telephone},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime},{"name":"canSendState","value":""+query.canSendState},{"name":"expressId","value":""+query.expressId}]}] as $it>
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
            <span class="fs20 arail fc3">${orderStatistics.notYetOrder!}</span>
            <p>未发货订单（单）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.notYetGoods!}</span>
            <p>未发货商品（件）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.notYetGoodsFee!}</span>
            <p>未发货商品金额（元）</p>
        </li>
    </ul>
</div>
<div class="orderSearch orderSearchBox">
    <ul>
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>手机：</label><input type="text"  class="fmInput" name="telephone" <#if query.telephone??> value="${query.telephone!}" </#if>></li>
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
        <li>
            <label>可发状态：</label>
            <select class="fmInput" name="canSendState">
                <option value="">请选择订单</option>
                <option value="1" <#if query.canSendState == '1'>selected</#if>>可发货订单</option>
                <option value="2" <#if query.canSendState == '2'>selected</#if>>不可发货订单</option>
            </select>
        </li>
        <li>
            <label>快递：</label>
            <select class="fmInput" name="expressId">
                <option value="">请选择快递</option>
                <#list expressList as express>
                <option value="${express.expressId!}"<#if query.expressId == express.expressId>selected</#if>>${express.express!}</option>
                </#list>
            </select>
        </li>
        <li>
<#list [{}] as $it>
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
<#list [{}] as $it>
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
            <li class="childOrderId">子订单ID</li>
            <li class="goodsInfo">商品信息</li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="otherFee">其他费用</li>
            <li class="orderState">订单状态</li>
            <li class="tradeState">交易状态</li>
        </ul>
    </div>
    <#list orders as order>
    <div class="orderItem">
        <div class="orderItemHead">
            <div class="leftConBox fl">
                <span>订单编号：${order.orderId!}</span>
                <span>时间：${order.tradeTime!}</span>
                <#if order.oldOrder == true>
                <i class="fcF40 icon-old oldOrder"></i>
                </#if>
            </div>
            <div class="buyerInfo fl">
                <span>下单人：${order.imTel!}
<#list [{"id":order.imWw}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
<#list [{"id":order.imQq}] as $it>
<#if $it.id != ''>
<a class="imQQ" href="//wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>
</#list></span>
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
            <p class="cdkey">库存编码：${childOrder.barCodeKey!}</p>
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
        <li class="orderState">
            <#if !childOrder.takeGoodsState && !childOrder.refundState>
            <p class="fc3 fcG">未分配</p>
            </#if>
            <#if childOrder.takeGoodsState == 1>
            <p>已拿到</p>
            <p><b class="fcBlue" jbtn="refunBeforeSale">不发退款</b></p>
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
        </li>
        <li class="tradeState">
            <#if childOrder_index == 0>
                <p>未发货</p>
                <p>${order.expressName!}</p>
                <#if order.expressCode??>
                    获得的快递号
                    <p>（${order.expressCode!}）</p>
                </#if>
                <#if order.enableSendBtn == true>
                <p>
                    <input type="text" placeholder="快递单号" class="expressCodeInput fmInput fmInput-sm">
                    <b class="manualSendBtn fcBlue" data-orderid="${order.orderId!}">手动发货</b>
                </p>
                </#if>
            </#if>
        </li>
    </ul>
</div>
        </#list>
    </div>
    </#list>
</div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
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