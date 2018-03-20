<#assign $pageid="iwantToRechargein5">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>充值 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__iwantToRechargein5_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__iwantToRechargein5_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="mybag">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a>我的资金 &gt; 充值</a></li>
</ul>
<div class="remainSum">
    <div class="remainSumTop">
        <div class="myRemain">
            <h3>我的余额（元）</h3>
            <p id="yuerBalance">加载中…</p>
        </div>
        <div class="amountFrozen">
            <h3>冻结金额（元）</h3>
            <p id="yuerBlockMoney">加载中…</p>
        </div>
    </div>
    <input type="hidden" id="tempCode" value="${tempCode!}">
</div>
<hr class="splitLine">
<div class="validateForm rechargeForm">
    <div class="validateItem">
        <div class="formGroup">
            <label>充值金额：</label>
            <input type="text" name="money" class="fmInput" placeholder="请输入充值金额">元
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label></label>
            <span class="fcF40">温馨提示：账户余额提现收取0.6%的手续费!</span>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup payType clearfix">
            <label>充值方式：</label>
<#list [{}] as $it>
<label class="fmRadio clearfix
        checked
">
    <input
        type="radio"
        autocomplete="off"
            name="payMode"
            value="1"
            checked
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <i class="icon-s-alipay alipay"></i>支付宝
    </span>
</label>
</#list>
<#list [{}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="payMode"
            value="3"
            <#if $it.checked??>
                checked
            </#if>
    >
    <i class="before"></i>
    <span>
        红包
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <p class="lastEnvelope">提示：红包余额 ${envelopeBalance!} 元，<a href="userBonus.htm" target="_blank">查看详情</a></p>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         czBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="czBtn"
>
        确认充值
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">