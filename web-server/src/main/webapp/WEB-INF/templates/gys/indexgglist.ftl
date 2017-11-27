<#assign $pageid>indexgglist</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>广告报名 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__indexgglist_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__indexgglist_js.ftl">
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
<div class="headTitle clearfix">
    <h3 class="title">广告区域</h3>
    <a href="dtgglistFinish.htm" target="_blank" class="searAllRe">查看上一期结果 &gt;</a>
</div>
<div class="goatList">
<#if (adsBoxList?size) gt 0>
    <#list adsBoxList as item>
    <div class="goatItem">
        <h3 class="goatTitle">${item.title!}</h3>
        <ul class="goatDetails">
            <li>
                <span class="detailName">数量：</span>
                <span class="detailVaule">${item.count!}</span>
            </li>
            <li>
                <span class="detailName">投放日期：</span>
                <span class="detailVaule">${item.beginTime!}</span>
            </li>
            <li>
                <span class="price">价格：</span>
                <span class="rmb">&yen;</span>
                <strong>${item.price!}</strong>
            </li>
        </ul>
        <div class="signBtn">
            <#if item.hdFinish??>
            <a href="dtgglist.htm?id=${item.id!}">查看结果</a>
            <#else>
            <a href="dtggapply.htm?id=${item.id!}">立即报名</a>
            </#if>
        </div>
    </div>
    </#list>
<#else>
<p style="text-align:center; font-size:16px; padding:20px;">暂无广告位</p>
</#if>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">