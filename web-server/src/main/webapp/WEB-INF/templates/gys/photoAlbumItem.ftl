<#assign $pageid="photoAlbumItem">
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
<#include "/__style_torrent__/gys__photoAlbumItem_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__photoAlbumItem_js.ftl">
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
<div class="photoAlbumInfo photoAlbumItem clearfix" data-id="${query.id!}">
    <div class="imgBox fl">
        <#if photoAlbumInfo.cover??>
        <img src="${photoAlbumInfo.cover!}_100x100.jpg" alt>
        <#else>
        <img src="//style.571xz.com/v6/gys/css/img/defaultPic.png" alt>
        </#if>
    </div>
    <div class="info fl">
        <p class="titleBox"><span class="title ellip">${photoAlbumInfo.title!}</span><span class="picCount"><em>${photoAlbumInfo.picCount!}</em>张</span></p>
        <p><b class="openUploadGoodsPic" data-title="${photoAlbumInfo.title!}" data-id="${query.id!}"><i class="uploadIcon"></i>上传图片</b></p>
    </div>
</div>
<#list [{}] as $it>
</#list>
<div class="goodsPicBox">
    <input type="hidden" id="defaultCover" value="//style.571xz.com/v6/gys/css/img/defaultPic.png">
    <div class="goodsPicList clearfix">
        <#if (photoAlbumInfo.goodsPics?size) gt 0>
            <#list photoAlbumInfo.goodsPics as item>
            <div class="goodsPicItem" data-id="${item.goodsPicId!}">
                <div class="imgBox">
                    <img src="${item.imgSrc!}_200x200.jpg">
                </div>
                <p>${item.created!}</p>
                <div class="deleteGoodsPic">删除</div>
            </div>
            </#list>
        <#else>
<#list [{}] as $it>
<div class="dataEmpty tac">
    <i class="errorPng"></i>
    <#if $it.errorCon??>
        <p class="tac fs14 fc6 yahei">${$it.errorCon!}</p>
    <#else>
        <p class="tac fs14 fc6 yahei">暂无数据！</p>
    </#if>
</div>
</#list>
        </#if>
    </div>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>