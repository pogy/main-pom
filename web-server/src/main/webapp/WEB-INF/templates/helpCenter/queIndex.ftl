<#assign $pageid="queIndex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>首页 - 帮助中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/helpCenter__common_css.ftl">
<#include "/__style_torrent__/helpCenter__queIndex_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/helpCenter__common_js.ftl">
<#include "/__style_torrent__/helpCenter__queIndex_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/helpCenter__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType=undefined>
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/helpCenter__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<#if queList??>
<div class="queList">
    <h3 class="fs14 yahei">${queCateNamePath!}</h3>
    <div class="queListCon">
        <h4 class="yahei fs20">问题列表</h4>
        <ul>
            <#list queList as que>
            <li><a href="queDetail.htm?id=${que.id!}" class="fc9">${que.title!}</a></li>
            </#list>
        </ul>
    </div>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
</div>
<#list [{"fields":[{"name":"id","value":""+cid},{"name":"keyword","value":""+query.keyword}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#else>
<div class="queEmpty"></div>
</#if>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">