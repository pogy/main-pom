<#assign $pageid="regedit">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>注册 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__regedit_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/login__regedit_js.ftl">
</head>
<body>
<#include "/__ftl_links__/login__common__header.ftl">
<div class="regeditContainer layout950">
<div class="regeditForm validateForm">
    <#if inviteRebateActive == 1>
        <div class="validateItem">
            <div class="formGroup">
                <label>邀请码：</label>
                <input type="text" name="inviteCode" class="fmInput" placeholder="请输入邀请码" >
            </div>
        </div>
    </#if>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>手机号码：</label>
            <input type="text" name="telephone" class="fmInput" maxlength="11" placeholder="请输入手机号码"    >
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>数字验证码：</label>
            <input type="text" name="imgValidate"  class="imgValidate fmInput" maxlength="4" placeholder="右侧验证码"  >
            <img id="checkCode" src="//www.571xz.com/IMG.htm">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>短信验证码：</label>
            <input type="text" name="msgValidate" class="fmInput" maxlength="6" placeholder="请输入短信验证码" >
            <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>密码：</label>
            <input type="password" name="password" class="fmInput" maxlength="20" placeholder="请输入登录密码" >
        </div>
    </div>
    <!--<div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>确认密码：</label>
            <input type="password" name="confirmPassword" class="fmInput" maxlength="20" placeholder="再次输入密码" >
        </div>
    </div>-->
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
         fmButton-orange
         regeditButton"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="regeditButton"
>
        立即注册
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="checkContract">点击“立即注册”，即表示您同意并愿意遵守四季星座网<a href="privacy.htm" target="_blank">隐私政策</a>和<a href="contract.htm" target="_blank">服务条款</a></div>
</div>
    <div class="regeditFastLoginIn">
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
        <li class="separated"></li>
        <li><a href="ortherLogin.htm?ortherLoginType=8&backUrl=${backUrl!}" target="_blank"  alt="苏宁登陆" title="苏宁登陆"><i class="icon-s-suning"></i><span>苏宁</span></a></li>
        <li><a href="ortherLogin.htm?ortherLoginType=9&backUrl=${backUrl!}" target="_blank"  alt="shopee登陆" title="shopee登陆"><i class="icon-s-shopee"></i><span>shopee</span></a></li>
    </ul>
</div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">