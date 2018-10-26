<#assign $pageid="photoShop">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>${shopInfo.marketName}${shopInfo.shopNo} - 相册 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/goodsDetail__common_css.ftl">
<#include "/__style_torrent__/goodsDetail__photoShop_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/goodsDetail__common_js.ftl">
<#include "/__style_torrent__/goodsDetail__photoShop_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/goodsDetail__common__topGoat.ftl">
<#include "/__ftl_links__/goodsDetail__common__header.ftl">
<#list [{"fields":[{"name":"cid","value":""+query.cid},{"name":"id","value":""+query.id}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="photoConBox">
<div class="layout">
    <div class="filterBox clearfix yahei">
        <div class="clearfix">
            <label class="fl fc9">分类：</label>
            <ul class="clearfix fl">
                <li><a href="photoShop.htm?id=${shopInfo.shopId!}" <#if !query.cPid>class="selected"</#if>>全部</a></li>
                <#list cates as cate>
                <li><a href="photoShop.htm?id=${shopInfo.shopId!}&cPid=${cate.cateId!}" <#if query.cPid == cate.cateId>class="selected"</#if>>${cate.cateName!}</a></li>
                </#list>
            </ul>
        </div>
        <#if childCates??>
        <div class="clearfix">
            <label class="fl fc9">子类：</label>
            <ul class="clearfix fl">
                <li><a href="photoShop.htm?id=${shopInfo.shopId!}<#if query.cPid??>&amp;cPid=${query.cPid!}</#if>" <#if !query.cid>class="selected"</#if>>全部</a></li>
                <#list childCates as cate>
                <li><a href="photoShop.htm?id=${shopInfo.shopId!}&cid=${cate.cateId!}<#if query.cPid??>&amp;cPid=${query.cPid!}</#if>" <#if query.cid == cate.cateId>class="selected"</#if>>${cate.cateName!}</a></li>
                </#list>
            </ul>
        </div>
        </#if>
    </div>
</div>
<div class="layout pb70">
    <div class="photoAlbumList">
        <ul class="clearfix">
            <#list photoAlbums as item>
            <li>
                <a href="photoItem.htm?id=${item.id!}" target="_blank" class="imgBox">
                    <#if item.cover?? && item.cover != "">
                    <img src="${item.cover!}_200x200.jpg" alt>
                    <#else>
                    <img src="//style.571xz.com/v6/goodsDetail/css/img/defaultPic.png" alt>
                    </#if>
                </a>
                <p><a href="photoItem.htm?id=${item.id!}" target="_blank" class="ellip title" title="${item.title!}">${item.title!}</a><span class="fr">(${item.picCount!})</span></p>
                <p class="fc9"><span class="created">${item.created!}</span><span class="fr">浏览：${item.readCount!}</span></p>
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
</div>
</div>
<#include "/common/xz__rightbar.ftl">
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">