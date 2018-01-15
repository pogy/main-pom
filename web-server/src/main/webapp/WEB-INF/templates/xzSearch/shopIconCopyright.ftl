<#assign $pageid="shopIconCopyright">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>商家知识产权展示 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__shopIconCopyright_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__shopIconCopyright_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<div class="banner">
    <div class="layout pr applyBox">
        <a class="pa applyBtn" href="bqsqIndex.htm"></a>
    </div>
</div>
<div class="copyrightList">
    <div class="layout">
        <ul>
            <#list copyrightList as item>
                <li>
                    <a href="http://www.571xz.com/shop.htm?id=${item.shopId!}" target="_blank">
                        <img class="lazyload" src="${item.imgSrc!}">
                    </a>
                    <h3 class="yahei fs14 tac"><a href="http://www.571xz.com/shop.htm?id=${item.shopId!}" target="_blank">${item.shopName!}</a></h3>
                </li>
            </#list>
        </ul>
    </div>
    <div class="paginationBox layout">
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
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">