<#assign $pageid="photoItem">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>${photoAlbumInfo.title} - 相册 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/goodsDetail__common_css.ftl">
<#include "/__style_torrent__/goodsDetail__photoItem_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/goodsDetail__common_js.ftl">
<#include "/__style_torrent__/goodsDetail__photoItem_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/goodsDetail__common__topGoat.ftl">
<#include "/__ftl_links__/goodsDetail__common__header.ftl">
<div class="photoPicBox">
<div class="treeNav layout yahei">
    <a href="photoShop.htm?id=${shopInfo.shopId!}" class="fs18 fcF40">相册列表</a>
    <span class="separated fs18">/</span>
    <span class="title ellip">${photoAlbumInfo.title!}</span>
    <em class="fc9">${photoAlbumInfo.picCount!}张</em>
</div>
<div class="layout">
    <#if photoAlbumInfo.desc??>
    <div class="photoAlbumDesc yahei">
        ${photoAlbumInfo.desc!}
    </div>
    </#if>
</div>
<div class="layout">
    <#if (photoAlbumInfo.pics?size) gt 0>
    <div class="picList">
        <ul class="clearfix">
            <#list photoAlbumInfo.pics as pic>
            <li data-index="${pic_index!}" data-img="${pic.imgSrc!}" data-time="${pic.uploadTime!}"><img src="${pic.imgSrc!}_200x200.jpg"></li>
			</#list>
        </ul>
    </div>
    <#else>
<#list [{"errorCon":"相册暂无图片！"}] as $it>
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
    <input type="hidden" value="${photoAlbumInfo.title!}" id="photoAlbumTitle">
    <input type="hidden" value="${shopInfo.shopId!}" id="shopId">
    <input type="hidden" value="${shopInfo.marketName!}" id="marketName">
    <input type="hidden" value="${shopInfo.shopNo!}" id="shopNo">
</div>
</div>
<#include "/common/xz__rightbar.ftl">
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">