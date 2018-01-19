<#assign $pageid="safexgmm">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>修改密码 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__safexgmm_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__safexgmm_js.ftl">
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
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">修改密码</a></li>
</ul>
<div class="validateForm">
    <div class="validateForm">
        <div class="validateItem">
            <div class="formGroup">
                <label>原密码：</label>
                <input type="password" class="fmInput" name="oldPwd" placeholder="请输入原密码">
            </div>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>新密码：</label>
            <input type="password" class="fmInput" name="newPwd" placeholder="请输入新密码">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>确认密码：</label>
            <input type="password" class="fmInput" name="surePwd" placeholder="请输入确认密码">
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
         savePwdBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="savePwdBtn"
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
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">