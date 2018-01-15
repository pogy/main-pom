<#assign $pageid>dtggapply</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>广告位申请 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__dtggapply_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__dtggapply_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isGys":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<div class="applyForm">
    <p class="tip">恭喜您，活动正在进行中，请填写一下资料申请</p>
    <form id="form1" action="dtggapplyinfo.htm" method="post">
        <input type="hidden" name="id" value="<#if id??>${id!}<#else>${activityId!}</#if>">
        <div class="validateForm">
            <div class="validateItem">
                <div class="formGroup">
                    <label>所属市场：</label>
                    <input type="text" class="fmInput" readonly="readonly" value="${session_user_redis__.logshop.market!}">
                </div>
            </div>
            <div class="validateItem">
                <div class="formGroup">
                    <label>档口号：</label>
                    <input type="text" class="fmInput" readonly="readonly" value="${session_user_redis__.logshop.shopNum!}">
                </div>
            </div>
            <div class="validateItem">
                <div class="formGroup">
                    <label><i>*</i>联系人：</label>
                    <input type="text" class="fmInput" name="lxuser" value="${lxuser!}">
                </div>
            </div>
            <div class="validateItem">
                <div class="formGroup">
                    <label><i>*</i>联系电话：</label>
                    <input type="text" class="fmInput" name="lxtel" value="${lxtel!}">
                </div>
            </div>
            <div class="validateItem">
                <div class="formGroup">
                    <label></label>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         applyBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitApply"
>
        提交申请
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
</div>
<#include "/common/xz__footer.ftl">