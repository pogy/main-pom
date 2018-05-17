<#assign $pageid="storeIn">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>店铺申请 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__storeIn_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__storeIn_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li class="select"><a>店铺申请</a></li>
    <li class="addStore">
        <div class="addStore"><a href="ruzhu.htm" target="_blank">添加店铺</a></div>
    </li>
</ul>
<div class="storelist">
    <table>
        <thead>
            <th class="storeName">店铺</th>
            <th class="sqtime">申请时间</th>
            <th class="status">状态</th>
            <th class="ope">操作</th>
        </thead>
        <tbody>
            <#list storelist as store>
            <tr>
                <td>${store.storeName!}</td>
                <td>${store.sqTime!}</td>
                <td>
                    <#if store.status == 0>
                        <p class="red">审核不通过</p>
                    <#elseif store.status == 1>
                        <p class="red">审核中...</p>
                    <#else>
                        <p class="green">已通过</p>
                    </#if>
                </td>
                <td>
                    <#if store.status == 1>
                        <a class="btn" href="storeInRead.htm?userCode=${store.userCode!}" target="_blank">查看</a>
                        <b class="btn" jbtn="remove" data-code="${store.userCode!}">删除</b>
                    <#elseif store.status == 0>
                        <a class="btn" href="storeInRead.htm?userCode=${store.userCode!}" target="_blank">查看</a>
                        <b class="btn" jbtn="remove" data-code="${store.userCode!}">删除</b>
                    <#else>
                        <a class="btn" href="storeInRead.htm?userCode=${store.userCode!}" target="_blank">查看</a>
                    </#if>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>