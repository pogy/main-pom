<#assign $pageid="sysSetsindex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>个人信息 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__sysSetsindex_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.form.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__sysSetsindex_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="safecenter">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<div class="setHeadImg yahei clearfix">
    <label>当前头像：</label>
    <div class="picbox">
        <img src="${userInfo.headUrl!}">
        <input type="file" name="file">
        <em>更换头像</em>
    </div>
    <div class="uidbox">
        <em>${userInfo.userId!}</em>
        <span>星座宝账户</span>
    </div>
</div>
<div class="validateForm">
    <div class="validateItem">
        <div class="formGroup">
            <label>用户名：</label>
            <input class="fmInput" name="nickname" placeholder="请输入您的昵称" maxlength="18" value="${userInfo.userNick!}">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>电子邮箱：</label>
            <input class="fmInput" name="email" placeholder="请输入您的电子邮箱" maxlength="30" value="${userInfo.email!}">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup clearfix">
            <label>性别：</label>
            <label class="fmRadio clearfix <#if userInfo.sex == 0>checked</#if>">
                <input type="radio" name="sex" value="0" <#if userInfo.sex == 0>checked</#if>>
                <i class="before"></i>
                <span>保密</span>
            </label>
            <label class="fmRadio clearfix <#if userInfo.sex == 1>checked</#if>">
                <input type="radio" name="sex" value="1" <#if userInfo.sex == 1>checked</#if>>
                <i class="before"></i>
                <span>男</span>
            </label>
            <label class="fmRadio clearfix <#if userInfo.sex == 2>checked</#if>">
                <input type="radio" name="sex" value="2" <#if userInfo.sex == 2>checked</#if>>
                <i class="before"></i>
                <span>女</span>
            </label>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>QQ：</label>
            <input class="fmInput" name="qq" placeholder="请输入您的QQ号码" maxlength="13" value="${userInfo.imQq!}">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>微信：</label>
            <input class="fmInput" name="wx" placeholder="请输入您的微信号" maxlength="20" value="${userInfo.imWx!}">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>阿里旺旺：</label>
            <input class="fmInput" name="ww" placeholder="请输入您的旺旺" maxlength="60" value="${userInfo.imWw!}">
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
         saveBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="saveBtn"
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
<#list [{}] as $it>
</#list>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">