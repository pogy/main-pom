<#assign $pageid="photoAlbumManagement">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>商品相册 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__photoAlbumManagement_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/plugin/sort/Sortable.js"></script>
<script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__photoAlbumManagement_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="goodsAblum">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a>商品相册</a></li>
</ul>
<#include "/__ftl_links__/gys__common__dilatation.ftl">
<div class="createPhotoAlbumBox">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-gray-b
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="createBtn"
>
        创建相册
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
<div class="photoAlbumBox">
    <div class="photoAlbumList clearfix">
        <#if (photoAlbums?size) gt 0>
            <#list photoAlbums as item>
<div class="photoAlbumItem pr" data-id="${item.id!}">
    <a class="imgBox" href="photoAlbumItem.htm?id=${item.id!}">
        <#if item.imgSrc?? && item.imgSrc!="">
        <img src="${item.imgSrc!}_300x300.jpg">
        <#else>
        <img src="//style.571xz.com/v6/gys/css/img/defaultPic.png" alt>
        </#if>
    </a>
    <p><a href="photoAlbumItem.htm?id=${item.id!}" class="title ellip" title="${item.title!}">${item.title!}</a><span class="fr">(${item.picCount!})</span></p>
    <p><span>创建${item.created!}</span> <span class="fr">浏览：${item.readCount!}</span></p>
    <div class="pa opeBox">
        <ul>
            <li><b class="openUploadGoodsPic" data-title="${item.title!}">上传图片</b></li>
            <li><b class="removePhotAlbum">删除</b></li>
            <li><b class="openPhotoAlbumBtn" data-title="${item.title!}" data-desc="${item.desc!}" data-cateid="${item.cateId!}">编辑</b></li>
        </ul>
    </div>
</div>
            </#list>
        <#else>
<#list [{"errorCon":"暂无相册！"}] as $it>
<#include "/common/xz__dataEmpty.ftl">
</#list>
        </#if>
    </div>
<#list [{}] as $it>
<div class="jqPagination blue" id="jqPagination0"
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
<script modulepath="gys/photoAlbumManagement#photoAlbumBox">
var cates = '${cates!}'
</script>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>