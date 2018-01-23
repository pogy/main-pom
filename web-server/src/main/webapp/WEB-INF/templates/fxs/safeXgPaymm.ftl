<#assign $pageid="safeXgPaymm">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>修改支付密码 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__safeXgPaymm_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__safeXgPaymm_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="safecenter">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<div class="pageTabs clearfix">
    <ul>
        <li class="select">
            <a href="javascript:;">
                <#if forPayPswType == 1>
                设置支付密码
                <#elseif forPayPswType == 2>
                修改支付密码
                <#elseif forPayPswType == 3>
                找回支付密码
                </#if>
            </a>
        </li>
    </ul>
</div>
<div class="passwordForm validateForm">
    <#if forPayPswType == 2>
    <div class="validateItem">
        <div class="formGroup">
            <label>原密码：</label>
            <input type="password" name="oldPwd" class="fmInput" placeholder="请输入原密码">
        </div>
    </div>
    <#elseif forPayPswType == 3>
    <div class="validateItem">
        <div class="formGroup">
            <label>手机号码：</label>
            <span class="telShow">${telphone?substring(0, 3)}****${telphone?substring(7, 11)}</span>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>短信验证码：</label>
            <input type="text" class="fmInput msgCode" name="msgCode" placeholder="请输入短信验证码">
<#list [{"value":telphone}] as $it>
<button type="button"
     id="getMsgCode"
     class="getVerCode"
    data-value="<#if $it.value??>${$it.value!}</#if>">获取验证码</button>
</#list>
        </div>
    </div>
    </#if>
    <div class="validateItem">
        <div class="formGroup">
            <label>新密码：</label>
            <input type="password" name="newPwd" class="fmInput" placeholder="请输入新密码">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>确认密码：</label>
            <input type="password" name="surePwd" class="fmInput" placeholder="请输入确认密码">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label></label>
            <#if forPayPswType == 1>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         saveBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="setPassword"
>
        保存
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <#elseif forPayPswType == 2>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         saveBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="modifyPassword"
>
        保存
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <#elseif forPayPswType == 3>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         saveBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="getBackPassword"
>
        保存
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </#if>
        </div>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">