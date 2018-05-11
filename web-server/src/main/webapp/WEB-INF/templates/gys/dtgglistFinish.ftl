<#assign $pageid="dtgglistFinish">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>广告派位结果 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__dtgglistFinish_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__dtgglistFinish_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<p class="resultInfo">第${indexggQ!}期活动已结束！<#if (indexggList?size) gt 0>派位结果如下：</#if></p>
<#if indexggList?? && (indexggList?size) gt 0>
    <#list indexggList as indexgg>
    <h3 class="syIntro">${indexgg.title!}</h3>
    <div class="ggList">
        <#if (indexgg.ggList?size) gt 0>
        <table>
            <tr class="tbhd">
                <th>序号</th>
                <th>市场</th>
                <th>店铺</th>
                <th>联系人</th>
                <th>电话</th>
            </tr>
            <#list indexgg.ggList as item>
            <tr>
                <td>${item_index + 1}</td>
                <td>${item.marketText!}</td>
                <td>${item.storeNum!}</td>
                <td>${item.lxuser!}</td>
                <td><#if item.lxtel??>${item.lxtel?substring(0, 3)}****${item.lxtel?substring(7, 11)}</#if></td>
            </tr>
            </#list>
        </table>
        </#if>
    </div>
    </#list>
</#if>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>