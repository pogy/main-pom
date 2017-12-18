<#assign $pageid>ruzhu</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>申请开店 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__ruzhu_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__ruzhu_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isFxs":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <div class="noSidebarBox">
<div class="applyState clearfix">
    <span class="active first">
        <em>1</em>
        <i>填写账户信息</i>
    </span>
    <span class="second">
        <i class="line"></i>
        <em>2</em>
        <i>等待专员审核</i>
    </span>
    <span class="third">
        <i class="line"></i>
        <em>3</em>
        <i>入驻成功</i>
    </span>
</div>
<div class="validateForm applyForm">
    <div class="validateItem clearfix">
        <div class="formGroup clearfix">
            <label><i>*</i>主营商品：</label>
            <ul class="mainbusList">
                <#list mainbusList as mainbus>
<#assign text>{"text":mainbus,"value":mainbus}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="mainCate"
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
                </#list>
            </ul>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>档口号：</label>
            <input class="fmInput" name="storeNum" value="">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>淘宝绑定：</label>
            <span class="noTaobaoBind">
                <#if tbNick??>
                    ${tbNick!}
                <#else>
                    您还未绑定淘宝，<a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1&backUrl=http%3A%2F%2Fwww.571xz.com%2Fruzhu.htm" target="_blank" class="red">立即绑定</a>
                </#if>
            </span>
            <input name="tbNick" type="hidden" value="${tbNick!}">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>联系电话：</label>
            <input type="text" class="fmInput" name="tel" value="">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>微信号：</label>
            <input type="text" class="fmInput" name="wx" value="">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>旺旺号：</label>
            <input type="text" class="fmInput" name="aliWw" value="">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>QQ：</label>
            <input type="text" class="fmInput" name="qq" value="">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label>电子邮箱：</label>
            <input type="text" class="fmInput" name="email" value="">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>所属市场：</label>
<#assign text>{"name":"cityId"}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="fmSelect" id="cityId">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
<#assign text>{"name":"marketId"}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="fmSelect" id="marketId">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
<#assign text>{"name":"marketFloor"}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="fmSelect" id="marketFloor">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup serverType">
            <label><i>*</i>售后服务：</label>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="serverType1"
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
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        可退
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="serverType2"
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
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        可换
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
            <input type="hidden" id="serverLevel" name="serverLevel" value="0">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup subBox">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<label class="fmCheckbox
        checked
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="agree"
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
            <span class="clause">“<a href="http://www.571xz.com/static/mianze/contract.html">服务条款</a>”和“<a href="http://www.571xz.com/static/mianze/contract.html">政策</a>”</span>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         submitBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitRuzhu"
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
<#include "/common/xz__footer.ftl">