<#assign $pageid>actRegister</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>活动列表 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__actRegister_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__actRegister_js.ftl">
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
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">所有活动</a></li>
    <li class="tabbutton"><a href="javascript:;">已参加的活动</a></li>
    <li class="tabbutton"><a href="javascript:;">未参加的活动</a></li>
</ul>
<div class="actContent">
    <div class="actItems allActs">
        <#list activities as actItem>
<div class="actItem clearfix">
    <div class="actImg">
        <img src=${actItem.actImg!}>
    </div>
    <div class="actDetails">
        <p class="lineHei32">
            <span class="actTitle">${actItem.actTitle!}</span>
            <span class="applyTime">报名时间：${actItem.applyTime!}</span>
        </p>
        <p class="actRange">
            <span class="applyRange">报名产品范围：${actItem.applyRange!}</span>
        </p>
        <p class="lineHei32">
            <span class="actTime">活动时间：${actItem.actStartTime!}-${actItem.actEndTime!}</span>
            <span class="actNums">名额：${actItem.actNums!} 款商品</span>
            <span class="chargeStyle">收费类型：<#if actItem.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span>
        </p>
        <p class="lineHei32">
            报名资质：
            <#list actItem.qualif as qua>
                <span class="applyQualify <#if qua.status == false>noApply</#if>">${qua.content!}</span>
            </#list>
        </p>
    </div>
    <div class="applyStatus">
        <#if actItem.hdStatus == true>
            <#if actItem.sqStatus == 0>
            <a href='actDetails.htm?actid=${actItem.actid!}' class="fmButton goRegister">立即报名</a>
            <#elseif actItem.sqStatus == 1>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         greenBtn"
        disabled="disabled"
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
        已报名
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <span class="statusTip">审核中…</span>
            <#elseif actItem.sqStatus == 2>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         greenBtn"
        disabled="disabled"
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
        报名已通过
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </#if>
        <#else>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
        "
        disabled="disabled"
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
        已结束
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </#if>
    </div>
</div>
        </#list>
    </div>
    <div class="actItems partedActs">
        <#list activities as actItem>
        <#if actItem.sqStatus == 2>
<div class="actItem clearfix">
    <div class="actImg">
        <img src=${actItem.actImg!}>
    </div>
    <div class="actDetails">
        <p class="lineHei32">
            <span class="actTitle">${actItem.actTitle!}</span>
            <span class="applyTime">报名时间：${actItem.applyTime!}</span>
        </p>
        <p class="actRange">
            <span class="applyRange">报名产品范围：${actItem.applyRange!}</span>
        </p>
        <p class="lineHei32">
            <span class="actTime">活动时间：${actItem.actStartTime!}-${actItem.actEndTime!}</span>
            <span class="actNums">名额：${actItem.actNums!} 款商品</span>
            <span class="chargeStyle">收费类型：<#if actItem.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span>
        </p>
        <p class="lineHei32">
            报名资质：
            <#list actItem.qualif as qua>
                <span class="applyQualify <#if qua.status == false>noApply</#if>">${qua.content!}</span>
            </#list>
        </p>
    </div>
    <div class="applyStatus">
        <#if actItem.hdStatus == true>
            <#if actItem.sqStatus == 0>
            <a href='actDetails.htm?actid=${actItem.actid!}' class="fmButton goRegister">立即报名</a>
            <#elseif actItem.sqStatus == 1>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         greenBtn"
        disabled="disabled"
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
        已报名
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <span class="statusTip">审核中…</span>
            <#elseif actItem.sqStatus == 2>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         greenBtn"
        disabled="disabled"
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
        报名已通过
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </#if>
        <#else>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
        "
        disabled="disabled"
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
        已结束
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </#if>
    </div>
</div>
        </#if>
        </#list>
    </div>
    <div class="actItems noPartedActs">
        <#list activities as actItem>
        <#if actItem.sqStatus == 0 || actItem.sqStatus == 1>
<div class="actItem clearfix">
    <div class="actImg">
        <img src=${actItem.actImg!}>
    </div>
    <div class="actDetails">
        <p class="lineHei32">
            <span class="actTitle">${actItem.actTitle!}</span>
            <span class="applyTime">报名时间：${actItem.applyTime!}</span>
        </p>
        <p class="actRange">
            <span class="applyRange">报名产品范围：${actItem.applyRange!}</span>
        </p>
        <p class="lineHei32">
            <span class="actTime">活动时间：${actItem.actStartTime!}-${actItem.actEndTime!}</span>
            <span class="actNums">名额：${actItem.actNums!} 款商品</span>
            <span class="chargeStyle">收费类型：<#if actItem.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span>
        </p>
        <p class="lineHei32">
            报名资质：
            <#list actItem.qualif as qua>
                <span class="applyQualify <#if qua.status == false>noApply</#if>">${qua.content!}</span>
            </#list>
        </p>
    </div>
    <div class="applyStatus">
        <#if actItem.hdStatus == true>
            <#if actItem.sqStatus == 0>
            <a href='actDetails.htm?actid=${actItem.actid!}' class="fmButton goRegister">立即报名</a>
            <#elseif actItem.sqStatus == 1>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         greenBtn"
        disabled="disabled"
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
        已报名
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <span class="statusTip">审核中…</span>
            <#elseif actItem.sqStatus == 2>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
         greenBtn"
        disabled="disabled"
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
        报名已通过
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </#if>
        <#else>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
        "
        disabled="disabled"
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
        已结束
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </#if>
    </div>
</div>
        </#if>
        </#list>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">