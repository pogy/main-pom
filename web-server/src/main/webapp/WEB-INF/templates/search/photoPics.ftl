<#assign $pageid="photoPics">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>图片库 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/search__common_css.ftl">
<#include "/__style_torrent__/search__photoPics_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/search__photoPics_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign searchType="goods">
<#assign headerTitle=null>
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/search__common__pageNav.ftl">
<div class="photoPicsBox">
<div class="layout">
    <div class="filterBox clearfix yahei">
        <label class="fl fc9">分类：</label>
        <ul class="clearfix fl">
            <li><a href="photoPics.htm" <#if !query.cid>class="selected"</#if>>全部</a></li>
            <#list cates as cate>
            <li><a href="photoPics.htm?cid=${cate.cateId!}" <#if query.cid == cate.cateId>class="selected"</#if>>${cate.cateName!}</a></li>
            </#list>
        </ul>
    </div>
</div>
<div class="layout pb70">
    <#if (photoAlbums?size) gt 0>
    <div class="photoAlbumList">
        <ul class="clearfix">
            <#list photoAlbums as item>
            <li>
                <a href="photoItem.htm?id=${item.id!}" target="_blank" class="imgBox">
                    <#if item.cover?? && item.cover != "">
                    <img src="${item.cover!}_200x200.jpg" alt>
                    <#else>
                    <img src="//style.571xz.com/v6/search/css/img/defaultPic.png" alt>
                    </#if>
                </a>
                <p><a href="photoItem.htm?id=${item.id!}" target="_blank" class="ellip title" title="${item.title!}">${item.title!}</a><span class="fr">(${item.picCount!})</span></p>
                <p class="fc9 otherInfo"><span class="created">创建${item.created!}</span><span class="fr">浏览：${item.readCount!}</span></p>
                <p class="marketName"><a href="photoShop.htm?id=${item.shopId!}" target="_blank" class="ellip" title="${item.marketName!}${item.shopNo!}"><i class="icon-list fcF40"></i>${item.marketName!}${item.shopNo!}</a></p>
            </li>
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
    <#else>
<#list [{"errorCon":"暂无相册数据！"}] as $it>
<#include "/common/xz__dataEmpty.ftl">
</#list>
    </#if>
</div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">