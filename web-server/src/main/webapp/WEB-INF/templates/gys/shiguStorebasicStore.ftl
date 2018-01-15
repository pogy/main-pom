<#assign $pageid="shiguStorebasicStore">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>店铺基本设置 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__shiguStorebasicStore_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__shiguStorebasicStore_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<#if submit_info??><input type="hidden" id="submitInfo"  value="${submit_info!}"></#if>
<form action="shiguStorebasicStore.htm" id="registerForm" method="post">
<div class="typeset">
    <div class="item clearfix">
        <h4>经营种类：</h4>
        <ul>
            <#list typeset.business_type as type>
                <#if typeset.mainBus == type>
<#list [{"value":type,"text":type}] as $it>
<label class="fmRadio clearfix
        checked
">
    <input
        type="radio"
        autocomplete="off"
            name="mainBus"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            checked
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                <#else>
<#list [{"value":type,"text":type}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="mainBus"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                </#if>
            </#list>
        </ul>
    </div>
    <div class="item clearfix">
        <h4>服务级别：</h4>
        <ul>
            <#list typeset.server_level as server>
                <label class="fmCheckbox">
                    <input type="checkbox" <#list typeset.servers as item> <#if item == server.value> checked="checked" </#if> </#list> name="servers" value="${server.value!}">
                    <i class="before"></i>
                    <span>${server.text!}</span>
                </label>
            </#list>
        </ul>
    </div>
</div>
<div class="validateForm shopForm">
    <#list shopinfo as item>
        <div class="validateItem clearfix">
            <div class="formGroup clearfix">
                <label><#if item.name == "telephone" || item.name == "imWw" || item.name == "imQq"><i>*</i></#if>${item.label!}：</label>
                <input type="text" value="${item.value!}" name="${item.name!}" class="fmInput" <#if item.readonly == true>readonly="readonly"</#if>>
            </div>
        </div>
    </#list>
    <div class="validateItem">
        <div class="formGroup acceptService">
            <label></label>
<#list [{}] as $it>
<label class="fmCheckbox
        checked
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="accept"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            checked
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        我同意
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
            <a href="/contract.htm" target="_blank">《服务条款》</a>和<a href="/privacy.htm" target="_blank">《政策》</a>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label></label>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         submitBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitBtn"
>
        保存
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
</div>
</form>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">