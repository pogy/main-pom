<#assign $pageid="userPhoneBind">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>绑定手机 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__userPhoneBind_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/login__userPhoneBind_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="bindTelephone">
    <p class="once"><strong>绑定手机号码：</strong>一个手机号只能验证一个四季星座网账号</p>
    <div class="bindForm">
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>手机号码：</label>
                <input type="text" name="telephone" class="fmInput" maxlength="11" placeholder="请输入手机号码" >
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>数字验证码：</label>
                <input type="text" name="imgValidate"  class="fmInput" maxlength="4" placeholder="右侧验证码" >
                <img id="checkCode" class="codeImg" src="/IMG.htm" />
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>短信验证码：</label>
                <input type="text" name="msgValidate" class="fmInput msgValidate" maxlength="6" placeholder="请输入短信验证码" >
                <button type="button" id="getMsgBtn" class="getMsgBtn">点击获取</button>
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label></label>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         bindButton"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="bindButton"
>
        立即绑定
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
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">