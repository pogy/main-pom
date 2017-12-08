<#assign $pageid>financialGoodsFeeDetail</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>商品费详情 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__financialGoodsFeeDetail_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__financialGoodsFeeDetail_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="showTime fs20">
    日期：${query.time!}
</div>
<div class="goodsFeeList">
    <ul>
        <#list goodsFeeList as item>
        <li data-id="${item.userId!}">
            <h4 class="fs20"><a href="userTakeGoodsDetail.htm?userId=${item.userId!}&time=${query.time!}">${item.userName!}商品费用</a></h4>
            <p class="fc6">今日应拿金额${item.allotmentFee!}元</p>
            <p class="fc6">今日已拿金额${item.haveToTakeFee!}元</p>
            <#if item.userRefundedFee??>
            <div class="showRefundedFee">
                <p class="fs20 <#if item.userRefundedIsWrong == true>fcF40</#if>">退回的费用：${item.userRefundedFee!}</p>
                <p>
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
        "
        jbtn="modifyRefundedFee"
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
        修改
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
            </div>
            <div class="editRefundedFee">
                <p><span class="fs14">退回的费用：</span><input type="text" class="userRefundedFee" value="${item.userRefundedFee!}"></p>
                <p>
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
        "
        jbtn="sbmitRefundedFee"
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
</#list></p>
            </div>
            <#else>
            <p><span class="fs14">退回的费用：</span><input type="text" class="userRefundedFee"></p>
            <p>
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
        "
        jbtn="sbmitRefundedFee"
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
</#list></p>
            </#if>
        </li>
        </#list>
    </ul>
    <input type=hidden id="time" value="${query.time!}">
</div>
    </div>
</div>