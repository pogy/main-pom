<#assign $pageid="paySuccess">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>支付成功 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__paySuccess_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/order__paySuccess_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
    <#assign statusNum=4>
<#include "/__ftl_links__/order__common__whiteHeader.ftl">
<div class="mainBox">
<div class="paySuccess layout">
    <div class="successTip fwb yahei">订单支付成功，我们尽快为您处理！</div>
    <ul class="orderInfo fc3">
        <#if orderNum??>
        <li>订单数量：<span class="arail fs14">${orderNum!}单</span></li>
        <#else>
        <li>订单编号：<span class="arail fs14">${orderId!}</span></li>
        </#if>
        <li>支付方式：${payType!}</li>
        <li>支付总金额：<span class="arail fs14">${amountPay!}</span> 元</li>
    </ul>
    <p class="gotoTip yahei fs14"><span class="fcF40 fwb time"><em id="timedownBox">5</em>s</span><span class="fc6">后自动跳转到我的订单页面！</span></p>
    <div class="gotoBox">
<#list [{"href":"/order/myOrder.htm"}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-lighter-b
        "
        jbtn="click"
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
        查看订单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        <a href="//www.571xz.com/">返回首页</a>
    </div>
</div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">