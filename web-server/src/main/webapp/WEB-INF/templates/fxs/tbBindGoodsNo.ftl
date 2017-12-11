<#assign $pageid>tbBindGoodsNo</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>绑定货号 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__tbBindGoodsNo_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__tbBindGoodsNo_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isFxs":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<div class="pageTabs clearfix yahei">
    <ul>
        <li class="select"><a>未关联商品</a></li>
    </ul>
</div>
<div class="goodsList">
<div class="listHead clearfix">
    <ul>
        <li class="tbGoods">淘宝商品</li>
        <li class="xzGoods">四季星座网商品</li>
        <li class="opera">操作</li>
    </ul>
</div>
    <#list goodsList as goods>
<div class="goodsItem" name="${goods.numiid!}" data-webSite="${goods.webSite!}">
    <ul class="clearfix">
        <li class="tbGoods clearfix">
            <a href="javascript:;" class="imgBox fl">
                <img src="${goods.imgSrc!}_80x80.jpg" alt width="80" height="80">
            </a>
            <div class="goodsInfo fl">
                <a title="${goods.title!}">${goods.title!}</a>
                <p class="fc9" title="颜色：${goods.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${goods.size!}">颜色：${goods.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${goods.size!}</p>
                <#if goods.newTbPrice??>
                <p class="fcF40 fs16 yahei">&yen; ${goods.newTbPrice!}</p>
                <#else>
                <p class="fcF40 fs16 yahei">&yen; ${goods.oldTbPrice!}</p>
                </#if>
            </div>
        </li>
        <li class="xzGoods yahei">
            <p class="fs12 fcF40">暂无关联四季星座网商品</p>
        </li>
        <li class="opera borderLe" data-imgSrc="${goods.imgSrc!}" data-title="${goods.title!}" <#if goods.newTbPrice??>data-price="${goods.newTbPrice!}"<#else>data-price="${goods.oldTbPrice!}"</#if> data-tbId="${goods.numiid!}">
            <p class="goodsGlBtn">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         toGlBtn"
        jhand="openGlWindow"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        立即关联
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
        </li>
    </ul>
</div>
    </#list>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">