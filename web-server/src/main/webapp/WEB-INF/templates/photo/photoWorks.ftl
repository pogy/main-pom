<#assign $pageid="photoWorks">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>作品 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__photoWorks_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__photoWorks_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#list [{"fields":[{"name":"webSite","value":""+query.webSite},{"name":"rid","value":""+query.rid},{"name":"pid","value":""+query.pid},{"name":"sid","value":""+query.sid},{"name":"sort","value":""+query.sort},{"name":"keyword","value":""+query.keyword},{"name":"page","value":""+query.page}]}] as $it>
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
        <label>角色：</label>
        <ul>
            <li <#if !query.rid>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if>">全部</a>
            </li>
            <#list roleList as role>
                <li <#if query.rid?? && query.rid == role.id>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&rid=${role.id!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if>">${role.text!}</a>
                </li>
            </#list>
        </ul>
    </div>
    <div class="filterItem">
        <label>类目：</label>
        <ul>
            <li <#if !query.pid>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}<#if query.rid??>&rid=${query.rid!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if>">全部</a>
            </li>
            <#list cateList as cate>
                <li <#if query.pid?? && query.pid == cate.id>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&pid=${cate.id!}<#if query.rid??>&rid=${query.rid!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if>">${cate.text!}</a>
                </li>
            </#list>
        </ul>
    </div>
    <div class="filterItem">
        <label>风格：</label>
        <ul>
            <li <#if !query.sid>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}<#if query.rid??>&rid=${query.rid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if>">全部</a>
            </li>
            <#list styleList as style>
                <li <#if query.sid?? && query.sid == style.id>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&sid=${style.id!}<#if query.rid??>&rid=${query.rid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if>">${style.text!}</a>
                </li>
            </#list>
        </ul>
    </div>
    <div class="filterItem">
        <label>排序：</label>
        <ul>
            <#list sortList as sort>
                <li <#if query.sort?? && query.sort == sort.type>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&sort=${sort.type!}<#if query.rid??>&rid=${query.rid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if>">${sort.text!}</a>
                </li>
            </#list>
        </ul>
    </div>
</div>
<#if (workList?size) gt 0>
    <div class="workList layout">
        <div class="worksBox">
            <#list workList as item>
<#include "/__ftl_links__/photo__common__coverItem.ftl">
            </#list>
        </div>
    </div>
<#include "/__ftl_links__/photo__common__pagenation.ftl">
<#else>
<#include "/__ftl_links__/photo__common__noDataTips.ftl">
</#if>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">