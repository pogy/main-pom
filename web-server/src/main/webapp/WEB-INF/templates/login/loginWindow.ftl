<#assign $pageid="loginWindow">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title></title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__loginWindow_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/login__loginWindow_js.ftl">
</head>
<body>
<div class="loginBox">
    <div class="loginContainer">
        <div class="loginHeader yahei fs16">
            <ul>
                <li class="current passwordLogin">账号登录</li>
                <li class="msgLogin">手机验证码登录</li>
            </ul>
        </div>
        <div class="loginSwitch">
            <div class="loginItems">
                <div class="errorTip"></div>
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="username" placeholder="账号" >
                </div>
                <div class="loginItem">
                    <label class="icon-password"></label>
                    <input type="password" class="fmInput-lg fmInput" name="password" placeholder="密码" >
                </div>
                <div class="loginItem fogertPassword">
                    <a href="forgetPassword.htm" target="_blank">忘记密码?</a>
                    <a href="regedit.htm" class="regegitEntery fr" target="_blank">注册账号</a>
                </div>
                <div class="loginItem">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         logoinBtn"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="loginBtn"
>
        立即登录
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                </div>
            </div>
            <div class="loginItems"  style="display:none">
                <div class="errorTip"></div>
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="telephone" maxlength="11" placeholder="手机号码"  >
                </div>
                <div class="loginItem">
                    <label class="icon-verifycode"></label>
                    <input type="text" class="fmInput-lg fmInput msgIpt" name="msgValidate" maxlength="6" placeholder="短信验证码" >
                    <div class="getMsgBox"><button type="button" id="getMsgBtn">获取验证码</button></div>
                </div>
                 <div class="loginItem fogertPassword">
                    <a href="forgetPassword.htm" target="_blank">忘记密码?</a>
                    <a href="regedit.htm" class="regegitEntery fr" target="_blank">注册账号</a>
                </div>
                <div class="loginItem">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         logoinBtn"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="msgLoginBtn"
>
        立即登录
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
<div class="fastLoginList">
    <p>你也可以用以下方式登录：</p>
    <ul>
        <li><a href="ortherLogin.htm?ortherLoginType=1&backUrl=${backUrl!}" target="_blank" alt="淘宝账号登陆" title="淘宝账号登陆"><i class="icon-s-taobao"></i><span>淘宝账号</span></a></li>
        <li class="separated"></li>
        <li><a href="ortherLogin.htm?ortherLoginType=2&backUrl=${backUrl!}" target="_blank"  alt="阿里账号登陆" title="阿里账号登陆"><i class="icon-s-alibaba"></i><span>阿里巴巴</span></a></li>
        <li><a href="ortherLogin.htm?ortherLoginType=4&backUrl=${backUrl!}" target="_blank"  alt="微信登陆" title="微信登陆"><i class="icon-s-weixin"></i><span>微信</span></a></li>
        <li class="separated"></li>
        <li><a href="ortherLogin.htm?ortherLoginType=6&backUrl=${backUrl!}" target="_blank"  alt="京东登陆" title="京东登陆"><i class="icon-s-jingdong"></i><span>京东</span></a></li>
        <li><a href="ortherLogin.htm?ortherLoginType=7&backUrl=${backUrl!}" target="_blank"  alt="拼多多登陆" title="拼多多登陆"><i class="icon-s-pinduoduo"></i><span>拼多多</span></a></li>
    </ul>
</div>
</div>
<#include "/common/cnzz.ftl">