<#assign $pageid="photoModel">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>模特 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__photoModel_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__photoModel_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#list [{"fields":[{"name":"crid","value":""+query.crid},{"name":"sid","value":""+query.sid},{"name":"keyword","value":""+query.keyword},{"name":"page","value":""+query.page}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="photoFilter layout yahei">
    <div class="filterItem">
        <label>模特：</label>
        <ul>
            <li <#if !query.crid>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}<#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sid??>&sid=${query.sid!}</#if>">全部</a>
            </li>
            <#list childRoleList as role>
                <li <#if query.crid?? && query.crid == role.id>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&crid=${role.id!}<#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sid??>&sid=${query.sid!}</#if>">${role.text!}</a>
                </li>
            </#list>
        </ul>
    </div>
    <div class="filterItem">
        <label>风格：</label>
        <ul>
            <li <#if !query.sid>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}<#if query.crid??>&crid=${query.crid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if>">全部</a>
            </li>
            <#list styleList as style>
                <li <#if query.sid?? && query.sid == style.id>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&sid=${style.id!}<#if query.crid??>&crid=${query.crid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if>">${style.text!}</a>
                </li>
            </#list>
        </ul>
    </div>
</div>
<#if (modelList?size) gt 0>
    <div class="modelList layout">
        <div class="listItems">
            <#list modelList as item>
<#include "/__ftl_links__/photo__common__roleItem.ftl">
            </#list>
        </div>
    </div>
<#include "/__ftl_links__/photo__common__pagenation.ftl">
<#else>
<#include "/__ftl_links__/photo__common__noDataTips.ftl">
</#if>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">