<#assign $pageid="payMode">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>支付方式 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__payMode_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/order__payMode_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
    <#assign statusNum=3>
<#include "/__ftl_links__/order__common__whiteHeader.ftl">
<div class="layout">
<div class="orderInfo">
    <span class="successIcon fl"></span>
    <div class="fl">
        <h3 class="fs18 yahei fwb fc3">订单提交成功，请尽快付款！</h3>
        <#if orderId??>
        <p><span class="orderNumber">订单编号：<em class="arail fs14">${orderId!}</em></span>请在<span class="fcF40 validTime"><em class="arail fs14">72</em>小时</span>之内完成付款，否则订单将会被取消！</p>
        <input type=hidden id="orderId" value="${orderId!}">
        <#else>
        <p>您已选择<span class="fcF40">${orderNum!}单</span>订单，请在<span class="fcF40 validTime"><em class="arail fs14">72</em>小时</span>之内完成付款，否则订单将会被取消！</p>
        <input type=hidden id="orderCode" value="${orderCode!}">
        </#if>
    </div>
    <div class="fr totalPrice">应付金额：<span class="fwb fcF40 arail">${amountPay!}</span>元</div>
</div>
<div class="payForm pr">
    <span class="tag pr fs16 yahei">请选择支付方式 <em class="pa"></em></span>
    <div class="payTypeList">
        <ul>
            <li class="selected">
<#list [{}] as $it>
<label class="fmRadio clearfix
        checked
        buttonRadio
">
    <input
        type="radio"
        autocomplete="off"
            name="pay"
            value="alipay"
            checked
    >
    <i class="before"></i>
    <span>
        支付宝
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                <span class="payNumber fr">支付：<em class="fwb fcF40 arail">${amountPay!}</em>元</span>
                <#if orderId??>
                <input type=hidden name="alipayUrl" value="/order/alipay.htm?id=${orderId!}&tempCode=${tempCode!}">
                <#else>
                <input type=hidden name="alipayUrl" value="/order/alipay.htm?orderCode=${orderCode!}&tempCode=${tempCode!}">
                </#if>
            </li>
            <li>
<#list [{}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
        buttonRadio
">
    <input
        type="radio"
        autocomplete="off"
            name="pay"
            value="xzpay"
            <#if $it.checked??>
                checked
            </#if>
    >
    <i class="before"></i>
    <span>
        星座宝
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                <div class="lastMoneyBox">
                    <span class="lastMoney none"><em class="fc9">余额：</em><em class="yahei">&yen;</em><em class="fs14 fwb">${currentAmount!}</em></span>
                    <span class="recharge"></span>
                </div>
                <span class="payNumber fr">支付：<em class="fwb fcF40 arail">${amountPay!}</em>元</span>
            </li>
        </ul>
        <div class="payPwd">
            <p class="fc9">请输入支付密码</p>
            <input type="password" placeholder="请输入支付密码" name="xzpayPwd">
            <#if notSetPassword??>
            <span class="recharge notSetPassword"><i></i><em class="fcF40">您还未设置星座宝（余额）支付密码，请尽快设置以防资金被盗！ </em> <a href="/member/safeXgPaymm.htm">立即设置</a></span>
            </#if>
        </div>
        <div class="payBtn">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg

        "
        disabled="disabled"
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="<#--submitPay-->"
>
        支付升级中...
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
</div>
<script modulepath="order/payMode#payForm">
var currentAmount = '${currentAmount!}';
var amountPay = '${amountPay!}';
</script>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">