<#assign $pageid="forgetPassword">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>忘记密码 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__forgetPassword_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/login__forgetPassword_js.ftl">
</head>
<body>
<#include "/__ftl_links__/login__common__header.ftl">
<div class="layout950">
    <div class="forgetPassword">
<div class="pwdStep">
    <ul>
        <li class="current"><span>1</span>填写手机号<i></i></li>
        <li><span>2</span>验证身份<i></i></li>
        <li><span>3</span>设置新密码<i></i></li>
        <li><span class="finish"></span>完成<i></i></li>
    </ul>
    <div class="line"></div>
</div>
<div class="pwdContainer validateForm">
    <div class="pwdForm">
        <div class="pwdValItems validateItem">
            <div class="pwdGroup">
                <label>手机号码：</label>
                <input type="text" class="fmInputNormal fmInput" name="telephone" maxlength="11" placeholder="请输入手机号码" >
            </div>
        </div>
        <div class="pwdValItems validateItem">
            <div class="pwdGroup">
                <label>数字验证码：</label>
                <input type="text" class="fmInputNormal fmInput imgValidate" maxlength="4" name="imgValidate" placeholder="右侧验证码" >
                <img id="checkCode" src="/IMG.htm" />
            </div>
        </div>
        <div class="pwdValItems">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         netxStep"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="stepOne"
>
        下一步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="pwdForm" style="display:none">
        <div class="pwdValItems">
            <div class="pwdGroup">
                <label>短信验证码：</label>
                <input type="text" name="msgValidate" class="fmInputNormal fmInput" maxlength="6" placeholder="请输入短信验证码" >
                <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
            </div>
        </div>
        <div class="pwdValItems">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         netxStep"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="stepTwo"
>
        下一步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="pwdForm" style="display:none">
        <div class="pwdValItems">
            <div class="pwdGroup">
                <label>密码：</label>
                <input type="password" class="fmInputNormal fmInput" name="password" maxlength="20" placeholder="请输入密码" >
            </div>
        </div>
        <div class="pwdValItems">
            <div class="pwdGroup">
                <label>确认密码：</label>
                <input type="password" class="fmInputNormal fmInput" name="confirmPassword" maxlength="20" placeholder="请再次输入密码" >
            </div>
        </div>
        <div class="pwdValItems">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         netxStep"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="stepThree"
>
        下一步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="pwdForm" style="display:none">
        <div class="updateSuccess">
            <p>密码修改成功！</p>
            <div class="successTip"><span class="time">3</span>s 后跳转到<a href="/">网站首页</a></div>
        </div>
    </div>
</div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">