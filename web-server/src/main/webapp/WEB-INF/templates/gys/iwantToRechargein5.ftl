<#assign $pageid>iwantToRechargein5</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
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
<#assign text>{"disabledChooseCity":true,"isGys":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>mybag</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
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
<div class="validateForm">
    <div class="validateItem">
        <div class="formGroup">
            <label>充值金额：</label>
            <input type="text" class="fmInput" name="money" placeholder="请输入充值金额"> 元</p>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>充值方式：</label>
            <input type="text" class="fmInput" value="支付宝" readonly="readonly">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label></label>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
     class="fmButton
         fmButton-lg
         fmButton-blue
         <#--czBtn-->"
        disabled="disabled"
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
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">