<#assign $pageid="bindAlipayUserOpe">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>绑定设置 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__bindAlipayUserOpe_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__bindAlipayUserOpe_js.ftl">
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
    <li class="tabbutton selected"><a>我的资金 &gt; 绑定设置</a></li>
</ul>
<div class="bindAliUserCon">
    <div class="validateForm bindAliUserForm">
        <div class="validateItem">
            <div class="formGroup">
                <label>支付宝账号：</label>
                <input type="text" name="alipay" class="fmInput"  placeholder="支付宝账户邮箱号或手机号">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>真实姓名：</label>
                <input type="text" name="payname" class="fmInput" maxlength="12"  placeholder="正确输入支付宝账户实名，防止打错账">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>图形验证码：</label>
                <input type="text" name="imgValidate" class="fmInput imgValidate"  placeholder="请填写图形验证码">
                <img src="/IMG.htm" id="imgValidatePic">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>手机号码：</label>
                <input type="text" value="${userTelephone!}" class="fmInput" readonly>
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>手机验证码：</label>
                <input type="text" name="teleValidateCode" class="fmInput teleValidateCode">
                <b class="teleValidateCodeBtn" jbtn="teleValidateCodeBtn">获取验证码</b>
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
         applyBindAliUserBtn"
        jbtn="applyBindAliUserBtn"
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
        提交
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
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>